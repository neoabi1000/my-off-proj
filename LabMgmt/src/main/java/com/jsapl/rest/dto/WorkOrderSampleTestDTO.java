package com.jsapl.rest.dto;


public class WorkOrderSampleTestDTO{

	private long testTypeId;
	private String requiredSpecification;
	private String comments;
	
	public long getTestTypeId() {
		return testTypeId;
	}
	public void setTestTypeId(long testTypeId) {
		this.testTypeId = testTypeId;
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
}
