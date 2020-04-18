package excerciseeleven;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
  public static void main(String[] args) {
    getFirstTenCommonWord("files/wiki_kennedy.txt")
        .forEach((k, v) -> System.out.println(k + " : " + v));
  }

  public static Map<String, Long> getFirstTenCommonWord(String fileName) {
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(Paths.get(fileName));
    } catch (NoSuchFileException e) {
      System.out.println("File doesn't exists");
      System.exit(-1);
    } catch (IOException e) {
      System.out.println("Something went wrong with reading");
      System.exit(-1);
    }
    Map<String, Long> firstHoundredCommonWordWithFrequencies =
        lines.stream()
            .flatMap(line -> Arrays.stream(line.split(" ")))
            .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
            .filter(word -> word.length() > 0)
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .limit(100)
            .collect(Collectors.toMap(
                word -> word.getKey(),
                word -> word.getValue(),
                (k, v) -> {
                  throw new IllegalStateException(String.format("Duplicate key %s", k));
                },
                LinkedHashMap::new
            ));
    return firstHoundredCommonWordWithFrequencies;
  }
}
