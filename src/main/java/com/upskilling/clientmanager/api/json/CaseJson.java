package com.upskilling.clientmanager.api.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CaseJson {

	private CasePayload payload;

	public CasePayload getPayload() {
		return payload;
	}

	public void setPayload(CasePayload payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "CaseJson [payload=" + payload + "]";
	}

}
