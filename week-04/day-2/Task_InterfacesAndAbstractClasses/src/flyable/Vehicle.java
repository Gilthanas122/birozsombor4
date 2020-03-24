package flyable;

abstract public class Vehicle {
  protected String name;
  protected int price;
  protected boolean isItForMilitary;

  public Vehicle() {
  }

  public Vehicle(String name, int price, boolean isItForMilitary) {
    this.name = name;
    this.price = price;
    this.isItForMilitary = isItForMilitary;
  }
}
