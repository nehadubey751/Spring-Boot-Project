package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(InvalidRequestException.class)
	    public ResponseEntity<?> handleInvalidRequestException(InvalidRequestException ex, WebRequest request) {
	        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
	        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	    public static class ErrorResponse {
	        private int statusCode;
	        private String message;

	        public ErrorResponse(int statusCode, String message) {
	            this.statusCode = statusCode;
	            this.message = message;
	        }

	        public int getStatusCode() {
	            return statusCode;
	        }

	        public String getMessage() {
	            return message;
	        }
	    }
	}

	   

