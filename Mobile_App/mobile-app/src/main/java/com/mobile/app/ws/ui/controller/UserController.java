package com.mobile.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   //Receives HTTP requests when sent and match URL path
@RequestMapping("users") //http:localhost:8080/users;Controller responsible for User apparitions
public class UserController {

	@GetMapping   //User to respond to HTTP get request
	public String getUser() 
	{
		return "get user was called";
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
