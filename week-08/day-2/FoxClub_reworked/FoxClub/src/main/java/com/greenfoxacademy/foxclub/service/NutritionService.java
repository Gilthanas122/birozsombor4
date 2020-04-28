package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Drink;
import com.greenfoxacademy.foxclub.model.Food;
import com.greenfoxacademy.foxclub.model.Fox;
import com.greenfoxacademy.foxclub.repository.DrinkRepository;
import com.greenfoxacademy.foxclub.repository.FoodRepository;
import org.springframework.stereotype.Service;

@Service
public class NutritionService {

  private FoodRepository foodRepository;
  private DrinkRepository drinkRepository;

  public NutritionService(FoodRepository foodRepository, DrinkRepository drinkRepository) {
    this.foodRepository = foodRepository;
    this.drinkRepository = drinkRepository;
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


  public long getLastSelectedFoodIndex(Fox selectedFoxByName) {
    return selectedFoxByName.getFood().getId();
  }

  public long getLastSelectedDrinkIndex(Fox selectedFoxByName) {
    return selectedFoxByName.getDrink().getId();
  }

  public void updateFood(Food food) {
    foodRepository.save(food);
  }

  public void update(Drink drink) {
    drinkRepository.save(drink);
  }
}
