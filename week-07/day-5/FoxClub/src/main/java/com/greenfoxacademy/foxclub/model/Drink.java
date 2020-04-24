package com.greenfoxacademy.foxclub.model;

public class Drink {
  private String name;
  private boolean isSelected = false;

  public Drink(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean getIsSelected() {
    return isSelected;
  }

  public void setIsSelected(boolean selected) {
    isSelected = selected;
  }
}
