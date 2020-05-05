package com.greenfoxacademy.redditproject.service;

import com.greenfoxacademy.redditproject.model.User;

public interface UserService {

  boolean isPasswordValid(User user, String passwordVerification);

  void addNewUser(User newUser);

  boolean isUsernameValid(User user);

  boolean validateUserData(String username, String password);

  void setUserActive(String username);

  void setActiveUserToInactive();

  boolean isActiveAnyUser();

  boolean isUserValid(User user, String passwordVerification);

  boolean isUserInvalid(User user, String passwordVerification);
}
