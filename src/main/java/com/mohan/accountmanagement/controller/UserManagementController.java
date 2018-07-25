package com.mohan.accountmanagement.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mohan.accountmanagement.model.Login;
import com.mohan.accountmanagement.model.User;
import com.mohan.accountmanagement.model.UserManagementForm;
import com.mohan.accountmanagement.service.UserManagementService;

@Controller
public class UserManagementController {

	@Autowired 
	private UserManagementService userManagementService;
	
	@RequestMapping(value="user", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn")== null) {
			return new ModelAndView("login","login", new Login());
		}
		return  new ModelAndView("home", "user", new UserManagementForm());
	}
	
	
	
	@RequestMapping(value="user", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") UserManagementForm userManagement, BindingResult result,
			HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn")== null) {
			return new ModelAndView("login","login", new Login());
		}
		if(request.getParameter("Search") != null) {
			userManagement.getSearchForm().setUserList(this.userManagementService.searchUsers(userManagement.getSearchForm().getAccountID().replace(",", "")));

			return  new ModelAndView("home", "user",userManagement );
		} else {
			System.out.println(userManagement.getUser().getUserName());
			if(userManagement.getActionType().equals("save")) {
				boolean isSaved = this.userManagementService.saveUserDetails(userManagement.getUser());
				if(isSaved) {
					
					userManagement.setMessage("Saved Successfully");
					return  new ModelAndView("home", "user", userManagement);
				}
				
			}
			else if(userManagement.getActionType().equals("load")) {
				User user = null;
				if(userManagement.getSearchForm().getSelectedUser() != null) {
					user = this.userManagementService.loadUserDetailsBySudentId(userManagement.getSearchForm().getSelectedUser().split("-")[0]);
				}
				else if(userManagement.getUser().getStudentId() != null && !userManagement.getUser().getStudentId().isEmpty()) {
					user = this.userManagementService.loadUserDetailsBySudentId(userManagement.getUser().getStudentId());
				}
				else if(userManagement.getUser().getUserName() != null && !userManagement.getUser().getUserName().isEmpty()) {
					user = this.userManagementService.loadUserDetailsByUserName(userManagement.getUser().getUserName());
				}
				else if(userManagement.getUser().getEmail() != null && !userManagement.getUser().getEmail().isEmpty()) {
					user = this.userManagementService.loadUserDetailsByEmail(userManagement.getUser().getEmail());
				}
				else {
					
					UserManagementForm form = new UserManagementForm();
					form.setMessage("Please provide either studentId or userName or email");
					return  new ModelAndView("home", "user", form);
				}
				if(user == null) {
					UserManagementForm form = new UserManagementForm();
					form.setMessage("No student found");
					return  new ModelAndView("home", "user", form);
				}
				UserManagementForm userManagementForm = new UserManagementForm();
				userManagementForm.setUser(user);
				//userManagementForm.setDesks(this.userManagementService.loadDesks());
				//userManagementForm.setDeskAccountIdMap(this.userManagementService.loadDeskAccountIDMap());
				userManagementForm.setMessage("Loaded details for "+ user.getUserName());
				return new ModelAndView("home", "user", userManagementForm);
			}
			else if(userManagement.getActionType().equals("delete")) {
				this.userManagementService.deleteUserDetails(userManagement.getUser().getStudentId());
				userManagement.setMessage("Deleted Successfully");
				return  new ModelAndView("home", "user", new UserManagementForm());
			}
			else if(userManagement.getActionType().equals("update")) {
				this.userManagementService.updateUserDetails(userManagement.getUser());
				userManagement.setMessage("Updated Successfully");
				return  new ModelAndView("home", "user", userManagement);
			}
			
		}
		
		return new ModelAndView("home", "user", new UserManagementForm());
	}
}
