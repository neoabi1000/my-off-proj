package com.jsapl.model;



public class WorkOrderTestItem {

	private TestId testId;
	private String requiredSpecification;
	private String comments;

	public WorkOrderTestItem(){}
	
	public WorkOrderTestItem(WorkOrder workOrder, Sample sample, TestType testType, String requiredSpecification, String comments){
		this.testId = new TestId(workOrder.getId(), sample.getSampleId(), testType.getTestTypeId());
		this.requiredSpecification=requiredSpecification;
		this.comments=comments;
	}

	
	
	
	
	
	
	public String getRequiredSpecification() {
		return requiredSpecification;
	}
	public void setRequiredSpecification(String requiredSpecification) {
		this.requiredSpecification = requiredSpecification;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		return testId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this == obj) return true;
		if(!(obj instanceof WorkOrderTestItem)) return false;

		WorkOrderTestItem in = (WorkOrderTestItem)obj;
		if(this.testId.equals(in.testId)) return true;
		return false;
	}

}
