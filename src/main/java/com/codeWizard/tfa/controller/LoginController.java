package com.codeWizard.tfa.controller;

import java.util.HashMap;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Login Controller class used for the data flow into model object 
 *                           and updates the view whenever data changes
  *         Version             1.0
  *         Created Date     26-JULY-2021
 ************************************************************************************/

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWizard.tfa.entities.Customer;
import com.codeWizard.tfa.entities.Login;
import com.codeWizard.tfa.exception.NoSuchUserException;
import com.codeWizard.tfa.exception.UserNameAlreadyExistsException;
import com.codeWizard.tfa.service.CustomerService;
import com.codeWizard.tfa.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin(origins = "*", allowedHeaders="*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
@Api(value = "Online Food Delivery System",description = "Operations pertaining to Login Module of Online Food Delivery System")
@Validated
public class LoginController {
	 
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@Autowired
	private LoginService loginService;
	
    @SuppressWarnings("finally")
	@ApiOperation(value = "Login and access your account", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully logged in"),
        @ApiResponse(code = 401, message = "You are not authorized to login"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@PostMapping(value="/login")
	public Map<String,String> login(@ApiParam(value = "Login credentials to login", required = true)@Valid @RequestBody Map<String, String> auth) {
		logger.trace("login method in login controller accessed");
		Map<String,String> result = new HashMap<>();
    	try {
    		Login profile = loginService.login(auth.get("username"),auth.get("password"));
    		result.put("Status", "Success");
    		result.put("Details", profile.getUserid()+"");
    	}
		catch(NoSuchUserException e) {
			logger.warn("Login failed");
			result.put("Status", "Failure");
			result.put("Details", e.getMessage());
		}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		return result;
    	}
	}	
	
    @SuppressWarnings("finally")
	@ApiOperation(value = "Create an account by signing up")
	@PostMapping(value = "/signup", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String,String> signup(@ApiParam(value = "Login credentials to sign up", required = true)@Valid @RequestBody Map<String, String> auth) {
    	logger.trace("signup method in login controller accessed");
    	Map<String,String> result = new HashMap<>();
    	try {
			loginService.signup(auth.get("username"),auth.get("password"),auth.get("firstName"),auth.get("lastName"),auth.get("gender"),auth.get("mobile"));
			result.put("Status","Success");
    		result.put("Details","Registered Successfully!");
    	}
		catch(UserNameAlreadyExistsException e) {
			logger.warn("Signup failed");
			result.put("Status","Failed");
			result.put("Details", e.getMessage());
		}
    	finally {
    		return result;
    	}
	}
	
    @ApiOperation(value = "Delete an account")
	@PostMapping("/delete/{uId}")
	public void deleteAccount(@ApiParam(value = "User Id to delete account object from database table")@PathVariable(value="uId") int userid) {
    	logger.trace("deleteAccount method in login controller accessed");
    	loginService.deleteAccount(userid);
	}
    
    @GetMapping("/gcu")
    public Customer customer() {
    	return loginService.customer;
    }
    
}