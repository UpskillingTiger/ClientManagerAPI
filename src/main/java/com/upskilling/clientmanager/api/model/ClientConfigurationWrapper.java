package com.upskilling.clientmanager.api.model;

import java.util.List;

public class ClientConfigurationWrapper {

	private List<ClientConfiguration> clientConfigurations;

	public List<ClientConfiguration> getClientConfigurations() {
		return clientConfigurations;
	}

	public void setClientConfigurations(List<ClientConfiguration> clientConfigurations) {
		this.clientConfigurations = clientConfigurations;
	}

	@Override
	public String toString() {
		return "ClientConfigurationWrapper [clientConfigurations=" + clientConfigurations + "]";
	}

}
