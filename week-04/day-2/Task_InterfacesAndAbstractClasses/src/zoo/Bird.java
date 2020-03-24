package zoo;

import java.awt.Color;

public class Bird extends Animal {
  protected Color colorOfFeather;
  protected boolean isItASinger;

  public Bird(String name) {
    super(name);
  }

  @Override
  public String breed() {
    return "laying eggs";
  }
}
