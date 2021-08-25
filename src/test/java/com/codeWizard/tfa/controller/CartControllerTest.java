package com.codeWizard.tfa.controller;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.codeWizard.tfa.controller.CartController;
import com.codeWizard.tfa.entities.Address;
import com.codeWizard.tfa.entities.Category;
import com.codeWizard.tfa.entities.Customer;
import com.codeWizard.tfa.entities.FoodCart;
import com.codeWizard.tfa.entities.Item;
import com.codeWizard.tfa.entities.Wallet;
import com.codeWizard.tfa.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(controllers = CartController.class)
@ActiveProfiles("test")
@ContextConfiguration
public class CartControllerTest {

	@Autowired
	private MockMvc mockmvc;
	
	
	@MockBean
	private CartService cartservice;
	
	@Autowired
	private ObjectMapper objectmapper;
	
	

	
	@Test
	void showAllFoodCart() throws Exception{
		
		int cartId = 54;
		Category category = new Category(85, "Chinese");
		List<Item> ItemList = new ArrayList<>();
		ItemList.add(new Item(111, "Noodles", "category", 1, 120,""));
		FoodCart cart = new FoodCart(cartId, new Customer(1511, "saurabh", "Thangaraj", "male", "8454057599",
				new Address("Kumutha Flat", "Chennai", "TamilNadu", "India", "600014"),
				"muttal19@gmail.com", new Wallet("840")),ItemList);
		
		given(cartservice.showCart(cartId)).willReturn(cart);
		
		this.mockmvc.perform(get("/fdsdata/cart/show/{cartid}",cartId))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.customer", is(cart.getCustomer())))
				.andExpect(jsonPath("$.itemList", is(cart.getItemList())));
				
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void createFoodCartTest() throws Exception {
		
		given(cartservice.createCart((FoodCart) any(FoodCart.class))).willAnswer((invocation) -> invocation.getArgument(0));
		
		int cartId = 54;
		Category category = new Category(85, "Chinese");
		List<Item> ItemList = new ArrayList<>();
		ItemList.add(new Item(111, "Noodles", "category", 1, 120,""));
		FoodCart cart = new FoodCart(cartId, new Customer(1511, "saurabh", "Thangaraj", "male", "8454057599",
				new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014"),
				"muttal19@gmail.com", new Wallet("840")),ItemList);
		
		this.mockmvc.perform(post("/fdsdata/cart/createCart")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectmapper.writeValueAsString(cart)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.customer", is(cart.getCustomer())))
				.andExpect(jsonPath("$.itemList",is(cart.getItemList()) ));
		
	}
	
}
