package com.users.location.backend.User;

import com.users.location.backend.User.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
