import java.util.Scanner;

public class AnimalAndLegs {
  public static void main(String[] args) {
    // Write a program that asks for two integers
    // The first represents the number of chickens the farmer has
    // The second represents the number of pigs owned by the farmer
    // It should print how many legs all the animals have
    Scanner input = new Scanner(System.in);
    System.out.println("How many chickens do you have?");
    int numberOfChickens = input.nextInt();
    System.out.println("How many chickens do you have?");
    int numberOfPigs = input.nextInt();

    int legsOfChickens = numberOfChickens * 2;
    int legsOfPigs = numberOfPigs * 4;
    int legs = legsOfChickens + legsOfPigs;

    System.out.println("All the animals have " + legs + " legs.");


  }
}
