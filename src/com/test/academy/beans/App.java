package com.test.academy.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.academy.dao.CategoryDAO;
import com.test.academy.services.CategoryService;
import com.test.academy.services.CourseService;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		CategoryService categoryService = context.getBean("categoryService", CategoryService.class);
		Category category =  null;
		categoryService.save(category);
		
	}
}
