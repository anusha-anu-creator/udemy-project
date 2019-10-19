package com.test.academy.services;

import java.util.List;

import com.test.academy.beans.Category;

public interface CategoryService {

	public Long save(Category category);

	public void update(Category category);

	public void delete(Category category);

	public Category get(Long id);

	public List<Category> listAll();
}
