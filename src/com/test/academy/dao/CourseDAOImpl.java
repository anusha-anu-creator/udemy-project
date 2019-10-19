package com.test.academy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.academy.beans.Course;



@Repository
public class CourseDAOImpl implements CourseDAO {
	@Autowired(required = true)
	private HibernateTemplate hibernateTemplate;

	@Transactional(readOnly = false)
	public Long save(Course course) {
		return (Long) hibernateTemplate.save(course);
	}

	@Transactional(readOnly = false)
	public void update(Course course) {
		hibernateTemplate.update(course);
	}

	@Transactional(readOnly = false)
	public void delete(Course course) {
		hibernateTemplate.delete(course);
	}

	@Transactional(readOnly = true)
	public Course get(Long id) {
		return hibernateTemplate.get(Course.class, id);
	}

	@Transactional(readOnly = true)
	public List<Course> listAll() {
		return hibernateTemplate.loadAll(Course.class);
	}

}
