package exerciseswithoneclass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseTwo {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    List<Integer> squaresOfPositiveNumbers = numbers.stream()
        .filter(i -> i > 0)
        .map(i -> (int) Math.pow(i, 2))
        .collect(Collectors.toList());
    squaresOfPositiveNumbers.stream()
        .forEach(System.out::println);
  }
}
