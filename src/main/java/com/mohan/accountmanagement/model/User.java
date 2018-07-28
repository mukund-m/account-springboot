package com.mohan.accountmanagement.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {

	String studentId;
	String userName;
	String email;
	String department;
	boolean canWrite;
	String desk;
	List<String> accountIds;
	
	List<String> deskAccountIds;
	
	private List<String> desks;
	
	
	public User() {
		this.desks = new ArrayList<>();
		this.desks.add("Desk 1");
		this.desks.add("Desk 2");
		this.desks.add("Desk 3");
		
	
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public boolean isCanWrite() {
		return canWrite;
	}
	public void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}
	public List<String> getAccountIds() {
		return accountIds;
	}
	public void setAccountIds(List<String> accountIds) {
		this.accountIds = accountIds;
	}
	public String getDesk() {
		return desk;
	}
	public void setDesk(String desk) {
		this.desk = desk;
	}
	
	public List<String> getDesks() {
		return desks;
	}

	public void setDesks(List<String> desks) {
		this.desks = desks;
	}

	public List<String> getDeskAccountIds() {
		return deskAccountIds;
	}

	public void setDeskAccountIds(List<String> deskAccountIds) {
		this.deskAccountIds = deskAccountIds;
	}

	
	
	
}
