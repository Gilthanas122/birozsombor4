package com.greenfoxacademy.jwtretrofittesenvmocking.controller;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.AuthenticationRequest;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.AuthenticationResponse;
import com.greenfoxacademy.jwtretrofittesenvmocking.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
  private JwtUtil jwtUtil;

  @Autowired
  public ApiController(AuthenticationManager authenticationManager,
                       UserDetailsService userDetailsService,
                       JwtUtil jwtUtil) {
    this.authenticationManager = authenticationManager;
    this.userDetailsService = userDetailsService;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping("/authenticate")
  public ResponseEntity getJwtTokenAndAuthenticateUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              authenticationRequest.getUsername(),
              authenticationRequest.getPassword())
      );
    } catch (BadCredentialsException e) {
      return ResponseEntity.badRequest().build();
    }
    UserDetails userDetails =
        userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    String jwt = jwtUtil.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }

  @GetMapping("/test")
  public ResponseEntity getTestString() {
    return ResponseEntity.ok(new String("Test"));
  }
}
