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
    if (userRepository.findAllByUsernameContaining(user.getUsername()).size() == 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validateUserData(String name, String password) {
    if (userRepository.findAllByUsernameContaining(name).size() > 0) {
      User user = userRepository.findAllByUsernameContaining(name).get(0);
      if (user.getUsername().equals(name) && user.getPassword().equals(password)) {
        return true;
      }
    } else {
      return false;
    }
    return false;
  }
}
