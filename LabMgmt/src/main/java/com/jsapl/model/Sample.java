package com.jsapl.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Sample {

	public enum Form {Wires, Spring, Powder, Plate, Pipe, Flat, Rod, Tube, Cast}
	public enum Status {Received, UnderTest, Used}
	
	private long sampleId;
	private String sampleName;
	private Form form;
	private Date receivedDate;
	private Status status;
	private int size;
	private String stamping;
	private boolean isToBeReturned;
	
	private Customer customer;
	
	private Set<Test> tests = new HashSet<>();
	
	public Sample(){}
	public Sample(Customer customer){this.customer = customer;}
	
	
	@Override
	public int hashCode() {
		return sampleName.hashCode()+29*size +29*form.hashCode()+29*customer.getName().hashCode();
		
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this == obj) return true;
		if(!(obj instanceof Sample)) return false;

		Sample in = (Sample)obj;
		if(this.sampleName.equals(in.sampleName) && 
				(this.size == in.size) && 
				(this.form.equals(in.form)) && 
				(this.getCustomer().getName().equals(in.getCustomer().getName()))) 
			return true;
		
		return false;
	}
	
	
	
	public boolean isToBeReturned() {
		return isToBeReturned;
	}
	public void setToBeReturned(boolean isToBeReturned) {
		this.isToBeReturned = isToBeReturned;
	}
	
	public String getSampleName() {
		return sampleName;
	}
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
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
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
}
