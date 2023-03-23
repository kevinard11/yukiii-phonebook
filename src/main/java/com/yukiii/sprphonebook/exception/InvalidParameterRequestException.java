package com.yukiii.sprphonebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParameterRequestException extends RuntimeException{

	public InvalidParameterRequestException(String message) {
		super(message);
	}
}
