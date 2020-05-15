package com.example.rest.webservices.restfulwebservices.versoning;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PesonVesioningController {

	@RequestMapping("v1/person")
	public Person1 person1() {
	
		return new Person1("Sankalp Sharma");
	}
	
	@RequestMapping("v2/person")
	public Person2 person2() {
		return new Person2(new Name("Sankalp","Sharma"));
	}
}
