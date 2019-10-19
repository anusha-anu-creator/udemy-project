package com.test.academy.dao;

import java.util.List;

import com.test.academy.beans.User;

public interface UserDAO {

	public String save(User user);

	public void update(User user);

	public void delete(User user);

	public User get(String id);

	public List<User> listAll();
}
