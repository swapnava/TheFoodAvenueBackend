package com.codeWizard.tfa.entities;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a entity class for OrderDetails default constructor, parameterized
 *                           constructor along with getters and setters.
 *         Version             1.0
 *         Created Date    27-July-2021
 ************************************************************************************/


@Entity
public class OrderDetails {
	
	@Id
	@Column(name="orderId", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	@Column(name="CustomerId", nullable=false)
	private String customerId;
	@Column(name="RestaurantName", nullable=false)
	private String restaurantName;
	@Column(name="Order_Date", nullable=false)
	private String orderDate;
	@Column(name="Item_List", nullable=false)
	@ElementCollection(targetClass=String.class)
	private List<String> itemList;
	@Column(name="Order_Status", nullable=false)
	private String orderStatus;
	@Column(name="Total_Amount", nullable=false)
	private double totalAmount;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public List<String> getItemList() {
		return itemList;
	}
	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public OrderDetails(int orderId, String customerId, String restaurantName, String orderDate, List<String> itemList,
			String orderStatus, double totalAmount) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantName = restaurantName;
		this.orderDate = orderDate;
		this.itemList = itemList;
		this.orderStatus = orderStatus;
		this.totalAmount = totalAmount;
	}
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", customerId=" + customerId + ", restaurantName=" + restaurantName
				+ ", orderDate=" + orderDate + ", itemList=" + itemList + ", orderStatus=" + orderStatus
				+ ", totalAmount=" + totalAmount + "]";
	}
	
		

}
