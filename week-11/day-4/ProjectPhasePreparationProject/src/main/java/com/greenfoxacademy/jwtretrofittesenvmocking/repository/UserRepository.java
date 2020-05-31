package com.greenfoxacademy.jwtretrofittesenvmocking.repository;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.UserDAO;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDAO, Long> {

  @Query(value = "SELECT * FROM user WHERE username = :username LIMIT 1", nativeQuery = true)
  Optional<UserDAO> findUserByUsername(String username);
}
