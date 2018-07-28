package com.mohan.accountmanagement.model;

public class Login {

	private String userName;
	
	private String password;
	
	private String newPassword;
	
	private String confirmPassword;

	public Login(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Login() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	
}
