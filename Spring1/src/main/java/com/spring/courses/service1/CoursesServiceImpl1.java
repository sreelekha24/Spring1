package com.spring.courses.service1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.courses.dao1.CoursesDao1;
import com.spring.courses.model.CourseDetails;
import com.spring.courses.model.MainCategory;

@Service
public class CoursesServiceImpl1 implements CoursesService1 {
	@Autowired
	CoursesDao1 coursesDao;

	public List<MainCategory> getAllCourses() {
		return coursesDao.getAllCourses();
	}

	public List getCourses(String courseName) {
		return coursesDao.getCourses(courseName);
	}

	public List<CourseDetails> getRecord(String coursename) {
		return coursesDao.getRecord(coursename);
	}

}
