package com.codeWizard.tfa.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.codeWizard.tfa.entities.OrderDetails;

class OrderDetailsTest {
	List<String> ItemList = new ArrayList<>();
	
	
	

	@Test
	void testGetOrderId() {
		
		OrderDetails od=new OrderDetails(1839,"1511","05-09-2021","",ItemList,"Preparing",20);
		assertEquals(1839,od.getOrderId());
		
	}

}
