package com.fdmgroup.UserSystem.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.UserSystem.Model.User;
import com.fdmgroup.UserSystem.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserSystemController {

	private UserService userService;
	
	public UserSystemController(UserService userService) {
		this.userService= userService;
	}
	

	@GetMapping("/{id}") 
	public ResponseEntity<?> findUserById(@PathVariable long id) {
		return new ResponseEntity<>(this.userService.findUserByid(id), HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<?> findUserByUsername(@PathVariable String username){
		return new ResponseEntity<>(this.userService.findUserByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			
			Map<String,String> errors= new HashMap();
			
		 for(FieldError error: bindingResult.getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}
		 return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.CREATED); //201
		}

	@PutMapping
	public ResponseEntity<?> editUser(@RequestBody User user){
		return new ResponseEntity<>(this.userService.updateUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable String username){
		this.userService.deleteUserByUsername(username);
		return new ResponseEntity<>(HttpStatus.GONE);
	}
}
