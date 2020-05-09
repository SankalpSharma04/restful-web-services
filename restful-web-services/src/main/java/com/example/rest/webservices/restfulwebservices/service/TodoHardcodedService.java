package com.example.rest.webservices.restfulwebservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rest.webservices.restfulwebservices.todo.Todo;

@Service
public class TodoHardcodedService {

	
	private static List<Todo> todos=new ArrayList();
	private static long counter=0;
	
	static {
		todos.add(new Todo(++counter,"sankalp", "learn to microservice", new Date(), false));
		todos.add(new Todo(++counter,"sharma", "learn to angular", new Date(), false));
		todos.add(new Todo(++counter,"shobit", "learn to lightning", new Date(), false));
		todos.add(new Todo(++counter,"jain", "learn to cook", new Date(), false));
		todos.add(new Todo(++counter,"arpit", "learn to study", new Date(), false));
		todos.add(new Todo(++counter,"bhardwaj", "learn to earn", new Date(), false));
		
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo save(Todo todo)
	{
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++counter);
			todos.add(todo);
		}else {
			removeById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo removeById(long id) {
		Todo todo=findById(id);
		if(todo==null) return null;
		
		if(todos.remove(todo)) {
		return todo;
		} 
		return null;
	}


	public Todo findById(long id) {
		// TODO Auto-generated method stub
		for(Todo todo: todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
		
	}
	

	
}
