package org.drools.examples.learner;

import java.util.List;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.StatefulSession;
import org.drools.audit.WorkingMemoryFileLogger;
import org.drools.compiler.PackageBuilder;
import org.drools.event.DebugAgendaEventListener;
import org.drools.event.DebugWorkingMemoryEventListener;
import org.drools.learner.DecisionTree;
import org.drools.learner.builder.DecisionTreeBuilder;
import org.drools.learner.builder.DecisionTreeFactory;
import org.drools.learner.tools.ObjectFactory;

public class CarExample {
	
	
	public static final void main(final String[] args) throws Exception {
		// my rule base 
		final RuleBase ruleBase = RuleBaseFactory.newRuleBase();

		final StatefulSession session = ruleBase.newStatefulSession();	// LearningSession

		//session.addEventListener( new DebugAgendaEventListener() );
		//session.addEventListener( new DebugWorkingMemoryEventListener() );

		//final WorkingMemoryFileLogger logger = new WorkingMemoryFileLogger( session );
		//logger.setFileName( "log/car" );   
		
		String inputFile = new String("data/car/car.data.txt");
		Class<?> obj_class = Car.class;
		List<Object> facts = ObjectFactory.getObjects(obj_class, inputFile);
		for (Object r : facts) {
			session.insert(r);
		}

		// instantiate a learner for a specific object class and pass session to train
		DecisionTree decision_tree; int ALGO = 2;
		switch (ALGO) {
		case 1:
		decision_tree  = DecisionTreeFactory.createBaggedC45(session, obj_class);
			break;
		case 2:
		decision_tree  = DecisionTreeFactory.createBoostedC45(session, obj_class);
			break;
		case 3:
		decision_tree  = DecisionTreeFactory.createSingleID3(session, obj_class);
			break;
		default:
			decision_tree  = DecisionTreeFactory.createSingleC45(session, obj_class);
		
		}
		
		final PackageBuilder builder = new PackageBuilder();
		//this wil generate the rules, then parse and compile in one step
		builder.addPackageFromTree( decision_tree );
		System.exit(0);
		ruleBase.addPackage( builder.getPackage() );
		/* 
			final Reader source = new InputStreamReader( HelloWorldExample.class.getResourceAsStream( "HelloWorld.drl" ) );
			//get the compiled package (which is serializable)
		    final Package pkg = builder.getPackage();
		    //add the package to a rulebase (deploy the rule package).
		    ruleBase.addPackage( pkg );
		 */

		session.fireAllRules();

		//logger.writeToDisk();

		session.dispose();
	}
}
