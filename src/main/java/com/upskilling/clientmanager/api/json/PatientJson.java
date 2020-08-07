package com.upskilling.clientmanager.api.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientJson {

	private PatientPayload payload;

	public PatientPayload getPayload() {
		return payload;
	}

	public void setPayload(PatientPayload payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "PatientJson [payload=" + payload + "]";
	}

}
