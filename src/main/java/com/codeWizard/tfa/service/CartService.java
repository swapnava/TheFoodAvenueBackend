package com.codeWizard.tfa.service;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Cart service implementation class that defines the method
 *         Version             1.0
 *         Created Date     29-JULY-2021
 ************************************************************************************/


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWizard.tfa.entities.Customer;
import com.codeWizard.tfa.entities.FoodCart;
import com.codeWizard.tfa.entities.Item;
import com.codeWizard.tfa.repository.ICartRepository;

@Service
public class CartService {
	
	@Autowired
	private ICartRepository cartRepository;
	
	public FoodCart createCart(FoodCart cart) {
		Customer customer=cart.getCustomer();
		List<Item> items=cart.getItemList();
		int cartId=customer.getCustomerId();
		FoodCart fcart=new FoodCart(cartId, customer, items);
		return cartRepository.save(fcart);
	}
	
	public FoodCart updateFoodCart(int cartId, FoodCart cart) {
		Customer customer=cart.getCustomer();
		List<Item> items=cart.getItemList();
		cartRepository.deleteById(cartId);
		FoodCart fcart=new FoodCart(cartId, customer, items);
		return cartRepository.save(fcart);
	}
	
	public FoodCart showCart(int cartId) {
		return cartRepository.findById(cartId).get();
	}
	
	public List<FoodCart> showAllCart(){
		return cartRepository.findAll();
	}
}
