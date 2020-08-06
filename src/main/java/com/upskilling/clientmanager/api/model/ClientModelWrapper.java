package com.upskilling.clientmanager.api.model;

import java.util.List;

public class ClientModelWrapper {

	private List<ClientModel> clientModels;

	public List<ClientModel> getClientModels() {
		return clientModels;
	}

	public void setClientModels(List<ClientModel> clientModels) {
		this.clientModels = clientModels;
	}

	@Override
	public String toString() {
		return "ClientModelWrapper [clientModels=" + clientModels + "]";
	}

}
