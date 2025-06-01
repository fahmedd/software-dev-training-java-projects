package com.fdmgroup.assessment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FULLTIME_EMPLOYEE")
public class FullTimeEmployee extends Employee{

	@Column(name="SALARY",nullable= false)
	private double salary;
	
	
	public FullTimeEmployee(String empName, String empDesignation, Department dept) {
		super(empName, empDesignation, dept);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public FullTimeEmployee() {}

	
	
	
	
	
}
