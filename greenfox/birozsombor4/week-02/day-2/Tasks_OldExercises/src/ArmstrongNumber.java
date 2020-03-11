import java.util.Scanner;

public class ArmstrongNumber {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Number: ");
    String userInput = input.nextLine();
    System.out.println(isItArmstrongNumber(userInput));

  }

  public static String isItArmstrongNumber(String input) {
    char[] charArray = input.toCharArray();
    int inputNumber = Integer.valueOf(input);
    int sum = 0;
    int[] numbers = new int[input.length()];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(String.valueOf(charArray[i]));
    }
    for (int i = 0; i < numbers.length; i++) {
      sum += Math.pow(numbers[i], numbers.length);
    }
    if (sum == inputNumber) {
      return new String("The " + inputNumber + " is an Armstrong number.");
    } else {
      return new String("The " + inputNumber + " is NOT an Armstrong number.");
    }

  }
}
