package com.spring.courses.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.courses.model.User;
import com.spring.courses.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/listUsers")
	public ModelAndView listUser() {
		List<User> listUsers = userService.listUser();
		return new ModelAndView("listUsers", "listUser", listUsers);
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@Valid @ModelAttribute User user, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("Home");
		} else
			this.userService.saveUser(user);

		return new ModelAndView("xxx");

	}

	@RequestMapping(value = "/newUser")
	public ModelAndView newUser(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("Home");
		return model;
	}

}
