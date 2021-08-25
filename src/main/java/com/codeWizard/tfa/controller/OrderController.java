package com.codeWizard.tfa.controller;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Controller class used for the data flow into model object 
 *                           and updates the view whenever data changes
  *         Version             1.0
  *         Created Date     26-JULY-2021
 ************************************************************************************/


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWizard.tfa.entities.OrderDetails;
import com.codeWizard.tfa.service.OrderService;
import com.codeWizard.tfa.service.RestaurantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders="*", maxAge = 3600)
@RestController
@RequestMapping("/fdsdata/order")
@Api(value = "Online Food Delivery System", description = "Operations pertaining to Order of Online Food Delivery System")
@Validated
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value = "Add a Order")
	@PostMapping("/add/{rid}")
	public OrderDetails addOrders(@ApiParam(value = "resaurant id to create order object store in database table", required = true)@Valid @PathVariable(value="rid") int restId,@ApiParam(value = "Order object store in database table", required = true)@Valid @RequestBody OrderDetails order) {
		logger.trace("addOrders method in Order controller accessed");
		return orderService.addOrders(restId, order);
		
	}
	
	@ApiOperation(value = "View a list of order", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping("/show")
	public List<OrderDetails> showOrder() {
		logger.trace("showOrder method in Order controller accessed");
		return orderService.showOrder();
	}
	
	@ApiOperation(value = "Get a Order by Id")
	@GetMapping("/getbyid/{id}")
	public OrderDetails viewOrderById(@ApiParam(value = "Item id from which customer object will be retrieved", required = true) @PathVariable("id") int orderId) {
		logger.trace("viewOrderById method in Order controller accessed");
		return this.orderService.viewByOrderId(orderId);
	}
	
	@GetMapping("/getByCustomerId/{id}")
	public List<OrderDetails> viewOrdersForCustomer(@PathVariable("id") String custId){
		return this.orderService.getOrderByCustomerId(custId);
	}
	
}
