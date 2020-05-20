package com.greenfoxacademy.foxclub.repository;

import com.greenfoxacademy.foxclub.model.Trick;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TrickRepository extends CrudRepository<Trick, Long> {

  Trick findByNameContainingIgnoreCase(String name);

  List<Trick> findAll();
}