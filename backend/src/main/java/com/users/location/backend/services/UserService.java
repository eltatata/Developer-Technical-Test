package com.users.location.backend.services;

import com.users.location.backend.dtos.UserCreateDTO;
import com.users.location.backend.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(UserCreateDTO userDTO);
    User updateUser(Long id, UserCreateDTO userDTO);
    void deleteUser(Long id);
}
