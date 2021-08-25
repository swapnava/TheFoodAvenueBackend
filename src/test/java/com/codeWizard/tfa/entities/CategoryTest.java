package com.codeWizard.tfa.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.codeWizard.tfa.entities.Category;

class CategoryTest {
	
	Category ct=new Category(2314,"Non Veg Indian Starter");

	@Test
	void testGetCatId() {
		
		assertEquals(2314,ct.getCatId());
	}

	@Test
	void testGetCategoryName() {
		
		assertEquals("Non Veg Indian Starter", ct.getCategoryName());
	}

}
