package person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingSpec {
  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(
        new Person("Sara", 4, "Norwegian"),
        new Person("Viktor", 40, "Serbian"),
        new Person("Eva", 42, "Norwegian")
    );

    Map<String, List<Person>> personsGrouppedByNationality = persons.stream()
        .collect(Collectors.groupingBy(Person::getNationality));
    personsGrouppedByNationality.forEach((k, v) -> System.out.println(k + "," + v.stream().map(Person::getName).collect(Collectors.toList())));
  }
}
