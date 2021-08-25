package com.codeWizard.tfa.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.codeWizard.tfa.controller.CategoryController;
import com.codeWizard.tfa.entities.Category;
import com.codeWizard.tfa.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebMvcTest(controllers = CategoryController.class)
@ActiveProfiles("test")
public class CategoryControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CategoryService categoryservice;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private List<Category> catList;
	
	@BeforeEach
	void setUp() {
		this.catList = new ArrayList<>();
		this.catList.add(new Category(85, "Chinese"));
		this.catList.add(new Category(86, "Arabian"));
		this.catList.add(new Category(87, "Italian"));
		
	}
	
	/*
	 * @Test void shouldReturn404WhenUpdatingNonExistingUser() throws Exception{
	 * String catId = "22";
	 * given(categoryservice.getCategory(catId)).willReturn(null); Category cat =
	 * new Category(catId, "Chinese");
	 * 
	 * this.mockMvc.perform(put("/update/{catId}",catId))
	 * .contentType(MediaType.APPLICATION_JSON_UTF8)
	 * .content(objectMapper.writeValueAsString(cat))
	 * 
	 * }
	 */
	 
	/*
	 * @Test void createNewCategoryTest() throws Exception{
	 * 
	 * String catName = "Malasian";
	 * given(categoryservice.addCategory(catName)).willAnswer((invocation) ->
	 * invocation.getArgument(0));
	 * 
	 * Category cat = new Category("88", catName);
	 * this.mockMvc.perform(post("/fdsdata/category/add/{cName}")
	 * .contentType(MediaType.APPLICATION_JSON_UTF8)
	 * .content(objectMapper.writeValueAsString(cat)))
	 * .andExpect(status().isCreated())
	 * .andExpect(jsonPath("$.catId",is(cat.getCatId())))
	 * .andExpect(jsonPath("$.categoryName",is(cat.getCategoryName()))));
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	@Test
	void shouldFetchAllCategory() throws Exception {
		given(categoryservice.getAllCategories()).willReturn(this.catList);

		this.mockMvc.perform(get("/fdsdata/category/all")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(catList.size())));
	}
	
	@Test
	void fetchCategorybyId() throws Exception{
		int catId = 75;
		Category cat = new Category(catId, "North Indian");
		given(categoryservice.getCategory(catId)).willReturn(cat);
		this.mockMvc.perform(get("/fdsdata/category/show/{cid}"))
		.andExpect(status().isOk())	
		.andExpect(jsonPath("$.categoryName",is(cat.getCategoryName()) ));
		
	
	}
	
	
	
	
}
