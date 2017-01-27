package com.jsapl.model;

import java.util.HashSet;
import java.util.Set;

public class Site {
	
	private int id;
	private String siteCode;
	private String address;
	
	private Set<String> contacts = new HashSet<>();
	
	public Site(){ }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<String> getContacts() {
		return contacts;
	}
	

}
