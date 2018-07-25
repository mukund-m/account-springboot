package com.mohan.accountmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


public interface LoginDAO {

	public String getLoginDetails(String userName);
	
}
