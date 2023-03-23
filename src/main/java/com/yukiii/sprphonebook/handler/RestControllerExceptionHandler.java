package com.yukiii.sprphonebook.handler;

import com.yukiii.sprphonebook.exception.InvalidParameterRequestException;
import com.yukiii.sprphonebook.exception.PhoneNumberAlreadyExistException;
import com.yukiii.sprphonebook.exception.PhonebookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({InvalidParameterRequestException.class, PhoneNumberAlreadyExistException.class})
	public final ResponseEntity<?> badRequestException(Exception ex) {
		return new ResponseEntity<>(
			ResponseException
				.builder()
				.timestamp(new Date())
				.message("Bad request")
				.error(ex.getLocalizedMessage())
				.build()
			, HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(PhonebookNotFoundException.class)
	public final ResponseEntity<?> notFoundException(Exception ex){
		return new ResponseEntity<>(
			ResponseException
				.builder()
				.timestamp(new Date())
				.message("Data not found")
				.error(ex.getLocalizedMessage())
				.build()
			, HttpStatus.NOT_FOUND
		);
	}
}
