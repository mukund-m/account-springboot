package com.mohan.accountmanagement.service;

import com.mohan.accountmanagement.model.Login;

public interface LoginService {

	public boolean authenticate(Login login);
}
