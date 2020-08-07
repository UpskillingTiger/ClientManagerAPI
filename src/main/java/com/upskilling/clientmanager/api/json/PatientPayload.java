package com.upskilling.clientmanager.api.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientPayload {

	private String Contact_ID__c;
	private PatientName Name;

	public String getContact_ID__c() {
		return Contact_ID__c;
	}

	public void setContact_ID__c(String contact_ID__c) {
		Contact_ID__c = contact_ID__c;
	}

	public PatientName getName() {
		return Name;
	}

	public void setName(PatientName name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "PatientPayload [Contact_ID__c=" + Contact_ID__c + ", Name=" + Name + "]";
	}

}