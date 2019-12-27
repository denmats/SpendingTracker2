package com.example.atest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.atest.model.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {
	

}
