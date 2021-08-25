package com.codeWizard.tfa.service;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Customer service implementation class that defines the method
 *         Version             1.0
 *         Created Date     29-JULY-2021
 ************************************************************************************/


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWizard.tfa.entities.Customer;
import com.codeWizard.tfa.repository.ICustomerRepository;
import com.codeWizard.tfa.repository.IOrderRepository;

@Service
public class CustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Autowired
	private LoginService loginService;

	public void addCustomer(Customer customer) {
		int customerId=customer.getEmail().hashCode();
		customer.setCustomerId(customerId);
		customerRepository.save(customer);
	}

	public void deleteCustomer(int custId) {
		customerRepository.deleteById(custId);
	}

	public Customer updateCustomer(int customerId,Customer newCustomer) {
		if(customerRepository.existsById(customerId)) {
		customerRepository.deleteById(customerId);
		}
		loginService.customer = customerRepository.save(newCustomer);
		return customerRepository.save(newCustomer);
		
	}
	
	public Customer showCustomer(int custId) {
		return customerRepository.findById(custId).get();
	}

	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
}