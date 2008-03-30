package dt.tools;

import java.util.List;

import dt.DecisionTree;
import dt.builder.C45TreeBuilder;
import dt.builder.DecisionTreeBuilder;
import dt.builder.IDTreeBuilder;
import dt.memory.FactSetFactory;
import dt.memory.WorkingMemory;

public class FileProcessor {
	public static List<Object> processFileExmID3(WorkingMemory simple, Object emptyObject, String drlfile, String datafile, String separator) {

		try {
			List<Object> obj_read=FactSetFactory.fromFileAsObject(simple, emptyObject.getClass(), datafile, separator);
			DecisionTreeBuilder bocuk = new IDTreeBuilder();

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
	
	public static List<Object> processFileExmC45(WorkingMemory simple, Object emptyObject, String drlfile, String datafile, String separator) {

		try {
			List<Object> obj_read=FactSetFactory.fromFileAsObject(simple, emptyObject.getClass(), datafile, separator);
			C45TreeBuilder bocuk = new C45TreeBuilder();

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
