package com.example.springsecuritytest.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecuritytest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
