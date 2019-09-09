package com.spring.courses.service;

import java.util.List;

import com.spring.courses.model.User;

public interface UserService {

	public void saveUser(User user);

	public List<User> listUser();

}
