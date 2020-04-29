package com.greenfoxacademy.redditproject.repository;

import com.greenfoxacademy.redditproject.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByUsername(String username);

  @Query("SELECT u FROM User u WHERE u.active  = true")
  User getActiveUser();
}
