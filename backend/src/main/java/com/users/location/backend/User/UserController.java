package com.users.location.backend.User;

import com.users.location.backend.User.DTO.UserDTO;
import com.users.location.backend.User.Entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {
  private final UserService userService;

  public UserController(@Autowired UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user = userService.getUserById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
    User newUser = userService.createUser(userDTO);
    return ResponseEntity.ok(newUser);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
    User updatedUser = userService.updateUser(id, userDTO);
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<User> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }
}
