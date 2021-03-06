package com.greenfoxacademy.redditproject.service;

import com.greenfoxacademy.redditproject.model.User;
import com.greenfoxacademy.redditproject.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void addNewUser(User newUser) {
    userRepository.save(newUser);
  }

  public boolean isPasswordValid(User user, String passwordVerification) {
    if (user.getPassword().equals(passwordVerification)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isUsernameValid(User user) {
    if (!userRepository.findByUsername(user.getUsername()).isPresent()) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validateUserData(String username, String password) {
    Optional<User> foundUser = userRepository.findByUsername(username);
    if (foundUser.isPresent()) {
      User user = foundUser.get();
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isUserValid(User user, String passwordVerification) {
    if (isPasswordValid(user, passwordVerification) && isUsernameValid(user)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isUserInvalid(User user, String passwordVerification) {
    if (!isPasswordValid(user, passwordVerification) && !isUsernameValid(user)) {
      return true;
    } else {
      return false;
    }
  }

  public void setUserActive(String username) {
    Optional<User> optionalUser = userRepository.findByUsername(username);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      user.setActive(true);
      userRepository.save(user);
    }
  }

  public void setActiveUserToInactive() {
    User user = userRepository.getActiveUser();
    user.setActive(false);
    userRepository.save(user);
  }

  @Override
  public boolean isActiveAnyUser() {
    if (userRepository.getActiveUser() == null) {
      return false;
    } else {
      return true;
    }
  }
}
