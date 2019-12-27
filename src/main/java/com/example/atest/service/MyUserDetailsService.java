package com.example.atest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.atest.dao.UserDAO;
import com.example.atest.model.User;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDAO.findByUsername(username);
		
		if(username==null) {
			throw new UsernameNotFoundException("The name is invalid!");
		}
		
		return new MyUserDetailsServiceImpl(user);
	}

}
