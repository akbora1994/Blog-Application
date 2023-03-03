package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.User;

public interface UserService {
	
	public User createNewUser(User user) throws LoginException;
	
	
}
