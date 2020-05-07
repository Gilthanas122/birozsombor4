package com.greenfoxacademy.restoptionals.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Yondu {

  private Float distance;
  private Float time;
  private Float speed;

  public Yondu(Float distance, Float time) {
    this.distance = distance;
    this.time = time;
    this.speed = distance / time;
  }
}
