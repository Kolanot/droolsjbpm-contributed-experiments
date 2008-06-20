package org.drools.learner.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

import org.drools.learner.AttributeValueComparator;
import org.drools.learner.DecisionTree;
import org.drools.learner.LeafNode;
import org.drools.learner.TreeNode;

public class RulePrinter {
	
	private static SimpleLogger flog = LoggerFactory.getUniqueFileLogger(RulePrinter.class, SimpleLogger.WARN);
	private static SimpleLogger slog = LoggerFactory.getSysOutLogger(RulePrinter.class, SimpleLogger.WARN);
	
	
	public static Reader readRules(DecisionTree learned_dt) {
		
		RulePrinter my_printer = new RulePrinter();	//bocuk.getNum_fact_trained()
		my_printer.setBoundOnNumRules(Util.MAX_NUM_RULES);
		my_printer.print(learned_dt, Util.SORT_RULES_BY_RANK);
		
		String all_rules = my_printer.write2string();
		if (Util.PRINT_RULES) {
			//my_printer.write2file("examples", "src/rules/examples/" + file);
			my_printer.write2File(all_rules, false, Util.DRL_DIRECTORY+learned_dt.getSignature());
		}
		
		return new StringReader(all_rules);
	}

	private Class<?> rule_clazz;	
	
	private Stack<NodeValue> nodes;
	
	private ArrayList<Rule> rules;
	//private ArrayList<String> ruleText;
	
	
	private int bound_on_num_rules;
	private double num_instances;

	private HashMap<String, ArrayList<Field>> attrRelations;
	
	//private NumberComparator nComparator;
	
	public RulePrinter() {
		/* most important */
		this.nodes = new Stack<NodeValue>();
		
		this.rules = new ArrayList<Rule>();
		//ruleText = new ArrayList<String>();
		
		this.bound_on_num_rules = -1;
		this.num_instances = -1.0d;
		
		//this.nComparator = new NumberComparator();
	}
	
	public Class<?> getRuleClass() {
		return rule_clazz;
	}
	
	public int getBoundOnNumRules() {
		return bound_on_num_rules;
	}

	public void setBoundOnNumRules(int max_num_rules) {
		this.bound_on_num_rules = max_num_rules;
	}
	
	public double getNumInstances() {
		return this.num_instances;
	}

	public void setNumInstances(int num) {
		this.num_instances = num;
	}
	
	public void print(DecisionTree dt, boolean sort) {//, PrintStream object
		this.rule_clazz = dt.getObjClass();
		this.attrRelations = dt.getAttrRelationMap();
		this.num_instances = dt.getRoot().getNumMatch();
		dfs(dt.getRoot());
		
		if (sort)
			Collections.sort(rules, Rule.getRankComparator());
	}
	
	private void dfs(TreeNode my_node) {
		//System.out.println("How many guys there of "+my_node.getDomain().getName() +"  : "+my_node.getDomain().getValues().size());
		
		NodeValue node_value = new NodeValue(my_node);
		nodes.push(node_value);
		
		if (my_node instanceof LeafNode) {
			node_value.setNodeValue(((LeafNode) my_node).getCategory()); //getValue(null));
			//ruleText.add(print(nodes));
			//rule_list.add(spit(nodes));
			// what if more than one condition (more than one leafNode)
			
			Rule newRule = spitRule(nodes);
			newRule.setId(rules.size());
			rules.add(newRule);
			return;
		}
		
		for (Object attributeValue : my_node.getChildrenKeys()) {
			//System.out.println("Domain: "+ my_node.getDomain().getName() + " the value:"+ attributeValue);
			node_value.setNodeValue(attributeValue);		
			TreeNode child = my_node.getChild(attributeValue);
			dfs(child);
			nodes.pop();
		}
		return;
	}
	
	private Rule spitRule(Stack<NodeValue> nodes) {
		//, Stack<NodeValue> leaves // if more than one leaf
		Rule newRule = new Rule(this.getRuleClass(), nodes.size());// (nodes, leaves) //if more than one leaf
		Iterator<NodeValue> it = nodes.iterator();
		while (it.hasNext()) {

			NodeValue current = it.next();
			if (slog.error() != null)
				slog.error().log("NodeValue " +current + "\n");
			
			if (slog.error() != null)
				slog.error().log("attrRelations [" +attrRelations.size() + "]\n");
			if (it.hasNext()) { 
				ArrayList<Field> nodeRelations = attrRelations.get(current.getFReference());
				
				if (nodeRelations == null || nodeRelations.isEmpty()) { 
					// this a direct child add 
					newRule.addConditionToMain(current);
					
				} else {
					
					for (Field f:nodeRelations) {	
						// i need the class that the field belongs to boooook
						String referenceOfCondition = Util.getDecReference(f);
						if (slog.error() != null)
							slog.error().log("[" +referenceOfCondition + "],");
					}
					if (slog.error() != null)
						slog.error().log("\n");
					newRule.processNodeValue(current, nodeRelations, 0, 1);	//int condition_or_action = condition = 1
				}
			} else {

				ArrayList<Field> nodeRelations = attrRelations.get(current.getFReference());
				if (nodeRelations == null || nodeRelations.isEmpty()) { 
					// this a direct child add to reference to the main guy 
					newRule.addActionToMain(current);
				} else {
					newRule.processNodeValue(current, nodeRelations, 0, 2);	//int condition_or_action = action = 2	
				}
			}
		}
		return newRule;	
	}
	
	public void write2File(String toWrite, boolean append, String fileSignature) {//DomainType domain_type, int tree_set  
	
		//String drlFileName = 
		if (!fileSignature.endsWith(".drl"))
			fileSignature += ".drl";
		System.out.println("file:"+ fileSignature);
		File file =new File(fileSignature);
		if (append)
		{
			if(!file.exists())
				//flog.warn("File doesnot exit, creating...");
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(fileSignature, true));
				out.write(toWrite);
				out.close();
				//System.out.println("I wrote "+ toWrite);
			} catch (IOException e) {
				//flog.error("No I couldnot append to the file e:"+ e);
				/* TODO */
			}

		} else {
			if(file.exists()&& (file.length()>0)) {
				file.delete();
				//flog.warn("File exits, deleting...");
			}
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(fileSignature));
				out.write(toWrite);
				out.close();
			} catch (IOException e) {
				//flog.error("No I couldnot create the file e:"+ e);
				/* TODO */
			}
		}
	}
	
	public String write2string(){//String packageName) {
		StringBuffer outputBuffer = new StringBuffer();
		
		String packageName = this.getRuleClass().getPackage().getName();
		
		//log.debug("Package name: "+ packageName);
		
		if (packageName != null)
			outputBuffer.append("package " + packageName +";\n\n");
		
		else {
			//TODO throw exception
			//flog.error("RulePrinter write2string packageName="+packageName);
		}
		
//		flog.debug(new Object() {
//			public String toString() {	
//				String out = "//Num of rules " +rules.size()+"\n //this.getBoundOnNumRules() "+ getBoundOnNumRules();
//				return out;	
//			}
//		});
	
		int total_num_facts=0;
		int i = 0, active_i = 0;
		for( Rule rule: rules) {
			i++;
			//flog.debug("Rule: "+ i);
			if (Util.ONLY_ACTIVE_RULES) {
				if (rule.getRank() >= 0) {
					active_i++;
//					if (Util.DEBUG_RULE_PRINTER) {
//						System.out.println("//Active rules " +i + " write to drl \n"+ rule +"\n");
//					}
					outputBuffer.append(rule.toString());
					outputBuffer.append("\n");
				}

			} else {
				if (rule.getRank() >= 0) {
					active_i++;
				}
//				if (Util.DEBUG_RULE_PRINTER) {
//					System.out.println("//rule " +i + " write to drl \n"+ rule +"\n");
//				}
				outputBuffer.append(rule.toString());
				outputBuffer.append("\n");
			}
			total_num_facts += rule.getNumClassifiedInstances();	
			if (this.getBoundOnNumRules()>0 && i >= this.getBoundOnNumRules())
				break;
		}
		outputBuffer.append("//THE END: Total number of facts correctly classified= "+ total_num_facts + " over "+ this.getNumInstances());
		outputBuffer.append("\n//with " + active_i + " number of rules over "+i+" total number of rules ");
		outputBuffer.append("\n"); // EOF
		
		return outputBuffer.toString();
	}
}

class Rule {
	
	private Class<?> main_obj;	// object class name
	private ArrayList<Declaration> rule_decs;
	private ArrayList<AttrReference>  actions;
	
	// key: the reference of the declaration, => id of the declaration
	private HashMap <String, Integer> declarationMap;
	
	private int num_declarations; 
	
	private double rank;				 // matching ratio
	private double num_classified_instances;// number of instances matching that rule
	
	private int id;						 // unique id, need a unique name in the drl file
//	private String referenceToMain = main_obj.getName()+"0";
	private int main_obj_id = 0;
	
	Rule(Class<?> obj, int numCond) {
		num_declarations = 0;
		rule_decs = new ArrayList<Declaration>(1); //new ArrayList<Declaration>(1);
		declarationMap = new HashMap<String, Integer>(1);
		main_obj= obj;
		String obj_ref = getObjectClassName().toLowerCase();
		declarationMap.put(obj_ref, num_declarations);
		
		rule_decs.add(new Declaration(main_obj, obj_ref, num_declarations));
		actions = new ArrayList<AttrReference>(1);
	}
	
	public void addConditionToMain(NodeValue current) {
		rule_decs.get(main_obj_id).addCondition(current);
	}
	
	public void addActionToMain(NodeValue current) {
		AttrReference aRef = new AttrReference(current);	//D
		rule_decs.get(main_obj_id).addActionReference(aRef);						//D
		addAction(aRef);									//D
		setRuleStats(current);								//D
	}
	
	public void addCondition(NodeValue current, ArrayList<Field> nodeRelations, int rel_id) {
		if (rel_id == nodeRelations.size()) {	// it must be primitive
			Field referenceField = nodeRelations.get(nodeRelations.size()-1);			
			String referenceOfCondition = Util.getDecReference(referenceField);
			
			System.out.println("It is primitive, should add a condition to its father "+referenceOfCondition+ " rel_id "+ rel_id + " size "+ (nodeRelations.size()-1)+ " \n");	
			Declaration dec = rule_decs.get(declarationMap.get(referenceOfCondition));
			dec.addCondition(current);					//D
		} else {
			Field referenceField = nodeRelations.get(rel_id);			
			String referenceOfCondition = Util.getDecReference(referenceField);
			System.out.println("referenceOfCondition " +referenceOfCondition + " rel_id "+ rel_id + " size "+ (nodeRelations.size()-1));
			Declaration the_place_declared = null;
			
			if (rel_id ==0 ) {
				
				the_place_declared = rule_decs.get(0);
				System.out.println("The first guy "+referenceField.getName()+" to main declaration (ref?)"+ " rel_id "+ rel_id + " size "+ (nodeRelations.size()-1)+ " \n");	
				
			} else {
				the_place_declared = rule_decs.get(rel_id-1);//declarationMap.get(referenceOfCondition));
				System.out.println("Continue"+referenceField.getName()+" in "+the_place_declared+ "??? rel_id "+ rel_id + " size "+ (nodeRelations.size()-1)+ " \n");	
			}
			
			if (!the_place_declared.hasReference(referenceField.getName())) {
				num_declarations++;
				Declaration new_dec = new Declaration(referenceField.getType(), referenceField.getName(), num_declarations);
				System.out.println("Create new dec "+referenceOfCondition+" (Main declaration doesnot have a ref"+ referenceField.getName() + ") rel_id "+ rel_id + " size "+ (nodeRelations.size()-1)+ " \n");	
				
				the_place_declared.addReference(new_dec);					//D
				declarationMap.put(referenceOfCondition, num_declarations);
				rule_decs.add(new_dec);
			}
			
			addCondition(current, nodeRelations, rel_id+1);
			
		}
	}
	
	public void processNodeValue(NodeValue current, ArrayList<Field> nodeRelations, int rel_id, int condition_or_action) {
		if (rel_id == nodeRelations.size()) {	// it must be primitive
			Field referenceField = nodeRelations.get(nodeRelations.size()-1);			
			String referenceOfCondition = Util.getDecReference(referenceField);
			
			System.out.println("It is primitive, should add a condition to its father "+referenceOfCondition+ " rel_id "+ rel_id + " size "+ (nodeRelations.size()-1)+ " \n");	
			Declaration dec = rule_decs.get(declarationMap.get(referenceOfCondition));
			
			switch (condition_or_action) {
			case 1: // condition
				dec.addCondition(current);					//D
				break;
			case 2: // action
				AttrReference aRef = new AttrReference(current);	//D
				dec.addActionReference(aRef);						//D
				addAction(aRef);									//D
				setRuleStats (current);								//D
				break;
			}
			return;

		} else {
			Field referenceField = nodeRelations.get(rel_id);			
			String referenceOfCondition = Util.getDecReference(referenceField);
			System.out.println("referenceOfCondition " +referenceOfCondition + " rel_id "+ rel_id + " size "+ (nodeRelations.size()-1));
			Declaration the_place_declared = null;
			
			if (rel_id ==0 ) {	
				the_place_declared = rule_decs.get(0);
				System.out.println("The first guy "+referenceField.getName()+" to main declaration (ref?)"+ " rel_id "+ rel_id + " size "+ (nodeRelations.size()-1)+ " \n");	
				
			} else {
				the_place_declared = rule_decs.get(rel_id-1);//declarationMap.get(referenceOfCondition));
				System.out.println("Continue"+referenceField.getName()+" in "+the_place_declared+ "??? rel_id "+ rel_id + " size "+ (nodeRelations.size()-1)+ " \n");	
			}
			
			if (!the_place_declared.hasReference(referenceField.getName())) {
				num_declarations++;
				Declaration new_dec = new Declaration(referenceField.getType(), referenceField.getName(), num_declarations);
				System.out.println("Create new dec "+referenceOfCondition+" (Main declaration doesnot have a ref"+ referenceField.getName() + ") rel_id "+ rel_id + " size "+ (nodeRelations.size()-1)+ " \n");	
				switch (condition_or_action) {
				case 1: // condition
					the_place_declared.addReference(new_dec);			//D
					break;
				case 2: // action
					AttrReference aRef = new AttrReference(current);	//D
					the_place_declared.addActionReference(aRef);		//D
					break;
				}
				declarationMap.put(referenceOfCondition, num_declarations);
				rule_decs.add(new_dec);
			}
			
			processNodeValue(current, nodeRelations, rel_id+1, condition_or_action);	
			
		}
	}
	
	public void addAction(AttrReference aRef) {
		actions.add(aRef);	
	}
	
	public void setRuleStats (NodeValue current) {
		this.setRank(((LeafNode)current.getNode()).getRank());
		this.setNumClassifiedInstances(((LeafNode)current.getNode()).getNumClassification());
	}
	


	public String getObjectClassName() {
		return main_obj.getSimpleName();
	}
	
	private int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id= id;
	}
	
	private void setNumClassifiedInstances(double dataSize) {
		this.num_classified_instances = dataSize;	
	}
	public double getNumClassifiedInstances() {
		return this.num_classified_instances;	
	}

	public void setRank(double r) {
		this.rank = r;
	}
	public double getRank() {
		return this.rank;
	}
	
	public String toString() {
		/*		 
		rule "Good Bye"
    		dialect "java"
			when
				$m:Message( status == Message.GOODBYE)
			then
				System.out.println( "[getLabel()] Expected value (" + $c.getLabel() + "), Classified as (False)"); 
		end
		
		// complex rule
		rule "Purchase notification"
    		salience 10

			when
				$c : Customer( name == "Bla")
				$p : Purchase( amount == 1, customer == $c)	    
			then
	    		System.out.println( "Customer " + $c.name + " just purchased " + $p.product.name );
		end
		 */
		//"rule \"#"+getId()+" "+decision+" rank:"+rank+"\" \n";
		StringBuffer sb_out = new StringBuffer("");
		
		sb_out.append("\t when");
		for (int dec_i =rule_decs.size()-1; dec_i>=0; dec_i--) {
			Declaration d = rule_decs.get(dec_i);
			String obj_ref = d.getSymbol(); //"$"+this.getObjectClassName().substring(0, 1).toLowerCase();
			sb_out.append("\n\t\t "+obj_ref+" : "+d.getDeclaringFTypeCanonicalName()+"("+ "");
			Iterator<NodeValue> dec_it = d.getConditionIt();
			while (dec_it.hasNext()) {
				NodeValue cond = dec_it.next();
				sb_out.append(cond.toString() + ", ");
			}
			
			Iterator<Reference> ref_it = d.getReferenceIt();
			while (ref_it.hasNext()) {
				Reference ref = ref_it.next();
				sb_out.append(ref.toString() + ", ");
			}			
			sb_out.delete(sb_out.length()-2, sb_out.length()-1);
			sb_out.append(")\n");
		}
		
		StringBuffer sb_action = new StringBuffer("");
		StringBuffer sb_field = new StringBuffer("");
		StringBuffer sb_expected_value = new StringBuffer("");
		for (AttrReference act: actions) {
			sb_action.append(act.getValue() + " , ");
			sb_expected_value.append(act.getVariableName()); 
			sb_field.append(act.getFName() + "");
			
		}
		sb_action.delete(sb_action.length()-3, sb_action.length()-1);
		
		sb_out.append("\t then ");
		sb_out.append("\n\t\t System.out.println(\"["+sb_field.toString()+ "] Expected value (\" + "+  sb_expected_value.toString()+ " + \"), Classified as ("+sb_action.toString()+")\");\n"); 
		if (getRank() <0)
			sb_out.append("\n\t\t System.out.println(\"But no matching fact found = DOES not fire on\");\n");
		
		sb_out.insert(0, "rule \"#"+getId()+" "+sb_field.toString()+ "= "+sb_action.toString()+" classifying "+this.getNumClassifiedInstances()+" num of facts with rank:"+getRank() +"\" \n");
		sb_out.append("end\n");

		return sb_out.toString();
	}
	
	
//	public String toString_() {
//		/*		 
//		rule "Good Bye"
//    		dialect "java"
//			when
//				$m:Message( status == Message.GOODBYE)
//			then
//				System.out.println( "[getLabel()] Expected value (" + $c.getLabel() + "), Classified as (False)"); 
//		end
//		 */
//		//"rule \"#"+getId()+" "+decision+" rank:"+rank+"\" \n";
//		StringBuffer sb_out = new StringBuffer("");
//		String obj_ref = "$"+this.getObjectClassName().substring(0, 1).toLowerCase();
//
//		sb_out.append("\t when");
//		sb_out.append("\n\t\t "+obj_ref+":"+this.getObjectClassName() +"("+ "");
////		for (NodeValue cond: conditions) {
////			sb_out.append(cond.toString() + ", ");
////		}
//		
//		StringBuffer sb_action = new StringBuffer("");
//		StringBuffer sb_field = new StringBuffer("");
//		StringBuffer sb_expected_value = new StringBuffer("");
//		for (NodeValue act: actions) {
//			// if the query is on a field then i have to get its value during in the rule 'cause it might be private
//			if (!act.getNode().getDomain().isArtificial())
//				sb_out.append(obj_ref+ "_"+act.getFName() + " : "+act.getFName()+", ");
//			
//			sb_action.append(act.getNodeValue() + " , ");
//			if (!act.getNode().getDomain().isArtificial())
//				sb_field.append(act.getFName() + "");
//			else
//				sb_field.append(act.getFName() + "()");
//			
//			
//			if (!act.getNode().getDomain().isArtificial())
//				sb_expected_value.append(obj_ref+ "_"+act.getFName());//reading the value by the reference of $o_fieldname
//			else
//				sb_expected_value.append(obj_ref+ "."+act.getFName() + "()");// reading the value from the object $o.function()
//			
//		}
//		sb_action.delete(sb_action.length()-3, sb_action.length()-1);
//		sb_out.delete(sb_out.length()-2, sb_out.length()-1);
//		sb_out.append(")\n");
//		sb_out.append("\t then ");
//		sb_out.append("\n\t\t System.out.println(\"["+sb_field.toString()+ "] Expected value (\" + "+  sb_expected_value.toString()+ " + \"), Classified as ("+sb_action.toString()+")\");\n"); 
//		if (getRank() <0)
//			sb_out.append("\n\t\t System.out.println(\"But no matching fact found = DOES not fire on\");\n");
//		
//		sb_out.insert(0, "rule \"#"+getId()+" "+sb_field.toString()+ "= "+sb_action.toString()+" classifying "+this.getNumClassifiedInstances()+" num of facts with rank:"+getRank() +"\" \n");
//		sb_out.append("end\n");
//
//		return sb_out.toString();
//	}
	
	public static Comparator<Rule> getRankComparator() {
		return new RuleComparator();
	}
	
	private static class RuleComparator implements Comparator<Rule>{
		// this will sort from best rank to least rank
		public int compare(Rule r1, Rule r2) {
			if (r1.getRank() < r2.getRank())
				return 1; // normally -1
			else if (r1.getRank() > r2.getRank())
				return -1; // normally 1
			else
				return 0;
		}	
	}

}

class Declaration{
	private int id; 
	private String dec_ref; 		
	private Class<?> declared_obj;	// object class name
//	private ArrayList<RuleNode> conditions;
	private ArrayList<NodeValue> conditions;
	private ArrayList<Reference> references;
	
	public Declaration(Class<?> obj_class, String name, int dec_id) {
		id = dec_id;
		declared_obj = obj_class;
		dec_ref = name;
		references = new ArrayList<Reference>();
		conditions = new ArrayList<NodeValue>();
	}
	
	public String getDeclaringFName() {
		return dec_ref;
	}
	
	public String getDeclaringFTypeCanonicalName() {
		return declared_obj.getSimpleName();
	}

	public void addCondition(NodeValue current) {
		NodeValue nv = new NodeValue(current.getNode());
		nv.setNodeValue(current.getNodeValue());
		conditions.add(nv);
	}
	
	public void addActionReference(AttrReference aRef) {//NodeValue current) {
		references.add(aRef);

	}
	
	public void addReference(Declaration d) {
		DecReference df = new DecReference(d);
		references.add(df);
	}
	
	public boolean hasReference(String fName) {
		for (Reference df : references) {
			if (df.getFName().equalsIgnoreCase(fName))
				return true;
		}
		return false;
		
	}
	
	public Iterator<NodeValue> getConditionIt() {
		return conditions.iterator();
	}
	public Iterator<Reference> getReferenceIt() {
		return references.iterator();
	}
	
	public String getSymbol() {
		return "$"+dec_ref + "_" + id;
	}
	
}

interface Reference {
	public String getFName();
}
class DecReference implements Reference {
	
	private String fName;
	Declaration toReference;
	
	public DecReference (Declaration d) {
		toReference = d;
		fName = d.getDeclaringFName();
	}
	
	public String getFName() {
		return fName;
	}
	public void setReference(Declaration _toReference) {
		toReference = _toReference;
	}
	
	
	public String toString() {
		return fName + " == "+ toReference.getSymbol();
	}
}

class AttrReference implements Reference {
	
	private String fName;
	private NodeValue real_value;
	
	public AttrReference (NodeValue v) {
		String _fName = v.getFName();
		if (v.getNode().getDomain().isArtificial()) {
			_fName = Util.getFieldName(_fName);
		}
		fName = _fName;
		real_value = new NodeValue(v.getNode());
		real_value.setNodeValue(v.getNodeValue());
	}
	public Object getVariableName() {
		return "$target_label";
	}
	public Object getValue() {
		return real_value.getNodeValue();
	}
	public String getFName() {
		return fName;
	}
	
	public String toString() {
		return getVariableName()+" : "+ fName ;
	}
}


class NodeValue { //implements RuleNode {
	
	//private static final Logger flog = LoggerFactory.getFileLogger(NodeValue.class, LogLevel.ERROR, Util.log_file); 
	
	private TreeNode node;
	private Object nodeValue;	// should it be Attribute???
	
	public NodeValue(TreeNode n) {
		this.node = n;
	}
	public String getFReference() {
		return node.getDomain().getFReferenceName();
	}
	
	public String getFName() {
//		String full_name = node.getDomain().getFName();
//		String fname = full_name.substring(full_name.lastIndexOf('@')+1, full_name.length());
		return node.getDomain().getFName() ;
	}
	
	public Object getNodeValue() {
		return nodeValue;
	}
	public void setNodeValue(Object category) {
		this.nodeValue = category;
		
	}
	
	public TreeNode getNode() {
		return node;
	}
	
	public String toString() {
		
		String fName = this.getFName();//object class name
		Class<?> node_obj = node.getDomain().getObjKlass();
		
		String value;
		if (node.getDomain().getFType() == String.class)
			value = "\""+nodeValue+ "\""; 
		else
			value = nodeValue + "";
		
		if (node.getDomain().isCategorical())
			return fName + " == "+ value; 
		else {
			
			int size = node.getDomain().getCategoryCount()-1;
			//System.out.println("How many guys there of "+node.getDomain().getName() +" and the value "+nodeValue+" : "+size);
			
			int idx = size;
			if (nodeValue instanceof Number) {
				for (; idx>=0; idx--) {
					Object categoryValue = node.getDomain().getCategory(idx);
					if (nodeValue instanceof Comparable && categoryValue instanceof Comparable) {
						// TODO ask this to daniel???
//						if (Util.DEBUG_RULE_PRINTER) {
//							System.out.println("NodeValue:"+ nodeValue+ " c-"+nodeValue.getClass() +" & category:"+ categoryValue+ " c-"+categoryValue.getClass());
//						}
						if ( AttributeValueComparator.instance.compare(nodeValue, categoryValue) == 0 ) {
							break;
						}
					} else {
						System.out.println("Fuck not comparable NodeValue:"+ nodeValue+ " c-"+nodeValue.getClass() +" & category:"+ categoryValue+ " c-"+categoryValue.getClass());
						System.exit(0);
					}

				}
			} else {
				/* TODO implement the String setting */
				System.out.println("Fuck not number:"+ nodeValue+ " c-"+nodeValue.getClass());
				System.exit(0);

			}
			
			if (idx == 0)
				return fName + " <= "+ value;
			else if (idx == size)
				// if the category is the last one that the rule is domain.name > category(last-1)
				return fName+ " > "+ node.getDomain().getCategory(size-1);
			else {
				//return node.getDomain().getCategory(idx) + " < " + fName+ " <= "+ node.getDomain().getCategory(idx+1);
				// Why drools does not support category(idx) < domain.name <= category(idx+1)
				//flog.debug("value "+ value + "=====?????"+   node.getDomain().getCategory(idx+1));
				
				return fName+ " <= "+ value; // node.getDomain().getCategory(idx+1);
			}
		}
	}
	
	public String toString_() {
		
		String fName = this.getFName();//node.getDomain().getFName();
		String value;
		if (node.getDomain().getFType() == String.class)
			value = "\""+nodeValue+ "\""; 
		else
			value = nodeValue + "";
		
		if (node.getDomain().isCategorical())
			return fName + " == "+ value; 
		else {
			
			int size = node.getDomain().getCategoryCount()-1;
			//System.out.println("How many guys there of "+node.getDomain().getName() +" and the value "+nodeValue+" : "+size);
			
			int idx = size;
			if (nodeValue instanceof Number) {
				for (; idx>=0; idx--) {
					Object categoryValue = node.getDomain().getCategory(idx);
					if (nodeValue instanceof Comparable && categoryValue instanceof Comparable) {
						// TODO ask this to daniel???
//						if (Util.DEBUG_RULE_PRINTER) {
//							System.out.println("NodeValue:"+ nodeValue+ " c-"+nodeValue.getClass() +" & category:"+ categoryValue+ " c-"+categoryValue.getClass());
//						}
						if ( AttributeValueComparator.instance.compare(nodeValue, categoryValue) == 0 ) {
							break;
						}
					} else {
						System.out.println("Fuck not comparable NodeValue:"+ nodeValue+ " c-"+nodeValue.getClass() +" & category:"+ categoryValue+ " c-"+categoryValue.getClass());
						System.exit(0);
					}

				}
			} else {
				/* TODO implement the String setting */
				System.out.println("Fuck not number:"+ nodeValue+ " c-"+nodeValue.getClass());
				System.exit(0);

			}
			
			if (idx == 0)
				return fName + " <= "+ value;
			else if (idx == size)
				// if the category is the last one that the rule is domain.name > category(last-1)
				return fName+ " > "+ node.getDomain().getCategory(size-1);
			else {
				//return node.getDomain().getCategory(idx) + " < " + fName+ " <= "+ node.getDomain().getCategory(idx+1);
				// Why drools does not support category(idx) < domain.name <= category(idx+1)
				//flog.debug("value "+ value + "=====?????"+   node.getDomain().getCategory(idx+1));
				
				return fName+ " <= "+ value; // node.getDomain().getCategory(idx+1);
			}
		}
	}
	
}
