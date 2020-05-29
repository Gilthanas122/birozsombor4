package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.User;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.UserDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceTest {

  private UserService userService;
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  @BeforeEach
  public void beforeEach() {
    this.userRepository = Mockito.mock(UserRepository.class);
    this.passwordEncoder = Mockito.mock(PasswordEncoder.class);
    this.userService = new UserServiceImpl(this.userRepository, this.passwordEncoder);
  }

  @Test
  public void saveUser_WithValidUserDTO_ReturnValidObject() {
    //Arrange
    UserDTO fakeUserDTO = new UserDTO("fakeuser", "fakepassword");

    User userReturnFromDatabase = new User();
    userReturnFromDatabase.setUsername("fakeuser");
    userReturnFromDatabase.setPassword("encodedPass");
    userReturnFromDatabase.setRoles("ROLE_USER,");

    Mockito.when(passwordEncoder.encode(Mockito.any(String.class))).thenReturn("encodedPass");
    Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(userReturnFromDatabase);

    //Act
    User savedUser = userService.saveUser(fakeUserDTO);

    //Assert
    Assert.assertEquals("fakeuser", savedUser.getUsername());
    Assert.assertEquals("encodedPass", savedUser.getPassword());
    Assert.assertEquals("ROLE_USER,", savedUser.getRoles());
  }

  @Test
  public void isUserDTOValid_WithEmptyPassword_ReturnFalse() {
    UserDTO fakeUserDTO = new UserDTO("fakeuser", "");

    boolean result = userService.isUserDTOValid(fakeUserDTO);

    Assert.assertFalse(result);
  }

  @Test
  public void isUserDTOValid_WithMissingPassword_ReturnFalse() {
    UserDTO fakeUserDTO = new UserDTO("fakeuser", "");
    fakeUserDTO.setPassword(null);

    boolean result = userService.isUserDTOValid(fakeUserDTO);

    Assert.assertFalse(result);
  }

  @Test
  public void isUserDTOValid_WithEmptyUsername_ReturnFalse() {
    UserDTO fakeUserDTO = new UserDTO("", "fakepassword");

    boolean result = userService.isUserDTOValid(fakeUserDTO);

    Assert.assertFalse(result);
  }

  @Test
  public void isUserDTOValid_WithMissingUsername_ReturnFalse() {
    UserDTO fakeUserDTO = new UserDTO("", "fakepassword");
    fakeUserDTO.setUsername(null);

    boolean result = userService.isUserDTOValid(fakeUserDTO);

    Assert.assertFalse(result);
  }

  @Test
  public void isUserDTOValid_WithValidUserDTO_ReturnFalse() {
    Boolean result = null;
    try {
      UserDTO fakeUserDTO = new UserDTO("fakeuser", "fakepassword");
      result = userService.isUserDTOValid(fakeUserDTO);
    } catch (UsernameNotFoundException e) {
      Assert.assertNull(result);
    }
  }
}
