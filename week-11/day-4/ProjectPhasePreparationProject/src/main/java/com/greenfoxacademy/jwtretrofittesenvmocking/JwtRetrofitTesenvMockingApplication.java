package com.greenfoxacademy.jwtretrofittesenvmocking;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.User;
import com.greenfoxacademy.jwtretrofittesenvmocking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtRetrofitTesenvMockingApplication implements CommandLineRunner {

  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public JwtRetrofitTesenvMockingApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public static void main(String[] args) {
    SpringApplication.run(JwtRetrofitTesenvMockingApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    User admin = new User();
    admin.setUsername("admin");
    admin.setPassword(passwordEncoder.encode("admin"));
    admin.setRoles("ROLE_ADMIN,ROLE_USER");
    userRepository.save(admin);
  }
}
