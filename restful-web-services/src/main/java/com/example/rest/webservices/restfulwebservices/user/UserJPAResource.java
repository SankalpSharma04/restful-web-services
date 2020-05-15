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
public class UserJPAResource {

	
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private PostRepository postrepo;
	
	
	@RequestMapping(value="/jpa/user", method=RequestMethod.GET)
	public List<User> FindAll() {
		return userrepo.findAll();
		
	}
	
	@RequestMapping(value="/jpa/user/{id}", method=RequestMethod.GET)
	public Optional<User> FindOne(@PathVariable Integer id) {
		return userrepo.findById(id); 
	
	}
	
	@RequestMapping(value="/jpa/users", method=RequestMethod.POST)
	public ResponseEntity add(@Valid @RequestBody User user) {
		User saveUser= userrepo.save(user);
		
	URI location = 
	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		
	return ResponseEntity.created(location).build();
	
	}
	
	
	@RequestMapping(value="/jpa/user/{id}", method=RequestMethod.DELETE)
	public void  DeleteOne(@PathVariable Integer id) {
	 userrepo.deleteById(id);
	
	}
	
	@RequestMapping(value="/jpa/user/{id}/posts", method=RequestMethod.GET)
	public Optional<User> FindAll(@PathVariable int id) {
		return userrepo.findById(id);
		
	}
	

	@RequestMapping(value="/jpa/users/{id}/post", method=RequestMethod.POST)
	public ResponseEntity createpost(@Valid @PathVariable Integer id, @RequestBody Post post) {
		Optional<User> useropt= userrepo.findById(id);
		
		if(!useropt.isPresent()) {
			throw new UserNotFoundException("id" + id);
		}
		
		User user=useropt.get();
		
		post.setUser(user);
		
	URI location = 
	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		
	return ResponseEntity.created(location).build();
	
	}
	
	
}
