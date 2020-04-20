package person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningSpec {
  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(
        new Person("Sara", 4),
        new Person("Viktor", 40),
        new Person("Eva", 42)
    );

    Map<Boolean, List<Person>> result = persons.stream()
        .collect(Collectors.partitioningBy(person -> person.getAge() > 18));
    result.forEach((k, v) -> System.out.println(k + "," + v.stream().map(Person::getName).collect(Collectors.toList())));
  }
}
