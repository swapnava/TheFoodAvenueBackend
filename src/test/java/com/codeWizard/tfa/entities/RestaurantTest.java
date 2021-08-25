package com.codeWizard.tfa.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.codeWizard.tfa.entities.Address;
import com.codeWizard.tfa.entities.Item;
import com.codeWizard.tfa.entities.Restaurant;

class RestaurantTest {

	List<Item> ItemList = new ArrayList<>();
	List<String> customerIdList = new ArrayList<>();
	List<Integer> orderIdList = new ArrayList<>();
	

	@Test
	void testGetManagerName() {
		ItemList.add(new Item(57, "Masal poori", "85", 2, 60,""));
		customerIdList.add("24");
		customerIdList.add("54");
		customerIdList.add("784");
		
		orderIdList.add(75);
		orderIdList.add(45);
		orderIdList.add(55);
		Address address = new Address("Kumutha Flat", "Chennai", "TamilNadu", "India", "600014");

		Restaurant r = new Restaurant(123,"Indian", "NiteBite", address, ItemList, "TamilSelvan", "8475998772",
				customerIdList, orderIdList,"");
		assertEquals("TamilSelvan", r.getManagerName());
	}



}
