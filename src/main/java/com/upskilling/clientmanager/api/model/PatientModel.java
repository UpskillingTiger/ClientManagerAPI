package com.upskilling.clientmanager.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patient")
public class PatientModel {
	private String firstName;
	private String lastName;
	private String contactId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "PatientModel [firstName=" + firstName + ", lastName=" + lastName + ", contactId=" + contactId + "]";
	}

}
