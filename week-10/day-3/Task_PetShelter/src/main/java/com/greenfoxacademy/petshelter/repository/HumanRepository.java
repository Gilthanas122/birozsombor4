package com.greenfoxacademy.petshelter.repository;

import com.greenfoxacademy.petshelter.model.Human;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends CrudRepository<Human, Long> {

  List<Human> findAll();

  @Query("SELECT h FROM Human h WHERE h.name = :name")
  Optional<Human> getHumanByName(String name);
}
