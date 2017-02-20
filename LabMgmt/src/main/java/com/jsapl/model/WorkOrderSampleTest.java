package com.jsapl.model;

import java.io.Serializable;

public class WorkOrderSampleTest  implements Serializable{

	private long workOrderSampleId;
	private long testTypeId;
	private String requiredSpecification;
	private String comments;
	
	
	
	
	
	public long getWorkOrderSampleId() {
		return workOrderSampleId;
	}
	public void setWorkOrderSampleId(long workOrderSampleId) {
		this.workOrderSampleId = workOrderSampleId;
	}
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
