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

	@Override
	public int hashCode() {
		return (String.valueOf(workOrderId)+String.valueOf(sampleId)+String.valueOf(testTypeId)).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof TestId)
		{
			TestId inTestId = (TestId)obj;
			if(this.workOrderId==inTestId.workOrderId)
				if(this.sampleId==inTestId.sampleId)
					if(this.testTypeId == inTestId.testTypeId)
						return true;
		}

		return false;
	}



}
