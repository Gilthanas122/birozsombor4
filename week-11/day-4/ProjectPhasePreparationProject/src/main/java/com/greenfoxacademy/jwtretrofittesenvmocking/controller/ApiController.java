package com.greenfoxacademy.jwtretrofittesenvmocking.controller;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.PopularMovie;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.AuthenticationRequest;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.AuthenticationResponse;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.UserDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.service.MovieService;
import com.greenfoxacademy.jwtretrofittesenvmocking.service.UserService;
import com.greenfoxacademy.jwtretrofittesenvmocking.util.JwtUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

  private AuthenticationManager authenticationManager;
  private UserDetailsService userDetailsService;
  private UserService userService;
  private JwtUtil jwtUtil;
  private MovieService movieService;

  @Autowired
  public ApiController(AuthenticationManager authenticationManager,
                       UserDetailsService userDetailsService,
                       UserService userService,
                       JwtUtil jwtUtil,
                       MovieService movieService) {
    this.authenticationManager = authenticationManager;
    this.userDetailsService = userDetailsService;
    this.userService = userService;
    this.jwtUtil = jwtUtil;
    this.movieService = movieService;
  }

  @PostMapping("/register")
  public ResponseEntity registerNewUser(@RequestBody UserDTO userDTO) {
    return ResponseEntity.ok(userService.saveUser(userDTO));
  }

  @PostMapping("/authenticate")
  public ResponseEntity getJwtTokenAndAuthenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              authenticationRequest.getUsername(),
              authenticationRequest.getPassword())
      );
    } catch (BadCredentialsException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    UserDetails userDetails =
        userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    String jwt = jwtUtil.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }

  @GetMapping("/test")
  public ResponseEntity getTestString() {
    return ResponseEntity.ok("Test");
  }

  @GetMapping("/popular-movies")
  public ResponseEntity getPopularMovies() {
    movieService.updatePopularMovies();
    List<PopularMovie> movieList = movieService.getPopularMovies();
    return ResponseEntity.ok(movieList);
  }

}
