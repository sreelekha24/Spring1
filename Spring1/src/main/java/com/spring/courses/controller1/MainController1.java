package com.spring.courses.controller1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.courses.model.CourseDetails;
import com.spring.courses.model.MainCategory;
import com.spring.courses.service1.CoursesService1;

@Controller
public class MainController1 {

	@Autowired
	CoursesService1 coursesService;

	@RequestMapping(value = "/listCourses1")
	public ModelAndView listCourses() {
		List<MainCategory> listCourses = coursesService.getAllCourses();
		System.out.println(listCourses);
		return new ModelAndView("mainCategory1", "listCourses", listCourses);
	}
	

	@RequestMapping(value = "/getCourses1/{courseName}")
	public ModelAndView listCourses(@PathVariable String courseName) {
		System.out.println(courseName);

		List listCourses = coursesService.getCourses(courseName);

		return new ModelAndView("adobe1", "listCourses", listCourses);
	}

	/*
	 * @RequestMapping(value = "/main1") public String method() { return "main1"; }
	 * 
	 */

	@RequestMapping(value = "details1/{courseName}")
	public ModelAndView getRecord(@PathVariable String courseName) {
		
		List<CourseDetails> listCourses=coursesService.getRecord(courseName);

		return new ModelAndView("display1", "list", listCourses);

	}
}
