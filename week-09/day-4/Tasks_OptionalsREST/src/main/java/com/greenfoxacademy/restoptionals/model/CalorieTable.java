package com.greenfoxacademy.restoptionals.model;

import java.util.List;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CalorieTable {

  private List<Food> foods;

  public CalorieTable(List<Food> foods) {
    this.foods = foods;
  }
}
