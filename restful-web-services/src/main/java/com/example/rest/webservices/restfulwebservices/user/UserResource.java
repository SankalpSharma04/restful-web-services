package com.example.rest.webservices.restfulwebservices.user;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.webservices.restfulwebservices.exception.UserNotFoundException;

/*import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;*/




@RestController
public class UserResource {

	
	
	@Autowired
	private UserdaoService userservice;
	
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public List<User> FindAll() {
		return userservice.findAll();
		
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public User FindOne(@PathVariable Integer id) {
	User user= userservice.findOne(id);
	if(user==null) 
		throw new UserNotFoundException("id-"+ id);
	
	//EntityModel<User> resource=new EntityModel<User>(user);
	
	//WebMvcLinkBuilder linkTo = linkTo(method(this.getClass()).FindAll());
   // resource.add(linkTo.withRel("all-users"));
	
	return user;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity add(@Valid @RequestBody User user) {
		User saveUser= userservice.save(user);
		
	URI location = 
	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		
	return ResponseEntity.created(location).build();
	
	}
	
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public ResponseEntity  DeleteOne(@PathVariable Integer id) {
	User user= userservice.deleteById(id);
	
	if(user==null) {
		throw new UserNotFoundException("id-"+ id);
	}
	return ResponseEntity.noContent().build();
	}
	
	
}
