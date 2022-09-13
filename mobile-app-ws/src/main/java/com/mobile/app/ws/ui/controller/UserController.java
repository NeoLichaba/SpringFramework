package com.mobile.app.ws.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.mobile.app.ws.ui.model.response.UserRest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;



@RestController // receive HTTP requests
@RequestMapping("users") // http://localhost:8080/users
							// Will be responsible for all apparitions relating to user
							// Entire class is mapped to users
public class UserController {
	
	Map<String,UserRest>users; //Map data type =key, object =UserRest

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
	}

	// Bind method to HTTP request
	// Receive value in either JSON/XML value
	@GetMapping(path = "/{userId}", 
			produces= {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE
					}) 
	
	//Obtain user info
	public ResponseEntity <UserRest> getUser (@PathVariable String userId) {
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);}
			else {
				return new ResponseEntity<>(users.get(userId), HttpStatus.NO_CONTENT);
			}
		}	
	
	

	// Responds to POST request
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());

		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);

		// check if there are any users
		if (users == null)
			users = new HashMap<>();
		users.put(userId, returnValue); //key, value

		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);

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

