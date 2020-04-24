package com.greenfoxacademy.foxclub.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Fox {
  private String name;
  private List<Trick> listOfTricks = new ArrayList<>();
  private Food food;
  private Drink drink;
  private LinkedHashMap<Date, Action> actionHistory = new LinkedHashMap<>();

  public Fox() {
  }

  public Fox(String name, Food food, Drink drink) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.actionHistory.put(new Date(), new Action(name + " is alive."));
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Trick> getListOfTricks() {
    return listOfTricks;
  }

  public void setListOfTricks(List<Trick> listOfTricks) {
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

  public LinkedHashMap<Date, Action> getActionHistory() {
    return actionHistory;
  }

  public void setActionHistory(LinkedHashMap<Date, Action> actionHistory) {
    this.actionHistory = actionHistory;
  }

  public void addNewTrick(Trick newTrick) {
    this.listOfTricks.add(newTrick);
  }

  public String getListAsString() {
    return this.listOfTricks.stream()
        .map(Trick::getName)
        .collect(Collectors.joining(", "));
  }
}
