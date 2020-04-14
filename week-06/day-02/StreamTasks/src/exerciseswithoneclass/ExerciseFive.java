package exerciseswithoneclass;

import java.util.Arrays;
import java.util.List;

public class ExerciseFive {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
    int sum = numbers.stream()
        .filter(i -> i % 2 != 0)
        .reduce(0, (carry, i) -> carry + i);
    int sum2 = numbers.stream()
        .filter(i -> i % 2 != 0)
        .mapToInt(Integer::intValue)
        .sum();
    System.out.println(sum);
    System.out.println(sum2);
  }
}
