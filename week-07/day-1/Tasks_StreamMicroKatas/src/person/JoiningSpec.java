package person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningSpec {
  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(
        new Person("Sara", 4),
        new Person("Viktor", 40),
        new Person("Eva", 42)
    );
    String names = "Names: " + persons.stream()
        .map(Person::getName)
        .collect(Collectors.joining(", "));
    System.out.println(names);
  }
}
