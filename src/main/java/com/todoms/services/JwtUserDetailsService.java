package com.todoms.services;

import java.util.ArrayList;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.todoms.exceptions.UserAlreadyExistsException;
import com.todoms.model.UserModel;
import com.todoms.repository.UserRepo;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public UserModel save(UserModel user) throws Exception{
		UserModel newUser = new UserModel();
		String username = user.getUsername();
		if(!Objects.isNull(((userRepo.findByUsername(username)))) && userRepo.findByUsername(username).getUsername().equals(username)){
			throw new UserAlreadyExistsException("Username Already Exists");
		}
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepo.save(newUser);
	}
}