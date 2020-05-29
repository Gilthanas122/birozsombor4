package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.User;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.UserDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.repository.UserRepository;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceTest {

  private UserService userService;
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;


  @BeforeEach
  public void before() {
    this.userRepository = Mockito.mock(UserRepository.class);
    this.passwordEncoder = Mockito.mock(PasswordEncoder.class);
    this.userService = new UserServiceImpl(this.userRepository, this.passwordEncoder);
  }

  @Test
  public void saveUser_WithValidUserDTO_SaveAndReturnValidObject() {
    //Arrange
    UserDTO fakeUserDTO = new UserDTO("fakeuser", "fakepassword");

    //Act
    UserDTO result = userService.saveUser(fakeUserDTO);

    //Assert
    Assert.assertEquals("fakeuser", result.getUsername());
  }


}
