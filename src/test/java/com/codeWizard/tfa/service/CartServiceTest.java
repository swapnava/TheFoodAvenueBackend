package com.codeWizard.tfa.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.codeWizard.tfa.entities.Address;
import com.codeWizard.tfa.entities.Customer;
import com.codeWizard.tfa.entities.FoodCart;
import com.codeWizard.tfa.entities.Item;
import com.codeWizard.tfa.entities.Wallet;
import com.codeWizard.tfa.repository.ICartRepository;
import com.codeWizard.tfa.service.CartService;

import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class CartServiceTest {

	@Autowired
	CartService cartservice;

	@Autowired
	ICartRepository cartrepository;
	
	
	

	@Test
	void cartDetailsTest() {
	

		List<Item> ItemList = new ArrayList<>();
		ItemList.add(new Item(57, "Masal poori", "85", 2, 60,""));
		Address address1 = new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014");

		Wallet wallet1 = new Wallet("580");

		Customer cust = new Customer(1411, "Mani", "Maran", "male", "9094057599", address1, "h9898k@gmail.com",
				wallet1);
		FoodCart cart = new FoodCart(111, cust, ItemList);
		
		assertEquals(111, cart.getCartId());
		assertEquals(cust, cart.getCustomer());
		assertEquals(ItemList, cart.getItemList());
	}


	
	@Test
	public final void testToString() {
		

		List<Item> ItemList = new ArrayList<>();
		ItemList.add(new Item(57, "Masal poori", "85", 2, 60,""));
		Address address1 = new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014");

		Wallet wallet1 = new Wallet("580");

		Customer cust = new Customer(1411, "Mani", "Maran", "male", "9094057599", address1, "h9898k@gmail.com",
				wallet1);
		FoodCart cart = new FoodCart(111, cust, ItemList);
		
		String result = String.format("FoodCart [cartId=%s, customer=%s, itemList=%s]", 
				cart.getCartId(),cart.getCustomer(),cart.getItemList());
		System.out.println(result);
		System.out.println(cart.toString());
		assertEquals(result, cart.toString());
	}
	
}
