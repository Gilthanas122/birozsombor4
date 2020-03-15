import java.util.Arrays;

public class ChangeElement {
  public static void main(String[] args) {
    // - Create an array variable named `numbers`
    //   with the following content: `[1, 2, 3, 8, 5, 6]`
    // - Change the 8 to 4
    // - Print the fourth element
    int[] numbers = {1, 2, 3, 8, 5, 6};
    for (int i = 0; i < numbers.length; i++) {
      if (i == 3) {
        numbers[i] = 4;
      }
    }
    System.out.println("The fourth element is: " + numbers[3]);

  }
}
