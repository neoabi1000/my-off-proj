package com.jsapl.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Sample {

	public enum Form {Wires, Spring, Powder, Plate, Pipe, Flat, Rod, Tube, Cast}
	public enum Status {Received, UnderTest, Used}
	
	private long sampleid;
	private Customer customer;
	private Form form;
	private Date receivedDate;
	private Status status;
	private int size;
	private String stamping;
	private boolean isToBeReurned;
	
	private Set<Test> tests = new HashSet<>();
	
	
	public boolean isToBeReurned() {
		return isToBeReurned;
	}
	public void setToBeReurned(boolean isToBeReurned) {
		this.isToBeReurned = isToBeReurned;
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
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
}
