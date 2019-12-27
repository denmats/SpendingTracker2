package com.example.atest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atest.model.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);

}
