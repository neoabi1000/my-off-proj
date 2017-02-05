package com.jsapl.model;

import java.util.HashSet;
import java.util.Set;

public class TestType {

	private long testTypeId;
	private String name;
	private String description;
	private double price;
	private TestCategory category;
	
	
	private Set<Test> tests = new HashSet<>();
	
	
	
	
	
	public long getTestTypeId() {
		return testTypeId;
	}
	public void setTestTypeId(long testTypeId) {
		this.testTypeId = testTypeId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TestCategory getCategory() {
		return category;
	}
	public void setCategory(TestCategory category) {
		this.category = category;
	}


}
