package com.andigital.model;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
	private ArrayList<Venues> venues;

	public ArrayList<Venues> getVenues() {
		return venues;
	}

	public void setVenues(ArrayList<Venues> venues) {
		this.venues = venues;
	}
}
