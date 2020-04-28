package com.greenfoxacademy.foxclub.repository;

import com.greenfoxacademy.foxclub.model.Fox;
import org.springframework.data.repository.CrudRepository;

public interface FoxRepository extends CrudRepository<Fox, Long> {
}
