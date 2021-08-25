package com.codeWizard.tfa.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a entity class for Customer default constructor, parameterized
 *                           constructor along with getters and setters.
 *         Version             1.0
 *         Created Date    27-July-2021
 ************************************************************************************/



@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@Column(name="customerId", nullable=false)
	private int customerId;
	@Column(name="First_Name", nullable=false)
	private String firstName;
	@Column(name="Last_Name", nullable=false)
	private String lastName;
	@Column(name="Gender")
	private String gender;
	@Column(name="Mobile_Number", nullable=false)
	private String mobileNumber;
	@Column(name="Address")
	@Embedded
	private Address address;
	@Column(name="Email_id", nullable=false)
	private String email;
	@Column(name="Wallet")
	@Embedded
	private Wallet wallet;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	public Customer() {
		super();
	}
	public Customer(int customerId, String firstName, String lastName, String gender,
			String mobileNumber, Address address, String email, Wallet wallet) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.email = email;
		this.wallet = wallet;
	}
	public Customer(int userid, String firstName, String lastName, String gender, String mobileNumber,
			String email) {
		super();
		this.customerId = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.email = email;
		
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", address=" + address
				+ ", email=" + email + ", wallet=" + wallet + "]";
	}
}
