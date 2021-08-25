package com.codeWizard.tfa.service;


/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Restaurant service implementation class that defines the method
 *         Version             1.0
 *         Created Date     29-JULY-2021
 ************************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWizard.tfa.entities.Item;
import com.codeWizard.tfa.entities.Restaurant;
import com.codeWizard.tfa.repository.IRestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private IRestaurantRepository restaurantRepository;
	
	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	public List<Restaurant> deleteRestaurant(int restId) {
		restaurantRepository.deleteById(restId);
		return restaurantRepository.findAll();
	}
	
	public Restaurant updateRestaurant(int restaurantId, Restaurant updatedRestaurant) {
		restaurantRepository.deleteById(restaurantId);
		updatedRestaurant.setRestaurantId(restaurantId);
		return restaurantRepository.save(updatedRestaurant);
	}
	
	public List<Restaurant> showAllRestaurant(){
		return restaurantRepository.findAll();
	}
	
	public List<Restaurant> showRestaurantByName(String name) {
		return restaurantRepository.findByRestaurantName(name);
	}
	
	public List<Restaurant> showRestaurantByItems(String itemName){
		List<Restaurant> res = restaurantRepository.findAll();
		List<Restaurant> result=new ArrayList<>();
		for(Restaurant r:res) {
			if(r.getItemList().contains((Object)itemName)) {
				result.add(r);
			}
		}
		return result;
	}
	
	public List<Item> showAllItems(int resId){
		return restaurantRepository.findById(resId).get().getItemList();
	}
	
	public void addCustomer(String customerId,int resId) {
		Restaurant r=restaurantRepository.findById(resId).get();
		List<String> customerIdList=r.getCustomerIdList();
		customerIdList.add(customerId);
		r.setCustomerIdList(customerIdList);
		restaurantRepository.save(r);
	}
	
	public List<String> customerIdList(int resId){
		return restaurantRepository.findById(resId).get().getCustomerIdList();
	}
	
	public List<Restaurant> showByCategory(String category){
		return restaurantRepository.findByCategory(category);
	}
	
}
