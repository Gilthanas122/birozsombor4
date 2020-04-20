public class FindMaximum {
  public static void main(String[] args) {
    int[] numbers = {7, 1, 2, 3, 4, 5, 6, 7};
    System.out.println(findMaximumValue(numbers));
  }

  public static int findMaximumValue(int[] input) {
    int max = 0;
    for (int i : input) {
      if (i >= max) {
        max = i;
      }
    }
    return max;
  }
}
