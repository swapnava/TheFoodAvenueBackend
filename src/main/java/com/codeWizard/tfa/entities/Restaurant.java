package com.codeWizard.tfa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a entity class for Restaurant default constructor, parameterized
 *                           constructor along with getters and setters.
 *         Version             1.0
 *         Created Date    27-July-2021
 ************************************************************************************/


@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="restaurantId",nullable=false)
	private int restaurantId;
	@Column(name="Category", nullable=false)
	private String category;
	@Column(name="restaurantName",nullable=false)
	private String restaurantName;
	@Column(name="Address", nullable=false)
	@Embedded
	private Address address;
	@Column(name="Item_List",nullable=false)
	@OneToMany(targetEntity=Item.class, fetch=FetchType.LAZY)
	private List<Item> itemList;
	@Column(name="Manager_Name",nullable=false)
	private String managerName;
	@Column(name="Contact_Number",nullable=false)
	private String contactNumber;
	@Column(name="CustomerIdList")
	@ElementCollection(targetClass=String.class)
	private List<String> customerIdList;
	@Column(name="OrderIdList")
	@ElementCollection(targetClass=Integer.class)
	private List<Integer> orderIdList;
	@Column(name="Image_Link")
	private String img;
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	public List<String> getCustomerIdList() {
		return customerIdList;
	}
	public void setCustomerIdList(List<String> customerIdList) {
		this.customerIdList = customerIdList;
	}
	public List<Integer> getOrderIdList() {
		return orderIdList;
	}
	public void setOrderIdList(List<Integer> orderIdList) {
		this.orderIdList = orderIdList;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Restaurant() {
		super();
	}
	public Restaurant(int restaurantId, String category, String restaurantName, Address address, List<Item> itemList,
			String managerName, String contactNumber, List<String> customerIdList, List<Integer> orderIdList,
			String img) {
		super();
		this.restaurantId = restaurantId;
		this.category = category;
		this.restaurantName = restaurantName;
		this.address = address;
		this.itemList = itemList;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
		this.customerIdList = customerIdList;
		this.orderIdList = orderIdList;
		this.img = img;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", category=" + category + ", restaurantName="
				+ restaurantName + ", address=" + address + ", itemList=" + itemList + ", managerName=" + managerName
				+ ", contactNumber=" + contactNumber + ", customerIdList=" + customerIdList + ", orderIdList="
				+ orderIdList + ", img=" + img + "]";
	}
	
}
