package com.example.rest.basic.auth;

public class AuthenticationBean {

	private String message;
	
//	private String name;

	public AuthenticationBean(String message) {
		this.message=message;
		//this.name=name;
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	@Override
	public String toString() {
		return String.format("HelloWorldBean [message= %s]",  message);
	}

}
