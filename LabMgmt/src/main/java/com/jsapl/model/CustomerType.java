package com.jsapl.model;


public class CustomerType {
	 	
	private int type;
	private String name;
	private int creditLimit;

	
	public CustomerType(){};
	
	public CustomerType(String name, int creditLimit)
	{
		this.creditLimit = creditLimit;
		this.name=name;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}
	
}
