package com.jsapl.model;

import java.sql.Date;

public class Test {
	public enum Status {PendingForWorkOrder, InQueue, StalledForMissingSample, StalledForMissingDetails, Completed }
	
	private TestId testId;
	private String requiredSpecification;
	private Test.Status testStatus;
	private Date created;
	private Date assignedToWrkOderOn;
	private String tester;
	private String testResults;
	
	

	public TestId getTestId() {
		return testId;
	}
	public void setTestId(TestId testId) {
		this.testId = testId;
	}
	public String getRequiredSpecification() {
		return requiredSpecification;
	}
	public void setRequiredSpecification(String requiredSpecification) {
		this.requiredSpecification = requiredSpecification;
	}
	public Test.Status getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(Test.Status testStatus) {
		this.testStatus = testStatus;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getAssignedToWrkOderOn() {
		return assignedToWrkOderOn;
	}
	public void setAssignedToWrkOderOn(Date assignedToWrkOderOn) {
		this.assignedToWrkOderOn = assignedToWrkOderOn;
	}
	public String getTester() {
		return tester;
	}
	public void setTester(String tester) {
		this.tester = tester;
	}
	public String getTestResults() {
		return testResults;
	}
	public void setTestResults(String testResults) {
		this.testResults = testResults;
	}
	
	
}
