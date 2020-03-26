package flyable;

import zoo.Animal;

public class Bird implements Flyable {


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


}
