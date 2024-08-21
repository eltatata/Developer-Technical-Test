package com.users.location.backend.Exceptions;

public class BadRequest extends RuntimeException {
  public BadRequest(String message) {
    super(message);
  }
}
