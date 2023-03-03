package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.UserSession;

public interface SessionDao extends JpaRepository<UserSession, Integer>{
	
	public Optional<UserSession> findByUserID(Integer userID);
	
	public Optional<UserSession> findByUuId(String uuId);
}
