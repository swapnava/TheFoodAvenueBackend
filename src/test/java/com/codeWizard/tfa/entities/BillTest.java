package com.codeWizard.tfa.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.codeWizard.tfa.entities.Bill;
import com.codeWizard.tfa.entities.OrderDetails;

class BillTest {

	
	List<String> ItemList = new ArrayList<>();
	

	

	@Test
	void testGetBillId() {

		OrderDetails order = new OrderDetails(2, "1511","02-04-2021", "", ItemList,"Delivered", 20);
		Bill bill = new Bill("152", "111", order, 2, 280, "02-04-2021");

		assertEquals("152", bill.getBillId());
	}

	@Test
	void testGetTotalCost() {

		OrderDetails order = new OrderDetails(2, "1511","02-04-2021","", ItemList,"Delivered",20 );
		Bill bill = new Bill("152", "111", order, 2, 280, "02-04-2021");
		assertEquals(280, bill.getTotalCost());
	}

}
