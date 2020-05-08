package com.greenfoxacademy.restoptionals.service;


import com.greenfoxacademy.restoptionals.model.CalorieTable;
import com.greenfoxacademy.restoptionals.model.Food;
import com.greenfoxacademy.restoptionals.repository.DraxRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DraxServiceImpl implements DraxService {

  private DraxRepository draxRepository;

  @Autowired
  public DraxServiceImpl(DraxRepository draxRepository) {
    this.draxRepository = draxRepository;
  }

  @Override
  public CalorieTable createAndGetCalorieTable() {
    List<Food> foods = new ArrayList<>();
    draxRepository.findAll().forEach(foods::add);
    CalorieTable calorieTable = new CalorieTable(foods);
    return calorieTable;
  }

  @Override
  public void addNewFoodToCalorieTable(Food food) {
    draxRepository.save(food);
  }

  @Override
  public void deleteFoodById(Long id) {
    draxRepository.deleteById(id);
  }

  @Override
  public void updateFoodInCalorieTable(Food food, Long id) {
    food.setId(id);
    draxRepository.save(food);
  }
}
