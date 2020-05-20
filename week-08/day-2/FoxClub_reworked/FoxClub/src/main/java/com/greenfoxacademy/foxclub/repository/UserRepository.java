package com.greenfoxacademy.foxclub.repository;

import com.greenfoxacademy.foxclub.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByUsername(String username);
}
