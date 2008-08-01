package org.drools.learner.builder;

import java.util.ArrayList;

import org.drools.WorkingMemory;
import org.drools.learner.DecisionTree;
import org.drools.learner.DecisionTreePruner;
import org.drools.learner.Memory;
import org.drools.learner.builder.Learner.DataType;
import org.drools.learner.builder.Learner.DomainAlgo;
import org.drools.learner.builder.DecisionTreeBuilder.TreeAlgo;
import org.drools.learner.eval.CrossValidation;
import org.drools.learner.eval.Entropy;
import org.drools.learner.eval.EstimatedNodeSize;
import org.drools.learner.eval.GainRatio;
import org.drools.learner.eval.Heuristic;
import org.drools.learner.eval.StoppingCriterion;
import org.drools.learner.tools.FeatureNotSupported;
import org.drools.learner.tools.Util;


// uses the static functions from the deprecated class DecisionTreeFactory
public class DecisionTreeFactory {
	
	public static DecisionTree createSingleID3E(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createSingleID3(wm, obj_class, new Entropy());
	}
	
	public static DecisionTree createSingleID3G(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createSingleID3(wm, obj_class, new GainRatio());
	}
	
	protected static DecisionTree createSingleID3(WorkingMemory wm, Class<? extends Object> obj_class, Heuristic h) throws FeatureNotSupported {	
		/*
		 * Quesitons:
		 * 1- which class to work with? : obj_class
		 * 2- what is its target attribute?
		 * 3- what are the objects
		 */ 
		DataType data = Learner.DEFAULT_DATA;
		ID3Learner learner = new ID3Learner(h);
		SingleTreeBuilder single_builder = new SingleTreeBuilder();
		
//		String algo_suffices = org.drools.learner.deprecated.DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), single_builder.getTreeAlgo());
//		String executionSignature = org.drools.learner.deprecated.DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		String algo_suffices = DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), single_builder.getTreeAlgo());
		String executionSignature = DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		
		/* create the memory */
		Memory mem = Memory.createFromWorkingMemory(wm, obj_class, learner.getDomainAlgo(), data);
		single_builder.build(mem, learner);//obj_class, target_attr, working_attr
		
		SingleTreeTester tester = new SingleTreeTester(learner.getTree());
		tester.printStats(tester.test(mem.getClassInstances()), Util.DRL_DIRECTORY + executionSignature);
		//Tester.test(c45, mem.getClassInstances());
		
		learner.getTree().setSignature(executionSignature);
		return learner.getTree();
	}
	public static DecisionTree createSingleC45E(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createSingleC45(wm, obj_class, new Entropy());
	}
	
	public static DecisionTree createSingleC45G(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createSingleC45(wm, obj_class, new GainRatio());
	}
	
	protected static DecisionTree createSingleC45(WorkingMemory wm, Class<? extends Object> obj_class, Heuristic h) throws FeatureNotSupported {
		DataType data = Learner.DEFAULT_DATA;
		C45Learner learner = new C45Learner(h);
		
		SingleTreeBuilder single_builder = new SingleTreeBuilder();
		
//		String algo_suffices = org.drools.learner.deprecated.DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), single_builder.getTreeAlgo());
//		String executionSignature = org.drools.learner.deprecated.DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		String algo_suffices = DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), single_builder.getTreeAlgo());
		String executionSignature = DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		
		/* create the memory */
		Memory mem = Memory.createFromWorkingMemory(wm, obj_class, learner.getDomainAlgo(), data);
		single_builder.build(mem, learner);//obj_class, target_attr, working_attr
		
		SingleTreeTester tester = new SingleTreeTester(learner.getTree());
		tester.printStats(tester.test(mem.getClassInstances()), Util.DRL_DIRECTORY + executionSignature);
		//Tester.test(c45, mem.getClassInstances());
		
		learner.getTree().setSignature(executionSignature);
		return learner.getTree();
	}
	
	public static DecisionTree createBagC45E(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createBagC45( wm,obj_class, new Entropy());
	}
	public static DecisionTree createBagC45G(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createBagC45( wm,obj_class, new GainRatio());
	}
	
	protected static DecisionTree createBagC45(WorkingMemory wm, Class<? extends Object> obj_class, Heuristic h) throws FeatureNotSupported {
		DataType data = Learner.DEFAULT_DATA;
		C45Learner learner = new C45Learner(h);	
		ForestBuilder forest = new ForestBuilder();
		
//		String algo_suffices = org.drools.learner.deprecated.DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), forest.getTreeAlgo());
//		String executionSignature = org.drools.learner.deprecated.DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		String algo_suffices = DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), forest.getTreeAlgo());
		String executionSignature = DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		
		/* create the memory */
		Memory mem = Memory.createFromWorkingMemory(wm, obj_class, learner.getDomainAlgo(), data);
		forest.build(mem, learner);
		//forest.clearForest(10);

		ForestTester tester = new ForestTester(forest.getTrees());
		tester.printStats(tester.test(mem.getClassInstances()), Util.DRL_DIRECTORY + executionSignature);
		//forest.test(mem.getClassInstances(), Util.DRL_DIRECTORY+executionSignature);
		
		//Tester bla => test(c45, mem.getClassInstances());
		learner.getTree().setSignature(executionSignature);
		return learner.getTree();
	}
	
	public static DecisionTree createBoostedC45E(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createBoostedC45(wm, obj_class, new Entropy());
	}
	public static DecisionTree createBoostedC45G(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createBoostedC45(wm, obj_class, new GainRatio());
	}
	
	public static DecisionTree createBoostedC45(WorkingMemory wm, Class<? extends Object> obj_class, Heuristic h) throws FeatureNotSupported {
		DataType data = Learner.DEFAULT_DATA;

		C45Learner learner = new C45Learner(h);		
		AdaBoostBuilder forest = new AdaBoostBuilder();
		
//		String algo_suffices = org.drools.learner.deprecated.DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), forest.getTreeAlgo());
//		String executionSignature = org.drools.learner.deprecated.DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		String algo_suffices = DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), forest.getTreeAlgo());
		String executionSignature = DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);

		
		/* create the memory */
		Memory mem = Memory.createFromWorkingMemory(wm, obj_class, learner.getDomainAlgo(), data);
		forest.build(mem, learner);
		//forest.clearForest(10);

		BoostedTester tester = new BoostedTester(forest.getTrees(), forest.getAccuracies());
		tester.printStats(tester.test(mem.getClassInstances()), Util.DRL_DIRECTORY + executionSignature);
		//forest.test(mem.getClassInstances(), Util.DRL_DIRECTORY+executionSignature);
		
		//Tester bla => test(c45, mem.getClassInstances());
		learner.getTree().setSignature(executionSignature);
		return learner.getTree();
	}
	
	public static DecisionTree createSinglePrunnedC45E(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createSinglePrunnedC45(wm, obj_class, new Entropy());
	}
	public static DecisionTree createSinglePrunnedC45G(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createSinglePrunnedC45(wm, obj_class, new GainRatio());
	}
	
	protected static DecisionTree createSinglePrunnedC45(WorkingMemory wm, Class<? extends Object> obj_class, Heuristic h) throws FeatureNotSupported {
		DataType data = Learner.DEFAULT_DATA;
		C45Learner learner = new C45Learner(h);
		
		SingleTreeBuilder single_builder = new SingleTreeBuilder();
		
//		String algo_suffices = org.drools.learner.deprecated.DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), single_builder.getTreeAlgo());
//		String executionSignature = org.drools.learner.deprecated.DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		String algo_suffices = DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), single_builder.getTreeAlgo());
		String executionSignature = DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		
		
		
		/* create the memory */
		Memory mem = Memory.createFromWorkingMemory(wm, obj_class, learner.getDomainAlgo(), data);
		single_builder.build(mem, learner);//obj_class, target_attr, working_attr
		
		CrossValidation validater = new CrossValidation(10, mem.getClassInstances());
		validater.validate(learner);
		
		DecisionTreePruner pruner = new DecisionTreePruner(validater);
		pruner.prun_to_estimate();
		
		// you should be able to get the pruned tree
		// prun.getMinimumCostTree()
		// prun.getOptimumCostTree()
		
		// test the tree
		SingleTreeTester tester = new SingleTreeTester(learner.getTree());
		tester.printStats(tester.test(mem.getClassInstances()), Util.DRL_DIRECTORY + executionSignature);
		
		/* Once Talpha is found the tree that is finally suggested for use is that 
		 * which minimises the cost-complexity using and all the data use the pruner to prun the tree
		 */
		pruner.prun_tree(learner.getTree());
		
		
		// test the tree again
		
		
		//Tester.test(c45, mem.getClassInstances());
		
		learner.getTree().setSignature(executionSignature);
		return learner.getTree();
	}
	
	
	public static DecisionTree createSingleC45E_StoppingCriteria(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createSingleC45_Stop(wm, obj_class, new Entropy());
	}
	
//	public static DecisionTree createSingleC45G(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
//		return createSingleC45(wm, obj_class, new GainRatio());
//	}
	
	protected static DecisionTree createSingleC45_Stop(WorkingMemory wm, Class<? extends Object> obj_class, Heuristic h) throws FeatureNotSupported {
		DataType data = Learner.DEFAULT_DATA;
		ArrayList<StoppingCriterion> stopping_criteria = new ArrayList<StoppingCriterion>();
		stopping_criteria.add(new EstimatedNodeSize(0.5));
		C45Learner learner = new C45Learner(h, stopping_criteria);
		SingleTreeBuilder single_builder = new SingleTreeBuilder();
		
//		String algo_suffices = org.drools.learner.deprecated.DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), single_builder.getTreeAlgo());
//		String executionSignature = org.drools.learner.deprecated.DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		String algo_suffices = DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), single_builder.getTreeAlgo());
		String executionSignature = DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		
		/* create the memory */
		Memory mem = Memory.createFromWorkingMemory(wm, obj_class, learner.getDomainAlgo(), data);
		single_builder.build(mem, learner);//obj_class, target_attr, working_attr
		
		SingleTreeTester tester = new SingleTreeTester(learner.getTree());
		tester.printStats(tester.test(mem.getClassInstances()), Util.DRL_DIRECTORY + executionSignature);
		//Tester.test(c45, mem.getClassInstances());
		
		learner.getTree().setSignature(executionSignature);
		return learner.getTree();
	}
	
	
	public static DecisionTree createSinglePrunnedStopC45E(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createSinglePrunnedStopC45(wm, obj_class, new Entropy());
	}
	public static DecisionTree createSinglePrunnedStopC45G(WorkingMemory wm, Class<? extends Object> obj_class) throws FeatureNotSupported {
		return createSinglePrunnedStopC45(wm, obj_class, new GainRatio());
	}
	
	protected static DecisionTree createSinglePrunnedStopC45(WorkingMemory wm, Class<? extends Object> obj_class, Heuristic h) throws FeatureNotSupported {
		DataType data = Learner.DEFAULT_DATA;
		ArrayList<StoppingCriterion> stopping_criteria = new ArrayList<StoppingCriterion>();
		stopping_criteria.add(new EstimatedNodeSize(0.05));
		C45Learner learner = new C45Learner(h, stopping_criteria);
		
		SingleTreeBuilder single_builder = new SingleTreeBuilder();
	
		String algo_suffices = DecisionTreeFactory.getAlgoSuffices(learner.getDomainAlgo(), single_builder.getTreeAlgo());
		String executionSignature = DecisionTreeFactory.getSignature(obj_class, "", algo_suffices);
		
		/* create the memory */
		Memory mem = Memory.createFromWorkingMemory(wm, obj_class, learner.getDomainAlgo(), data);
		single_builder.build(mem, learner);//obj_class, target_attr, working_attr
		
		CrossValidation validater = new CrossValidation(10, mem.getClassInstances());
		validater.validate(learner);
		
		DecisionTreePruner pruner = new DecisionTreePruner(validater);
		pruner.prun_to_estimate();
		
		// you should be able to get the pruned tree
		// prun.getMinimumCostTree()
		// prun.getOptimumCostTree()
		
		// test the tree
		SingleTreeTester tester = new SingleTreeTester(learner.getTree());
		tester.printStats(tester.test(mem.getClassInstances()), Util.DRL_DIRECTORY + executionSignature);
		
		/* Once Talpha is found the tree that is finally suggested for use is that 
		 * which minimises the cost-complexity using and all the data use the pruner to prun the tree
		 */
		pruner.prun_tree(learner.getTree());
		
		
		// test the tree again
		
		
		//Tester.test(c45, mem.getClassInstances());
		
		learner.getTree().setSignature(executionSignature);
		return learner.getTree();
	}
	
	
	public static String getSignature(Class<? extends Object> obj_class, String fileName, String suffices) {
		
		//String fileName = (dataFile == null || dataFile == "") ? this.getRuleClass().getSimpleName().toLowerCase(): dataFile; 			
		String objectSignature = fileName;
		if (objectSignature == null || objectSignature =="") {
			objectSignature = obj_class.getSimpleName().toLowerCase();
			if (suffices != null && suffices != "")
				objectSignature += "_"+ suffices;
		}
		
		String packageFolders = obj_class.getPackage().getName();
		String _packageNames = packageFolders.replace('.', '/');
		String executionSignature = _packageNames+"/"+ objectSignature; //"src/main/rules/"+
		
		return executionSignature;
		
	}
	
	public static String getAlgoSuffices(DomainAlgo domain_a, TreeAlgo tree_a) {
		String suffix = "";
		switch (domain_a) {
		case CATEGORICAL:
			suffix += "id3" ;
			break;
		case QUANTITATIVE:
			suffix += "c45";
			break;
		default:
			suffix += "?" ;
		
		}
		
		switch (tree_a) {
		case SINGLE:
			suffix += "_one";
			break;
		case BAG:
			suffix += "_bag";
			break;
		case BOOST:
			suffix += "_boost";
			break;
		default:
			suffix += "_?" ;
		
		}
		return suffix;
	}
}
