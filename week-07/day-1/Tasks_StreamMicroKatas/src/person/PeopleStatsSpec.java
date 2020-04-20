package person;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class PeopleStatsSpec {
  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(
        new Person("Sara", 4),
        new Person("Viktor", 40),
        new Person("Eva", 42)
    );

    IntSummaryStatistics personsStatistics = persons.stream()
        .map(x -> x.getAge())
        .mapToInt(x -> Integer.valueOf(x))
        .summaryStatistics();
    System.out.println(personsStatistics.getMax());
  }
}
