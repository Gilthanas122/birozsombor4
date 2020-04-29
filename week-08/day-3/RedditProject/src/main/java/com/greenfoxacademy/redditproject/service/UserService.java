package com.greenfoxacademy.redditproject.service;

import com.greenfoxacademy.redditproject.model.User;

public interface UserService {

  boolean verifiedPassword(User user, String passwordVerification);

  void addNewUser(User newUser);

  boolean verifiedUsername(User user);

  boolean validateUserData(String username, String password);

  void setUserActive(String username);

  void setActiveUserToInactive();

  boolean isActiveAnyUser();
}
