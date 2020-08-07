package com.upskilling.clientmanager.api.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CasePayload {

	private String CaseNumber;
	private String Type;
	private String Priority;
	private String Origin;
	private String Primary_Product__c;
	private String Status;

	public String getCaseNumber() {
		return CaseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		CaseNumber = caseNumber;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getPriority() {
		return Priority;
	}

	public void setPriority(String priority) {
		Priority = priority;
	}

	public String getOrigin() {
		return Origin;
	}

	public void setOrigin(String origin) {
		Origin = origin;
	}

	public String getPrimary_Product__c() {
		return Primary_Product__c;
	}

	public void setPrimary_Product__c(String primary_Product__c) {
		Primary_Product__c = primary_Product__c;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "CasePayload [CaseNumber=" + CaseNumber + ", Type=" + Type + ", Priority=" + Priority + ", Origin="
				+ Origin + ", Primary_Product__c=" + Primary_Product__c + ", Status=" + Status + "]";
	}

}
