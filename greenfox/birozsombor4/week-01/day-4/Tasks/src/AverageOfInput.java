import java.util.Scanner;

public class AverageOfInput {
  public static void main(String[] args) {
    // Write a program that asks for 5 integers in a row,
    // then it should print the sum and the average of these numbers like:
    //
    // Sum: 22, Average: 4.4
    Scanner input = new Scanner(System.in);
    System.out.println("Give me 5 integers to get to know their sum and average!");
    int a = input.nextInt();
    int b = input.nextInt();
    int c = input.nextInt();
    int d = input.nextInt();
    int e = input.nextInt();

    int sum = a + b + c + d + e;
    double average = (double) sum / 5;

    System.out.println("Sum: " + sum + "Average: " + average);

  }
}
