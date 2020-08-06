package com.upskilling.clientmanager.api.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {

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
		return "Client [id=" + id + ", name=" + name + ", caseSelection=" + caseSelection + ", patientSelection="
				+ patientSelection + ", products=" + products + ", url=" + url + ", status=" + status + "]";
	}

}
