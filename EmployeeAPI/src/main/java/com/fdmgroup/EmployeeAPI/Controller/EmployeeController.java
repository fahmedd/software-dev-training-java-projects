package com.fdmgroup.EmployeeAPI.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.EmployeeAPI.Exception.EmployeeNotFoundException;
import com.fdmgroup.EmployeeAPI.Model.Employee;
import com.fdmgroup.EmployeeAPI.Service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Operation(summary = "Creates a new Employee resource with the employee that is given.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "employee resource successfully created.", headers = {
					@Header(name = "employeeapi", description = "/api/v1/employees") }, content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@PostMapping
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<>();

			for (FieldError error : bindingResult.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(this.employeeService.createEmployee(employee), HttpStatus.CREATED); // 201

	}

	@Operation(summary = "pass the employee id once is found it returns")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "employee resource successfully found.", headers = {
					@Header(name = "employeeapi", description = "/api/v1/employees/{id}") }, content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@GetMapping("/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable long id) throws EmployeeNotFoundException {
		return new ResponseEntity<>(this.employeeService.findEmployeeById(id), HttpStatus.OK);

	}

	@Operation(summary = "finds all employees saved")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "employee resource successfully found.", headers = {
					@Header(name = "employeeapi", description = "/api/v1/employees/") }, content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@GetMapping
	public ResponseEntity<?> findAllEmployees() {
		return new ResponseEntity<>(this.employeeService.findAllEmployees(), HttpStatus.OK);
	}

	@Operation(summary = "deletes employee with the id that is given")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "employee resource successfully deleted.", headers = {
					@Header(name = "employeeapi", description = "/api/v1/employees/{id}") }, content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable long id) throws EmployeeNotFoundException {
		this.employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Operation(summary = "updates employee with employee that is given")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "employee resource successfully updated.", headers = {
					@Header(name = "employeeapi", description = "/api/v1/employees/") }, content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException{
		return new ResponseEntity<>(this.employeeService.updateEmployee(employee), HttpStatus.OK);
	}

}
