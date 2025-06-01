package com.fdmgroup.academyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.academyapi.models.BasicUser;

public interface BasicUserDAO extends JpaRepository<BasicUser, Integer> {
	BasicUser findByUsername(String username);
}
