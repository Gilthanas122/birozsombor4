package flyable;

public class Helicopter extends Vehicle implements Flyable {
  @Override
  public void land() {
    System.out.println("Helicopter has landed.");
  }

  @Override
  public void fly() {
    System.out.println("Helicopter is flying.");
  }

  @Override
  public void takeOff() {
    System.out.println("Helicopter take off.");
  }
}
