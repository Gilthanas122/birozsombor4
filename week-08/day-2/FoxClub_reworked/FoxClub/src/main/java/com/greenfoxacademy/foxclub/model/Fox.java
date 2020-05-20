package com.greenfoxacademy.foxclub.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Fox {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private User user;

  private String name;

  /*@ManyToMany
  @JoinTable(name = "foxes_tricks",
      joinColumns = @JoinColumn(name = "trick_id"),
      inverseJoinColumns = @JoinColumn(name = "fox_id"))
  private Set<Trick> tricks;*/

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private Food food;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private Drink drink;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "fox")
  private List<Action> actionHistory;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "fox_trick",
      joinColumns = @JoinColumn(name = "fox_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "trick_id")
  )
  private List<Trick> tricks;

  public Fox() {
    this.actionHistory = new ArrayList<>();
  }

  public Fox(String name) {
    this();
    this.name = name;
  }

  public Fox(String name, Food food, Drink drink) {
    this();
    this.name = name;
    this.food = food;
    this.drink = drink;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Trick> getTricks() {
    return tricks;
  }

  public void setTricks(List<Trick> tricks) {
    this.tricks = tricks;
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  /*public Set<Trick> getTricks() {
    return tricks;
  }

  public void setTricks(Set<Trick> tricks) {
    this.tricks = tricks;
  }*/

  public List<Action> getActionHistory() {
    return actionHistory;
  }

  public void setActionHistory(List<Action> actionHistory) {
    this.actionHistory = actionHistory;
  }

  /*public void addNewTrick(Trick newTrick) {
    this.listOfTricks.add(newTrick);
  }

  public String getListAsString() {
    return this.listOfTricks.stream()
        .map(Trick::getName)
        .collect(Collectors.joining(", "));
  }*/
}
