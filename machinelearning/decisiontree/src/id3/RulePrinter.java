package id3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Stack;

public class RulePrinter {
	
	private ArrayList<String> ruleText;
	//private ArrayList<ArrayList<NodeValue>> rule_list;
	private ArrayList<Rule> rules;
	
	private Stack<NodeValue> nodes;
	
	private Object ruleObject;
	//private RuleComparator rule_comp = new RuleComparator();
	
	public RulePrinter() {
		ruleText = new ArrayList<String>();
		//rule_list = new ArrayList<ArrayList<NodeValue>>();
		rules = new ArrayList<Rule>();
		
		/* most important */
		nodes = new Stack<NodeValue>();
	}
	
	public void printer(DecisionTree dt, String packageName, String outputFile) {//, PrintStream object
		ruleObject = dt.getName();
		dfs(dt.getRoot());
		
//		int j = 0;
//		for( String rule: ruleText) {
//			j++;
//			System.out.println("Rule " +j + " suggests that \n"+ rule +".\n");
//		}
		
		//String outputFile = new String("src/id3/rules"+".drl");
		if (outputFile!=null) {
			if (packageName != null)
				write("package " + packageName +";\n\n", false, outputFile);
			else
				try {
					throw new Exception("The package is not specified");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			write("/* \n", false, outputFile);
//			write(" * Spitting the rules= \n", true, outputFile);
//			write(" */ \n", true, outputFile);
		}
		
		int i = 0;
		Collections.sort(rules, Rule.getRankComparator());
		for( Rule rule: rules) {
			i++;
			System.out.println("//rule " +i + " write to drl \n"+ rule +"\n");
			if (outputFile!=null) {
				write(rule.toString(), true, outputFile);
				write("\n", true, outputFile);
			}
		}
	}
	public Object getRuleObject() {
		return ruleObject;
	}
	
	private void dfs(TreeNode my_node) {
		NodeValue node_value = new NodeValue(my_node);
		nodes.push(node_value);
		
		if (my_node instanceof LeafNode) {
			node_value.setNodeValue(((LeafNode) my_node).getValue());
			ruleText.add(print(nodes));
			//rule_list.add(spit(nodes));
			// what if more than one condition (more than one leafNode)
			
			Rule newRule = spitRule(nodes);
			newRule.setId(rules.size());
			rules.add(newRule);
			return;
		}
		
		Hashtable<Object,TreeNode> children = my_node.getChildren();
		for (Object attributeValue : children.keySet()) {
			//System.out.println("Domain: "+ my_node.getDomain().getName() + " the value:"+ attributeValue);
			node_value.setNodeValue(attributeValue);		
			TreeNode child = children.get(attributeValue);
			dfs(child);
			nodes.pop();
		}
		return;
		
		
			
		
	}
	
	private Rule spitRule(Stack<NodeValue> nodes) {
						//, Stack<NodeValue> leaves // if more than one leaf
		Rule newRule = new Rule(nodes.size());// (nodes, leaves) //if more than one leaf
		newRule.setObject(getRuleObject().toString());
		Iterator<NodeValue> it = nodes.iterator();

		while (it.hasNext()) {
			
			NodeValue current = it.next();
			if (it.hasNext()) { 
				newRule.addCondition(current);
			} else {
				newRule.addAction(current);
			}
		}
		return newRule;	
	}
	
	private String print(Stack<NodeValue> nodes) {
		Iterator<NodeValue> it = nodes.iterator();
		
		String out = "rule \"1 rank:\" \n";
		out += "\t when";
		out += "\t\t "+ruleObject+"Object("+ "";
		while (it.hasNext()) {
			
			NodeValue current = it.next();
			if (it.hasNext()) { 
				out += "" + current.getDomain() + " == "+ current.getNodeValue() +" & " ;
			} else {
				out = out.substring(0, out.length()-2) + ")\n";
				out += "\n\t then ";
				out += "\n\t\t System.out.println(\"Decision (\"" + current.getDomain() + "\") = \""+ current.getNodeValue()+");";
			}
		}
		
		/*
		 
		rule "Good Bye"
    		dialect "java"
			when
				Message( status == Message.GOODBYE, message : message )
			then
				System.out.println( "Goodbye: " + message ); 
		end
		 */
		return out;	
	}
	
	//	--------------------------------------------------------------------------------
	// Saves the string
	//--------------------------------------------------------------------------------
	public void write(String toWrite, boolean append, String data)	{  
		//String data = new String("data/results_"+System.currentTimeMillis()+".m");
		File file =new File(data);
		if (append)
		{
			if(!file.exists())
				System.out.println("File doesnot exit, creating...");
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(data, true));
				out.write(toWrite);
				out.close();
				//System.out.println("I wrote "+ toWrite);
			} catch (IOException e) {
				System.out.println("No I cannot write to the file");
				System.exit(0);
			}

		} else {
			if(file.exists()&& (file.length()>0))
				file.delete();
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(data));
				out.write(toWrite);
				out.close();
				System.out.println("I wrote "+ toWrite);
			} catch (IOException e) {
				System.out.println("No I cannot write to the file");
			}
		}
	}
}

class Rule {
	private int id;
	private String attr_obj;
	private double rank;
	private ArrayList<NodeValue> conditions;
	private ArrayList<NodeValue>  actions;
	
	Rule(int numCond) {
		conditions = new ArrayList<NodeValue>(numCond);
		actions = new ArrayList<NodeValue>(1);
	}

	public double getRank() {
		return rank;
	}

	public void addCondition(NodeValue current) {
		conditions.add(new NodeValue(current.getNode(), current.getNodeValue()));
	}
	public void addAction(NodeValue current) {
		actions.add(new NodeValue(current.getNode(), current.getNodeValue()));
		rank = ((LeafNode)current.getNode()).getRank();
	}
	public void setObject(String obj) {
		attr_obj= obj;
	}
	
	public String getObject() {
		return attr_obj;
	}
	
	private int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(int id) {
		this.id= id;
	}
	
	
	
	public String toString() {
		/*		 
		rule "Good Bye"
    		dialect "java"
			when
				Message( status == Message.GOODBYE, message : message )
			then
				System.out.println( "Goodbye: " + message ); 
		end
		 */
		
		String out = ""; //"rule \"#"+getId()+" "+decision+" rank:"+rank+"\" \n";
		out += "\t when";
		out += "\n\t\t "+getObject() +"("+ "";
		for (NodeValue cond: conditions) {
			out += cond + ", ";
		}
		
		String action = "";
		String decision = "";
		for (NodeValue act: actions) {
			out += act.getDomain() + " : "+act.getDomain()+" , ";
			action += act.getNodeValue() + " , ";
			decision += act.getDomain() + " ";
		}
		action = action.substring(0, action.length()-3);
		out = out.substring(0, out.length()-3) + ")\n";
		
		out += "\t then ";
		out += "\n\t\t System.out.println(\"Decision on "+decision+"= \"+" + decision + "+\": ("+action+")\");\n";
		
		out = "rule \"#"+getId()+" "+decision+ "= "+action+" with rank:"+rank+"\" \n" + out;
		
		out += "end\n";

		return out;
	}
	



	public static Comparator<Rule> getRankComparator() {
		return new RuleComparator();
	}
	
	private static class RuleComparator implements Comparator<Rule>{
		public int compare(Rule r1, Rule r2) {
			if (r1.getRank() < r2.getRank())
				return -1;
			else if (r1.getRank() > r2.getRank())
				return 1;
			else
				return 0;
		}	
	}
}


class NodeValue {
	
	private TreeNode node;
	private Object nodeValue;
	
	
	NodeValue(TreeNode n) {
		this.node = n;
	}
	
	NodeValue(TreeNode n, Object value) {
		this.node = n;
		this.nodeValue = value;
	}
	public String getDomain() {
		return node.getDomain().getName();
	}
	
	public TreeNode getNode() {
		return node;
	}
	public void setNode(TreeNode node) {
		this.node = node;
	}
	public Object getNodeValue() {
		return nodeValue;
	}
	public void setNodeValue(Object nodeValue) {
		this.nodeValue = nodeValue;
	}
	public String toString() {
		if (node.getDomain() instanceof LiteralDomain)
			return node.getDomain() + " == "+ "\""+nodeValue+ "\""; 
		else
			return node.getDomain() + " == "+ nodeValue;
	}
		
}

