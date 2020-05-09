package com.example.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticatonController {

	@GetMapping(path="/basicauth")
	public AuthenticationBean helloWorldPathVariable() {
		//throw new RuntimeException("Some error has happened! Contact support at ***--*** ");
		return new AuthenticationBean("You are authenticated");
	}
}
