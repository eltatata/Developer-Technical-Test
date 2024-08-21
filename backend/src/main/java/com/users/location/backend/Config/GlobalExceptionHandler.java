package com.users.location.backend.Config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.users.location.backend.Exceptions.BadRequest;
import com.users.location.backend.Exceptions.NotFound;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFound.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(NotFound ex) {
    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BadRequest.class)
  public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequest ex) {
    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
    ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred: " + ex.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}