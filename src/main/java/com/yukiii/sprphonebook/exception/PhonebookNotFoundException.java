package com.yukiii.sprphonebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PhonebookNotFoundException extends RuntimeException {
	public PhonebookNotFoundException(String message) {
		super(message);
	}

	public PhonebookNotFoundException() {
		super("Phone book not found");
	}
}
