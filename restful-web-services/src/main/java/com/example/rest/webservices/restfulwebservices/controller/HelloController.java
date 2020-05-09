package com.example.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloController {
	
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String helloWorld() {
		return "hello Sankalp sharma";
	}
	
	@RequestMapping(path="/hello-world1")
	public String helloWorld1() {
		//throw new RuntimeException("Some error has happened! Contact support at ***--*** ");
		return "hello Sankalp sharma";
	}

	@GetMapping( path="/hello-world/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		//throw new RuntimeException("Some error has happened! Contact support at ***--*** ");
		return new HelloWorldBean(String.format("hello World, %s",  name));
	}
}
