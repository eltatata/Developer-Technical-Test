package com.users.location.backend.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.location.backend.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
