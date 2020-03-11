import java.util.Random;
import java.util.Scanner;

public class GuessMyNumber {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    System.out.print("Range? ");
    int range = input.nextInt();
    int randomNumber = random.nextInt(range);
    System.out.println(randomNumber);
    boolean gameHasEnded = false;
    int lives = 10;

    while (!gameHasEnded) {
      if (lives > 0) {
        System.out.print("What is your guess? ");
        int userInput = input.nextInt();
        if (userInput > randomNumber) {
          lives--;
          System.out.println("Too high! You have " + lives + " lives left.");
        } else if (userInput < randomNumber) {
          lives--;
          System.out.println("Too low! You have " + lives + " lives left.");
        } else {
          System.out.println("Congratulations! YOU WON!");
          System.out.println("Random number: " + randomNumber + ", Your number: " + userInput);
          gameHasEnded = true;
        }

      } else {
        gameHasEnded = true;
      }


    }
  }
}
