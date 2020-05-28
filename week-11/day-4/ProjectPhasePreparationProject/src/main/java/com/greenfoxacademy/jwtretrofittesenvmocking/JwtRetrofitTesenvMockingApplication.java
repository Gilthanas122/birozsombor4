package com.greenfoxacademy.jwtretrofittesenvmocking;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.User;
import com.greenfoxacademy.jwtretrofittesenvmocking.repository.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtRetrofitTesenvMockingApplication implements CommandLineRunner {

  private UserRepository userRepository;

  @Autowired
  public JwtRetrofitTesenvMockingApplication(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(JwtRetrofitTesenvMockingApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    User defaultUser = new User();
    defaultUser.setUsername("user");
    defaultUser.setPassword("password");
    defaultUser.setRoles("ROLE_USER");
    userRepository.save(defaultUser);
  }
}
