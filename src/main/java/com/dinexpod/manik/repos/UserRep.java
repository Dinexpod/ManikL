package com.dinexpod.manik.repos;

import com.dinexpod.manik.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
