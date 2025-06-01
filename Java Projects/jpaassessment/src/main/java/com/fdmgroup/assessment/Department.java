package com.fdmgroup.assessment;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQuery(
		name="Department.findByDeptName",
		query= "SELECT d from Department d WHERE d.deptName = :Dname")
@Entity
@Table(name="DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "DEP_SEQ_GNTR")
	@SequenceGenerator(name= "DEP_SEQ_GNTR", sequenceName= "DEP_SEQ", allocationSize = 1)
	@Column(name="DEPT_ID", nullable=false)
	private int deptId;
	
	@Column(name="DEPT_NAME",unique= true, nullable= false)
	private String deptName;
	
	@OneToMany(mappedBy="dept")
	private List<Employee> employees;
	
	public Department() {}

	public Department(String deptName) {
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}

