import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedLines {
  public static void main(String[] args) throws IOException {
    // Create a method that decrypts reversed-lines.txt
    // Create a method that decrypts the duplicated-chars.txt
    Path path = Paths.get("files/reversed-lines.txt");
    Path saveLocation = Paths.get("files/reversed-linesFIXED.txt");
    reverseTheLines(path, saveLocation);
  }

  private static void reverseTheLines(Path path, Path saveLocation) throws IOException {
    List<String> lines = Files.readAllLines(path);
    List<String> fixedLines = new ArrayList<>();
    for(String line : lines){
      StringBuilder builder = new StringBuilder(line);
      fixedLines.add(builder.reverse().toString());
    }
    Files.write(saveLocation,fixedLines);
  }
}
