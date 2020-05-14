package com.greenfoxacademy.petshelter.repository;

import com.greenfoxacademy.petshelter.model.Pet;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

  List<Pet> findAll();

  @Query("SELECT p FROM Pet p WHERE p.name = :name")
  Optional<Pet> getPetByName(String name);
}
