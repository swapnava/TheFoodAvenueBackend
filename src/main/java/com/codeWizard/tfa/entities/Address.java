package com.codeWizard.tfa.entities;

import javax.persistence.Embeddable;
/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a embedded class for Address default constructor, parameterized
 *                           constructor along with getters and setters with the annotation
 *                           @Embeddable 
 *         Version             1.0
 *         Created Date    27-July-2021
 ************************************************************************************/
@Embeddable
public class Address {
	private String addressLine;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	public Address() {
		super();
	}
	public Address(String addressLine, String city, String state,
			String country, String pincode) {
		super();
		this.addressLine = addressLine; 
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressLine=" + addressLine + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", pincode=" + pincode + "]";
	}
	
	
}
