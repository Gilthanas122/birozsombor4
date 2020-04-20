public class LinearSearch {
  public static void main(String[] args) {
    Integer[] numbers = {7, 1, 2, 3, 4, 5, 6, 7};
    System.out.println(getIndexOfFirstOccurence(1, numbers));
  }

  public static int getIndexOfFirstOccurence(Integer n, Integer[] list) {
    for (int i = 0; i < list.length; i++) {
      if (n == list[i]) {
        int returnValue = i;
        return returnValue;
      }
    }
    return 0;
  }
}
