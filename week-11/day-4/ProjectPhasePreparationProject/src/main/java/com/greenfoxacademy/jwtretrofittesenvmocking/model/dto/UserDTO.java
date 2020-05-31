package com.greenfoxacademy.jwtretrofittesenvmocking.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.UserDAO;

public class UserDTO {

  private String username;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  public UserDTO() {
  }

  public UserDTO(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public UserDTO(UserDAO user) {
    this.username = user.getUsername();
    this.password = user.getPassword();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
