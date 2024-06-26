package com.lifung.todolistservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifung.todolistservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByUsername(String username);
}
