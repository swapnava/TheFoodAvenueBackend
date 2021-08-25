package com.codeWizard.tfa.service;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.codeWizard.tfa.entities.Address;
import com.codeWizard.tfa.entities.Bill;
import com.codeWizard.tfa.entities.Customer;
import com.codeWizard.tfa.entities.Item;
import com.codeWizard.tfa.entities.OrderDetails;
import com.codeWizard.tfa.entities.Wallet;
import com.codeWizard.tfa.repository.IBillRepository;
import com.codeWizard.tfa.service.BillService;

import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)

public class BillServiceTest {

	@Autowired
	BillService billservice;

	@MockBean
	IBillRepository brepository;

	@Test
	public void testBillDetails() {
		

		List<String> ItemList = new ArrayList<>();

		Address address1 = new Address("Kumutha Flat", "Chennai", "TamilNadu", "India", "600014");

		Wallet wallet1 = new Wallet("580");

		Customer cust = new Customer(1411, "Mani", "Maran", "male", "9094057599", address1, "h9898k@gmail.com",
				wallet1);

		OrderDetails order = new OrderDetails(57, "1411", "02-04-2013","", ItemList, "Delivered",20);

		Bill bill = new Bill("152", "111", order, 2, 280, "02-04-2013");

		assertEquals("152", bill.getBillId());
		assertEquals("111", bill.getCustomerId());
		assertEquals(2, bill.getTotalItem());
		assertEquals(order, bill.getOrder());
		assertEquals(280, bill.getTotalCost());
		assertEquals("02-04-2013", bill.getBillDate());

	}




	@Test
	public final void BillDetailsToStringTest(){
		

		List<String> ItemList = new ArrayList<>();

		Address address1 = new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014");

		Wallet wallet1 = new Wallet("580");

		Customer cust = new Customer(1411, "Mani", "Maran", "male", "9094057599", address1, "h9898k@gmail.com",
				wallet1);

		OrderDetails order = new OrderDetails(57, "1411", "02-04-2013","", ItemList, "Delivered", 20);

		Bill bill = new Bill("152", "111", order, 2, 280, "02-04-2013");
		
		String result = String.format("Bill [billId=%s, order=%s, totalItem=%s, totalCost=%s, billDate=%s]",
				bill.getBillId(),bill.getOrder(),bill.getTotalItem(),bill.getTotalCost(),bill.getBillDate());
		
		System.out.println(result);
		
		assertEquals(result, bill.toString());
		}
		
		
}