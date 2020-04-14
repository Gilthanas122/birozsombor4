package exerciseswithoneclass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaskSeven {
  public static void main(String[] args) {
    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH",
        "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
    System.out.println(findCitiesWithThisLetter("L", cities).toString());
  }

  public static List<String> findCitiesWithThisLetter(String letter, List<String> inputList) {
    return inputList.stream()
        .filter(s -> s.startsWith(letter.toUpperCase()))
        .collect(Collectors.toList());
  }
}
