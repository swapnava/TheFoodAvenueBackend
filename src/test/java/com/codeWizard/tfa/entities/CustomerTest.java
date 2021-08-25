package com.codeWizard.tfa.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.codeWizard.tfa.entities.Address;
import com.codeWizard.tfa.entities.Customer;
import com.codeWizard.tfa.entities.Wallet;

class CustomerTest {

	Customer c = new Customer(1411, "Mani", "Maran", "male", "1234567890",  
    		new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014"), "hello@gmail.com",
    		new Wallet("11.09"));
	
	@Test
	void testGetMobileNumber() {
		assertEquals("1234567890", c.getMobileNumber());
	}

	
	@Test
	void testGetEmail() {
		assertEquals("hello@gmail.com", c.getEmail());
	}

	


}
