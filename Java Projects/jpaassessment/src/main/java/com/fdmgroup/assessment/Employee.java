package com.fdmgroup.assessment;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "EMP_SEQ_GNTR")
	@SequenceGenerator(name= "EMP_SEQ_GNTR", sequenceName= "EMP_SEQ", allocationSize = 1)
	@Column(name="EMP_ID",nullable= false)
	private int empId;
	
	@Column(name="EMP_NAME", nullable= false, updatable=false)
	private String empName;
	
	@Column(name="EMP DESIGNATION", nullable= false)
	private String empDesignation;
	
	@ManyToOne
	@JoinColumn(name= "FK_DEPT_ID")
	private Department dept;
	
	public Employee() {}

	public Employee(String empName, String empDesignation, Department dept) {
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.dept = dept;
	}


	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	

}
