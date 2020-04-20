package person;

import java.util.Arrays;
import java.util.List;

public class OldestPerson {
  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(
        new Person("Sara", 4),
        new Person("Viktor", 40),
        new Person("Eva", 42)
    );

    Person oldestPerson = persons.stream()
        .sorted((person1, person2) -> Integer.compare(person2.getAge(), person1.getAge()))
        .findFirst()
        .get();
    System.out.println(oldestPerson.getName() + " " + oldestPerson.getAge());
  }
}
