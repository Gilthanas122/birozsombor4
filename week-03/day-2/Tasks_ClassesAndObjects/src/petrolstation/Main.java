package petrolstation;

public class Main {
  public static void main(String[] args) {
    Car car = new Car();
    System.out.println("Petrol station gas amount before filling: " + Station.gasAmount);
    System.out.println("Car gas amount before filling: " + car.gasAmount);
    Station.refill(car);
    System.out.println("Petrol station gas amount after filling: " + Station.gasAmount);
    System.out.println("Car gas amount after filling: " + car.gasAmount);
  }
}
