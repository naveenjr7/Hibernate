package com.springBatchExample.Demo.Model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	int streetId;
	String streetName;
	String landmark;
	String state;
	String country;
	String pincode;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int streetId, String streetName, String landmark, String state, String country, String pincode) {
		super();
		this.streetId = streetId;
		this.streetName = streetName;
		this.landmark = landmark;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public int getStreetId() {
		return streetId;
	}

	public void setStreetId(int streetId) {
		this.streetId = streetId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [streetId=" + streetId + ", streetName=" + streetName + ", landmark=" + landmark + ", state="
				+ state + ", country=" + country + ", pincode=" + pincode + "]";
	}

}
