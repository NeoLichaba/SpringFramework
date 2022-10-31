package com.mobile.app.ws.ui.model.response;

import java.util.Date;

//Error message contains properties

public class ErrorMessage {

	private Date timestamp;	

	private String message;
	
	public ErrorMessage() {} 								//no args constructor created
	
	public ErrorMessage(Date timestamp, String message) {   //constructor that accepts parameters
		this.timestamp= timestamp;
		this.message=message;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
