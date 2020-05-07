package com.greenfoxacademy.restoptionals.repository;

import com.greenfoxacademy.restoptionals.model.Cargo;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {
  Optional<Cargo> findTopByOrderByIdDesc();
}
