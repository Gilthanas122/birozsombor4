package gardenapp;

public class Main {
  public static void main(String[] args) {
    Garden garden = new Garden();

    garden.addPlants(new Flower("yellow", 0));
    garden.addPlants(new Flower("blue", 0));
    garden.addPlants(new Tree("purple", 0));
    garden.addPlants(new Tree("orange", 0));

    garden.info();
    System.out.println("");
    garden.irrigate(40);
    garden.info();
    System.out.println("");
    garden.irrigate(70);
    garden.info();
  }
}
