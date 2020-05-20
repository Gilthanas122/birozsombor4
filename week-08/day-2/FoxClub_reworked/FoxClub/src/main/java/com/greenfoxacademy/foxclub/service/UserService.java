package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.User;
import com.greenfoxacademy.foxclub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void addNewUser(User newUser) {
    userRepository.save(newUser);
  }

  public boolean verifiedPassword(User user, String passwordVerification) {
    if (user.getPassword().equals(passwordVerification)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean verifiedUsername(User user) {
    return !userRepository.findByUsername(user.getUsername()).isPresent();
  }

  public boolean validateUserData(String name, String password) {
    if (userRepository.findByUsername(name).isPresent()) {
      User user = userRepository.findByUsername(name).get();
      if (user.getUsername().equals(name) && user.getPassword().equals(password)) {
        return true;
      }
    } else {
      return false;
    }
    return false;
  }

  public User getUserByUsername(String username) {
    return userRepository.findByUsername(username).orElse(null);
  }
}
