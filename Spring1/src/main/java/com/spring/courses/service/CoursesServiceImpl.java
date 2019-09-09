package com.spring.courses.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.courses.dao.CoursesDao;
import com.spring.courses.model.AddCourse;
import com.spring.courses.model.CourseDetails;
import com.spring.courses.model.MainCategory;

@Service
public class CoursesServiceImpl implements CoursesService {
	@Autowired
	CoursesDao coursesDao;

	public List<MainCategory> getAllCourses() {
		return coursesDao.getAllCourses();
	}

	public List getCourses(String courseName) {
		return coursesDao.getCourses(courseName);
	}

	public void addDetails(long count) throws IOException {
		coursesDao.addDetails(count);
	}

	public List<CourseDetails> getRecord(String coursename) {
		return coursesDao.getRecord(coursename);
	}

	public Long getCount() {
		return coursesDao.getCount();
	}

	public void addCourse(AddCourse addcourse) {
		coursesDao.addCourse(addcourse);
	}

	@Override
	public void deleteCourse(String coursename) {

		coursesDao.deleteCourse(coursename);
	}

}
