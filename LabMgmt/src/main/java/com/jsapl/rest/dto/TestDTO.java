package com.jsapl.rest.dto;

import java.sql.Date;

public class TestDTO {
	
	private long workOrderId;
	private long sampleId;
	private long testTypeId;
	private String testStatus;
	private String requiredSpecification;
	private Date created;
	private Date assignedToWrkOderOn;
	
	
	
	public long getWorkOrderId() {
		return workOrderId;
	}
	public void setWorkOrderId(long workOrderId) {
		this.workOrderId = workOrderId;
	}
	public long getSampleId() {
		return sampleId;
	}
	public void setSampleId(long sampleId) {
		this.sampleId = sampleId;
	}
	public long getTestTypeId() {
		return testTypeId;
	}
	public void setTestTypeId(long testTypeId) {
		this.testTypeId = testTypeId;
	}
	public String getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	public String getRequiredSpecification() {
		return requiredSpecification;
	}
	public void setRequiredSpecification(String requiredSpecification) {
		this.requiredSpecification = requiredSpecification;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getAssignedToWrkOderOn() {
		return assignedToWrkOderOn;
	}
	public void setAssignedToWrkOderOn(Date assignedToWrkOderOn) {
		this.assignedToWrkOderOn = assignedToWrkOderOn;
	}
}
