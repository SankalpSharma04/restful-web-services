package com.example.rest.webservices.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*@CrossOrigin(origins="http://localhost:4200")*/
@RestController
public class HelloController {
	
	@Autowired
	private MessageSource messageSource;
	
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
	
	@GetMapping( path="/hello-world")
	public HelloWorldBean helloWorldBean() {
		//throw new RuntimeException("Some error has happened! Contact support at ***--*** ");
		return new HelloWorldBean("hello World");
	}
	
	@GetMapping( path="/hellointernolization")
	public String helloBeanInternolization(/* @RequestHeader(name="Accept-Language", required=false) Locale locale */) {
		//throw new RuntimeException("Some error has happened! Contact support at ***--*** ");
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
	/* here we write LocaleContextHolder.getLocale() just because we dont want to 
	 * sprcify the acept-lang everytime in every language*/
}
