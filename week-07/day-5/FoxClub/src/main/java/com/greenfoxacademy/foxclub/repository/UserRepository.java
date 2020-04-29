package com.greenfoxacademy.foxclub.repository;

import com.greenfoxacademy.foxclub.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  List<User> findAllByUsernameContaining(String username);

  User findByUsername(String username);
}
