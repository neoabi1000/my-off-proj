package com.jsapl.rest.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.jsapl.model.Sample;

public class SampleDTO {

	private long sampleId;
	private long custId;
	private String custName;
	private String sampleName;
	private String form;
	private int size;
	private String stamping;
	private boolean isToBeReturned;
	private String status;
	private String sampleDescription;
	private Date receivedDate;

	public SampleDTO(){

	}

	public SampleDTO(Sample sample){
		this.sampleId = sample.getSampleId();
		this.sampleName = sample.getSampleName();
		this.custId = sample.getCustomer().getCustId();
		this.custName = sample.getCustomer().getName();
		this.form = sample.getForm().name();
		this.receivedDate = sample.getReceivedDate();
		this.status = sample.getStatus().name();
		this.size = sample.getSize();
		this.stamping=sample.getStamping();
		this.isToBeReturned = sample.isToBeReturned();
		this.sampleDescription=sample.getSampleDescription();
	}



	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getSampleName() {
		return sampleName;
	}
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}


	public String getSampleDescription() {
		return sampleDescription;
	}

	public void setSampleDescription(String sampleDescription) {
		this.sampleDescription = sampleDescription;
	}

	public boolean isToBeReturned() {
		return isToBeReturned;
	}
	public void setToBeReturned(boolean isToBeReturned) {
		this.isToBeReturned = isToBeReturned;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getSampleId() {
		return sampleId;
	}
	public void setSampleId(long sampleId) {
		this.sampleId = sampleId;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getStamping() {
		return stamping;
	}
	public void setStamping(String stamping) {
		this.stamping = stamping;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}


	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public static List<SampleDTO> covertList(List<Sample> samples){
		List<SampleDTO> retListOfSamples = new ArrayList<>();

		for(Sample sample: samples){
			retListOfSamples.add(new SampleDTO(sample));
		}
		return retListOfSamples;
	}

}
