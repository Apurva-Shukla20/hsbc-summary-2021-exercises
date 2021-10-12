package com.hsbc.exception;

public class EmployeeAlreadyExistsException extends Exception {

	public EmployeeAlreadyExistsException() {
		super();
	}

	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}

}