package com.users.location.backend.services;

import com.users.location.backend.dtos.UserCreateDTO;
import com.users.location.backend.entities.User;
import com.users.location.backend.exceptions.BadRequest;
import com.users.location.backend.exceptions.NotFound;
import com.users.location.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUserById(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new NotFound("User not found"));
  }

  @Override
  public User createUser(UserCreateDTO userDTO) {
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

  @Override
  public User updateUser(Long id, UserCreateDTO userDTO) {
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

  @Override
  public void deleteUser(Long id) {
    if (!userRepository.existsById(id)) {
      throw new NotFound("User not found");
    }
    userRepository.deleteById(id);
  }
}
