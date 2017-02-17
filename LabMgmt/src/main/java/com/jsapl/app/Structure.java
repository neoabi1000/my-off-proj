package com.jsapl.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


class InvalidTestSampleException extends Exception{
	public InvalidTestSampleException(){}
	public InvalidTestSampleException(String msg){super(msg);}
}

class DuplicateTestException extends Exception{
	public DuplicateTestException(){}
	public DuplicateTestException(String msg){super(msg);}
}

class TestType{
	String testName;
	String testCagegory;

	public TestType(String category, String testName){
		this.testCagegory = category;
		this.testName = testName;
	}

	@Override
	public int hashCode() {
		return testCagegory.hashCode()+29*testName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this == obj) return true;
		if(!(obj instanceof TestType)) return false;

		TestType in = (TestType)obj;
		if(this.testCagegory.equals(in.testCagegory) && this.testName.equals(in.testName)) return true;
		return false;
	}

}

class Customer{
	String name;
	private Set<Sample> samples = new HashSet<>();
	private Set<WorkOrder> workOrders = new HashSet<>();

	public Customer(String name){
		this.name = name;
	}
	public Set<Sample> getSamples(){ return this.samples;}
	public Set<WorkOrder> getWorkOrders(){ return this.workOrders;}
	
	public String getName(){
		return this.name;
	}

}

class Sample{
	String name;
	String size;
	String type;
	Customer c;
	public Sample(Customer c, String name){
		this.name=name;
		this.c = c;
		c.getSamples().add(this);
		
	}

	public Customer getCustomer(){
		return c;
	}
	
	@Override
	public int hashCode() {
		//return name.hashCode()+29*size.hashCode() +29*type.hashCode()+29*c.getName().hashCode();
		return name.hashCode()+29*c.getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this == obj) return true;
		if(!(obj instanceof Sample)) return false;

		Sample in = (Sample)obj;
		if(this.name.equals(in.name) && 
				this.size.equals(in.size) && 
				this.type.equals(in.type) && 
				this.getCustomer().getName().equals(in.getCustomer().getName())) 
			return true;
		
		return false;
	}
};

class WorkOrder{


	Customer c;
	HashMap<Sample, HashSet<WorkOrderTestItem>> workOrderTestItemMap = new HashMap<>();

	public WorkOrder(Customer c){
		this.c=c;
		c.getWorkOrders().add(this);
	}

	public boolean addTest(Sample sample, WorkOrderTestItem workOrderTestItem) throws InvalidTestSampleException, DuplicateTestException{

		if(!sample.getCustomer().equals(c))
			throw new InvalidTestSampleException("This sample doesn't below to customer of this work order");
		
		if(workOrderTestItemMap.containsKey(sample)){
			if(workOrderTestItemMap.get(sample).contains(workOrderTestItem)){
				throw new DuplicateTestException("The work order already contains the said test, if required please invoke update");
			}else{
				workOrderTestItemMap.get(sample).add(workOrderTestItem);
			}
		}else{
			HashSet<WorkOrderTestItem> workOrderTestItems = new HashSet<>();
			workOrderTestItems.add(workOrderTestItem);
			workOrderTestItemMap.put(sample, workOrderTestItems);
		}
		return true;
	}

	
}

class WorkOrderTestItem
{
	TestType testType;
	String requiredSpec;
	String comments;

	public WorkOrderTestItem(){}
	public WorkOrderTestItem(TestType testType, String requiredSpc){
		this.testType=testType;
		this.requiredSpec=requiredSpc;
	}
	
	public TestType getTestType(){return this.testType;}

	public String getRequiredSpec() {
		return requiredSpec;
	}
	public void setRequiredSpec(String requiredSpec) {
		this.requiredSpec = requiredSpec;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		return testType.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this == obj) return true;
		if(!(obj instanceof WorkOrderTestItem)) return false;

		WorkOrderTestItem in = (WorkOrderTestItem)obj;
		if(this.testType.equals(in.testType)) return true;
		return false;
	}


}




public class Structure 
{
	public static TestType tt1 = new TestType("Chemical", "Spetro");
	public static TestType tt2 = new TestType("Tensile", "elasticity");
	public static TestType duplicatett = new TestType("Tensile", "elasticity");

	public static void main(String[] args) throws Exception {


		Customer customer = new Customer("Neha");
		Customer customer1 = new Customer("Bipin");

		Sample sample1 = new Sample(customer,"sample1");
		Sample sample2 = new Sample(customer, "sample2");
		Sample sample3 = new Sample(customer, "sample3");
		
		
		Sample sample4 = new Sample(customer1, "sample1");
		

		WorkOrder workOrder1 = new WorkOrder(customer);
		workOrder1.addTest(sample1, new WorkOrderTestItem(tt1, "xyz1"));
		workOrder1.addTest(sample1, new WorkOrderTestItem(tt2, "xyz2"));
		workOrder1.addTest(sample2, new WorkOrderTestItem(tt1, "abc1"));
		
		workOrder1.addTest(sample4, new WorkOrderTestItem(tt2, "uvw"));
		workOrder1.addTest(sample1, new WorkOrderTestItem(tt1, "xyz2"));

		WorkOrder workOrder2 = new WorkOrder(customer);
		workOrder2.addTest(sample3, new WorkOrderTestItem(tt1, "cbd1"));
		
		

	}
}
