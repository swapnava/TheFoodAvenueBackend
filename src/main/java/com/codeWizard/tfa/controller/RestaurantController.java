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
import org.springframework.web.bind.annotation.RestController;

import com.codeWizard.tfa.entities.Item;
import com.codeWizard.tfa.entities.Restaurant;
import com.codeWizard.tfa.service.RestaurantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders="*", maxAge = 3600)
@RestController
@RequestMapping("/fdsdata/restaurant")
@Api(value = "Online Food Delivery System", description = "Operations pertaining to Restaurant of Online Food Delivery System")
@Validated
public class RestaurantController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	private RestaurantService restaurantService;
	
	@ApiOperation(value = "View a list of restaurant", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping("/all")
	public List<Restaurant> getRestaurantList(){
		logger.trace("getRestaurantList method in Restaurant controller accessed");
		return restaurantService.showAllRestaurant();
	}
	
	@ApiOperation(value = "Add a restaurant")
	@PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Restaurant addRestaurant(@ApiParam(value = "restaurant object store in database table", required = true)@Valid @RequestBody Restaurant restaurant){
		logger.trace("addRestaurant method in Restaurant controller accessed");
		return restaurantService.addRestaurant(restaurant);
	}
	
	@ApiOperation(value = "Delete a Restaurant")
	@DeleteMapping("/remove/{id}")
	public List<Restaurant> removeRestaurant(@ApiParam(value = "Restaurant Id to delete restaurant object from database table") @PathVariable(value="id") int id) {
		logger.trace("removeRestaurant method in Restaurant controller accessed");
		return restaurantService.deleteRestaurant(id);
	}
	
	@ApiOperation(value = "Update a Restaurant")
	@PutMapping("/updateRestaurant/{resId}")
	public Restaurant updateRestaurant(@ApiParam(value = "Restaurant Id to update restaurant object", required = true) @PathVariable(value="resId") String restaurantId, @ApiParam(value = "Update restaurant object", required = true)@Valid@RequestBody Restaurant restaurant) {
		logger.trace("updateRestaurant method in Restaurant controller accessed");
		return restaurantService.updateRestaurant(Integer.parseInt(restaurantId), restaurant);
	}
	
	@ApiOperation(value = "Get a restaurant by name")
	@GetMapping("/allByName/{name}")
	public List<Restaurant> showRestaurantByName(@ApiParam(value = "Restaurant name from which restaurant object will be retrieved", required = true) @PathVariable(value="name") String name){
		logger.trace("showRestaurantByName method in Restaurant controller accessed");
		return restaurantService.showRestaurantByName(name);
	}
	
	@ApiOperation(value = "Get a restaurant by items")
	@GetMapping("/allByItems/{item}")
	public List<Restaurant> showRestaurantByItems(@ApiParam(value = "Restaurant items from which restaurant object will be retrieved", required = true) @PathVariable(value="item") String itemName){
		logger.trace("showRestaurantByItems method in Restaurant controller accessed");
		return restaurantService.showRestaurantByItems(itemName);
	}
	
	@ApiOperation(value = "Get all items by restaurant")
	@GetMapping("/items/{rid}")
	public List<Item> showAllItems(@ApiParam(value = "Restaurant id from which item object will be retrieved", required = true) @PathVariable(value="rid") int resId){
		logger.trace("showAllItems method in Restaurant controller accessed");
		return restaurantService.showAllItems(resId);
	}
	
	@ApiOperation(value = "Add a customer")
	@PostMapping("/addCustomer/{rid}")
	public void addCustomer(@ApiParam(value = "Restaurant id for which customer object will be retrieved", required = true) @PathVariable(value="rid") int resId,@ApiParam(value = "customer object store in database table", required = true) @Valid @RequestBody String customer) {
		logger.trace("addCustomer method in Restaurant controller accessed");
		restaurantService.addCustomer(customer, resId);
	}
	
	@ApiOperation(value = "Show all customer by restaurant")
	@GetMapping("/showCustomers/{rid}")
	public List<String> customerList(@ApiParam(value = "Restaurant id for which customer object will be retrieved", required = true) @PathVariable(value="rid") int resId){
		logger.trace("customerList method in Restaurant controller accessed");
		return restaurantService.customerIdList(resId);
	}
	
	@GetMapping("/showByCategory/{category}")
	public List<Restaurant> getByCategory(@PathVariable(value="category")String category){
		return restaurantService.showByCategory(category);
	}
}
