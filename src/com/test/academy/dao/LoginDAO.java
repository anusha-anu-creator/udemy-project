package com.test.academy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.test.academy.beans.User;

@Repository("loginDAO")
public class LoginDAO {
	@Autowired(required = true)
	private HibernateTemplate hibernateTemplate;
	
	public User findByEmail(String email) {
		List<User> users = (List<User>) hibernateTemplate.find("from User where email =?", email);
		if(users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
}
