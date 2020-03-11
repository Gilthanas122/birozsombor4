import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Calculator {
  public static void main(String... args) {
    // Create a simple calculator application which reads the parameters from the prompt
    // and prints the result to the prompt.
    // It should support the following operations,
    // create a method named "calculate()":
    // +, -, *, /, % and it should support two operands.
    // The format of the expressions must be: {operation} {operand} {operand}.
    // Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)

    // You can use the Scanner class
    // It should work like this:

    // Start the program
    // It prints: "Please type in the expression:"
    // Waits for the user input
    // Print the result to the prompt
    // Exit
    Scanner input = new Scanner(System.in);
    System.out.print("Please type in the expression: ");
    String userInput = input.nextLine();
    System.out.println(calculate(userInput));

  }

  public static double calculate(String input) {
    double returnValue = 0;
    ArrayList<String> userInput = new ArrayList(Arrays.asList(input.split(" ")));
    System.out.println(userInput);
    double a = Double.parseDouble(userInput.get(1));
    double b = Double.parseDouble(userInput.get(2));
    if (userInput.get(0).equals("/")) {
      returnValue = a / b;
    } else if (userInput.get(0).equals("*")) {
      returnValue = a * b;
    } else if (userInput.get(0).equals("+")) {
      returnValue = a + b;
    } else if (userInput.get(0).equals("-")) {
      returnValue = a - b;
    } else {
      System.out.println("Invalid input");
    }
    return returnValue;
  }
}
