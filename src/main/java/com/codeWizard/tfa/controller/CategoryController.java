package com.codeWizard.tfa.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.codeWizard.tfa.entities.Category;
import com.codeWizard.tfa.entities.Item;
import com.codeWizard.tfa.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Controller class used for the data flow into model object 
 *                           and updates the view whenever data changes
 *         Version             1.0
 *         Created Date     27-JULY-2021
 ************************************************************************************/


@CrossOrigin(origins = "*", allowedHeaders="*", maxAge = 3600)
@RestController
@RequestMapping("/fdsdata/category")
@Api(value = "Online Food Delivery System", description = "Operations pertaining to Category of Online Food Delivery System")
@Validated
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	/************************************************************************************
	 * Method:                         	addCategory
	 *Description:                      To create a new Category
	 * @return Category    				It returns category to the database
	 * @postMapping:                    It is used to handle POST type of request method.
	 * @RequestBody:					It maps the HttpRequest body to a transfer or domain object                       

	 ************************************************************************************/

	@ApiOperation(value = "Add a Category")
	@PostMapping("/add/{cName}")
	public Category addCategory(@ApiParam(value = "category name to create category object store in database table", required = true)@Valid @PathVariable(value="cName") String catName) {
		logger.trace("addCategory method in Category controller accessed");
		return categoryService.addCategory(catName);
	}

	/************************************************************************************
	 * Method:                         	deleteCategory
	 *Description:                      To delete a category based on ID
	 * @return Category 				It returns cart to the database
	 * @deleteMapping:                  It is used to handle DELETE type of request method.
	 * @RequestBody:					It maps the HttpRequest body to a transfer or domain object                         

	 ************************************************************************************/


	@ApiOperation(value = "Delete a category")
	@DeleteMapping("/delete/{cId}")
	public void deleteCategory(@ApiParam(value = "Category Id to delete category object from database table") @PathVariable(value="cId") int catId) {
		logger.trace("deleteCategory method in category controller accessed");
		categoryService.deleteCategory(catId);
	}
	
	/************************************************************************************
	 * Method:                         	updateCategory
	 *Description:                      To update a existing category
	 * @return category     			It returns cart to the database
	 * @putMapping:                  	It is used to handle PUT type of request method.
	 * @RequestBody:					It maps the HttpRequest body to a transfer or domain object                        

	 ************************************************************************************/


	@ApiOperation(value = "Update a cart")
	@PutMapping("/update/{catId}")
	public Category updateCategory(@ApiParam(value = "Category Id to update category object", required = true) @PathVariable(value="catId") int catId,@ApiParam(value = "Update category object", required = true)@Valid @RequestBody Map<String,String> catName) {
		logger.trace("updateCategory method in Category controller accessed");
		return categoryService.updateCategory(catId, catName.get("categoryName"));
	}

	/************************************************************************************
	 * Method:                         	getAllCategories
	 *Description:                      To view all categories
	 * @return List<Category>     		It returns category from the database
	 * @getMapping:                     It is used to handle GETT type of request method.
	 * @RequestBody:					It maps the HttpRequest body to a transfer or domain object                     

	 ************************************************************************************/

	
	@ApiOperation(value = "View a list of category", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	
	@GetMapping("/all")
	public List<Category> getAllCategories(){
		logger.trace("getAllCategories method in Category controller accessed");
		return categoryService.getAllCategories();
	}

	/************************************************************************************
	 * Method:                         	getCategory
	 *Description:                      To create a new Cart
	 * @return Category   				It returns category from the database based on ID
	 * @getMapping:                   	It is used to handle GET type of request method.                           

	 ************************************************************************************/

	
	@ApiOperation(value = "Get a Category by Id")
	@GetMapping("/show/{id}")
	public Category getCategory(@ApiParam(value = "Category id from which category object will be retrieved", required = true)@PathVariable(value="id") int catId) {
		logger.trace("getCategory method in Category controller accessed");
		return categoryService.getCategory(catId);
	}
	
	/************************************************************************************
	 * Method:                         	getItemsByCategory
	 *Description:                      To view all items w.r.t a Category
	 * @return Cart     				It returns category from the database based on ID
	 * @getMapping:                   	It is used to handle GETT type of request method.
	 * @RequestBody:					It maps the HttpRequest body to a transfer or domain object                           

	 ************************************************************************************/


	@ApiOperation(value = "Get a list of Item by Category Id")
	@GetMapping("/items/{id}")
	public List<Item> getItemsByCategory(@PathVariable(value="id") int catId){
		logger.trace("getItemsByCategory method in Category controller accessed");
		return categoryService.getItemsByCategory(catId);
	}
}
