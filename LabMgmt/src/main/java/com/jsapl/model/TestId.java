package com.jsapl.model;

import java.io.Serializable;

public class TestId  implements Serializable{
	
	private long workOrderId;
	private long sampleId;
	private long testTypeId;
	
	
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

	
	
}
