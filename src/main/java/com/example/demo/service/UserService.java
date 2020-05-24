package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User create(final String email, final String password) throws Exception {
    final User anotherUser = userRepository.findByEmail(email);

    if (anotherUser != null) {
      throw new Exception("User with this email already exists");
    }

    return userRepository.save(new User(email, password));
  }

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public User get(final String userId) {
    return userRepository.findById(userId).get();
  }

  public User getByEmail(final String email) {
    return userRepository.findByEmail(email);
  }
}
