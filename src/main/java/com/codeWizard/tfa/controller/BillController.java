package com.codeWizard.tfa.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWizard.tfa.entities.Bill;
import com.codeWizard.tfa.exception.NoBillWithGivenIdException;
import com.codeWizard.tfa.service.BillService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Controller class used for the data flow into model object 
 *                           and updates the view whenever data changes
  *         Version             1.0
  *         Created Date     26-JULY-2021
 ************************************************************************************/


@CrossOrigin(origins = "*", allowedHeaders="*", maxAge = 3600)
@RestController
@RequestMapping("/fdsdata/bill")
@Api(value = "Online Food Delivery System", description = "Operations pertaining to Bill of Online Food Delivery System")
@Validated
public class BillController {

	private static final Logger logger = LoggerFactory.getLogger(BillController.class);
	
	@Autowired
	private BillService billService;
	
	/************************************************************************************
	 * Method:                         	getBill
     *Description:                      To display the bill based on ID
	 * @return Bill     				It returns bill based on the customer ID provided
	 * @GetMapping:                     It is used to handle GET type of request method.                
	 
	 ************************************************************************************/


	@ApiOperation(value = "Get a Bill")
	@GetMapping("/getBill")
	public Bill getBill(@ApiParam(value = "bill object store in database table", required = true)@Valid @RequestBody Bill bill) {
		logger.trace("getBill method in bill controller accessed");
		return billService.generateBill(bill);
	}

	
	/************************************************************************************
	 * Method:                         	getBillById
     *Description:                      To display the bill based on ID
	 * @return Bill     				It returns bill based on the bill ID provided
	 * @GetMapping:                     It is used to handle GET type of request method.
                       
	 
	 ************************************************************************************/

	
	@ApiOperation(value = "Get a Bill by Id")
	@GetMapping("/getBill/{id}")
	public Bill getBillById(@ApiParam(value = "Bill id from which bill object will be retrieved", required = true)@PathVariable(value="id") String id) {
		logger.trace("getBillById method in Bill controller accessed");
		return billService.getBillById(id);
	}

	@ApiOperation(value = "Get a Bill by Customer Id")
	@GetMapping("/getBillByCId/{cid}")
	public List<Bill> getBillByCustomerId(@ApiParam(value = "Customer id from which bill object will be retrieved", required = true)@PathVariable(value="cid") String custId){
		logger.trace("getBillByCustomerId method in Bill controller accessed");
		return billService.getBillByCustomerId(custId);
	}

	@ApiOperation(value = "Update a bill")
	@PostMapping(value="/updateBill/{bid}")
	public Bill updateBill(@ApiParam(value = "Bill Id to update bill object", required = true) @PathVariable(value="bid") String billId, @ApiParam(value = "Update bill object", required = true)@Valid @RequestBody Bill bill) {
		logger.trace("updateBill method in Bill controller accessed");
		return billService.updateBill(billId, bill);
	}

	@ApiOperation(value = "Delete a bill")
	@DeleteMapping("/deleteBill/{bid}")
	public String deleteBill(@ApiParam(value = "Bill Id to delete bill object from database table") @PathVariable(value = "bid") String billId) {
		logger.trace("deleteBill method in bill controller accessed");
		try {
			billService.deleteBill(billId);
			return "200";
		}
		catch(NoBillWithGivenIdException e) {
			logger.warn("Failed to remove bill");
			return e.getMessage();
		}
	}
	
}