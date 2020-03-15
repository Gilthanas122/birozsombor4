import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZero {
  public static void main(String[] args) {
    // Create a function that takes a number
    // divides ten with it,
    // and prints the result.
    // It should print "fail" if the parameter is 0
    divideByZero();
  }

  public static void divideByZero() {
    Scanner input = new Scanner(System.in);
    System.out.print("Give me a number: ");
    try {
      int userInput = input.nextInt();
      System.out.println(10 / userInput);
    } catch (ArithmeticException e) {
      System.out.println("fail");
    }
  }
}