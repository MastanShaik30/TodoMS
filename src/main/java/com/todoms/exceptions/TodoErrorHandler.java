package com.todoms.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.todoms.model.ErrorType;

@RestControllerAdvice
public class TodoErrorHandler {
	/**
	 * In case of TodoNotFoundException is thrown
	 * from any controller method, this logic gets
	 * executed which behaves like re-usable and
	 * clear code (Code Modularity)
	 * @param nfe
	 * @return ResponseEntity
	 */
	//@ResponseBody
	@ExceptionHandler(TodoNotFoundException.class)
	public ResponseEntity<ErrorType> handleNotFound(TodoNotFoundException nfe){
		
		return new ResponseEntity<ErrorType>(
				new ErrorType(
						new Date(System.currentTimeMillis()).toString(), 
						"404- NOT FOUND", 
						nfe.getMessage()), 
				HttpStatus.NOT_FOUND);
	}
	
	
}
