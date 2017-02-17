package com.jsapl.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Customer {
	
	private long custId;
	private String name;
	private String phone;
	private String pan;
	
	private CustomerType customerType;
	
	@JsonIgnore
	private Set<Sample> samples = new HashSet<>();
	
	@JsonIgnore
	private Set<WorkOrder> workOrders = new HashSet<>();

	@JsonIgnore
	private Set<CustomerContact> contacts = new HashSet<>();
	
	
	
	
	public Set<Sample> getSamples() {
		return samples;
	}
	public void setSamples(Set<Sample> samples) {
		this.samples = samples;
	}
	public Set<WorkOrder> getWorkOrders() {
		return workOrders;
	}
	public void setWorkOrders(Set<WorkOrder> workOrders) {
		this.workOrders = workOrders;
	}
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	
	public void setContacts(Set<CustomerContact> contacts) {
		this.contacts = contacts;
	}
	public Set<CustomerContact> getContacts() {
		return contacts;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
