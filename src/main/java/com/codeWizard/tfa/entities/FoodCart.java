package com.codeWizard.tfa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a entity class forFoodCart default constructor, parameterized
 *                           constructor along with getters and setters.
 *         Version             1.0
 *         Created Date    27-July-2021
 ************************************************************************************/


@Entity
public class FoodCart {
	
	@Id
	@Column(name="cartId", nullable=false)
	private int cartId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Customer", referencedColumnName="customerId")
	private Customer customer;
	@Column(name="Item_List", nullable=false)
	@OneToMany(targetEntity=Item.class, fetch=FetchType.LAZY)
	private List<Item> itemList=new ArrayList<>();
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public FoodCart(int cartId2, Customer customer, List<Item> itemList) {
		super();
		this.cartId = cartId2;
		this.customer = customer;
		this.itemList = itemList;
	}
	public FoodCart() {
		super();
	}
	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", itemList=" + itemList + "]";
	}
}
