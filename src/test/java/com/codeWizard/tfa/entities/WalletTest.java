package com.codeWizard.tfa.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.codeWizard.tfa.entities.Wallet;

class WalletTest {
	
	Wallet w=new Wallet("74.93");
		
	@Test
	void testGetBalance() {
		
		assertEquals("74.93",w.getBalance());
	}

	
}
