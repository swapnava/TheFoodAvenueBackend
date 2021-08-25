package com.codeWizard.tfa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a entity class for Bill default constructor, parameterized
 *                           constructor along with getters and setters.
 *         Version             1.0
 *         Created Date    27-July-2021
 ************************************************************************************/


@Entity
public class Bill {
	@Id
	@Column(name="billId", nullable=false)
	private String billId;
	@Column(name="customerId", nullable=false)
	private String customerId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Order_Details", referencedColumnName="orderId")
	private OrderDetails order;
	@Column(name="Total_Item", nullable=false)
	private int totalItem;
	@Column(name="Total_Cost", nullable=false)
	private double totalCost;
	@Column(name="Bill_Date", nullable=false)
	private String billDate;

	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public OrderDetails getOrder() {
		return order;
	}
	public void setOrder(OrderDetails order) {
		this.order = order;
	}
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public Bill() {
		super();
	}

	public Bill(String billId,String customerId, OrderDetails order, int totalItem, double totalCost, String billDate) {
		super();
		this.billId = billId;
		this.customerId = customerId;
		this.order = order;
		this.totalItem = totalItem;
		this.totalCost = totalCost;
		this.billDate = billDate;
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", order=" + order + ", totalItem=" + totalItem + ", totalCost=" + totalCost
				+ ", billDate=" + billDate + "]";
	}
}
