package com.jsapl.rest.dto;

import java.sql.Date;

import com.jsapl.model.Sample;

public class SampleDTO {

	private long sampleid;
	private long custId;
	private Sample.Form form;
	private Date receivedDate;
	private Sample.Status status;
	private int size;
	private String stamping;
	private boolean isToBeReturned;
	

	public SampleDTO(Sample sample){
		this.sampleid = sample.getSampleid();
		this.custId = sample.getCustomer().getCustId();
		this.form = sample.getForm();
		this.receivedDate = sample.getReceivedDate();
		this.status = sample.getStatus();
		this.size = sample.getSize();
		this.stamping=sample.getStamping();
		this.isToBeReturned = sample.isToBeReturned();
	}
	
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public boolean isToBeReturned() {
		return isToBeReturned;
	}
	public void setToBeReturned(boolean isToBeReturned) {
		this.isToBeReturned = isToBeReturned;
	}
	
	public Sample.Status getStatus() {
		return status;
	}
	public void setStatus(Sample.Status status) {
		this.status = status;
	}
	public long getSampleid() {
		return sampleid;
	}
	public void setSampleid(long sampleid) {
		this.sampleid = sampleid;
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
	public Sample.Form getForm() {
		return form;
	}
	public void setForm(Sample.Form form) {
		this.form = form;
	}
}
