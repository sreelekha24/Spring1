package com.spring.courses.dao1;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.courses.model.CourseDetails;
import com.spring.courses.model.MainCategory;



@Repository
@Transactional
public class CoursesDaoImpl1 implements CoursesDao1 {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<MainCategory> getAllCourses() {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("MainCategory");
		Query query = session.createQuery("from MainCategory");

		List<MainCategory> courseList = query.list();
		System.out.println(courseList);
		return courseList;
	}

	@SuppressWarnings("unchecked")
	public List getCourses(String courseName) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from " + courseName);

		List courseList = query.list();

		System.out.println(courseList);

		return courseList;
	}

	@SuppressWarnings("unchecked")
	public List<CourseDetails> getRecord(String courseName) {

		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseDetails");

		List<CourseDetails> courseList = query.list();
		System.out.println(courseList);
		return courseList;
	}

}
