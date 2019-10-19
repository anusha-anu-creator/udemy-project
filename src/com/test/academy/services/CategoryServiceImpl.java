package com.test.academy.services;

import java.util.List;

import com.test.academy.beans.Category;
import com.test.academy.dao.CategoryDAO;

public class CategoryServiceImpl implements CategoryService{
	private CategoryDAO categoryDAO;

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public Long save(Category category) {
		if(category != null)
			return categoryDAO.save(category);
		else
			throw new RuntimeException("Null category provided");
	}

	public void update(Category category) {
		if(category != null)
			categoryDAO.update(category);
		else
			throw new RuntimeException("Cannot delete null category");
	}

	public void delete(Category category) {
		if(category != null)
			categoryDAO.delete(category);
		else
			throw new RuntimeException("Cannot delete null category");
	}

	public Category get(Long id) {
		if(id == null) {
			throw new RuntimeException("id is null");
		}
		return categoryDAO.get(id);
	}

	public List<Category> listAll() {
		return categoryDAO.listAll();
	}

}
