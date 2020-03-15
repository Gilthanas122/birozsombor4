import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottery {
  public static void main(String[] args) throws IOException {
    // Create a method that find the 5 most common lottery numbers in lottery.csv
    Path path = Paths.get("files/lottery.csv");
    findTheMostCommonNumbers(path);
  }

  private static void findTheMostCommonNumbers(Path path) throws IOException {
    List<String> originalLines = Files.readAllLines(path);
    List<String> winnerNumbersWithComas = new ArrayList<>();
    List<Integer> winnerNumbers = new ArrayList<>();
    List<Integer> uniqueWinnerNumbers = new ArrayList<>();
    String[] winnerNumbersWithoutComas = new String[5];

    for (String line : originalLines) {
      winnerNumbersWithComas.add(line.substring(line.lastIndexOf("Ft") + 3));
    }
    System.out.println("Example for a line from winnerNumbersWihComas: " + winnerNumbersWithComas.get(0));

    for (String line : winnerNumbersWithComas) {
      winnerNumbersWithoutComas = line.split(";");
      for (String number : winnerNumbersWithoutComas) {
        winnerNumbers.add(Integer.parseInt(number));
      }
    }
    winnerNumbersWithComas.clear();

    System.out.println("How many winner number do we have: " + winnerNumbers.size());
    Collections.sort(winnerNumbers);
    for (int number : winnerNumbers) {
      if (!uniqueWinnerNumbers.contains(number)) {
        uniqueWinnerNumbers.add(number);
      }
    }
    System.out.println("Unique numbers: " + uniqueWinnerNumbers.size());

    HashMap<Integer, Integer> uniqeWinnerNumbersInHash = new HashMap();
    for (int uniqueNumber : uniqueWinnerNumbers) {
      uniqeWinnerNumbersInHash.put(uniqueNumber, 0);
    }

    for (Integer winnerNumber : winnerNumbers) {
      int holder = uniqeWinnerNumbersInHash.get(winnerNumber);
      holder++;
      uniqeWinnerNumbersInHash.put(winnerNumber, holder);
    }

    List<Integer> winnerKeys = new ArrayList<>();
    List<Integer> winnerAmounts = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      int amountHolder = 0;
      int keyHolder = 0;

      for (Map.Entry<Integer, Integer> numberAndAmount : uniqeWinnerNumbersInHash.entrySet()) {
        if (numberAndAmount.getValue() > amountHolder) {
          amountHolder = numberAndAmount.getValue();
        }
      }
      for (Map.Entry<Integer, Integer> numberAndAmount : uniqeWinnerNumbersInHash.entrySet()) {
        if (numberAndAmount.getValue() == amountHolder) {
          keyHolder = numberAndAmount.getKey();
        }
      }
      winnerKeys.add(keyHolder);
      winnerAmounts.add(amountHolder);
      uniqeWinnerNumbersInHash.remove(keyHolder, amountHolder);
      amountHolder = 0;
      keyHolder = 0;
    }
    System.out.println(winnerKeys);
    for (int i = 0; i < 5; i++) {
      System.out.println("Winner number: " + winnerKeys.get(i) + " (with: " + winnerAmounts.get(i) + "x)");
    }
  }
}
