package com.test.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	
	
	@RequestMapping(path="/login", method = RequestMethod.GET)
	public String home() {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap map) {
		map.put("greeting", "Hello from spring MVC");
		return "index";
	}
	
	@RequestMapping(path="/admin**",method = RequestMethod.GET)
	public ModelAndView admin(ModelMap map) {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;
	}
	
	// /WEB-INF/views/index.jsp
}
