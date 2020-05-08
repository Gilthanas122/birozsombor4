package com.greenfoxacademy.restoptionals.service;

import com.greenfoxacademy.restoptionals.model.CalorieTable;
import com.greenfoxacademy.restoptionals.model.Food;

public interface DraxService {
  CalorieTable createAndGetCalorieTable();

  void addNewFoodToCalorieTable(Food food);

  void deleteFoodById(Long id);

  void updateFoodInCalorieTable(Food food, Long id);
}
