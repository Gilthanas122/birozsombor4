package com.greenfoxacademy.restoptionals.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Groot {

  private String received;
  private String translated;

  public Groot(String received) {
    this.received = received;
    this.translated = "I am Groot!";
  }
}
