package com.test.academy.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.test.academy.beans.Category;
import com.test.academy.dao.CategoryDAO;

public class CategoryServiceImplTest {
	private static CategoryDAO categoryDAO;
	private static CategoryServiceImpl categoryService;
	private static Category category;
	@BeforeClass
	public static void setUp() {
		System.out.println("Before class");
		
		categoryDAO =  mock(CategoryDAO.class);
		
		category = mock(Category.class);
		when(category.getName()).thenReturn("Technical Catalog");
		
		when(categoryDAO.get(1L)).thenReturn(category);
		
		categoryService =  new CategoryServiceImpl();
		
		categoryService.setCategoryDAO(categoryDAO);
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("After class");
	}
	@After
	public void after(){
		System.out.println("After");
	}
	@Before
	public void before(){
		System.out.println("Before");
	}
	
	@Test
	public void testGetCategoryDAO() {
		System.out.println("Test 1");
		Category category = categoryService.get(1L);
		assertEquals("Names didnt match", category.getName(), "Technical Catalog");
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetCategoryDAOWithNull() {
		System.out.println("Test 2");
		Category category = categoryService.get(null);
	}
}
