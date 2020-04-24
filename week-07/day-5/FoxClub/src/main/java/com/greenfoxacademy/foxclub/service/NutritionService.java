package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Drink;
import com.greenfoxacademy.foxclub.model.Food;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NutritionService {

  private List<Food> listOfFoods;
  private List<Drink> listOfDrinks;

  public NutritionService() {
    listOfFoods = initAllFoods();
    listOfDrinks =
  }

  public List<Food> initAllFoods() {
    return Arrays.asList(new Food("hotdog"),
        new Food("pizza"),
        new Food("hamburger"),
        new Food("spaghettni"),
        new Food("salad"),
        new Food("bread"),
        new Food("another fox"),
        new Food("tás"));
  }

  public List<Drink> initAllDrinks() {
    return Arrays.asList( new Drink("wein"),
        new Drink("wein"),
        new Drink("wein"),
        new Drink("wein"),
  }

  public List<Food> getListOfFoods() {
    return listOfFoods;
  }

  public void setListOfFoods(List<Food> listOfFoods) {
    this.listOfFoods = listOfFoods;
  }

  public List<Drink> getListOfDrinks() {
    return listOfDrinks;
  }

  public void setListOfDrinks(List<Drink> listOfDrinks) {
    this.listOfDrinks = listOfDrinks;
  }
}
