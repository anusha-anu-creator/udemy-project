package com.test.academy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.academy.beans.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired(required = true)
	private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional(readOnly=false)
	public String save(User user) {
		// TODO Auto-generated method stub
		return hibernateTemplate.save(user).toString();
	}

	@Override
	public void update(User user) {
		hibernateTemplate.update(user);
	}

	@Override
	public void delete(User user) {
		hibernateTemplate.delete(user);
	}

	@Override
	public User get(String id) {
		return hibernateTemplate.get(User.class, id);
	}

	@Override
	public List<User> listAll() {
		return hibernateTemplate.loadAll(User.class);
	}

}
