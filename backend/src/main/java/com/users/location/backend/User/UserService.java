package com.users.location.backend.User;

import com.users.location.backend.Exceptions.BadRequest;
import com.users.location.backend.Exceptions.NotFound;
import com.users.location.backend.User.DTO.UserDTO;
import com.users.location.backend.User.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new NotFound("User not found"));
  }

  public User createUser(UserDTO userDTO) {
    if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
      throw new BadRequest("A user with the provided email already exists.");
    }

    User user = User.builder()
        .name(userDTO.getName())
        .email(userDTO.getEmail())
        .address(userDTO.getAddress())
        .latitude(userDTO.getLatitude())
        .longitude(userDTO.getLongitude())
        .build();
    return userRepository.save(user);
  }

  public User updateUser(Long id, UserDTO userDTO) {
    User user = userRepository.findById(id).orElseThrow(() -> new NotFound("User not found"));
    Optional<User> existingUserWithEmail = userRepository.findByEmail(userDTO.getEmail());
    if (existingUserWithEmail.isPresent() && !existingUserWithEmail.get().getId().equals(id)) {
      throw new BadRequest("Email is already taken by another user.");
    }

    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail());
    user.setAddress(userDTO.getAddress());
    user.setLatitude(userDTO.getLatitude());
    user.setLongitude(userDTO.getLongitude());
    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    if (!userRepository.existsById(id)) {
      throw new NotFound("User not found");
    }

    userRepository.deleteById(id);
  }
}
