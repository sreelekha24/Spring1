package com.spring.courses.service;

import java.io.IOException;
import java.util.List;

import com.spring.courses.model.AddCourse;
import com.spring.courses.model.CourseDetails;
import com.spring.courses.model.MainCategory;

public interface CoursesService {

	public List<MainCategory> getAllCourses();

	public List getCourses(String courseName);

	public void addDetails(long count) throws IOException;

	public List<CourseDetails> getRecord(String coursename);

	public Long getCount();
	
	public void addCourse(AddCourse addcourse);
	
	public void deleteCourse(String coursename);


}
