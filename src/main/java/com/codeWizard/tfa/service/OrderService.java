package com.codeWizard.tfa.service;


/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Order service implementation class that defines the method
 *         Version             1.0
 *         Created Date     29-JULY-2021
 ************************************************************************************/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWizard.tfa.entities.OrderDetails;
import com.codeWizard.tfa.entities.Restaurant;
import com.codeWizard.tfa.exception.OrderNotFoundException;
import com.codeWizard.tfa.repository.IOrderRepository;
import com.codeWizard.tfa.repository.IRestaurantRepository;

@Service
public class OrderService {
	
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Autowired
	private IRestaurantRepository restaurantRepository;
	
	public List<OrderDetails> showOrder()
	{
		return orderRepository.findAll();
	}
	
	public OrderDetails addOrders(int restId, OrderDetails order) {
//		List<Integer> orderList = restaurantRepository.findById(restId).get().getOrderIdList();
//		orderList.add(order.getOrderId());
//		
//		Restaurant r=restaurantRepository.getById(restId);
//		
//		r.setOrderIdList(orderList);
//		
//		restaurantRepository.deleteById(restId);
//		restaurantRepository.save(r);
		return orderRepository.save(order);
		
	}
	
	public OrderDetails viewByOrderId(int orderId) {
		return this.orderRepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order not found with orderId : " + orderId));
	}
	
	public List<OrderDetails> getOrderByCustomerId(String custId){
		return orderRepository.findByCustomerId(custId);
	}
}
