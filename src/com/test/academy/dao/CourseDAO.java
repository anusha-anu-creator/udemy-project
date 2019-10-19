package com.test.academy.dao;

import java.util.List;

import com.test.academy.beans.Course;

public interface CourseDAO {
	public Long save(Course course);

	public void update(Course course);

	public void delete(Course course);

	public Course get(Long id);

	public List<Course> listAll();
	
}
