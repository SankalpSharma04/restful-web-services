package com.example.rest.webservices.restfulwebservices.controller;

public class HelloWorldBean {

	private String message;
	
//	private String name;

	public HelloWorldBean(String message) {
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
		return String.format("HelloWorldBean [message= %s]", message);
	}

}
