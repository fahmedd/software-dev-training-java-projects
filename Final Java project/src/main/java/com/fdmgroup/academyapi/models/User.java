package com.fdmgroup.academyapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class User {

	@Id
	@Column(name = "user_id")
	@SequenceGenerator(name = "USER_ID_GEN", sequenceName = "user_id_seq", initialValue = 21, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GEN")
	private int id;

	@NotBlank(message = "Username is required. ")
	@Size(min = 4, max = 20, message = "Username is not valid. Please use 4 to 20 characters.")
	@Column(unique = true)
	private String username;

	@NotBlank(message = "Password is required. ")
	@Size(min = 6, max = 20, message = "Password is not valid. Please use 5 to 20 characters.")
	private String password;

	@ManyToMany
	@JoinTable(name = "user_watch_item", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie> watchList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Movie> getWatchList() {
		return watchList;
	}

	public void setWatchList(List<Movie> watchList) {
		this.watchList = watchList;
	}

}
