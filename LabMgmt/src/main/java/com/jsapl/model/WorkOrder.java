package com.jsapl.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class WorkOrder {
	
	public enum Status{New, InProgress, Stalled, Completed}
	
	private long id;
	private String description;
	private String clientInfo;
	private Status status;
	private Date dateCommited;
	private double totalCost;
	private double advancePaid;
	private Date createdOn;
	private String createdBy;
	private Date lastUpdatedOn;
	private String lastUpdatedBy;
	
	
	private Customer customer;
	
	private Set<WorkOrderSample> workOrderSamples = new HashSet<>();
	
	
	public WorkOrder(){}
	public WorkOrder(Customer customer){ this.customer = customer;}


	

	

//	public boolean addTest(Sample sample, TestType testType, String requiredSpec, String comments) throws CustomerSampleMismatchException, DuplicateWorkOrderTestItemException{
//
//		if(!sample.getCustomer().equals(customer))
//			throw new CustomerSampleMismatchException("This sample doesn't belogns to customer of this work order");
//		
//		WorkOrderTestItem workOrderTestItem = new WorkOrderTestItem(this, sample, testType, requiredSpec, comments);
//
//		if(workOrderTestItemMap.containsKey(sample.getSampleId())){
//			if(workOrderTestItemMap.get(sample.getSampleId()).contains(workOrderTestItem)){
//				throw new DuplicateWorkOrderTestItemException("The work order already contains the said test, if required please invoke update");
//			}else{
//				workOrderTestItemMap.get(sample.getSampleId()).add(workOrderTestItem);
//			}
//		}else{
//			HashSet<WorkOrderTestItem> workOrderTestItems = new HashSet<>();
//			workOrderTestItems.add(workOrderTestItem);
//			workOrderTestItemMap.put(sample.getSampleId(), workOrderTestItems);
//		}
//		return true;
//	}
	
	
	
	
	
	public Set<WorkOrderSample> getWorkOrderSamples() {
		return workOrderSamples;
	}
	public void setWorkOrderSamples(Set<WorkOrderSample> workOrderSamples) {
		this.workOrderSamples = workOrderSamples;
	}
	
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

}
