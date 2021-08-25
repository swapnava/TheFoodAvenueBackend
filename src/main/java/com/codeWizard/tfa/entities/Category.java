package com.codeWizard.tfa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a entity class for Category default constructor, parameterized
 *                           constructor along with getters and setters.
 *         Version             1.0
 *         Created Date    27-July-2021
 ************************************************************************************/

@Entity
public class Category {
	@Id
	@Column(name="categoryId", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;
	@Column(name="categoryName", nullable=false)
	private String categoryName;
	
	public int getCatId() {
		return categoryId;
	}
	public void setCatId(int catId) {
		this.categoryId = catId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category() {
		super();
	}
	
	public Category(int catId, String categoryName) {
		super();
		this.categoryId = catId;
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [catId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
}
