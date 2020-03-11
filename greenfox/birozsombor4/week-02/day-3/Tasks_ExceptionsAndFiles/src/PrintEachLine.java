import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class PrintEachLine {
  public static void main(String[] args) {
    // Write a program that opens a file called "my-file.txt", then prints
    // each line from the file.
    // If the program is unable to read the file (for example it does not exist),
    // then it should print the following error message: "Unable to read file: my-file.txt"
    Path path = Paths.get("src/my-file.txt");
    Path path2 = Paths.get("src/my-file.txasdqwdq");
    readAFile(path);
    readAFile(path2);
  }

  public static void readAFile(Path path) {
    try {
      List<String> lines = Files.readAllLines(path);
      lines.stream().forEach(line -> System.out.println(line));
    } catch (NoSuchFileException e) {
      System.out.println("The file doesn't exists.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}