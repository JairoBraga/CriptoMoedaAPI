package com.workshop.teste.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<StandardError> userNotFoundException(UserNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		Integer status = HttpStatus.NOT_FOUND.value();
		
		return new ResponseEntity<StandardError>(
				new StandardError(Instant.now(), error, status, e.getMessage(), request.getContextPath()),
				HttpStatus.NOT_FOUND);
		
	}	
	@ExceptionHandler(CoinNotFoundException.class)
	public ResponseEntity<StandardError> coinNotFoundException(CoinNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		Integer status = HttpStatus.NOT_FOUND.value();
		
		return new ResponseEntity<StandardError>(
				new StandardError(Instant.now(), error, status, e.getMessage(), request.getContextPath()),
				HttpStatus.NOT_FOUND);
		
	}	
}
