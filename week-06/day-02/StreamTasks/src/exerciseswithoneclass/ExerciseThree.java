package exerciseswithoneclass;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class ExerciseThree {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(3, 9, 2, 8, 6, 5);
    List<Integer> numbersWhichSquaredValueIsMoreThan20 = numbers.stream()
        .filter(i -> Math.pow(i, 2) > 20)
        .collect(Collectors.toList());
    numbersWhichSquaredValueIsMoreThan20.stream()
        .forEach(System.out::println);
  }
}
