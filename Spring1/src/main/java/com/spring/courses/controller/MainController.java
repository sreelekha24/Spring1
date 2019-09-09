package com.spring.courses.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.courses.model.AddCourse;
import com.spring.courses.model.CourseDetails;
import com.spring.courses.model.MainCategory;
import com.spring.courses.service.CoursesService;

@Controller
public class MainController {

	static AddCourse fileUploadObj;

	@Autowired
	CoursesService coursesService;

	@RequestMapping(value = "/listCourses")
	public ModelAndView listCourses() {
		List<MainCategory> listCourses = coursesService.getAllCourses();
		return new ModelAndView("mainCategory", "listCourses", listCourses);
	}

	@RequestMapping(value = "/getCourses/{courseName}")
	public ModelAndView listCourses(@PathVariable String courseName) {
		System.out.println(courseName);

		List listCourses = coursesService.getCourses(courseName);

		return new ModelAndView("adobe", "listCourses", listCourses);
	}

	@RequestMapping(value = "/main")
	public String method() {
		return "main";
	}

	@RequestMapping(value = "/call")
	public String method1() throws IOException {

//		Long count = coursesService.getCount();
		coursesService.addDetails(1);
		return "adobe";
	}

	@RequestMapping(value = "details/{courseName}")
	public ModelAndView getRecord(@PathVariable String courseName) {

		List<CourseDetails> listCourses = coursesService.getRecord(courseName);

		return new ModelAndView("display", "list", listCourses);

	}

	@RequestMapping(value = "/addCourse")
	public String addCourse(Model model) {
		model.addAttribute("addcourse", new AddCourse());
		return "addCourse";
	}

	@RequestMapping(value = "/addCourseDetails", method = RequestMethod.POST)
	public ModelAndView addCourseDetails(@ModelAttribute("addcourse") AddCourse addcourse, Model model,
			final @RequestParam CommonsMultipartFile[] attachFileObj,
			final @RequestParam CommonsMultipartFile[] attachFileObj1) throws IllegalStateException, IOException {

		if ((attachFileObj != null && attachFileObj1 != null) && (attachFileObj.length > 0 && attachFileObj1.length > 0)
				&& (!attachFileObj.equals("") && !attachFileObj1.equals(""))) {
			for (CommonsMultipartFile aFile : attachFileObj) {
				for (CommonsMultipartFile aFile1 : attachFileObj1) {

					if (aFile.isEmpty() && aFile1.isEmpty()) {
						continue;
					} else {
						System.out.println("Attachment Name?= " + aFile.getOriginalFilename() + "\n");
						if (!aFile.getOriginalFilename().equals("")) {
							fileUploadObj = new AddCourse();

							String category = addcourse.getCategory();
							fileUploadObj.setCourseName(addcourse.getCourseName());
							fileUploadObj.setImage(aFile.getBytes());
							fileUploadObj.setCategory(category);
							fileUploadObj.setFile(aFile1.getBytes());
							fileUploadObj.setFilename(aFile1.getOriginalFilename());
							coursesService.addCourse(fileUploadObj);
						}
					}
				}
			}

		}
		return new ModelAndView("xxx");
	}

	@RequestMapping(value = "/deleteCourse/{courseName}")
	public void deleteCourse(@PathVariable String courseName) {

		coursesService.deleteCourse(courseName);

	}
}
