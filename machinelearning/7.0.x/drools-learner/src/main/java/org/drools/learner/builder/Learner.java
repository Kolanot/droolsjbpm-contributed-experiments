package org.drools.learner.builder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.drools.learner.DecisionTree;
import org.drools.learner.Domain;
import org.drools.learner.Instance;
import org.drools.learner.InstanceList;
import org.drools.learner.TreeNode;
import org.drools.learner.eval.InstDistribution;
import org.drools.learner.eval.stopping.StoppingCriterion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Learner {

    public static                DomainAlgo DEFAULT_DOMAIN = DomainAlgo.QUANTITATIVE;
    public static                DataType   DEFAULT_DATA   = DataType.PRIMITIVE;
    protected static final transient Logger     log            = LoggerFactory.getLogger(Learner.class);
    protected HashSet<Instance> missclassifiedData;
    protected ArrayList<StoppingCriterion> criteria;
    private int dataSize, dataSizePerTree;

    // must be deleted, goes to builder	
    //	private DecisionTree best_tree;
    private   InstanceList      inputData;
    private DomainAlgo algorithm;

    public Learner() {
        this.dataSize = 0;
        this.dataSizePerTree = 0;

        criteria = new ArrayList<StoppingCriterion>(4);
        missclassifiedData = new HashSet<Instance>();
    }

    protected abstract TreeNode train(DecisionTree dt, InstDistribution dataStats, int depth);

    public DecisionTree instantiateTree() {
        String targetReference = this.getTargetDomain().getFReferenceName();
        //System.out.println("(Learner) target   "+ target_reference);
        DecisionTree dt = new DecisionTree(inputData.getSchema(), targetReference);

        //flog.debug("Num of attributes: "+ dt.getAttrDomains().size());
        return dt;
    }

    public void trainTree(DecisionTree dt, InstanceList workingInstances) {
        InstDistribution statsByClass = new InstDistribution(dt.getTargetDomain());
        statsByClass.calculateDistribution(workingInstances.getInstances());

        dt.FACTS_READ += workingInstances.getSize();

        TreeNode root = train(dt, statsByClass, 0);
        dt.setRoot(root);
        //flog.debug("Result tree\n" + dt);
        //		return dt;
    }

    public DecisionTree trainTree(InstanceList workingInstances) {
        String targetReference = this.getTargetDomain().getFReferenceName();
        //System.out.println("(Learner) target   "+ target_reference);
        DecisionTree dt = new DecisionTree(inputData.getSchema(), targetReference);

        //flog.debug("Num of attributes: "+ dt.getAttrDomains().size());

        InstDistribution statsByClass = new InstDistribution(dt.getTargetDomain());
        statsByClass.calculateDistribution(workingInstances.getInstances());

        dt.FACTS_READ += workingInstances.getSize();

        TreeNode root = train(dt, statsByClass, 0);
        dt.setRoot(root);
        //flog.debug("Result tree\n" + dt);
        return dt;
    }

    public Domain getTargetDomain() {
        Iterator<String> itTarget = inputData.getTargets().iterator();
        // TODO check if there is a target candidate
        String target = itTarget.next();
        //System.out.println("(Learner) What is target?? "+ target +" and the domain "+ input_data.getSchema().getAttrDomain(target));
        return inputData.getSchema().getAttrDomain(target);
    }

    // TODO how are we going to select the target domain if there is more than one candidate
    private DecisionTree selectTarget(InstanceList workingInstances) {
        DecisionTree dt = null;
        for (String target : inputData.getTargets()) {
            dt = new DecisionTree(inputData.getSchema(), target);

            //flog.debug("Num of attributes: "+ dt.getAttrDomains().size());

            InstDistribution statsByClass = new InstDistribution(dt.getTargetDomain());
            statsByClass.calculateDistribution(workingInstances.getInstances());
            dt.FACTS_READ += workingInstances.getSize();

            TreeNode root = train(dt, statsByClass, 0);
            dt.setRoot(root);
            //flog.debug("Result tree\n" + dt);
        }
        return dt;
    }

    public ArrayList<StoppingCriterion> getStoppingCriteria() {
        return criteria;
    }

    public void addStoppingCriteria(StoppingCriterion c) {
        criteria.add(c);
    }

    public int getTrainingDataSizePerTree() {
        return this.dataSizePerTree;
    }

    public void setTrainingDataSizePerTree(int num) {
        this.dataSizePerTree = num;
    }

    public int getTrainingDataSize() {
        return this.dataSize;
    }

    public void setTrainingDataSize(int num) {
        this.dataSize = num;
    }

    public DomainAlgo getDomainAlgo() {
        return this.algorithm;
    }

    public void setDomainAlgo(DomainAlgo type) {
        this.algorithm = type;
    }
    // must be deleted, goes to builder	
    //	public DecisionTree getTree() {
    //		return best_tree;
    //	}

    public void setInputSpec(InstanceList classInstances) {
        this.inputData = classInstances;
    }

    public static enum DomainAlgo {
        CATEGORICAL, QUANTITATIVE
    }

    public static enum DataType {
        PRIMITIVE, STRUCTURED, COLLECTION
    }

    //	public InstanceList getInputData() {
    //		return input_data;
    //	}

    // must be deleted, goes to builder	
    //	public void setBestTree(DecisionTree dt) {
    //		this.best_tree = dt;
    //	}
}
