package com.jsapl.rest.dto;

import java.util.Set;

import com.jsapl.model.CustomerContact;

public class CustomerDTO 
{
	private long custId;
	private String name;
	private String phone;
	private String pan;
	private int customerType;
	
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
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
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public int getCustomerType() {
		return customerType;
	}
	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}
	public Set<CustomerContact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<CustomerContact> contacts) {
		this.contacts = contacts;
	}
	private Set<CustomerContact> contacts;
	
}
