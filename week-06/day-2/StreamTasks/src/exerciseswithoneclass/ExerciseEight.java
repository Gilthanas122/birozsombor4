package exerciseswithoneclass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseEight {
  public static void main(String[] args) {
    List<Character> characterList = Arrays.asList('a', 'b', 'c');
    String concatenatedCharacterList = characterList.stream()
        .map(c -> c.toString())
        .collect(Collectors.joining(""));
    System.out.println(concatenatedCharacterList);
  }
}
