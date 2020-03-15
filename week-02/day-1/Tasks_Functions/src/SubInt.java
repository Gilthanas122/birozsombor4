import java.util.ArrayList;
import java.util.Arrays;

public class SubInt {
  public static void main(String[] args) {
    //  Create a function that takes a number and an array of integers as a parameter
    //  Returns the indices of the integers in the array of which the first number is a part of
    //  Or returns an empty array if the number is not part of any of the integers in the array

    //  Example:
    System.out.println(subInt(1, new int[] {1, 11, 34, 52, 61}));
    //  should print: `[0, 1, 4]`
    System.out.println(subInt(9, new int[] {1, 11, 34, 52, 61}));
    //  should print: '[]'

  }

  public static String subInt(int searchFor, int[] array) {
    char searchForCar = Character.forDigit(searchFor, 10); //for numbers which bigger than 100, to check the first digit
    int counter = 0;
    for (int i = 0; i < array.length; i++) {
      double doubleI = array[i];
      String number = Integer.toString(array[i]); //to check the first digit
      char[] charArray = number.toCharArray(); //for first digit as well
      if ((doubleI - searchFor) % 10 == 0 || array[i] == searchFor || (charArray[0] == searchForCar)) {
        counter++;
      }
    }
    int[] returnArray = new int[counter];
    int newCounter = 0;
    for (int i = 0; i < array.length; i++) {
      double doubleI = array[i];
      String number = Integer.toString(array[i]);
      char[] charArray = number.toCharArray();
      if ((doubleI - searchFor) % 10 == 0 || array[i] == searchFor || (charArray[0] == searchForCar)) {
        returnArray[newCounter] = i;
        newCounter++;
      }
    }
    return Arrays.toString(returnArray);
  }
}
