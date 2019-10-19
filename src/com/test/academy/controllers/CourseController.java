package com.test.academy.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.academy.beans.Course;
import com.test.academy.services.CategoryService;
import com.test.academy.services.CourseService;

@Controller
public class CourseController {
	@Autowired(required=true)
	private CourseService courseService;
	
	@Autowired(required=true)
	private CategoryService categoryService;
	
	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping(path="/courseList", method=RequestMethod.GET)
	public String courseHome(ModelMap map) {
		List<Course> list = courseService.listAll();
		map.put("courseList", list);
		return "course/index";
	}
	@RequestMapping(path="/course", method=RequestMethod.GET)
	public ModelAndView createCourse() {
		Map<String, Object> map = new HashMap<>();
		map.put("command", new Course());
		map.put("categoryList", categoryService.listAll());
		return new ModelAndView("course/create", map );
	}
	
	@RequestMapping(path="/course/{id}", method=RequestMethod.GET)
	public ModelAndView saveCourse(@PathVariable("id") Long id) {
		Map<String, Object> map = new HashMap<>();
		map.put("command", courseService.get(id));
		map.put("categoryList", categoryService.listAll());
		return new ModelAndView("course/create", map);
	}
}
