package person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KidsSpec {
  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(
        new Person("Sara", 4),
        new Person("Viktor", 40),
        new Person("Eva", 42)
    );

    List<String> namesOfKids = persons.stream()
        .filter(x -> x.getAge() < 18)
        .map(x -> x.getName())
        .collect(Collectors.toList());
    System.out.println(namesOfKids);
  }
}
