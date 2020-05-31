package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.UserDAO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.UserDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public UserDAO saveUser(UserDTO userDTO) {
    UserDAO user = new UserDAO();
    user.setUsername(userDTO.getUsername());
    user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    user.setRoles("ROLE_USER,");
    return userRepository.save(user);
  }

  @Override
  public boolean isUserDTOValid(UserDTO userDTO) {
    if (isUsernameValid(userDTO.getUsername()) && isPasswordValid(userDTO.getPassword())) {
      return true;
    } else {
      return false;
    }
  }

  private boolean isPasswordValid(String password) {
    if (password == null || password.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }

  private boolean isUsernameValid(String username) {
    if (username == null || username.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }
}
