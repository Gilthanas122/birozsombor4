import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedOrder {
  public static void main(String[] args) throws IOException {
    // Create a method that decrypts reversed-order.txt
    Path path = Paths.get("files/reversed-order.txt");
    Path saveLocation = Paths.get("files/reversed-orderFIXED.txt");
    reverseOrder(path, saveLocation);
  }

  private static void reverseOrder(Path path, Path saveLocation) throws IOException {
    List<String> lines = Files.readAllLines(path);
    List<String> fixedLines = new ArrayList<>();
    int maxLineIndex = lines.size() - 1;
    for (int i = 0; i < lines.size(); i++) {
      fixedLines.add(lines.get(maxLineIndex));
      maxLineIndex--;
    }
    Files.write(saveLocation, fixedLines);
  }
}
