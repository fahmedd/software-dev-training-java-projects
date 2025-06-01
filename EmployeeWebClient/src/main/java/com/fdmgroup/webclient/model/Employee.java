package com.fdmgroup.webclient.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee { 

	@JsonProperty("id")
	private long id;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("salary")
	private BigDecimal salary;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("country")
	private String country;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}
