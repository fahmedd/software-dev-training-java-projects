package com.fdmgroup.assessment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PARTTIME_EMPLOYEE")
public class PartTimeEmployee extends Employee{
	
	@Column(name="WAGES",nullable= false)
	private double wages;

	public PartTimeEmployee() {
	}

	
	public PartTimeEmployee(String empName, String empDesignation, Department dept) {
		super(empName, empDesignation, dept);
	}


	public double getWages() {
		return wages;
	}

	public void setWages(double wages) {
		this.wages = wages;
	}
	
	
	

}
