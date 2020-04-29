package com.greenfoxacademy.foxclub.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Fox {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private User user;

  private String name;
  @Transient
  private List<Trick> listOfTricks = new ArrayList<>();
  @Transient
  private Food food;
  @Transient
  private Drink drink;
  @Transient
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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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
