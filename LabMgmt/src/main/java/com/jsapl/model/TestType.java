package com.jsapl.model;

public class TestType {

	private long id;
	private String name;
	private String description;
	private TestCategory category;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
