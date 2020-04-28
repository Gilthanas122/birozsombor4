package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Action;
import com.greenfoxacademy.foxclub.model.Drink;
import com.greenfoxacademy.foxclub.model.Food;
import com.greenfoxacademy.foxclub.model.Fox;
import com.greenfoxacademy.foxclub.repository.FoxRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxService {

  private FoxRepository foxRepository;
  private NutritionService nutritionService;

  @Autowired
  public FoxService(NutritionService nutritionService, FoxRepository foxRepository) {
    this.nutritionService = nutritionService;
    this.foxRepository = foxRepository;

  }

  public Iterable<Fox> getListOfFoxes() {
    return foxRepository.findAll();
  }

  public boolean checkIsItExist(String name) {
    return (foxRepository.findAllByNameContainingIgnoreCase(name).size() > 0);
  }

  public void createNewFoxWithNameAndAddToTheDatabase(String name) {
    Drink drink = nutritionService.getSelectedDrink("water");
    Food food = nutritionService.getSelectedFood("bread");
    Fox newFox = new Fox(name);
    List<Fox> foodFoxes = food.getFoxes();
    foodFoxes.add(newFox);
    food.setFoxes(foodFoxes);
    nutritionService.updateFood(food);
    List<Fox> drinkFoxes = drink.getFoxes();
    drinkFoxes.add(newFox);
    drink.setFoxes(foodFoxes);
    nutritionService.update(drink);
    foxRepository.save(newFox);
  }

  public Fox getSelectedFoxByName(String name) {
    return foxRepository.findByNameContainingIgnoreCase(name);
  }

  public void updateFoxInDatabase(Fox fox) {
    foxRepository.save(fox);
  }

  public void updateFoxFood(Fox selectedFox, String selectedFood) {
    Fox fox = foxRepository.findByNameContainingIgnoreCase(selectedFox.getName());
    Food food = nutritionService.getSelectedFood(selectedFood);
    fox.setFood(food);
    List<Fox> listOfFoxes = food.getFoxes();
    listOfFoxes.add(fox);
    food.setFoxes(listOfFoxes);
    foxRepository.save(fox);
    nutritionService.updateFood(food);
  }

  public void updateFoxDrink(Fox selectedFox, String selectedDrink) {
    Fox fox = foxRepository.findByNameContainingIgnoreCase(selectedFox.getName());
    Drink drink = nutritionService.getSelectedDrink(selectedDrink);
    fox.setDrink(drink);
    List<Fox> listOfFoxes = drink.getFoxes();
    listOfFoxes.add(fox);
    drink.setFoxes(listOfFoxes);
    foxRepository.save(fox);
    nutritionService.update(drink);
  }
}
