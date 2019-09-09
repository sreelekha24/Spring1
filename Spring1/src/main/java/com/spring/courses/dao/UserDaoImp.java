package com.spring.courses.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.courses.model.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
	}

	public List<User> listUser() {

		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> userList = session.createQuery("from User").list();
		return userList;
	}

}
