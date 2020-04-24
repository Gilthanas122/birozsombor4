package com.greenfoxacademy.foxclub.model;

import java.util.ArrayList;
import java.util.List;

public class Fox {
  private String name;
  private List<String> listOfTricks = new ArrayList<>();
  private Food food;
  private Drink drink;

  public Fox() {
  }

  public Fox(String name, Food food, Drink drink) {
    this.name = name;
    this.food = food;
    this.drink = drink;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getListOfTricks() {
    return listOfTricks;
  }

  public void setListOfTricks(List<String> listOfTricks) {
    this.listOfTricks = listOfTricks;
  }

  public Food getFood() {
    return food;
  }

  public void setFood(Food food) {
    this.food = food;
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(Drink drink) {
    this.drink = drink;
  }
}
