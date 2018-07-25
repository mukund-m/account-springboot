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
	
	private List<String> desks;
	
	private HashMap<String, List<String>> deskAccountIdMap;
		
	
	public User() {
		this.desks = new ArrayList<>();
		this.desks.add("Desk 1");
		this.desks.add("Desk 2");
		this.desks.add("Desk 3");
		
		this.deskAccountIdMap = new HashMap();
		List<String> desk1AccountIds = new ArrayList<>();
		desk1AccountIds.add("Account ID 1");
		desk1AccountIds.add("Account ID 2");
		
		List<String> desk2AccountIds = new ArrayList<>();
		desk2AccountIds.add("Account ID A");
		desk2AccountIds.add("Account ID B");
		
		List<String> desk3AccountIds = new ArrayList<>();
		desk3AccountIds.add("Account ID I");
		desk3AccountIds.add("Account ID II");
		desk3AccountIds.add("Account ID III");
		
		this.deskAccountIdMap.put("Desk 1", desk1AccountIds);
		this.deskAccountIdMap.put("Desk 2", desk2AccountIds);
		this.deskAccountIdMap.put("Desk 3", desk3AccountIds);
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

	public HashMap<String, List<String>> getDeskAccountIdMap() {
		return deskAccountIdMap;
	}

	public void setDeskAccountIdMap(HashMap<String, List<String>> deskAccountIdMap) {
		this.deskAccountIdMap = deskAccountIdMap;
	}
	
	
}
