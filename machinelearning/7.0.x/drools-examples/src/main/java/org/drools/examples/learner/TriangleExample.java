package org.drools.examples.learner;

import java.util.List;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.StatefulSession;
import org.drools.compiler.PackageBuilder;
import org.drools.learner.DecisionTree;
import org.drools.learner.builder.DecisionTreeFactory;
import org.drools.learner.tools.ObjectFactory;
import org.drools.learner.tools.ReteStatistics;
import org.drools.learner.tools.Util;

public class TriangleExample {
	
	public static final void main(final String[] args) throws Exception {
		long start_time = System.currentTimeMillis();
		// my rule base 
		final RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		//ruleBase.addPackage( pkg );

		final StatefulSession session = ruleBase.newStatefulSession();
		// LearningSession

//		// what are these listeners???
//		session.addEventListener( new DebugAgendaEventListener() );
//		session.addEventListener( new DebugWorkingMemoryEventListener() );
//
//		final WorkingMemoryFileLogger logger = new WorkingMemoryFileLogger( session );
//		logger.setFileName( "log/poker" );   
		
		String inputFile = new String("data/triangle/triangle.data.txt");
		Class<?> obj_class = Triangle.class;
		List<Object> facts = ObjectFactory.getObjects(obj_class, inputFile);
		for (Object r : facts) {
			session.insert(r);
		}

		// instantiate a learner for a specific object class and pass session to train
		DecisionTree decision_tree; int ALGO = 121;
		/* 
		 * Single	1xx, Bag 	2xx, Boost 3xx
		 * ID3 		x1x, C45 	x2x
		 * Entropy	xx1, Gain	xx2
		 */
		switch (ALGO) {
		case 111:
			decision_tree  = DecisionTreeFactory.createSingleID3E(session, obj_class);
			break;
		case 112:
			decision_tree  = DecisionTreeFactory.createSingleID3G(session, obj_class);
			break;
		case 121: 
			decision_tree  = DecisionTreeFactory.createSingleC45E(session, obj_class);
			break;
		case 122: 
			decision_tree  = DecisionTreeFactory.createSingleC45G(session, obj_class);
			break;
		case 123: 
			decision_tree  = DecisionTreeFactory.createSingleC45E_worst(session, obj_class);
			break;
		case 124: 
			decision_tree  = DecisionTreeFactory.createSingleC45Random(session, obj_class);
			break;
		case 131: 
			decision_tree  = DecisionTreeFactory.createSingleC45E_Stop(session, obj_class);
			break;
		case 132: 
			decision_tree  = DecisionTreeFactory.createSingleC45G_Stop(session, obj_class);
			break;
		case 141: 
			decision_tree  = DecisionTreeFactory.createSingleC45E_PrunStop(session, obj_class);
			break;
		case 142: 
			decision_tree  = DecisionTreeFactory.createSingleC45G_PrunStop(session, obj_class);
			break;
		case 221:
			decision_tree  = DecisionTreeFactory.createBagC45E(session, obj_class);
			break;		
		case 222:
			decision_tree  = DecisionTreeFactory.createBagC45G(session, obj_class);
			break;	
		case 231:
			decision_tree  = DecisionTreeFactory.createBagC45E_Stop(session, obj_class);
			break;		
		case 232:
			decision_tree  = DecisionTreeFactory.createBagC45G_Stop(session, obj_class);
			break;	
		case 241:
			decision_tree  = DecisionTreeFactory.createBagC45E_PrunStop(session, obj_class);
			break;		
		case 242:
			decision_tree  = DecisionTreeFactory.createBagC45G_PrunStop(session, obj_class);
			break;
		case 321:
			decision_tree  = DecisionTreeFactory.createBoostC45E(session, obj_class);
			break;		
		case 322:
			decision_tree  = DecisionTreeFactory.createBoostC45G(session, obj_class);
			break;	
		case 331:
			decision_tree  = DecisionTreeFactory.createBoostC45E_Stop(session, obj_class);
			break;		
		case 332:
			decision_tree  = DecisionTreeFactory.createBoostC45G_Stop(session, obj_class);
			break;	
		case 341:
			decision_tree  = DecisionTreeFactory.createBoostC45E_PrunStop(session, obj_class);
			break;		
		case 342:
			decision_tree  = DecisionTreeFactory.createBoostC45G_PrunStop(session, obj_class);
			break;
		default:
			decision_tree  = DecisionTreeFactory.createSingleID3E(session, obj_class);
		
		}
		
		final PackageBuilder builder = new PackageBuilder();
		//this wil generate the rules, then parse and compile in one step
		builder.addPackageFromTree( decision_tree );
		/* 
		 * get the compiled package (which is serializable) from the builder
		 * add the package to a rulebase (deploy the rule package). 
		 */
		ruleBase.addPackage( builder.getPackage() );

		session.fireAllRules();
		long end_time = System.currentTimeMillis();
		System.out.println("Total time="+ (end_time-start_time));
		
		
        ReteStatistics stats = new ReteStatistics(ruleBase);
        stats.calculateNumberOfNodes();
        stats.print(Util.DRL_DIRECTORY + decision_tree.getSignature());
//		logger.writeToDisk();

		session.dispose();
	}
	
	

}
