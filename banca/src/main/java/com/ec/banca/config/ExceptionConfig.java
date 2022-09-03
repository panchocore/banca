package com.ec.banca.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.ec.banca.config.exception.BadRequestException;
import com.ec.banca.config.exception.NotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundException(Exception e){
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestException(Exception e){
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
