package com.fdmgroup.academyapi.exceptions;


public class UsernameResponse {
	
	private String message;

	public UsernameResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
