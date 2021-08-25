package com.codeWizard.tfa.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.codeWizard.tfa.entities.Address;

class AddressTest {
	
	Address a=new Address("Nanda","Kolkata", "West Bengal", "India", "700135");

	@Test
	void testGetBuildingName() {
		assertEquals("Nanda" , a.getAddressLine());
	}

	@Test
	void testGetState() {
		assertEquals("West Bengal", a.getState());	
		}

	
}
