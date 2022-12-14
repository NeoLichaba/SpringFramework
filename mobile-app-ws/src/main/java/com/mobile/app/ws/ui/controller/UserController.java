package com.mobile.app.ws.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mobile.app.ws.exceptions.UserServiceException;
import com.mobile.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.mobile.app.ws.ui.model.response.UserRest;
import com.mobile.app.ws.userservice.UserService;
import com.mobile.app.ws.userservice.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;



@RestController // receive HTTP requests
@RequestMapping("users") // http://localhost:8080/users
							// Will be responsible for all apparitions relating to user
							// Entire class is mapped to users
public class UserController {
	
	Map<String,UserRest>users; //declaring users variable, Map data type =key, object =UserRest
	
	@Autowired
	UserService userService;

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
		
		//if(true) throw new UserServiceException("A user exception is thrown");
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);} //return ResponseEntity using userID
			else {
				return new ResponseEntity<>(users.get(userId), HttpStatus.NO_CONTENT);
			}
		}	
	
	

	// Responds to POST request
	@PostMapping(
			consumes = { 
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE }, 
			produces = {
			MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE 
			})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

		UserRest returnValue = userService.createUser(userDetails); 
		

		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);

	}

	@PutMapping (path = "/{userId}", 
			consumes = { 
			MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE }, 
			produces = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE 
	})
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest storedUserDetails = users.get(userId); //obtain 
		storedUserDetails.setFirstName(userDetails.getFirstName()); //update storedUserDetails
		storedUserDetails.setLastName(userDetails.getLastName());
		
		users.put(userId,  storedUserDetails); //update users map. updated under userId with storedUserDetails
		
		return storedUserDetails;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) { //void
		users.remove(id);//make use of key (id) in order to delete
		
		return ResponseEntity.noContent().build(); //return ResponseEntity, response 204 (should not return content), build response

	}
}

