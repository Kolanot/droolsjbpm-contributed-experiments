package examples;


import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.StatefulSession;
import org.drools.audit.WorkingMemoryFileLogger;
import org.drools.compiler.PackageBuilder;
import org.drools.event.DebugAgendaEventListener;
import org.drools.event.DebugWorkingMemoryEventListener;
import org.drools.rule.Package;

import dt.memory.WorkingMemory;
import dt.tools.FileProcessor;

public class CarExample {

	public static final void main(final String[] args) throws Exception {

		/*
		 * | class values 
		 * 		unacc, acc, good, vgood
		 * | attributes
		 * 		buying: vhigh, high, med, low. 
		 * 		maint: vhigh, high, med, low. 
		 * 		doors: 2, 3, 4, 5, more. 
		 * 		persons: 2, 4, more. 
		 * 		lug_boot: small, med, big.
		 * 		safety: low, med, high.
		 */
		String drlFile = new String("cars" + ".drl");

		WorkingMemory simple = new WorkingMemory();

		Object car = new Car();

		/* create the drl */
		List<Object> my_objects = FileProcessor.processFileExmID3(simple,
				car, drlFile, "data/car/car.data.txt", ",");

		/* parse the drl */
		//read in the source 
		// TODO give an exception of the file does not exist
		final Reader source = new InputStreamReader(Car.class
				.getResourceAsStream(drlFile));

		final PackageBuilder builder = new PackageBuilder();

		//this will parse and compile in one step
		builder.addPackageFromDrl(source);

		// Check the builder for errors
		if (builder.hasErrors()) {
			System.out.println(builder.getErrors().toString());
			throw new RuntimeException("Unable to compile \"" + drlFile + "\".");
		}
		//get the compiled package (which is serializable)
		final Package pkg = builder.getPackage();

		//add the package to a rulebase (deploy the rule package).
		final RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(pkg);

		boolean load_to_drools = false;
		if (load_to_drools) {
			/* feeding the object to Drools working memory */
			final StatefulSession session = ruleBase.newStatefulSession();
			session.addEventListener(new DebugAgendaEventListener());
			session.addEventListener(new DebugWorkingMemoryEventListener());

			final WorkingMemoryFileLogger logger = new WorkingMemoryFileLogger(
					session);
			logger.setFileName("log/cars");

			Iterator<Object> it_obj = my_objects.iterator();
			while (it_obj.hasNext()) {
				Object obj = it_obj.next();

				//System.out.println("Object " + obj);

				try {
					session.insert(obj);

				} catch (Exception e) {
					System.out
							.println("Inserting element " + obj + " and " + e);
				}
			}

			session.fireAllRules();

			//        Iterator<Object> my_it = session.iterateObjects();
			//        
			//        while(my_it.hasNext()) {
			//        	Object o = my_it.next();
			//        	System.out.println("Object " + o);
			//        }
			logger.writeToDisk();

			session.dispose();
		}
		System.out.println("Happy ending");

	}

}
