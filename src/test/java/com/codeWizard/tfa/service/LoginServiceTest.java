package com.codeWizard.tfa.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.codeWizard.tfa.entities.Login;
import com.codeWizard.tfa.repository.ILoginRepository;
import com.codeWizard.tfa.service.LoginService;

import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class LoginServiceTest {
	
	@Autowired
	LoginService loginservice;
	
	@Autowired
	ILoginRepository loginrepository;
	
	@Test
	void logindetails() {
		Login log = new Login(887,"Muttal","pwd");
		assertEquals("887", log.getUserid());
		assertEquals("Muttal", log.getUserName());
		assertEquals("pwd", log.getPassword());
	}
	
	@Test
	void logintoStringTest() {
		Login log = new Login(887,"Muttal","pwd");
		String result = String.format("Login [userid=%s, userName=%s, password=%s]",
				log.getUserid(),log.getUserName(),log.getPassword());
		
		assertEquals(result, log.toString());
		
	}
	
	
	
	

	
}
