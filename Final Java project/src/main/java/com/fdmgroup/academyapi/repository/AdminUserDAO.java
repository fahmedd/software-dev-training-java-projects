package com.fdmgroup.academyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.academyapi.models.AdminUser;

public interface AdminUserDAO extends JpaRepository<AdminUser, Integer> {
	
	AdminUser findByUsername(String username);
	
	
}
