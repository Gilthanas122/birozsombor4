package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.User;
import java.util.Optional;

public interface UserService {
  Optional<User> getUserByUsername(String username);
}
