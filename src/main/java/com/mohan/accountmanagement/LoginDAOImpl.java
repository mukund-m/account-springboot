package com.mohan.accountmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mohan.accountmanagement.dao.LoginDAO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public String getLoginDetails(String userName) {
		/*String sql = "SELECT password from  FROM user_details where userName=?";
		String password = (String)this.jdbcTemplate.queryForObject(
				sql, new Object[] { userName }, String.class);
		return password;*/
		return null;
	}
}
