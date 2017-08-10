package org.drools.examples.learner;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.drools.learner.DecisionTree;
import org.drools.learner.builder.DecisionTreeFactory;
import org.drools.learner.tools.ObjectFactory;

public class MannersLearnerBenchmark {
	public static final void main(final String[] args) throws Exception {
//		long start_time = System.currentTimeMillis();
//		// my rule base
//		final RuleBase ruleBase = RuleBaseFactory.newRuleBase();
//		//ruleBase.addPackage( pkg );
//
//		final StatefulSession session = ruleBase.newStatefulSession();
//		// LearningSession
//
////		// what are these listeners???
////		session.addEventListener( new DebugAgendaEventListener() );
////		session.addEventListener( new DebugWorkingMemoryEventListener() );
////
////		final WorkingMemoryFileLogger logger = new WorkingMemoryFileLogger( session );
////		logger.setFileName( "log/poker" );
//
//
//		String filename;
//        if ( args.length != 0 ) {
//            String arg = args[0];
//            filename = arg;
//        } else {
//            filename = "manners64.dat";
//        }
//
//        InputStream is = MannersBenchmark.class.getResourceAsStream( filename );
//        Class<?> obj_class = Guest.class;
//        List list = MannersBenchmark.getInputObjects( is );
//        for ( Iterator it = list.iterator(); it.hasNext(); ) {
//            Object object = it.next();
//            session.insert( object );
//        }
//
//		// instantiate a learner for a specific object class and pass session to train
//		DecisionTree decision_tree; int ALGO = 111;
//		/*
//		 * Single	1xx, Bag 	2xx, Boost 3xx
//		 * ID3 		x1x, C45 	x2x
//		 * Entropy	xx1, Gain	xx2
//		 */
//		switch (ALGO) {
//		case 111:
//			decision_tree  = DecisionTreeFactory.createSingleID3E(session, obj_class);
//			break;
//		case 112:
//			decision_tree  = DecisionTreeFactory.createSingleID3G(session, obj_class);
//			break;
//		case 121:
//			decision_tree  = DecisionTreeFactory.createSingleC45E(session, obj_class);
//			break;
//		case 122:
//			decision_tree  = DecisionTreeFactory.createSingleC45G(session, obj_class);
//			break;
//		case 221:
//			decision_tree  = DecisionTreeFactory.createBagC45E(session, obj_class);
//			break;
//
//		default:
//			decision_tree  = DecisionTreeFactory.createSingleID3E(session, obj_class);
//
//		}
		
//		final PackageBuilder builder = new PackageBuilder();
//		//this wil generate the rules, then parse and compile in one step
//		builder.addPackageFromTree( decision_tree );
//		/*
//		 * get the compiled package (which is serializable) from the builder
//		 * add the package to a rulebase (deploy the rule package).
//		 */
//		ruleBase.addPackage( builder.getPackage() );
//
//		session.fireAllRules();
//		long end_time = System.currentTimeMillis();
//		System.out.println("Total time="+ (end_time-start_time));
//
////		logger.writeToDisk();
//
//		session.dispose();
	}
}
