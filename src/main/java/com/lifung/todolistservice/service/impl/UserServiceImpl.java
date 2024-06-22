package com.lifung.todolistservice.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lifung.todolistservice.model.User;
import com.lifung.todolistservice.repository.UserRepository;
import com.lifung.todolistservice.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public Optional<User> findByUsername(String username) {
    return userRepository.findByUsername(username).stream().findFirst();
  }
}
