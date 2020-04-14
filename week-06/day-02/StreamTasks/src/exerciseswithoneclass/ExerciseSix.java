package exerciseswithoneclass;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TaskSix {
  public static void main(String[] args) {
    String example = "asdopimqw";
    String example2 = "aAdD";
    String example3 = "Majompók";

    example2.chars()
        .filter(x -> x == ((int) (Character.toString((char) x).toUpperCase()).charAt(0)))
        .forEach(x -> System.out.println((char) x));

    example2.chars()
        .map(i -> (char) i)
        .filter(c -> c == Character.toString(c).toUpperCase().charAt(0))
        .forEach(x -> System.out.println((char) x));
  }
}
