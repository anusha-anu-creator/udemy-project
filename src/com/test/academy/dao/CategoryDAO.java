package com.test.academy.dao;

import java.util.List;

import com.test.academy.beans.Category;

public interface CategoryDAO {

	public Long save(Category category);

	public void update(Category category);

	public void delete(Category category);

	public Category get(Long id);

	public List<Category> listAll();
}
