package com.fdmgroup.EmployeeAPI.Exception;

public class EmployeeNotFoundResponse {
	
	private String message;

	public EmployeeNotFoundResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
