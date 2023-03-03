package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.User;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public User createNewUser(User user) throws LoginException {
		
		Optional<User> opt =  userDao.findByMobile(user.getMobile());
		
		if(opt.isPresent()) {
			throw new LoginException("User already exists with this mobile number..");
		}
		
		User usr1 =  userDao.save(user);
		return usr1;
	}

}
