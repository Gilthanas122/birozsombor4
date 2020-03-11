import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Doubled {
  public static void main(String[] args) throws IOException {
    // Create a method that decrypts the duplicated-chars.txt
    Path path = Paths.get("src/duplicated-chars.txt");
    Path saveLocation = Paths.get("src/duplicated-charsFIXED.txt");
    removeEverySecondChar(path, saveLocation);
  }

  private static void removeEverySecondChar(Path path, Path saveLocation) throws IOException {
    List<String> originalLines = Files.readAllLines(path);
    List<String> fixedLines = new ArrayList<>();
    for (String line : originalLines) {
      List<Character> listOfCharacterOfALine = new ArrayList<>();
      List<Character> listOfCharacterOfALineFixed = new ArrayList<>();
      String holder = "";
      for (char c : line.toCharArray()) {
        listOfCharacterOfALine.add(c);
      }
      for (int i = 0; i < listOfCharacterOfALine.size(); i++) {
        if (i > 1) {
          listOfCharacterOfALine.remove(i - 1);
        }
        listOfCharacterOfALineFixed.add(listOfCharacterOfALine.get(i));
      }
      for (int i = 1; i < listOfCharacterOfALineFixed.size(); i++) {
        holder += listOfCharacterOfALineFixed.get(i);
      }
      fixedLines.add(holder);
      listOfCharacterOfALineFixed.clear();
    }
    Files.write(saveLocation, fixedLines);
  }
}
