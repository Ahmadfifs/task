package com.ahmad.task.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;


@ControllerAdvice
public class RestExceptionHandler {
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleEntityNotFound(Exception exception) {
		ApiError apiError = ApiError.of(HttpStatus.BAD_REQUEST, LocalDateTime.now(), exception.getMessage());
		return ResponseEntity.badRequest().body(apiError);
	}
}