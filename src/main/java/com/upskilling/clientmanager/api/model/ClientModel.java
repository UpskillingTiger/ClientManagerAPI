package com.upskilling.clientmanager.api.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client")
public class ClientModel {
	@Id
	private String id;
	private String name;
	private Boolean caseSelection;
	private Boolean patientSelection;
	private List<String> products;
	private String url;
	private Boolean status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getCaseSelection() {
		return caseSelection;
	}

	public void setCaseSelection(Boolean caseSelection) {
		this.caseSelection = caseSelection;
	}

	public Boolean getPatientSelection() {
		return patientSelection;
	}

	public void setPatientSelection(Boolean patientSelection) {
		this.patientSelection = patientSelection;
	}

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> products) {
		this.products = products;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ClientModel [id=" + id + ", name=" + name + ", caseSelection=" + caseSelection + ", patientSelection="
				+ patientSelection + ", products=" + products + ", url=" + url + ", status=" + status + "]";
	}

}
