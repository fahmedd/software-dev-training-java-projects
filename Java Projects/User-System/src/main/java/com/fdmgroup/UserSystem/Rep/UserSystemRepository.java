package com.fdmgroup.UserSystem.Rep;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.UserSystem.Model.User;

public interface UserSystemRepository extends CrudRepository<User,Long > {

	User findByUsername(String username);
	
	User deleteUser(String username);

}
