package id3;

import java.util.List;

public class BocukFileExample {

	public static void main(String[] args) {
		

		WorkingMemory simple = new WorkingMemory();


		/* insert the guys */
		//String klassCar =  FactSetFactory.insertCarSet(simple);
		String klassNursery =  FactSetFactory.insertNurserySet(simple);
		
		//String klassAdvertisement = FactSetFactory.insertAdvertisementSet(simple);

		
		boolean buildTree = true;
		if (buildTree) {

			DecisionTreeBuilder bocuk = new DecisionTreeBuilder();
			//DecisionTreeBuilderMT bocuk = new DecisionTreeBuilderMT();

			long dt = System.currentTimeMillis();
			//DecisionTree bocuksTree = bocuk.build(simple, klassCar, "classCar", null);
			DecisionTree bocuksTree = bocuk.build(simple, klassNursery, "classnursery", null);
			
			//DecisionTree bocuksTree = bocuk.build(simple, klassAdvertisement, "classAdvertisement", FactSetFactory.attributesOfAdvertisement);
			
			
			dt = System.currentTimeMillis() - dt;
			System.out.println("Time"+dt + " facts read: "+bocuksTree.getNumRead() + " num call: "+ bocuk.getNumCall() );
			//System.out.println(bocuksTree);

			RulePrinter my_printer = new RulePrinter();
			my_printer.printer(bocuksTree, null, null);
		}
	}
	
	public static List<Object> processFileExample(WorkingMemory simple, Object emptyObject, String drlfile, String datafile, String separator) {

		try {
			List<Object> obj_read=FactSetFactory.fromFileAsObject(simple, emptyObject.getClass(), datafile, separator);
			DecisionTreeBuilder bocuk = new DecisionTreeBuilder();

			long dt = System.currentTimeMillis();
			String target_attr = Util.getTargetAnnotation(emptyObject.getClass());
			
			DecisionTree bocuksTree = bocuk.build(simple, emptyObject.getClass().getName(), target_attr, null);
			dt = System.currentTimeMillis() - dt;
			System.out.println("Time" + dt + "\n" + bocuksTree);

			RulePrinter my_printer = new RulePrinter();
			my_printer.printer(bocuksTree, "examples", "src/rules/examples/"+drlfile);
			
			return obj_read;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		
	}



}

