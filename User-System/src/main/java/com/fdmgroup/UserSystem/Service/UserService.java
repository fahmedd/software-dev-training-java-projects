package com.fdmgroup.UserSystem.Service;

import com.fdmgroup.UserSystem.Model.User;
import com.fdmgroup.UserSystem.Rep.UserSystemRepository;

import jakarta.validation.Valid;

public interface UserService {

	User findUserByid(long id);

	User findUserByUsername(String username);

	User createUser(User user);

	User updateUser(User user);

	User deleteUserByUsername(String username);
	
	 
}
