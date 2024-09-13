package com.users.location.backend.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserCreateDTO {
  @NotBlank(message = "Name cannot be empty")
  @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
  private String name;

  @NotBlank(message = "Email cannot be empty")
  @Email(message = "Email should be valid")
  private String email;

  @NotBlank(message = "Address cannot be empty")
  private String address;

  @DecimalMin(value = "-90", inclusive = false, message = "Latitude must be a valid decimal number between -90 and 90")
  @DecimalMax(value = "90", inclusive = true, message = "Latitude must be a valid decimal number between -90 and 90")
  private BigDecimal latitude;

  @DecimalMin(value = "-180", inclusive = false, message = "Longitude must be a valid decimal number between -180 and 180")
  @DecimalMax(value = "180", inclusive = true, message = "Longitude must be a valid decimal number between -180 and 180")
  private BigDecimal longitude;
}
