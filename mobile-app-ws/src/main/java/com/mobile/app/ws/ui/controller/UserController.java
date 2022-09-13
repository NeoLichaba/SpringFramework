package com.mobile.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  //receive HTTP requests
@RequestMapping("users")  //http://localhost:8080/users
						  //Will be responsible for all apparitions relating to user
						  //Entire class is mapped to users
public class UserController {
	
	@GetMapping
	public String getUsers(@RequestParam(value="page", defaultValue ="1") int page, 
			@RequestParam(value="limit", defaultValue ="50") int limit,  
	@RequestParam(value="sort", defaultValue= "desc", required = false) String sort){
		return "get user was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
	}
	
	
	@GetMapping(path = "/{userId}") //Bind method to HTTP request
	
	//Obtain user info
	public String getUser(@PathVariable String userId) {
		return "get user was called with userId = " + userId;
	}
	
	@PostMapping //Responds to POST request
	public String createUser() {
		return "create user was called";
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
}
