package com.codeWizard.tfa.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.codeWizard.tfa.entities.Item;

class ItemTest {
	Item i=new Item(9749,"Crispy Chicken","87",1,185,"");

	@Test
	void testGetItemId() {
		
		assertEquals(9749,i.getItemId());
	}

	@Test
	void testGetItemName() {
		
		assertEquals("Crispy Chicken",i.getItemName());
	}

}
