package com.fdmgroup.UserSystem.Model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue( strategy= GenerationType.AUTO)
	private long id;
	
	@NotBlank(message="Invalid firstname")
	@Size(min=1, max=200,message="Invalid firstname")
	@Column (updatable=true)
	private String fullName;
	
	@NotBlank(message="Invalid lastname")
	@Size(min=1, max=200,message="Invalid lastname")
	@Column (updatable=true)
	private String lastName;
	
	@NotBlank(message="Invalid email")
	@Size(min=4, max=200,message="Invalid email")
	@Column (updatable=false)
	private String email;
	
	@NotBlank(message="Invalid username")
	@Size(min=5, max=200,message="Invalid username")
	@Column(unique= true, updatable=true)
	private String username;
	
	@NotBlank(message="Invalid password")
	@Size(min=4, max=200,message="Invalid password")
	@Column (updatable=true)
	private String password;
	
	
	public User() {}
	
	public User(String fullName, String lastName, String email, String username, String password) {
		super();
		this.fullName = fullName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	
	
	
}
