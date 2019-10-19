package com.test.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.academy.beans.User;
import com.test.academy.dao.UserDAO;
@Component
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO =  userDAO;
	}
	@Override
	public String save(User user) {
		return userDAO.save(user);
	}

	@Override
	public void update(User user) {
		userDAO.update(user);
	}

	@Override
	public void delete(User user) {
		userDAO.delete(user);
	}

	@Override
	public User get(String id) {
		// TODO Auto-generated method stub
		return userDAO.get(id);
	}

	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return userDAO.listAll();
	}

}
