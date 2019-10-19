package com.test.academy.beans;

import org.springframework.stereotype.Component;

@Component
public class Course {
	private Long id;
	private String name;
	private String description;
	private String author;
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return String.format("Id: %s, Name: %s, Description: %s, Author: %s, Category: [%s]", id, name, description, author, category);
	}
}
