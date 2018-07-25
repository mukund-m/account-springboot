package com.mohan.accountmanagement.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mohan.accountmanagement.model.User;
import com.mohan.accountmanagement.model.UserManagementForm;
import com.mohan.accountmanagement.service.UserManagementService;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	private static List<User> userList = new ArrayList<>();
	
	@Override
	public boolean saveUserDetails(User user) {
		this.userList.add(user);
		return true;
	}

	@Override
	public User loadUserDetailsByEmail(String email) {
		for(User user: userList) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User loadUserDetailsByUserName(String userName) {
		for(User user: userList) {
			if(user.getUserName().equals(userName)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User loadUserDetailsBySudentId(String studentId) {
		for(User user: userList) {
			if(user.getStudentId().equals(studentId)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User deleteUserDetails(String studentId) {
		User temp = null;
		for(User user: userList) {
			if(user.getStudentId().equals(studentId)) {
				temp = user;
			}
		}
		if(temp != null) {
			userList.remove(temp);
		}
		return temp;
	}

	@Override
	public User updateUserDetails(User updatedUser) {
		User temp = null;
		for(User user: userList) {
			if(user.getStudentId().equals(updatedUser.getStudentId())) {
				temp = user;
			}
		}
		if(temp == null) {
			return null;
		}
		this.userList.remove(temp);
		this.userList.add(updatedUser);
		return updatedUser;
	}

	@Override
	public List<String> searchUsers(String accountID) {
		List<String> searchResult = new ArrayList<>();
		searchResult.add("");
		for(User user: this.userList) {
			if(user.getAccountIds() != null) {
				for(String accId: user.getAccountIds()) {
					if(accId.equals(accountID)) {
						searchResult.add(user.getStudentId()+"-"+user.getUserName());
					}
				}
			}
		}
		return searchResult;
	}
}
