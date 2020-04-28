package com.greenfoxacademy.foxclub.repository;

import com.greenfoxacademy.foxclub.model.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {

  Food findByNameContainingIgnoreCase(String name);
}
