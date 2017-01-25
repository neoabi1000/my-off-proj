package com.jsapl.rest;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class CustomerObj {
	
	private long custId;
	private String name;
	private String phone;
	private String pan;

	


	
	
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
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
	

}
