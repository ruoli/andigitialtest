package com.andigital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SearchResult {
	@Id
    @GeneratedValue
    private Integer id;
	
	private String venueName;
	private String address;
	private String distance;
	private String contactNumber;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	 
	
}
