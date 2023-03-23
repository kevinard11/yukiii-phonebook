package com.yukiii.sprphonebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PhoneNumberAlreadyExistException extends RuntimeException{

	public PhoneNumberAlreadyExistException() {
		super("Phone number already exist");
	}

	public PhoneNumberAlreadyExistException(String message) {
		super(message);
	}
}
