import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EncodedLines {
  public static void main(String[] args) throws IOException {
    // Create a method that decrypts encoded-lines.txt
    Path path = Paths.get("files/encoded-lines.txt");
    Path saveLocation = Paths.get("files/encoded-linesFIXED.txt");
    decoder(path, saveLocation);
  }

  private static void decoder(Path inputPath, Path saveLocation) throws IOException {
    List<String> lines = Files.readAllLines(inputPath);
    List<String> fixedLines = new ArrayList<>();
    List<Character> actualLine = new ArrayList<>();
    List<Character> fixedActualLine = new ArrayList<>();
    for (String line : lines) {
      for (char c : line.toCharArray()) {
        actualLine.add(c);
      }
      for (char c : actualLine) {
        if (c != ' ') {
          int character = Character.valueOf(c);
          character--;
          char fixedCharacter = (char) character;
          fixedActualLine.add(fixedCharacter);
        } else {
          fixedActualLine.add(c);
        }
      }
      String lineHolder = "";
      for (char c : fixedActualLine) {
        lineHolder += c;
      }
      fixedLines.add(lineHolder);
      actualLine.clear();
      fixedActualLine.clear();
    }
    Files.write(saveLocation, fixedLines);
  }
}
