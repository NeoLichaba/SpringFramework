package com.mobile.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.mobile.app.ws.ui.model.response.UserRest;
import com.mobile.app.ws.userservice.UserService;
import com.mobile.app.ws.utils.Utils;

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserRest> users; // Map data type =key, object =UserRest
	
	Utils utils;
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}
	

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());

		String userId = utils.generateUserId();
		returnValue.setUserId(userId);

		// check if there are any users
		if (users == null)
			users = new HashMap<>();   //create hashmap
		users.put(userId, returnValue); // key, value

		return returnValue;
	}

}
