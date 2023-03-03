package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Login;
import com.masai.model.User;
import com.masai.service.UserSessionService;
import com.masai.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserSessionService usService;
	
	@PostMapping("/users")
	public ResponseEntity<User> createNewUser(@RequestBody User user) throws LoginException{
		
		User usr = userService.createNewUser(user);
		return new ResponseEntity<User>(usr,HttpStatus.OK);
	}

	@PostMapping("/users/login")
	public ResponseEntity<String> loginAccount(@RequestBody Login login) throws UserException, LoginException {
		
		String str =  usService.logIntoAccount(login);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	@DeleteMapping("/users/logout/{id}")
	public ResponseEntity<String> logoutAccount(@PathVariable("id") String uniqueId) throws LoginException{
		
		String message = usService.logoutFromAccount(uniqueId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
