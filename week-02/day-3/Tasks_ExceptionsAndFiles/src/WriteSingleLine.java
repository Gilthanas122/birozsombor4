import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class WriteSingleLine {
  public static void main(String[] args) {
    // Write a function that is able to manipulate a file
    // By writing your name into it as a single line
    // The file should be named "my-file.txt"
    // In case the program is unable to write the file,
    // It should print the following error message: "Unable to write file: my-file.txt"
    Scanner input = new Scanner(System.in);
    System.out.println("What would you like to add your file?");
    String userInput = input.nextLine();
    System.out.println("File location?");
    String userPath = input.nextLine();
    writeASingleLine(userInput, userPath);
  }

  public static void writeASingleLine(String input, String filePath) {
    Path path = Paths.get(filePath);
    try {
      List<String> lines = Files.readAllLines(path);
      lines.add(input);
      Files.write(path, lines);

    } catch (IOException e) {
      System.out.println("Unable to write file:" + filePath);
    }
  }

}
