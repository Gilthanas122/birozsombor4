package pirates;

public class BattleApp {
  public static void main(String[] args) {
    Ship ship1 = new Ship();
    Ship ship2 = new Ship();

    System.out.println("INFOS ABOUT ship1");
    ship1.getInfo();

    System.out.println("INFOS ABOUT ship2");
    ship2.getInfo();

    System.out.println("ship1 HAS WON: " + ship1.battle(ship2));
    ship1.getInfo();
    ship2.getInfo();
  }
}
