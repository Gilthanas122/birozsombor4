package excerciseten;

import java.awt.Color;

public class Fox {
  private String name;
  private Color color;
  private int age;

  public String getName() {
    return name;
  }

  public Color getColor() {
    return color;
  }

  public int getAge() {
    return age;
  }

  public Fox(String name, Color color, int age) {
    this.name = name;
    this.color = color;
    this.age = age;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
