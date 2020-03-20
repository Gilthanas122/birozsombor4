package cowsandbulls;

public class Main {
  public static void main(String[] args) {
    CowsAndBulls candb = new CowsAndBulls();
    System.out.println(candb.numberToGuess);
    System.out.println(candb.guess(1234));
    System.out.println(candb.numberToGuess);
    System.out.println(candb.guess(1235));
  }
}
