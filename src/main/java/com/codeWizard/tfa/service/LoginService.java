package com.codeWizard.tfa.service;


/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Login service implementation class that defines the method
 *         Version             1.0
 *         Created Date     29-JULY-2021
 ************************************************************************************/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWizard.tfa.entities.Address;
import com.codeWizard.tfa.entities.Customer;
import com.codeWizard.tfa.entities.Login;
import com.codeWizard.tfa.entities.Wallet;
import com.codeWizard.tfa.exception.NoSuchUserException;
import com.codeWizard.tfa.exception.UserNameAlreadyExistsException;
import com.codeWizard.tfa.repository.ICustomerRepository;
import com.codeWizard.tfa.repository.ILoginRepository;

@Service
public class LoginService {
	@Autowired
	private ILoginRepository loginRepository;
	
	@Autowired
	private CustomerService customerService;
	
	public Customer customer;
	
	public Login login(String username,String password) throws NoSuchUserException {
		Login profile=loginRepository.findByUserName(username);
		int custId = username.hashCode();
		if((profile!=null && !profile.getUserName().equals("cginterndevteam@cg.com")) && profile.getPassword().equals(password)) {
			customer=customerService.showCustomer(custId);
			return profile;
		}
		else if(profile.getUserName().equals("cginterndevteam@cg.com") && profile.getPassword().equals(password)) {
			return profile;
		}
		else
			throw new NoSuchUserException("Invalid Username and Password Combination!");
	}
	
	public Login signup(String username,String password,String firstName,String lastName, String gender, String mobileNumber) throws UserNameAlreadyExistsException {
		int custId = username.hashCode();
		Login profile=new Login(custId,username,password);
		Customer customer=new Customer(custId,firstName,lastName,gender,mobileNumber, username);
		if(loginRepository.existsById(custId)) {
			throw new UserNameAlreadyExistsException("User with given username already exists!");
		}
		else
			if(username!="cginterndevteam@cg.com") {
				customerService.addCustomer(customer);
			}
			return loginRepository.save(profile);
	}
	
	public void deleteAccount(int userid) {
		loginRepository.deleteById(userid);
	}
}

