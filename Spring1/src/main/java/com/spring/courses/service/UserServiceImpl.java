package com.spring.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.courses.dao.UserDao;
import com.spring.courses.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	public void saveUser(User user) {
		
		userDao.saveUser(user);
	}

	public List<User> listUser() {
		return userDao.listUser();
	}

}
