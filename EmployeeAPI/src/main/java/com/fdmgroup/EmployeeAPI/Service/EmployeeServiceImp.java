package com.fdmgroup.EmployeeAPI.Service;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.fdmgroup.EmployeeAPI.Exception.EmployeeNotFoundException;
import com.fdmgroup.EmployeeAPI.Model.Employee;
import com.fdmgroup.EmployeeAPI.Repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
			return this.employeeRepository.save(employee);
	
	}
	
	@Override
	public Iterable<Employee> findAllEmployees() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(long id) throws EmployeeNotFoundException{
		return this.employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployee(Employee employee)throws EmployeeNotFoundException{
		return this.employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(long id) throws EmployeeNotFoundException{
		this.employeeRepository.deleteById(id);
		
	}

}
