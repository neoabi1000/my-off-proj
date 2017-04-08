package com.jsapl.rest.dto;

import java.sql.Date;

import com.jsapl.model.WorkOrder;

public class WorkOrderDTO {
	
	private long id;
	private long custId;
	private String description;
	private String clientInfo;
	private String status;
	private Date dateCommited;
	private double totalCost;
	private double advancePaid;
	private Date createdOn;
	private String createdBy;
	private Date lastUpdatedOn;
	private String lastUpdatedBy;
	
	public WorkOrderDTO(){
		
	}
	
	public WorkOrderDTO(WorkOrder workOrder) {
		this.id = workOrder.getId();
		this.custId = workOrder.getCustomer().getCustId();
		this.description=workOrder.getDescription();
		this.clientInfo=workOrder.getClientInfo();
		this.status= workOrder.getStatus().name();
		this.dateCommited=workOrder.getDateCommited();
		this.totalCost = workOrder.getTotalCost();
		this.advancePaid = workOrder.getAdvancePaid();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
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
