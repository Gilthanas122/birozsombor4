package exerciseswithoneclass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskNine {
  public static void main(String[] args) {
    String example = "aaAbcA";
    Map<String, Long> charactersFrequency =
        Arrays.stream(example.split(""))
            .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    charactersFrequency.forEach((k, v) -> System.out.println(k + " : " + v));
  }
}
