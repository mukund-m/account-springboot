package com.mohan.accountmanagement.service;

import java.util.List;

import com.mohan.accountmanagement.model.User;
import com.mohan.accountmanagement.model.UserManagementForm;

public interface UserManagementService {

	public boolean saveUserDetails(User user);
	
	public User loadUserDetailsByEmail(String email);
	
	public User loadUserDetailsByUserName(String userName);
	
	public User loadUserDetailsBySudentId(String sudentId);
	
	public User deleteUserDetails(String sudentId);
	

	User updateUserDetails(User user);

	public List<String> searchUsers(String accountID);
	
	
}
