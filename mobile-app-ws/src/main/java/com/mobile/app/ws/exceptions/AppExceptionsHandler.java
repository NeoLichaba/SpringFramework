package com.mobile.app.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mobile.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice //annotation allows it to listen for exceptions across all mapping methods. If not available, class won't be able to listen
			      //for exceptions that take place within our app
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class }) //
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) { //method that handles the exception, returns ResponseEntity

		String errorMessageDescription = ex.getLocalizedMessage(); 

		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();

		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR); //returns HttpHeaders and status
	}

	@ExceptionHandler(value = { NullPointerException.class, UserServiceException.class })//NullPointerException 
	public ResponseEntity<Object> handleSpecificExceptions(Exception ex, WebRequest request) { //handle

		String errorMessageDescription = ex.getLocalizedMessage(); //

		if (errorMessageDescription == null) //
			errorMessageDescription = ex.toString();

		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage()); //returns custom Error class
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
}
