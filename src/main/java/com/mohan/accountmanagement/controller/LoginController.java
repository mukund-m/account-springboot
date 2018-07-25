package com.mohan.accountmanagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mohan.accountmanagement.model.Login;
import com.mohan.accountmanagement.model.UserManagementForm;
import com.mohan.accountmanagement.service.LoginService;


@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index() {
		return  new ModelAndView("index", "login", new Login());
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView login() {
		return  new ModelAndView("login", "login", new Login());
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().setAttribute("loggedIn", null);
		return  new ModelAndView("login", "login", new Login());
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") Login login, BindingResult result,
			HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return  new ModelAndView("login", "login", new Login());
		}
		
		if(login.getUserName() == null || login.getUserName().isEmpty()) {
			result.rejectValue("userName", "userName.empty", "User Name can not be empty");
			return  new ModelAndView("login", "login", new Login());
		}
		
		if(login.getPassword() == null || login.getPassword().isEmpty()) {
			result.rejectValue("userName", "userName.empty", "Password can not be empty");
			return  new ModelAndView("login", "login", new Login());
		}
		
		if(this.loginService.authenticate(login)) {
			request.getSession().setAttribute("loggedIn", true);
			return new ModelAndView("home", "user", new UserManagementForm());
			
		} else {
			result.rejectValue("userName", "userName.empty", "Invalid Credentials");
			return  new ModelAndView("login", "login", new Login());
		}
		
	}
}
