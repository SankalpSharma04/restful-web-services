package com.example.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication extends SpringBootServletInitializer {

	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestfulWebServicesApplication.class);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	@Bean
   public LocaleResolver localeresolver() {
		/* SessionLocaleResolver localeresolver= new SessionLocaleResolver(); */
		AcceptHeaderLocaleResolver localeresolver= new AcceptHeaderLocaleResolver();
		//here we use AcceptHeaderLocaleResolver so it will take any header languae
		localeresolver.setDefaultLocale(Locale.US);
		return localeresolver;
	}
	
	
	/*
	 * @Bean public ResourceBundleMessageSource bundleMessageSource() {
	 * ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
	 * messageSource.setBasename("messages"); return messageSource; }
	 * 
	 * this bean is ussed to bing the message.properties, if we use spring.messages.basename=messages. 
	 * then no need to write this bean
	 */
}