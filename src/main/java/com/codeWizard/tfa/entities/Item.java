package com.codeWizard.tfa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a entity class for Item default constructor, parameterized
 *                           constructor along with getters and setters.
 *         Version             1.0
 *         Created Date    27-July-2021
 ************************************************************************************/


@Entity
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemId;
	private String itemName;
	private String categoryId;
	private int quantity;
	private double cost;
	private String img;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return categoryId;
	}
	public void setCategory(String categoryId) {
		this.categoryId = categoryId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Item() {
		super();
	}
	public Item(int itemId, String itemName, String categoryId, int quantity, double cost, String img) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.categoryId = categoryId;
		this.quantity = quantity;
		this.cost = cost;
		this.img = img;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", categoryId=" + categoryId + ", quantity="
				+ quantity + ", cost=" + cost + ", img=" + img + "]";
	}
	
	
}
