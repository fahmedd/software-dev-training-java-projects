package com.fdmgroup.academyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.academyapi.exceptions.UsernameException;
import com.fdmgroup.academyapi.models.AdminUser;
import com.fdmgroup.academyapi.repository.AdminUserDAO;

@Service
public class AdminUserService {

	@Autowired
	private AdminUserDAO adminUserDAO;

	public List<AdminUser> getAllAdminUsers() {
		return adminUserDAO.findAll();
	}

	public AdminUser createAdminUser(AdminUser adminUser) {
		AdminUser existingAdminUser = adminUserDAO.findByUsername(adminUser.getUsername());

		if (existingAdminUser == null) {
			return adminUserDAO.save(adminUser);
		} else {
			throw new UsernameException("Username " + adminUser.getUsername() +" already in use");
		}

	}

	public AdminUser getAdminUserByUsername(String username) {
		AdminUser adminUser = adminUserDAO.findByUsername(username);

		return adminUser;
	}

	public boolean updateAdminUser(AdminUser adminUser) {
		if (adminUserDAO.existsById(adminUser.getId())) {
			adminUserDAO.save(adminUser);
			return true;
		}
		return false;
	}

	public boolean removeAdminUser(int adminUserId) {
		if (adminUserDAO.existsById(adminUserId)) {
			adminUserDAO.deleteById(adminUserId);
			return true;
		}
		return false;
	}

}
