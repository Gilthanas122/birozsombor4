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
    listOfDrinks = initAllDrinks();
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
    return Arrays.asList(new Drink("wein"),
        new Drink("coke"),
        new Drink("water"),
        new Drink("beer"));
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

  public Food getSelectedFood(String name) {
    Food selectedFood = null;
    for (Food food : listOfFoods) {
      if (food.getName().toLowerCase().equals(name.toLowerCase())) {
        selectedFood = food;
        break;
      }
    }
    return selectedFood;
  }

  public Drink getSelectedDrink(String name) {
    Drink selectedDrink = null;
    for (Drink drink : listOfDrinks) {
      if (drink.getName().toLowerCase().equals(name.toLowerCase())) {
        selectedDrink = drink;
        break;
      }
    }
    return selectedDrink;
  }
}
