package com.fdmgroup.EmployeeAPI.Service;

import com.fdmgroup.EmployeeAPI.Model.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	
	Iterable<Employee> findAllEmployees ();
	
	Employee findEmployeeById (long id);
	
	Employee updateEmployee (Employee employee);
	
	void deleteEmployeeById (long id);

}
