package com.test.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.academy.beans.Course;
import com.test.academy.dao.CourseDAO;

@Component
public class CourseServiceImpl implements CourseService{
	@Autowired(required=true)
	private CourseDAO courseDAO;
	
	public Long save(Course course) {
		return courseDAO.save(course);
	}

	public void update(Course course) {
		courseDAO.update(course);
	}

	public void delete(Course course) {
		courseDAO.delete(course);
		
	}

	public Course get(Long id) {
		return courseDAO.get(id);
	}

	public List<Course> listAll() {
		// TODO Auto-generated method stub
		return courseDAO.listAll();
	}

}
