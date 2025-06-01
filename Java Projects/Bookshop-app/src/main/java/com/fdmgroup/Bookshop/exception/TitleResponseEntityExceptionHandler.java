package com.fdmgroup.Bookshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //any controllers that come across this exception, this will handle it
@RestController
public class TitleResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler //object is superclass of all the classess
	public ResponseEntity<Object> handleUniqueTitleException(TitleException e, WebRequest request)
	{
		TitleResponse response = new TitleResponse(e.getMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	// exception that is happening in the database
	}
}
