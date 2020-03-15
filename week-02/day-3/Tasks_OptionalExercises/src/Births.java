import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Births {
  public static void main(String[] args) throws IOException {
    // Create a function that
    // - takes the name of a CSV file as a parameter,
    // - every row is in the following format: <person name>;<birthdate in YYYY-MM-DD format>;<city name>
    // - returns the year when the most births happened.
    // - if there were multiple years with the same number of births then return any one of them
    // You can find such a CSV file in this directory named births.csv
    // If you pass "births.csv" to your function, then the result should be either 2006, or 2016.
    System.out.println(yearWhenTheMostBirthsHappened("files/births.csv"));
  }

  private static int yearWhenTheMostBirthsHappened(String input) throws IOException {
    int winnerYear = 0;
    int currentlyGreatestAmount = 0;
    int actualAmount = 1;
    int previousNumber = 0;
    Path path = Paths.get(input);
    List<String> lines = Files.readAllLines(path);
    List<Integer> birthYears = new ArrayList<>();
    for (String line : lines) {
      birthYears.add(Integer.parseInt(line.substring(line.indexOf(";") + 1, line.indexOf(";") + 5)));
    }
    Collections.sort(birthYears);
    for (Integer i : birthYears) {
      if (previousNumber != i) {
        actualAmount = 1;
      }
      if (previousNumber == i) {
        actualAmount++;
      }
      previousNumber = i;
      if (actualAmount >= currentlyGreatestAmount) { //if ">= the result will be 2016, if ">" the result will be 2006
        currentlyGreatestAmount = actualAmount;
        winnerYear = i;
      }
    }
    return winnerYear;
  }
}
