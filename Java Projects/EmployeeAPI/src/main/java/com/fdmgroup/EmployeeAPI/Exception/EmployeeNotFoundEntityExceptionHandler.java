package com.fdmgroup.EmployeeAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice 
@RestController
public class EmployeeNotFoundEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler 
	public ResponseEntity<Object> handleUniqueIdException(EmployeeNotFoundException e, WebRequest request)
	{
		EmployeeNotFoundResponse response = new EmployeeNotFoundResponse(e.getMessage());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
}
