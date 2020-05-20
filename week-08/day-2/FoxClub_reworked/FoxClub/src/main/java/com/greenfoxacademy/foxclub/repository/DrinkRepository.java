package com.greenfoxacademy.foxclub.repository;

import com.greenfoxacademy.foxclub.model.Drink;
import org.springframework.data.repository.CrudRepository;

public interface DrinkRepository extends CrudRepository<Drink, Long> {

  Drink findByNameContainingIgnoreCase(String name);
}
