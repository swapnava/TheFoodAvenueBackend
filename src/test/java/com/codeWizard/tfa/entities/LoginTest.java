package com.codeWizard.tfa.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.codeWizard.tfa.entities.Login;

class LoginTest {

	Login l = new Login(123,"user123","pass1234");
	
	@Test
	void testGetUserName() {
		assertEquals("user123", l.getUserName());
	}

	@Test
	void testGetPassword() {
		assertEquals("pass1234", l.getPassword());
	}

}
