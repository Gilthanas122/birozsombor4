package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Action;
import com.greenfoxacademy.foxclub.model.Drink;
import com.greenfoxacademy.foxclub.model.Food;
import com.greenfoxacademy.foxclub.model.Fox;
import com.greenfoxacademy.foxclub.model.Trick;
import com.greenfoxacademy.foxclub.model.User;
import com.greenfoxacademy.foxclub.repository.FoxRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxService {

  private FoxRepository foxRepository;
  private NutritionService nutritionService;
  private UserService userService;
  private TrickService trickService;

  @Autowired
  public FoxService(FoxRepository foxRepository, NutritionService nutritionService, UserService userService, TrickService trickService) {
    this.foxRepository = foxRepository;
    this.nutritionService = nutritionService;
    this.userService = userService;
    this.trickService = trickService;
  }

  public Iterable<Fox> getListOfFoxes() {
    return foxRepository.findAll();
  }

  public void createNewFoxWithNameAndAddToTheDatabase(String name) {
    Drink drink = nutritionService.getSelectedDrink("water");
    Food food = nutritionService.getSelectedFood("bread");
    User user = userService.getUserByUsername(name);
    Fox newFox = new Fox(name);
    newFox.setUser(user);
    newFox.setDrink(drink);
    newFox.setFood(food);
    newFox.setActionHistory(Arrays.asList(new Action(name + "is alive.")));
    foxRepository.save(newFox);
  }

  public void updateFoxFood(Long foxId, String selectedFood) {
    Fox fox = getFoxById(foxId);
    Food food = nutritionService.getSelectedFood(selectedFood);
    fox.setFood(food);
    foxRepository.save(fox);
  }

  public void updateFoxDrink(Long foxId, String selectedDrink) {
    Fox fox = getFoxById(foxId);
    Drink drink = nutritionService.getSelectedDrink(selectedDrink);
    fox.setDrink(drink);
    foxRepository.save(fox);
  }

  public void updateFoxTricks(Long foxId, String selectedTrick) {
    Fox fox = getFoxById(foxId);
    Trick trick = trickService.getTrickByName(selectedTrick);
    List<Trick> learnedTricks = fox.getTricks();
    learnedTricks.add(trick);
    fox.setTricks(learnedTricks);
    foxRepository.save(fox);
  }

  public Fox getFoxById(Long foxId) {
    return foxRepository.findById(foxId).orElse(null);
  }
}
