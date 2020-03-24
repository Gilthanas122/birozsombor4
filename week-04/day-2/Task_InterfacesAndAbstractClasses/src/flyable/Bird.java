package flyable;

import zoo.Animal;

public class Bird extends Animal implements Flyable {
  public Bird(String name) {
    super(name);
  }

  @Override
  public void land() {
    System.out.println("The bird has landed.");
  }

  @Override
  public void fly() {
    System.out.println("The bird is flying.");
  }

  @Override
  public void takeOff() {
    System.out.println("The bird take off.");
  }

  @Override
  public String breed() {
    return "laying eggs";
  }
}
