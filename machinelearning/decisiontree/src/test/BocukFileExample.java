package test;


import java.util.List;

import dt.DecisionTree;
import dt.builder.C45TreeBuilder;
import dt.builder.IDTreeBuilder;
import dt.memory.FactSetFactory;
import dt.memory.WorkingMemory;
import dt.tools.ObjectReader;
import dt.tools.RulePrinter;

public class BocukFileExample {

	public static void main(String[] args) {
		

		WorkingMemory simple = new WorkingMemory();


		/* insert the guys */
		//String klassCar =  FactSetFactory.insertCarSet(simple);
		String klassNursery =  FactSetFactory.insertNurserySet(simple);
		
		//String klassAdvertisement = FactSetFactory.insertAdvertisementSet(simple);

		
		boolean buildTree = true;
		if (buildTree) {

			IDTreeBuilder bocuk = new IDTreeBuilder();
			//DecisionTreeBuilderMT bocuk = new DecisionTreeBuilderMT();

			long dt = System.currentTimeMillis();
			//DecisionTree bocuksTree = bocuk.build(simple, klassCar, "classCar", null);
			DecisionTree bocuksTree = bocuk.build(simple, klassNursery, "classnursery", null);
			
			//DecisionTree bocuksTree = bocuk.build(simple, klassAdvertisement, "classAdvertisement", FactSetFactory.attributesOfAdvertisement);
			
			
			dt = System.currentTimeMillis() - dt;
			System.out.println("Time"+dt + " facts read: "+bocuksTree.getNumRead() + " num call: "+ bocuk.getNumCall() );
			//System.out.println(bocuksTree);

			RulePrinter my_printer = new RulePrinter(bocuk.getNum_fact_trained());
			boolean sort_via_rank = true;
			boolean print = true;
			my_printer.printer(bocuksTree, sort_via_rank, print);
			my_printer.write2file(null, null);
		}
	}
	

}

