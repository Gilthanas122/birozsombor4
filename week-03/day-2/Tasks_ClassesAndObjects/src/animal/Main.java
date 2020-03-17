package animal;

public class Main {
  public static void main(String[] args) {
    Animal giraffe = new Animal();
    System.out.println("Giraffe has: thirst: " + giraffe.thirst + "; hunger: " + giraffe.hunger);
    giraffe.drink();
    giraffe.eat();
    System.out.println("Giraffe has after drinking and eating: thirst: " + giraffe.thirst + "; " +
        "hunger: " + giraffe.hunger);
    giraffe.play();
    System.out.println("Giraffe has after playing: thirst: " + giraffe.thirst + "; hunger: " + giraffe.hunger);
  }
}
