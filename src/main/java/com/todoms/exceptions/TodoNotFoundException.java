package com.todoms.exceptions;

public class TodoNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public TodoNotFoundException() {
		super();
	}
	
	public TodoNotFoundException(String message) {
		super(message);
	}

}
