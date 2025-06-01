package com.fdmgroup.webclient.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.webclient.model.Employee;
import com.fdmgroup.webclient.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/webclient/v1/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Employee> saveEmployee(@RequestBody Employee employee) {
		System.err.println(employee.getFirstName());
		return this.employeeService.save(employee);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Flux<Employee> findAllEmployees() {
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Employee> findEmployeeById(@PathVariable Long id) {
		return this.employeeService.findEmployeeById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Employee> deleteEmployeeById(@PathVariable Long id) {
		return this.employeeService.deleteEmployeeById(id);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Mono<Employee> updateEmployee(@RequestBody Employee employee) {
		return this.employeeService.updateEmployee(employee);
	}
}
