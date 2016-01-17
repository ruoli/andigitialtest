package com.andigital.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Venues {
	private String name = "";
	private Contact contact;
	private Location location; 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
