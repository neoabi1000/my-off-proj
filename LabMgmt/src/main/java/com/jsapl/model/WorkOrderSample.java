package com.jsapl.model;

import java.util.HashSet;
import java.util.Set;

public class WorkOrderSample
{
	private long id;
	private long workOrderId;
	private long sampleId;
	
	private Set<WorkOrderSampleTest> workOrderSampleTests = new HashSet<>();

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

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
	public Set<WorkOrderSampleTest> getWorkOrderSampleTests() {
		return workOrderSampleTests;
	}
	public void setWorkOrderSampleTests(
			Set<WorkOrderSampleTest> workOrderSampleTests) {
		this.workOrderSampleTests = workOrderSampleTests;
	}


	
	
}
