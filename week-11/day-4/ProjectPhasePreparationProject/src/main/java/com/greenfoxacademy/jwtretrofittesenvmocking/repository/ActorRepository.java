package com.greenfoxacademy.jwtretrofittesenvmocking.repository;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.ActorDAO;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<ActorDAO, Long> {

  @Query(value = "SELECT * FROM actor WHERE id = :id LIMIT 1", nativeQuery = true)
  Optional<ActorDAO> findActorById(Long id);
}
