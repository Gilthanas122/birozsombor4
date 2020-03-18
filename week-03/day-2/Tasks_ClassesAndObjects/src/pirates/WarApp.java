package pirates;

public class WarApp {
  public static void main(String[] args) {
    Armada armada1 = new Armada();
    Armada armada2 = new Armada();

    armada1.fillWithSips(50);
    armada2.fillWithSips(50);

    System.out.println("This ship has won: " + armada1.war(armada2));
  }

}
