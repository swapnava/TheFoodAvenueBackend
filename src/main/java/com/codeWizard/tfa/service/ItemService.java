package com.codeWizard.tfa.service;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Item service implementation class that defines the method
 *         Version             1.0
 *         Created Date     29-JULY-2021
 ************************************************************************************/


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codeWizard.tfa.entities.Item;
import com.codeWizard.tfa.exception.ItemNotFoundException;
import com.codeWizard.tfa.repository.IItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private IItemRepository itemRepository;
	
	public Item addItem(Item item) {
		return itemRepository.save(item);
	}
	
	public List<Item> viewAllItems() {
		//itemRepository.flush();
		return itemRepository.findAll();
	}
	
	public Item viewByItemId(int itemId) {
		return this.itemRepository.findById(itemId)
				.orElseThrow(() -> new ItemNotFoundException("Item not found with itemId : " + itemId));
		
	}
	 public List<Item> removeItem(int itemId) {
		Item existingitem = this.itemRepository.getById(itemId);
			this.itemRepository.delete(existingitem);
			return this.itemRepository.findAll();
		}
}
