package com.greenfoxacademy.restoptionals.repository;

import com.greenfoxacademy.restoptionals.model.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DraxRepository extends CrudRepository<Food, Long> {
}
