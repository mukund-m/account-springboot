package com.mohan.accountmanagement.serviceimpl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohan.accountmanagement.dao.LoginDAO;
import com.mohan.accountmanagement.model.Login;
import com.mohan.accountmanagement.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	

	@Autowired
	LoginDAO loginDAO;
	
	private List<Login> credentials = new ArrayList<>() ;
	
	public  LoginServiceImpl() {
		
		credentials.add(new Login("mohan", "test123"));
		credentials.add(new Login("mohan1", "test123"));
		credentials.add(new Login("mohan2", "test123"));
	}
	
	/**
	 * Return true if the userName and password exist as an entry in list
	 */
	@Override
	public boolean authenticate(Login login) {
		System.out.println(this.loginDAO.getLoginDetails("asd"));
		for(Login cred: this.credentials) {
			if(cred.getUserName().equals(login.getUserName()) &&
					cred.getPassword().equals(login.getPassword())) {
				return true;
			}
		}
		return false;
		
	}

}
