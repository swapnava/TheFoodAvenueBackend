package com.codeWizard.tfa.controller;

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

import com.codeWizard.tfa.entities.FoodCart;
import com.codeWizard.tfa.service.CartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/************************************************************************************
 *          @author       	 Swapnava Halder
 *          Description      It is a Controller class used for the data flow into model object 
 *                           and updates the view whenever data changes
 *         Version             1.0
 *         Created Date     27-JULY-2021
 ************************************************************************************/


@CrossOrigin(origins = "*", allowedHeaders="*", maxAge = 3600)
@RestController
@RequestMapping("/fdsdata/cart")
@Api(value = "Online Food Delivery System", description = "Operations pertaining to Cart of Online Food Delivery System")
@Validated
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;


	/************************************************************************************
	 * Method:                         	createCart
	 *Description:                      To create a new Cart
	 * @return Cart     				It returns cart to the database
	 * @postMapping:                    It is used to handle POST type of request method.
	 * @RequestBody:					It maps the HttpRequest body to a transfer or domain object                        

	 ************************************************************************************/

	@ApiOperation(value = "Add a Cart")
	@PostMapping("/createCart")
	public FoodCart createCart(@ApiParam(value = "cart object store in database table", required = true)@Valid @RequestBody FoodCart cart) {
		logger.trace("createCart method in Cart controller accessed");
		return cartService.createCart(cart);
	}

	/************************************************************************************
	 * Method:                         	updateFoodCart
	 *Description:                      To update existing cart
	 * @return Cart     				It returns cart to the database
	 * @postMapping:                    It is used to handle POST type of request method.
	 * RequestBody:						It maps the HttpRequest body to a transfer or domain object                    

	 ************************************************************************************/


	@ApiOperation(value = "Update a cart")
	@PostMapping("/updateCart/{cartid}")
	public FoodCart updateFoodCart(@ApiParam(value = "Cart Id to update cart object", required = true) @PathVariable(value = "cartid") int cartid,@ApiParam(value = "Update cart object", required = true)@Valid @RequestBody FoodCart cart) {
		logger.trace("updateFoodCart method in Cart controller accessed");
		return cartService.updateFoodCart(cartid, cart);
	}

	/************************************************************************************
	 * Method:                         	showCart
	 *Description:                      To display a new Cart
	 * @return Cart     				It returns cart to the database
	 * @getMapping:                     It is used to handle GET type of request method.					                       

	 ************************************************************************************/


	@ApiOperation(value = "Get a Cart by Id")
	@GetMapping("/show/{cartid}")
	public FoodCart showCart(@ApiParam(value = "Cart id from which cart object will be retrieved", required = true) @PathVariable int cartid) {
		logger.trace("showCart method in Cart controller accessed");
		return cartService.showCart(cartid);
	}
}
