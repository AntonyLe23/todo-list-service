package com.lifung.todolistservice.service;

import java.util.Optional;

import com.lifung.todolistservice.model.User;

public interface UserService {
  Optional<User> findByUsername(String username);
}
