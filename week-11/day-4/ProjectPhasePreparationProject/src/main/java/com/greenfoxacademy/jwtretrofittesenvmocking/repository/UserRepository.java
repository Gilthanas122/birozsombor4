package com.greenfoxacademy.jwtretrofittesenvmocking.repository;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  @Query(value = "SELECT * FROM user WHERE username = :username LIMIT 1", nativeQuery = true)
  Optional<User> findUserByUsername(String username);
}
