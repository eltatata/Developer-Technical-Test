package com.users.location.backend.exceptions;

public class BadRequest extends RuntimeException {
  public BadRequest(String message) {
    super(message);
  }
}
