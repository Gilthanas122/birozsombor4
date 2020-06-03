package com.greenfoxacademy.jwtretrofittesenvmocking.controller;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.UserDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.service.UserService;
import com.greenfoxacademy.jwtretrofittesenvmocking.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class ApiControllerTest {

  @Autowired
  private MockMvc mockMvc;
  private UserService userService;
  private UserDetailsService userDetailsService;
  private JwtUtil jwtUtil;

  @Autowired
  public ApiControllerTest(UserService userService,
                           UserDetailsService userDetailsService,
                           JwtUtil jwtUtil) {
    this.userService = userService;
    this.userDetailsService = userDetailsService;
    this.jwtUtil = jwtUtil;
    this.userService.saveUser(new UserDTO("default", "password"));
    this.userService.saveAdmin(new UserDTO("admin", "adminPass"));
  }

  @Test
  public void registerNewUser_WithValidUserDto_ReturnsValidStatusAndObject() throws Exception {
    mockMvc.perform(post("/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"username\":\"test\",\"password\":\"password\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.username", is("test")));
  }

  @Test
  public void registerNewUser_WithEmptyPassword_ReturnsValidStatusAndObject() throws Exception {
    mockMvc.perform(post("/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"username\":\"test\",\"password\":\"\"}"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Username and password fields are " +
            "incorrect or missing.")));
  }

  @Test
  public void registerNewUser_WithEmptyUsername_ReturnsValidStatusAndObject() throws Exception {
    mockMvc.perform(post("/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"username\":\"\",\"password\":\"password\"}"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Username and password fields are " +
            "incorrect or missing.")));
  }

  @Test
  public void registerNewUser_WithMissingPassword_ReturnsValidStatusAndObject() throws Exception {
    mockMvc.perform(post("/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"username\":\"test\"}"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Username and password fields are " +
            "incorrect or missing.")));
  }

  @Test
  public void registerNewUser_WithMissingUsername_ReturnsValidStatusAndObject() throws Exception {
    mockMvc.perform(post("/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"password\":\"password\"}"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Username and password fields are " +
            "incorrect or missing.")));
  }

  @Test
  public void getJwtTokenAndAuthenticateUser_WithValidAuthenticationRequestDTO_ReturnsValidStatusAndObject() throws Exception {
     mockMvc.perform(post("/authenticate")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"username\":\"default\",\"password\":\"password\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.jwt").exists());
  }

  @Test
  public void getJwtTokenAndAuthenticateUser_WithValidInvalidUsername_ReturnsUnauthorized() throws Exception {
    mockMvc.perform(post("/authenticate")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"username\":\"defaultasd\",\"password\":\"password\"}"))
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void getJwtTokenAndAuthenticateUser_WithValidInvalidPassword_ReturnsUnauthorized() throws Exception {
    mockMvc.perform(post("/authenticate")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"username\":\"default\",\"password\":\"passwordasd\"}"))
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void getTestString_WithoutAuthentication_ReturnsClientSideError() throws Exception {
    mockMvc.perform(get("/test"))
        .andExpect(status().is4xxClientError());
  }

  @Test
  public void getTestString_WithAuthentication_ReturnsValidStatusAndContent() throws Exception {
    UserDetails userDetails = userDetailsService.loadUserByUsername("default");
    String jwt = jwtUtil.generateToken(userDetails);
    mockMvc.perform(get("/test")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk())
        .andExpect(content().string("This is a test string for all authenticated user."));
  }

  @Test
  public void getPopularMovies_WithoutAuthentication_ReturnsClientSideError() throws Exception {
    mockMvc.perform(get("/popular-movies"))
        .andExpect(status().is4xxClientError());
  }

  @Test
  public void getPopularMovies_WithAuthentication_ReturnsOk() throws Exception {
    UserDetails userDetails = userDetailsService.loadUserByUsername("default");

    //PowerMockito.mockStatic(System.class);
    //PowerMockito.when(System.getenv("SECRET_KEY")).thenReturn("test");

    String jwt = jwtUtil.generateToken(userDetails);
    mockMvc.perform(get("/popular-movies")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk());
  }

  @Test
  public void getActorById_WithoutAuthentication_ReturnsClientSideError() throws Exception {
    mockMvc.perform(get("/actor/1"))
        .andExpect(status().is4xxClientError());
  }

  @Test
  public void getActorById_WithAuthentication_ReturnsOk() throws Exception {
    UserDetails userDetails = userDetailsService.loadUserByUsername("default");
    String jwt = jwtUtil.generateToken(userDetails);
    mockMvc.perform(get("/actor/1")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk());
  }

  @Test
  public void getTestStringForAdmin_WithoutAuthentication_ReturnsClientSideError() throws Exception {
    mockMvc.perform(get("/admin/test"))
        .andExpect(status().is4xxClientError());
  }

  @Test
  public void getTestStringForAdmin_WithAuthenticationAndWithoutAdminRole_ReturnsForbidden() throws Exception {
    UserDetails userDetails = userDetailsService.loadUserByUsername("default");
    String jwt = jwtUtil.generateToken(userDetails);
    mockMvc.perform(get("/admin/test")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isForbidden());
  }

  @Test
  public void getTestStringForAdmin_WithAuthenticationAndWithAdminRole_ReturnsOkAndValidString() throws Exception {
    UserDetails userDetails = userDetailsService.loadUserByUsername("admin");
    String jwt = jwtUtil.generateToken(userDetails);
    mockMvc.perform(get("/admin/test")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk())
        .andExpect(content().string("This is a test string just for admins!"));
  }

  @Test
  public void getTestStringForUser_WithoutAuthentication_ReturnsClientSideError() throws Exception {
    mockMvc.perform(get("/user/test"))
        .andExpect(status().is4xxClientError());
  }

  @Test
  public void getTestStringForUser_WithAuthenticationAndWithUserRole_ReturnsOkAndValidString() throws Exception {
    UserDetails userDetails = userDetailsService.loadUserByUsername("default");
    String jwt = jwtUtil.generateToken(userDetails);
    mockMvc.perform(get("/user/test")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk())
        .andExpect(content().string("This is a test string just for users!"));
  }

  @Test
  public void getTestStringForUser_WithAuthenticationAndWithAdminRole_ReturnsOkAndValidString() throws Exception {
    UserDetails userDetails = userDetailsService.loadUserByUsername("admin");
    String jwt = jwtUtil.generateToken(userDetails);
    mockMvc.perform(get("/user/test")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk())
        .andExpect(content().string("This is a test string just for users!"));
  }
}
