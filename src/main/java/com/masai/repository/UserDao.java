package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.User;


public interface UserDao extends JpaRepository<User, Integer>{
	
	public Optional<User> findByMobile(String mobile);
}
