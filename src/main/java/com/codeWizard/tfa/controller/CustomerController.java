package com.codeWizard.tfa.controller;


/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Customer Controller class used for the data flow into model object 
 *                           and updates the view whenever data changes
  *         Version             1.0
  *         Created Date     26-JULY-2021
 ************************************************************************************/


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codeWizard.tfa.entities.Customer;
import com.codeWizard.tfa.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders="*", maxAge = 3600)
@RestController
@RequestMapping("/fdsdata/customer")
@Api(value = "Online Food Delivery System", description = "Operations pertaining to Customer of Online Food Delivery System")
@Validated
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	
	/************************************************************************************
	 * Method:                         	addCustomer
	 *Description:                      To add a new Customer
	 * @return void     				adds customer to database
	 * @postMapping:                   	It is used to handle POST type of request method.
	 * @RequestBody:					It maps the HttpRequest body to a transfer or domain object
	 *Created By                      	Swapnava Halder
	 *Created Date                     	26-JULY-2021                           

	 ************************************************************************************/

	
	@ApiOperation(value = "Add a Customer")
	@PostMapping("/add")
	public void addCustomer(@ApiParam(value = "customer object store in database table", required = true)@Valid @RequestBody Customer customer) {
		logger.trace("addCustomer method in Customer controller accessed");
		customerService.addCustomer(customer);
	}
	
	@ApiOperation(value = "Update a Customer")
	@PostMapping(value="/update/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@ApiParam(value = "Customert Id to update customer object", required = true) @PathVariable(value="id") int custId,@ApiParam(value = "Update customer object", required = true)@Valid @RequestBody Customer newCustomer) {
		logger.trace("updateCustomer method in Customer controller accessed");
		return this.customerService.updateCustomer(custId, newCustomer);

	}
	
	@ApiOperation(value = "Delete a customer")
	@DeleteMapping("/delete/{cid}")
	public void deleteCustomer(@ApiParam(value = "Customer Id to delete customer object from database table") @PathVariable(value="cid") int custId) {
		logger.trace("deleteCustomer method in customer controller accessed");
		customerService.deleteCustomer(custId);
	}
	
	@ApiOperation(value = "Get a Customer by Id")
	@GetMapping("/show/{cid}")
	public Customer showCustomer(@ApiParam(value = "Customer id from which customer object will be retrieved", required = true) @PathVariable(value="cid") int custId) {
		logger.trace("showCustomer method in Customer controller accessed");
		return customerService.showCustomer(custId);
	}
	
	@ApiOperation(value = "View a list of customer", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping("/show")
	public List<Customer> showAllCustomer(){
		logger.trace("showAllCustomer method in Customer controller accessed");
		return customerService.getAllCustomer();
	}
	
}