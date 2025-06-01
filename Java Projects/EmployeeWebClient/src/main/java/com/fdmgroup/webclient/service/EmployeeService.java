package com.fdmgroup.webclient.service;

import java.time.Duration;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.webclient.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

	private WebClient webClient;
	
	public EmployeeService(WebClient webClient) {
		this.webClient = webClient;
	}
	
	public Mono<Employee> save(Employee employee) {
		// @formatter:off
		return this.webClient
				.post()
				.uri("/api/v1/employees")
				.body(BodyInserters.fromValue(employee))
				.retrieve()
				.bodyToMono(Employee.class);
		// @formatter:on
	}
	
	public Flux<Employee> findAllEmployees() {
		// @formatter:off
		return this.webClient
				.get()
				.uri("/api/v1/employees")
				.retrieve()
				.bodyToFlux(Employee.class)
				.timeout(Duration.ofMillis(10_000));
		// @formatter:on
	}
	
	public Mono<Employee> findEmployeeById(long id) {
		// @formatter:off
		return this.webClient
				.get()
				.uri("/api/v1/employees/"+id)
				.retrieve()
				.bodyToMono(Employee.class)
				.timeout(Duration.ofMillis(10_000));
		// @formatter:on
	}
	
	public Mono<Employee> deleteEmployeeById(@PathVariable Long id) {
		// @formatter:off
		return this.webClient
				.delete()
				.uri("/api/v1/employees/"+id)
				.retrieve()
				.bodyToMono(Employee.class);
		// @formatter:on
	}

	public Mono<Employee> updateEmployee(Employee employee) {
		// @formatter:off
		return this.webClient
				.put()
				.uri("/api/v1/employees")
				.body(BodyInserters.fromValue(employee))
				.retrieve()
				.bodyToMono(Employee.class);
		// @formatter:on
	}
	
}
