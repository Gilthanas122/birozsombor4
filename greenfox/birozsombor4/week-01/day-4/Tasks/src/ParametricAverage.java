import java.util.Scanner;

public class ParametricAverage {
  public static void main(String[] args) {
    // Write a program that asks for a number.
    // It would ask this many times to enter an integer,
    // if all the integers are entered, it should print the sum and average of these
    // integers like:
    //
    // Sum: 22, Average: 4.4
    Scanner input = new Scanner(System.in);
    System.out.println("How many integers do you want?");
    int howManyIntegers = input.nextInt();
    int sum = 0;

    for (int i = 0; i < howManyIntegers; i++) {
      System.out.print("Type a number: ");
      int number = input.nextInt();
      sum += number;
    }
    double average = (double) sum / howManyIntegers;
    System.out.println("SUM: " + sum + " , " + "Average: " + average);
  }
}
