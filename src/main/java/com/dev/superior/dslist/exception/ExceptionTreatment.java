package com.dev.superior.dslist.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionTreatment {

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> throwingValidationException(ValidationException exception){
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}
