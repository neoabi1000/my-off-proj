package com.jsapl.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.glassfish.jersey.internal.inject.Custom;

public class WorkOrder {
	
	public enum Status{New, InProgress, Stalled, Completed}
	
	private long id;
	private Customer customer;
	private String description;
	private String clientInfo;
	private Date created;
	private Date updated;
	private Status status;
	private Date dateCommited;
	private double totalCost;
	private double advancePaid;
	
	
	private Set<Test> tests = new HashSet<>();
	
	public WorkOrder(){}
	public WorkOrder(Customer customer){ this.customer = customer;}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClientInfo() {
		return clientInfo;
	}
	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getDateCommited() {
		return dateCommited;
	}
	public void setDateCommited(Date dateCommited) {
		this.dateCommited = dateCommited;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double getAdvancePaid() {
		return advancePaid;
	}
	public void setAdvancePaid(double advancePaid) {
		this.advancePaid = advancePaid;
	}
	public Set<Test> getTests() {
		return tests;
	}
	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}
}
