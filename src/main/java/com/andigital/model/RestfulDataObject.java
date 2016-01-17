package com.andigital.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestfulDataObject {
	private Response response;

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
	
}
