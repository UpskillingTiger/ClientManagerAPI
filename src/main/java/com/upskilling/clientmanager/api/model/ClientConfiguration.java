package com.upskilling.clientmanager.api.model;

public class ClientConfiguration {

	private String id;
	private String name;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ClientConfiguration [id=" + id + ", name=" + name + ", status=" + status + "]";
	}

}
