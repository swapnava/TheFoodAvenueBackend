package com.codeWizard.tfa.controller;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Controller class used for the data flow into model object 
 *                           and updates the view whenever data changes
  *         Version             1.0
  *         Created Date     27-JULY-2021
 ************************************************************************************/


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWizard.tfa.entities.Item;
import com.codeWizard.tfa.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders="*", maxAge = 3600)
@RestController
@RequestMapping("/fdsdata/item")
@Api(value = "Online Food Delivery System", description = "Operations pertaining to Item of Online Food Delivery System")
@Validated
public class ItemController {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;
	
	@ApiOperation(value = "Add a Item")
	@PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Item addItem(@ApiParam(value = "item object store in database table", required = true)@Valid @RequestBody Item item) {
		logger.trace("addItem method in Item controller accessed");
		return itemService.addItem(item);
	}
	
	@ApiOperation(value = "View a list of item", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping("/getallitems")
	public List<Item> viewAllItems() {
		logger.trace("viewAllItems method in Item controller accessed");
		return this.itemService.viewAllItems();
	}
	
	@ApiOperation(value = "Get a Item by Id")
	@GetMapping("/getbyid/{id}")
	public Item viewItemById(@ApiParam(value = "Item id from which customer object will be retrieved", required = true) @PathVariable("id") int itemId) {
		logger.trace("viewItemById method in Item controller accessed");
		return this.itemService.viewByItemId(itemId);
	}
	@ApiOperation(value = "Delete an Item")
	@DeleteMapping("/delete/{id}")
	public List<Item> removeItem(@ApiParam(value = "Item Id from which item object will delete from database table", required = true) @PathVariable("id") int itemId) {
		logger.trace("removeItem method in Item controller accessed");
		return this.itemService.removeItem(itemId);
	}
}
