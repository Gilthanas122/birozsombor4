package com.greenfoxacademy.foxclub.repository;

import com.greenfoxacademy.foxclub.model.Fox;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FoxRepository extends CrudRepository<Fox, Long> {

  @Query(value = "SELECT * FROM fox WHERE name = :name LIMIT 1", nativeQuery = true)
  Optional<Fox> findByName(String name);
}
