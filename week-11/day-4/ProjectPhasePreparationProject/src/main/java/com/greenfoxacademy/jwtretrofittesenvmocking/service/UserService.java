package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.User;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.UserDTO;

public interface UserService {

  User saveUser(UserDTO userDTO);

  boolean isUserDTOValid(UserDTO userDTO);
}
