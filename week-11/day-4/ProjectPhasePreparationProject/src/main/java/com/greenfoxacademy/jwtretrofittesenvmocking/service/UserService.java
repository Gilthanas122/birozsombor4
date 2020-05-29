package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.User;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.UserDTO;
import java.util.Optional;

public interface UserService {
  Optional<User> getUserByUsername(String username);

  UserDTO saveUser(UserDTO userDTO);

  boolean isUserDTOValid(UserDTO userDTO);
}
