package com.fdmgroup.EmployeeAPI.Repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.EmployeeAPI.Model.Employee;

public interface EmployeeRepository extends CrudRepository <Employee,Long>{
	
	
	void deleteById(long id);

}
