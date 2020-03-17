package petrolstation;

public class Station {
  static int gasAmount = 20000;

  public static void refill(Car car) {
    gasAmount -= car.capacity;
    car.gasAmount += car.capacity;
  }
}
