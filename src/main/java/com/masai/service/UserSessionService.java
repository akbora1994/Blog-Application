package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Login;

public interface UserSessionService {
	
	public String logIntoAccount(Login login) throws UserException, LoginException;
	
	public String logoutFromAccount(String uuid) throws LoginException;
}
