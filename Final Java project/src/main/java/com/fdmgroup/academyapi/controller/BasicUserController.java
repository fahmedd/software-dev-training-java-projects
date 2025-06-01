package com.fdmgroup.academyapi.controller;

import java.net.URI;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.academyapi.models.BasicUser;
import com.fdmgroup.academyapi.service.BasicUserService;

@RestController
@RequestMapping("/api/v1/basicUser")
@CrossOrigin(origins = "http://localhost:3000")
public class BasicUserController {
	
	private static Logger logger = LogManager.getLogger(BasicUserController.class);

	@Autowired
	private BasicUserService basicUserService;

	@GetMapping
	public List<BasicUser> getBasicUsers() {
		logger.trace("Get all Basic Users method called");
		return basicUserService.getAllBasicUsers();
	}

	@GetMapping("/{username}")
	public ResponseEntity<BasicUser> getBasicUser(@PathVariable String username) {
		logger.trace("Get Basic User by Username Method called");
		BasicUser basicUser = basicUserService.getBasicUserByUsername(username);

		if (basicUser != null) {
			logger.info("User received");
			return ResponseEntity.status(HttpStatus.OK).body(basicUser);
		}
		logger.debug("Unable to get user");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBasicUser(@PathVariable int id) {
		logger.trace("Delete basic user method called");
		if (basicUserService.removeBasicUser(id)) {
			logger.info("User deleted");
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		logger.debug("Unable to delete user");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	public ResponseEntity<BasicUser> createBasicUser(@RequestBody BasicUser basicUser) {
		logger.trace("Create basic user object attempted");
		BasicUser createdBasicUser = basicUserService.createBasicUser(basicUser);

		if (createdBasicUser != null) {
			logger.info("USer created");
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{BasicUserId}")
					.buildAndExpand(createdBasicUser.getId()).toUri();
			return ResponseEntity.created(location).body(createdBasicUser);
		}
		logger.debug("Unable to create user");
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}

	@PutMapping
	public ResponseEntity<BasicUser> updateBook(@RequestBody BasicUser BasicUser) {
		logger.trace("Update basic user method called");
		if (basicUserService.updateBasicUser(BasicUser)) {
			logger.info("Updated user");
			return ResponseEntity.ok(BasicUser);
		}
		logger.debug("Unable to update user");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
