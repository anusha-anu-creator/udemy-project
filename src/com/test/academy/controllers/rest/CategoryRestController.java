package com.test.academy.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.academy.beans.Category;
import com.test.academy.services.CategoryService;

@RestController
public class CategoryRestController {
	@Autowired(required = true)
	private CategoryService categoryService;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping(value="/rest/category")
	public List<Category> listAll() {
		return categoryService.listAll();
	}
	
	@GetMapping(path="/rest/category/{id}")
	public ResponseEntity getCategory(@PathVariable("id") Long id) {
		Category category = categoryService.get(id);
		if(category != null)
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path="/rest/category/{id}")
	public ResponseEntity updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
		category.setId(id);
		categoryService.update(category);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
}
