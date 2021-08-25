package com.codeWizard.tfa.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.Before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.codeWizard.tfa.controller.CustomerController;
import com.codeWizard.tfa.entities.Address;
import com.codeWizard.tfa.entities.Customer;
import com.codeWizard.tfa.entities.Wallet;
import com.codeWizard.tfa.exception.NoBillWithGivenIdException;
import com.codeWizard.tfa.repository.IBillRepository;
import com.codeWizard.tfa.repository.ICustomerRepository;
import com.codeWizard.tfa.service.BillService;
import com.codeWizard.tfa.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import mockit.integration.junit4.JMockit;


@RunWith(JMockit.class)
public class CustomerServiceTest {

	@Autowired
	CustomerService service;

	@Autowired
	BillService bservice;
	
	@MockBean
	ICustomerRepository repository;

	@MockBean
	IBillRepository brepository;
	

    @Autowired
    private ObjectMapper objectMapper;

    private List<Customer> userList;

    @BeforeEach
    void setUp() {
        this.userList = new ArrayList<>();
        this.userList.add(new Customer(1511, "saurabh", "Thangaraj", "male", "8454057599",
        		new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014"), "muttal19@gmail.com",
        		new Wallet("840")));
        this.userList.add(new Customer(1411, "Mani", "Maran", "male", "9094057599",  
        		new Address("Kumutha Flat", "Chennai", "TamilNadu", "India", "600014"), "h9898k@gmail.com",
        		new Wallet("4788")));

        //objectMapper.registerModule(new ProblemModule());
        //objectMapper.registerModule(new ConstraintViolationProblemModule());
    }


	@Test()
	public void CustomertestEquals() throws NullPointerException{
		
		Customer cust1 = new Customer();
		assertNotNull(cust1);
		Customer cust2 = null;
		Customer cust3 = new Customer(1511, "saurabh", "Thangaraj", "male", "8454057599", new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014"), "muttal19@gmail.com", new Wallet("840"));
		Customer cust4 = new Customer(1511, "saurabh", "Thangaraj", "male", "8454057599", new Address("Kumutha Flat", "Chennai", "TamilNadu", "India", "600014"), "muttal19@gmail.com", new Wallet("840"));
		assertFalse(cust1.equals(cust2));
		assertFalse(cust3.equals(cust2));
		assertFalse(cust4.equals(cust3));
		//assertTrue(cust3.equals(cust4));
		assertTrue(cust3.getFirstName().equals(cust4.getFirstName()));
		
	}
	
	@Test()
	public void testCustomerdetails()
	{
		Address address1 = new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014");
		
		Wallet wallet1 = new Wallet("580");
		
		
		Customer cust =new Customer(1411, "Mani", "Maran", "male", "9094057599", address1, "h9898k@gmail.com", wallet1);
		
		assertEquals(1411,cust.getCustomerId());
		assertEquals("Mani",cust.getFirstName());
		assertEquals("Maran",cust.getLastName());
		assertEquals("male",cust.getGender());
		assertEquals("9094057599",cust.getMobileNumber());
		assertEquals(address1, cust.getAddress());
		assertEquals("h9898k@gmail.com",cust.getEmail());
		assertEquals(wallet1, cust.getWallet());
	}
	
	 @Test
	   public void addCustomerTest() {
	    Customer cust =new Customer(1411, "Mani", "Maran", "male", "9094057599",
	    		new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014"), "h9898k@gmail.com", 
	    		new Wallet("840"));
	    assertEquals(1411, cust.getCustomerId());
	   }
	
	
	    

}



