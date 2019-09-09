package com.spring.courses.dao;

import java.util.List;

import com.spring.courses.model.User;

public interface UserDao {
	public void saveUser(User user);

	public List<User> listUser();
}
