
package com.fdmgroup.academyapi.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

import com.fdmgroup.academyapi.exceptions.UsernameException;
import com.fdmgroup.academyapi.models.AdminUser;
import com.fdmgroup.academyapi.service.AdminUserService;

@RestController
@RequestMapping("/api/v1/adminUser")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminUserController {

	private static Logger logger = LogManager.getLogger(BasicUserController.class);

	@Autowired
	private AdminUserService adminUserService;

	@GetMapping
	public List<AdminUser> getAdminUsers() {
		logger.trace("Get all Admin Users method called");
		return adminUserService.getAllAdminUsers();
	}

	@GetMapping("/{username}")
	public ResponseEntity<AdminUser> getAdminUser(@PathVariable String username) {
		logger.trace("Get Admin User by Username Method called");
		AdminUser adminUser = adminUserService.getAdminUserByUsername(username);

		if (adminUser != null) {
			logger.info("User received");
			return ResponseEntity.status(HttpStatus.OK).body(adminUser);
		}
		logger.debug("Unable to get user");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAdminUser(@PathVariable int id) {
		logger.trace("Delete admin user method called");
		if (adminUserService.removeAdminUser(id)) {
			logger.info("User deleted");
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		logger.debug("Unable to delete user");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	public ResponseEntity<?> createAdminUser(@Valid @RequestBody AdminUser adminUser, BindingResult bindingResult) {
		logger.trace("Create admin user object attempted");
		if (bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<>();

			for (FieldError error : bindingResult.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		try {
			AdminUser createdAdminUser = adminUserService.createAdminUser(adminUser);

			if (createdAdminUser != null) {
				logger.info("USer created");
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{AdminUserId}")
						.buildAndExpand(createdAdminUser.getId()).toUri();
				return ResponseEntity.created(location).body(createdAdminUser);
			}
			logger.debug("Unable to create user");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();

		} catch (UsernameException e) {
			Map<String, String> errors = new HashMap<>();
			errors.put("username", "Username already exists");
			logger.debug("Unable to create user");
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
			
		}
	}

	@PutMapping
	public ResponseEntity<AdminUser> updateBook(@RequestBody AdminUser AdminUser) {
		logger.trace("Update admin user method called");
		if (adminUserService.updateAdminUser(AdminUser)) {
			logger.info("Updated user");
			return ResponseEntity.ok(AdminUser);
		}
		logger.debug("Unable to update user");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
