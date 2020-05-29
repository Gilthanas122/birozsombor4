package com.greenfoxacademy.jwtretrofittesenvmocking.security;

import com.greenfoxacademy.jwtretrofittesenvmocking.security.UserDetailsImpl;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.User;
import com.greenfoxacademy.jwtretrofittesenvmocking.repository.UserRepository;
import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

  private UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findUserByUsername(username);
    user.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    UserDetails userDetails = new UserDetailsImpl(user.get());
    return userDetails;
  }
}
