package com.jsapl.rest.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.jsapl.model.Customer;
import com.jsapl.model.CustomerContact;

public class CustomerDTO 
{
	private long custId;
	private String name;
	private String phone;
	private String pan;
	private int customerTypeId;
	private String customerTypeName;
	private Date createdOn;
	private String createdBy;
	private Date lastUpdatedOn;
	private String lastUpdatedBy;

	private Set<CustomerContact> contacts;
	
	public CustomerDTO(){}
	public CustomerDTO(Customer customer){
		this.custId = customer.getCustId();
		this.name = customer.getName();
		this.phone = customer.getPhone();
		this.pan = customer.getPan();
		this.customerTypeId=customer.getCustomerType().getType();
		this.customerTypeName = customer.getCustomerType().getName();
		this.contacts = customer.getContacts();
		this.createdBy = customer.getCreatedBy();
		this.createdOn = customer.getCreatedOn();
		this.lastUpdatedBy = customer.getLastUpdatedBy();
		this.lastUpdatedOn = customer.getLastUpdatedOn();

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
	public int getCustomerTypeId() {
		return customerTypeId;
	}
	public void setCustomerType(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}
	
	public String getCustomerTypeName() {
		return customerTypeName;
	}
	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}
	
	
	public Set<CustomerContact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<CustomerContact> contacts) {
		this.contacts = contacts;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	public static List<CustomerDTO> covertList(List<Customer> customers){
		
		List<CustomerDTO> retListOfCustomers = new ArrayList<>();
		
		for(Customer customer: customers){
			retListOfCustomers.add(new CustomerDTO(customer));
		}
		return retListOfCustomers;
	}
	
	
	
}
