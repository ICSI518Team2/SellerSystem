package com.fusemachine.inventory.service;

import com.fusemachine.inventory.domain.User;

public interface UserService {
	//User service
	//Get user by email to check validation when login
	public User findUserByEmailID(String emailID);
	//After edit user information, need to save data to db
	public void saveUser(User user);
}
