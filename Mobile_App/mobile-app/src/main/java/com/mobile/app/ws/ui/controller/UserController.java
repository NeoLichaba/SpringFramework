package com.mobile.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController   //Receives HTTP requests when sent and match URL path
@RequestMapping("/users") //http:localhost:8080/users;Controller responsible for User apparitions
public class UserController {

	@GetMapping 
	//Request Parameters available to method
	public String getUsers(@RequestParam(value= "page", defaultValue = "1") int page, 	//page = number of pages, default value of 1 provided if page number isn't
			@RequestParam(value= "limit", defaultValue = "50") int limit, 				//limit = number of users to be returned/page, default value given
			@RequestParam(value= "sort", defaultValue = "desc", required = false) String sort) 
	{
		
		return "get user was called with page = " + page + " and limit = " + limit + " sort = " + sort; 
	}
	@GetMapping(path="/{userid}")   //User to respond to HTTP get request
	//Binding created for get method to URL with user value 
	public String getUser(@PathVariable String userId) 
	{
		return "get user was called with userId: " + userId; 
	}
	
	@PostMapping 
	public String createUser()
	{
		return "create user was called";
	}
	
	@PutMapping
	public String updateUser()
	{
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser()
	{
		return "delete user was called";
	}
}
