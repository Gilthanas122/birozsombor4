package com.greenfoxacademy.foxclub.repository;

import com.greenfoxacademy.foxclub.model.Fox;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface FoxRepository extends CrudRepository<Fox, Long> {

  List<Fox> findAllByNameContainingIgnoreCase(String name);

  Fox findByNameContainingIgnoreCase(String name);
}
