package com.fdmgroup.UserSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class UsernameExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler //object is superclass of all the classess
	public ResponseEntity<Object> handleUniqueUsernameException(UsernameException e, WebRequest request)
	{
		UsernameResponse response = new UsernameResponse(e.getMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	// exception that is happening in the database
	}
}


