package com.fdmgroup.EmployeeAPI.Repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.fdmgroup.EmployeeAPI.Model.Employee;

@ActiveProfiles({"test","dev"})
@DataJpaTest
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	Employee employee;
	
	@BeforeEach
	void setup () {
		employee = new Employee();
		employee.setFirstName("John");
		employee.setLastName("Doe");
		employee.setCountry("USA");
		employee.setState("New york");
		employee.setSalary(BigDecimal.valueOf(21.000));	
	}
	
	
	@Test
	void givenEmployee_whenSaveEmployeeIsCalled_ThenReturnsNumberOfSavedEmployees() {
		employeeRepository.save(employee);
		
		assertThat(employeeRepository.count()).isEqualTo(1);	
	}
	
	
	@Test 
	void givenEmployee_whenDeleteByIdIsCalled_ThenDeleteTheEmployee(){
		employeeRepository.save(employee);
		
		employeeRepository.deleteById(employee.getId());
		
		assertThat(employeeRepository.count()).isEqualTo(0);
		
	}
	
	
	//find all
	@Test
	void givenAnEmployee_WhenFindAllMethodCalled_ReturnsListOfEmployees() {
		employeeRepository.save(employee);
		
		ArrayList<Employee> employees= (ArrayList<Employee>)employeeRepository.findAll();
		
		assertThat(employees.size()).isEqualTo(1);
	}
	
	
	//find by id
	@Test
	@DisplayName("Find by Id")
	void givenAnId_WhenFindByIdMethodCalled_ReturnCorrectEmployee() {
		employee.setId(1L);
		employeeRepository.save(employee);
		
		Optional<Employee> actualEmployee=employeeRepository.findById(employee.getId());
		
		assertThat(actualEmployee).isNot(null);
		assertThat(employeeRepository.count()).isEqualTo(1);
		assertThat(actualEmployee.get().getId()).isEqualTo(2L);
		
	}
	
	
	
	@AfterEach
	void tearDown() {
		employeeRepository.deleteAll();
		employee= null;
		employeeRepository=null;
	}
	
}
