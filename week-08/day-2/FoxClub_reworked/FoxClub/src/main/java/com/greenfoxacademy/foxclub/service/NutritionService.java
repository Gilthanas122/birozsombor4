package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Drink;
import com.greenfoxacademy.foxclub.model.Food;
import com.greenfoxacademy.foxclub.model.Fox;
import com.greenfoxacademy.foxclub.repository.DrinkRepository;
import com.greenfoxacademy.foxclub.repository.FoodRepository;
import com.greenfoxacademy.foxclub.repository.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutritionService {

  private FoodRepository foodRepository;
  private DrinkRepository drinkRepository;
  private FoxRepository foxRepository;

  @Autowired
  public NutritionService(FoodRepository foodRepository, DrinkRepository drinkRepository, FoxRepository foxRepository) {
    this.foodRepository = foodRepository;
    this.drinkRepository = drinkRepository;
    this.foxRepository = foxRepository;
  }

  public Iterable<Food> getListOfFoods() {
    return foodRepository.findAll();
  }

  public Iterable<Drink> getListOfDrinks() {
    return drinkRepository.findAll();
  }

  public Food getSelectedFood(String name) {
    return foodRepository.findByNameContainingIgnoreCase(name);
  }

  public Drink getSelectedDrink(String name) {
    return drinkRepository.findByNameContainingIgnoreCase(name);
  }


  public long getLastSelectedFoodIndex(Long foxId) {
    Fox selectedFox = foxRepository.findById(foxId).get();
    return selectedFox.getFood().getId();
  }

  public long getLastSelectedDrinkIndex(Long foxId) {
    Fox selectedFox = foxRepository.findById(foxId).get();
    return selectedFox.getDrink().getId();
  }
}
