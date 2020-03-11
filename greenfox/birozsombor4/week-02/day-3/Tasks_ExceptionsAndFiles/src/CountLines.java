import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountLines {
  public static void main(String[] args) {
    // Write a function that takes a filename as string,
    // then returns the number of lines the file contains.
    // It should return zero if it can't open the file, and
    // should not raise any error.

    //my-file.txt's absolute path: "D:/GreenFox/greenfox-repo/greenfox/birozsombor4/week-02/day-3/Tasks_ExceptionsAndFiles/src/my-file.txt"
    //my-file.txt's relative path: "src/my-file.txt"

    Scanner input = new Scanner(System.in);
    System.out.println("Give me a path: ");
    String userInput = input.nextLine();
    System.out.println(howManyLinesHasTheFile(userInput));
  }

  public static int howManyLinesHasTheFile(String input) {
    int numberOfLines = 0;
    Path path = Paths.get(input);
    if (Files.isReadable(path)) {
      try {
        numberOfLines = Files.readAllLines(path).size();
        return numberOfLines;
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      return 0;
    }
    return 0;
  }
}
