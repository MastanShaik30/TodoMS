package com.todoms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todoms.model.UserModel;

@Repository
public interface UserRepo extends CrudRepository<UserModel, Integer> {
	
	UserModel findByUsername(String username);
	
}