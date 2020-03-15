import java.util.Arrays;

public class Bubble {
  public static void main(String[] args) {
    //  Create a function that takes a list of numbers as parameter
    //  Returns a list where the elements are sorted in ascending numerical order
    //  Make a second boolean parameter, if it's `true` sort that list descending

    //  Example:
    System.out.println(bubble(new int[] {34, 12, 24, 9, 5}));
    //  should print [5, 9, 12, 24, 34]
    System.out.println(advancedBubble(new int[] {34, 12, 24, 9, 5}, true));
    //  should print [34, 24, 12, 9, 5]
  }

  public static String bubble(int[] inputArray) {
    Arrays.sort(inputArray);
    return Arrays.toString(inputArray);
  }

  public static String advancedBubble(int[] inputArray, boolean reversedSort) {
    Arrays.sort(inputArray);
    if (reversedSort == true) {
      int[] reversedArray = new int[inputArray.length];
      int indexCounter = 0;
      for (int i = inputArray.length - 1; i > -1; i--) {
        reversedArray[indexCounter] = inputArray[i];
        indexCounter++;
      }
      return Arrays.toString(reversedArray);
    } else {
      return Arrays.toString(inputArray);
    }
  }
}