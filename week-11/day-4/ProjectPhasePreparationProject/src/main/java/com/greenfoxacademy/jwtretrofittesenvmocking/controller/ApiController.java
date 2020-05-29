package com.greenfoxacademy.jwtretrofittesenvmocking.controller;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.Actor;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.PopularMovie;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.AuthenticationRequestDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.AuthenticationResponseDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.ErrorDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.PopularMoviesResponseDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.UserDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.service.ActorService;
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
import org.springframework.web.bind.annotation.PathVariable;
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
  private ActorService actorService;

  @Autowired
  public ApiController(AuthenticationManager authenticationManager,
                       UserDetailsService userDetailsService,
                       UserService userService,
                       JwtUtil jwtUtil,
                       MovieService movieService,
                       ActorService actorService) {
    this.authenticationManager = authenticationManager;
    this.userDetailsService = userDetailsService;
    this.userService = userService;
    this.jwtUtil = jwtUtil;
    this.movieService = movieService;
    this.actorService = actorService;
  }

  @PostMapping("/register")
  public ResponseEntity registerNewUser(@RequestBody UserDTO userDTO) {
    if (userService.isUserDTOValid(userDTO)) {
      return ResponseEntity.ok(new UserDTO(userService.saveUser(userDTO)));
    } else {
      return ResponseEntity.badRequest().body(new ErrorDTO("Username and password fields are " +
          "incorrect or missing."));
    }
  }

  @PostMapping("/authenticate")
  public ResponseEntity getJwtTokenAndAuthenticateUser(@RequestBody AuthenticationRequestDTO authenticationRequest) {
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
    return ResponseEntity.ok(new AuthenticationResponseDTO(jwt));
  }

  @GetMapping("/test")
  public ResponseEntity getTestString() {
    return ResponseEntity.ok("Test");
  }

  @GetMapping("/popular-movies")
  public ResponseEntity getPopularMovies() {
    movieService.fetchPopularMovies();
    List<PopularMovie> movieList = movieService.getAllPopularMovie();
    return ResponseEntity.ok(new PopularMoviesResponseDTO(movieList));
  }

  @GetMapping("/actor/{id}")
  public ResponseEntity getActorById(@PathVariable Long id) {
    if (!actorService.isActorStoredAlready(id)) {
      actorService.fetchActorById(id);
    }
    Actor foundActor = actorService.getActorById(id);
    return ResponseEntity.ok(foundActor);
  }
}
