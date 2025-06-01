package com.fdmgroup.EmployeeAPI.Model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@NotBlank(message="Invalid Firstname")
	@Size(min=2, max=100,message="Invalid Firstname")
	@Column(updatable=true, nullable= false)
	private String firstName;
	
	@NotBlank(message="Invalid Lastname")
	@Size(min=2, max=100,message="Invalid Lastname")
	@Column(updatable=true, nullable= false)
	private String lastName;
	
	@DecimalMin(value= "0.1", inclusive=false)
	@Digits(integer=5, fraction= 2)
	@Column(updatable=true, nullable= false)
	private BigDecimal salary;
	
	@NotBlank(message="Invalid State")
	@Size(min=2, max=100,message="Invalid State")
	@Column(updatable=false, nullable= false)
	private String state;
	
	@NotBlank(message="Invalid Country")
	@Size(min=2, max=100,message="Invalid Country")
	@Column(updatable=false, nullable= false)
	private String country;
	
	public Employee() {}

	public Employee(String firstName, String lastName, BigDecimal salary, String state, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.state = state;
		this.country = country;
	}

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
