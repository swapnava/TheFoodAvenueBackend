package com.codeWizard.tfa.service;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a Category service implementation class that defines the method
 *         Version             1.0
 *         Created Date     29-JULY-2021
 ************************************************************************************/


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWizard.tfa.entities.Category;
import com.codeWizard.tfa.entities.Item;
import com.codeWizard.tfa.repository.ICategoryRepository;
import com.codeWizard.tfa.repository.IItemRepository;

@Service
public class CategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private IItemRepository itemRepository;
	
	public Category addCategory(String catName) {
		int catId=catName.hashCode();
		Category cat=new Category(catId,catName);
		return categoryRepository.save(cat);
	}
	
	public void deleteCategory(int catId) {
		categoryRepository.deleteById(catId);
	}
	
	public Category updateCategory(int catId,String catName) {
		categoryRepository.deleteById(catId);
		Category cat=new Category(catId,catName);
		return categoryRepository.save(cat);
	}
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Category getCategory(int catId) {
		return categoryRepository.findById(catId).get();
	}
	
	public List<Item> getItemsByCategory(int catId){
		return itemRepository.findByCategoryId(catId);
	}
}
