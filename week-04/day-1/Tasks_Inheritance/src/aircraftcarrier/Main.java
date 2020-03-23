package aircraftcarrier;

public class Main {
  public static void main(String[] args) {
    AircraftCarrier aircraftCarrier1 = new AircraftCarrier(45, 5000);
    aircraftCarrier1.add(new F35());
    aircraftCarrier1.add(new F35());
    aircraftCarrier1.add(new F35());
    aircraftCarrier1.add(new F16());
    aircraftCarrier1.add(new F16());

    AircraftCarrier aircraftCarrier2 = new AircraftCarrier(2300, 2500);
    aircraftCarrier2.add(new F35());
    aircraftCarrier2.add(new F35());
    aircraftCarrier2.add(new F35());
    aircraftCarrier2.add(new F16());
    aircraftCarrier2.add(new F16());

    System.out.println(aircraftCarrier1.getStatus());
    aircraftCarrier1.fill();
    System.out.println(aircraftCarrier1.getStatus());
    System.out.println("-------------------------------");

    aircraftCarrier1.fight(aircraftCarrier2);
    System.out.println(aircraftCarrier2.getStatus());
    aircraftCarrier1.fight(aircraftCarrier2);
    System.out.println(aircraftCarrier2.getStatus());
  }
}
