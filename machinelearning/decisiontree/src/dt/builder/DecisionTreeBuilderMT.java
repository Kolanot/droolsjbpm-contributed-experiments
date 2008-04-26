package dt.builder;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import dt.DecisionTree;
import dt.LeafNode;
import dt.TreeNode;
import dt.memory.Domain;
import dt.memory.Fact;
import dt.memory.FactDistribution;
import dt.memory.FactSet;
import dt.memory.FactTargetDistribution;
import dt.memory.OOFactSet;
import dt.memory.WorkingMemory;
import dt.tools.Util;

public class DecisionTreeBuilderMT {

	class MyThread extends Thread {
		DecisionTreeBuilderMT builder;
		DecisionTree dt;
		List<Fact> facts;
		List<String> attributeNames;
		TreeNode currentNode = null;
		Object value = null;
		TreeNode result = null;
		@Override
		public void run() {
			result = builder.id3(dt, facts, attributeNames);
			currentNode.putNode(value, result);
		}
	}

	MyThread helper;
	private int FUNC_CALL = 0;
	private int num_fact_processed = 0;
	
	private List<Fact> unclassified_facts;

	/* 
	 * treebuilder.execute(workingmemory, classtoexecute, attributestoprocess)

	foreach factset in workingmemory
		if classtoexecute.isAssignableFrom( factset.class )
			internaladd(factset)

	internalprocess(attributestoprocess)
	 */

	public DecisionTree build(WorkingMemory wm, Class<?> klass, String targetField, Collection<String> workingAttributes) {

		unclassified_facts = new ArrayList<Fact>();
		DecisionTree dt = new DecisionTree(klass.getName());
//		**OPT		List<FactSet> facts = new ArrayList<FactSet>();
		ArrayList<Fact> facts = new ArrayList<Fact>();
		FactSet klass_fs = null;
		Iterator<FactSet> it_fs= wm.getFactsets(); 
		while (it_fs.hasNext()) {
			FactSet fs = it_fs.next();
			if (fs instanceof OOFactSet) {
				if (klass.isAssignableFrom(((OOFactSet)fs).getFactClass())) {
//					**OPT		facts.add(fs);
					((OOFactSet)fs).assignTo(facts); // adding all facts of fs to "facts"

					if (klass == ((OOFactSet)fs).getFactClass()) {
						klass_fs = fs;
					}
				}
			} else if (klass.getName()== fs.getClassName()) {

			}

		}
		dt.FACTS_READ += facts.size();

		num_fact_processed = facts.size();

		if (workingAttributes != null)
			for (String attr: workingAttributes) {
				dt.addDomain(klass_fs.getDomain(attr));
			}
		else 
			for (Domain<?> d: klass_fs.getDomains())
				dt.addDomain(d);

		dt.setTarget(targetField);

		ArrayList<String> attrs = new ArrayList<String>(dt.getAttributes());
		Collections.sort(attrs);

		helper = new MyThread();
//		System.out.println("IS ALIVE"+helper.isAlive());
		TreeNode root = id3(dt, facts, attrs);
		try {
			helper.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dt.setRoot(root);

		return dt;
	}

	public DecisionTree build(WorkingMemory wm, String klass, String targetField, Collection<String> workingAttributes) {

		unclassified_facts = new ArrayList<Fact>();
		DecisionTree dt = new DecisionTree(klass);
//		**OPT		List<FactSet> facts = new ArrayList<FactSet>();
		ArrayList<Fact> facts = new ArrayList<Fact>();
		FactSet klass_fs = null;
		Iterator<FactSet> it_fs= wm.getFactsets(); 
		while (it_fs.hasNext()) {
			FactSet fs = it_fs.next();
			if (klass == fs.getClassName()) {
//				**OPT		facts.add(fs);
				fs.assignTo(facts); // adding all facts of fs to "facts"

				klass_fs = fs;
				break;
			}
		}
		dt.FACTS_READ += facts.size();
		num_fact_processed = facts.size(); 

		if (workingAttributes != null)
			for (String attr: workingAttributes) {
				System.out.println("Bok degil "+ attr);
				if (attr =="aratio") {
					System.out.println("Bok");
					System.exit(0);
				}
				dt.addDomain(klass_fs.getDomain(attr));
			}
		else 
			for (Domain<?> d: klass_fs.getDomains())
				dt.addDomain(d);

		dt.setTarget(targetField);

		ArrayList<String> attrs = new ArrayList<String>(dt.getAttributes());
		Collections.sort(attrs);

		helper = new MyThread();
		//System.out.println("IS ALIVE"+helper.isAlive());
		TreeNode root = id3(dt, facts, attrs);
		try {
			helper.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dt.setRoot(root);

		return dt;
	}

	/*
	 function ID3
		Input:   (R: a set of non-target attributes,
          		  C: the target attribute,
          		  S: a training set) returns a decision tree;
		begin
   			If S is empty, return a single node with 
      			value Failure;
   			If S consists of records all with the same 
      			value for the target attribute, 
      			return a single leaf node with that value;
   			If R is empty, 
   				then return a single node with the value of the most frequent of the values of the target attribute 
   				that are found in records of S; [in that case there may be be errors, 
   				examples that will be improperly classified];
   			Let A be the attribute with largest 
      			Gain(A,S) among attributes in R;
   			Let {aj| j=1,2, .., m} be the values of attribute A;
   			Let {Sj| j=1,2, .., m} be the subsets of S consisting respectively of records with value aj for A;
   			Return a tree with root labeled A and arcs labeled a1, a2, .., am going respectively 
      			to the trees (ID3(R-{A}, C, S1), ID3(R-{A}, C, S2),.....,ID3(R-{A}, C, Sm);
   			Recursively apply ID3 to subsets {Sj| j=1,2, .., m} until they are empty
		end


	 */
	//*OPT*	private TreeNode decisionTreeLearning(List<FactSet> facts,
	//*OPT*										  List<String> attributeNames) {
	//*OPT*	private TreeNode decisionTreeLearning(List<FactSet> facts,
	//*OPT*										  List<String> attributeNames) {
	private TreeNode id3(DecisionTree dt, List<Fact> facts, List<String> attributeNames) {

		FUNC_CALL  ++;
		if (facts.size() == 0) {
			throw new RuntimeException("Nothing to classify, factlist is empty");
		}
		/* let's get the statistics of the results */
		FactDistribution stats = new FactDistribution(dt.getDomain(dt.getTarget()));
		stats.calculateDistribution(facts);
		
		stats.evaluateMajority();

		/* if all elements are classified to the same value */
		if (stats.getNum_supported_target_classes() == 1) {
			//*OPT*			return new LeafNode(facts.get(0).getFact(0).getFieldValue(target));
			LeafNode classifiedNode = new LeafNode(dt.getDomain(dt.getTarget()), stats.getThe_winner_target_class());
			classifiedNode.setRank((double)facts.size()/(double)num_fact_processed);
			classifiedNode.setNumSupporter(facts.size());
			return classifiedNode;
		}

		/* if  there is no attribute left in order to continue */
		if (attributeNames.size() == 0) {
			/* an heuristic of the leaf classification*/
			Object winner = stats.getThe_winner_target_class();
			LeafNode noAttributeLeftNode = new LeafNode(dt.getDomain(dt.getTarget()), winner);
			noAttributeLeftNode.setRank((double)stats.getVoteFor(winner)/(double)num_fact_processed);
			noAttributeLeftNode.setNumSupporter(stats.getVoteFor(winner));
			return noAttributeLeftNode;
		}

		/* id3 starts */
		String chosenAttribute = Entropy.chooseAttribute(dt, facts, stats, attributeNames);

		System.out.println(Util.ntimes("*", 20)+" 1st best attr: "+ chosenAttribute);

		TreeNode currentNode = new TreeNode(dt.getDomain(chosenAttribute));
		//ConstantDecisionTree m = majorityValue(ds);
		/* the majority */

		List<?> attributeValues = dt.getPossibleValues(chosenAttribute);
		Hashtable<Object, List<Fact> > filtered_facts = splitFacts(facts, chosenAttribute, attributeValues);
		dt.FACTS_READ += facts.size();


//		if (FUNC_CALL ==5) {
//		System.out.println("FUNC_CALL:" +FUNC_CALL);
//		System.exit(0);
//		}
		for (int i = 0; i < attributeValues.size(); i++) {
			/* split the last two class at the same time */
			Object value = attributeValues.get(i);

			ArrayList<String> attributeNames_copy = new ArrayList<String>(attributeNames);
			attributeNames_copy.remove(chosenAttribute);

			if (filtered_facts.get(value).isEmpty()) {
				/* majority !!!! */
				LeafNode majorityNode = new LeafNode(dt.getDomain(dt.getTarget()), stats.getThe_winner_target_class());
				majorityNode.setRank(0.0);
				currentNode.putNode(value, majorityNode);
			} else {
//				TreeNode newNode = id3(dt, filtered_facts.get(value), attributeNames_copy);
//				currentNode.addNode(value, newNode);
				if (helper.isAlive()) {
					TreeNode newNode = id3(dt, filtered_facts.get(value), attributeNames_copy);
					currentNode.putNode(value, newNode);
				}
				else {
					helper.attributeNames = attributeNames_copy;
					helper.builder = this;
					helper.dt = dt;
					helper.facts = filtered_facts.get(value);
					helper.value = value;
					helper.currentNode = currentNode;
					helper.start();
					System.out.println("helper thread launched");
				}
			}
		}

		return currentNode;
	}

//	//String chooseAttribute(List<FactSet> facts, List<String> attrs) {
//	public String attributeWithGreatestGain(DecisionTree dt, List<Fact> facts, Hashtable<Object, Integer> facts_in_class, List<String> attrs) {
//
//		double dt_info = dt.getInformation(facts_in_class, facts.size());
//		double greatestGain = 0.0;
//		String attributeWithGreatestGain = attrs.get(0);
//		for (String attr : attrs) {
//			double gain = dt_info - dt.getGain(facts, attr);
//			System.out.println("Attribute: "+attr +" the gain: "+gain);
//			if (gain > greatestGain) {
//				greatestGain = gain;
//				attributeWithGreatestGain = attr;
//			}
//		}
//
//		return attributeWithGreatestGain;
//	}

	public Hashtable<Object, List<Fact> > splitFacts(List<Fact> facts, String attributeName, 
			List<?> attributeValues) {		
		Hashtable<Object, List<Fact> > factLists = new Hashtable<Object, List<Fact> >(attributeValues.size());
		for (Object v: attributeValues) {
			factLists.put(v, new ArrayList<Fact>());
		}
		for (Fact f : facts) {
			factLists.get(f.getFieldValue(attributeName)).add(f);
		}
		return factLists;
	}
	
	public int getNumCall() {
		return FUNC_CALL;
	}

}
