package com.jsapl.rest.dto;

import java.util.List;

public class WorkOrderSampleDTO {
	
	private long sampleId;
	private List<WorkOrderSampleTestDTO> tests;
	
	public long getSampleId() {
		return sampleId;
	}
	public void setSampleId(long sampleId) {
		this.sampleId = sampleId;
	}
	public List<WorkOrderSampleTestDTO> getTests() {
		return tests;
	}
	public void setTests(List<WorkOrderSampleTestDTO> tests) {
		this.tests = tests;
	}
	
}
