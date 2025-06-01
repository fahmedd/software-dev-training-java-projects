package com.fdmgroup.academyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.academyapi.models.BasicUser;
import com.fdmgroup.academyapi.repository.BasicUserDAO;

@Service
public class BasicUserService {

	@Autowired
	private BasicUserDAO basicUserDAO;

	public List<BasicUser> getAllBasicUsers() {
		return basicUserDAO.findAll();
	}

	public BasicUser createBasicUser(BasicUser basicUser) {
		BasicUser existingBasicUser = basicUserDAO.findByUsername(basicUser.getUsername());

		if (existingBasicUser == null) {
			return basicUserDAO.save(basicUser);
		}
		return null;
	}

	public BasicUser getBasicUserByUsername(String username) {
		BasicUser basicUser = basicUserDAO.findByUsername(username);

		return basicUser;
	}

	public boolean updateBasicUser(BasicUser basicUser) {
		if (basicUserDAO.existsById(basicUser.getId())) {
			basicUserDAO.save(basicUser);
			return true;
		}
		return false;
	}

	public boolean removeBasicUser(int basicUserId) {
		if (basicUserDAO.existsById(basicUserId)) {
			basicUserDAO.deleteById(basicUserId);
			return true;
		}
		return false;
	}

}
