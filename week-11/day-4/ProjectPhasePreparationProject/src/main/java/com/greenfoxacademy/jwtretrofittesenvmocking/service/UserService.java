package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.UserDAO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.UserDTO;

public interface UserService {

  UserDAO saveUser(UserDTO userDTO);

  boolean isUserDTOValid(UserDTO userDTO);
}
