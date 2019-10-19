package com.test.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.academy.beans.Category;
import com.test.academy.services.CategoryService;
// This signifies this class as controller
@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired(required=true)
	private CategoryService categoryService;
	
	
	public CategoryService getCategoryService() {
		return categoryService;
	}


	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(path="/list", method=RequestMethod.GET)
	public ModelAndView listAll() {
		ModelMap map =  new ModelMap();
		map.put("categoryList", categoryService.listAll());
		return new ModelAndView("category/list", map);
	}
	
	// Request Mapping will map this method to request with matching url
	@RequestMapping(path="/createForm", method=RequestMethod.GET)
	public ModelAndView createForm() {
		return new ModelAndView("category/createForm", "command", new Category());
	}
	
	// Model attribute will map all input parameters to bean
	@RequestMapping(path="/create", method=RequestMethod.POST)
	public String create(@ModelAttribute("category") Category category ) {
		categoryService.save(category);
		return "redirect:list";
	}
	
	// PathVariable will get value from path and assign to variable
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ModelAndView view(@PathVariable("id") Long id) {
		ModelMap map =  new ModelMap();
		map.put("category", categoryService.get(id));
		if(map.get("category") == null) {
			throw new RuntimeException("Unable to find Category with id:" + id);
		}
		return new ModelAndView("category/view", map);
	}
}
