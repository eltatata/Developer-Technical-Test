package com.users.location.backend.User;

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

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public User createUser(UserDTO userDTO) {
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
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail());
    user.setAddress(userDTO.getAddress());
    user.setLatitude(userDTO.getLatitude());
    user.setLongitude(userDTO.getLongitude());
    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
