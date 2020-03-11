import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFile {
  public static void main(String[] args) {
    // Write a function that copies the contents of a file into another
    // It should take the filenames as parameters
    // It should return a boolean that shows if the copy was successful
    Scanner input = new Scanner(System.in);
    System.out.println("Path from: ");
    String userPathFrom = input.nextLine();
    System.out.println("Path to: ");
    String userPathTo = input.nextLine();
    System.out.println(copyAFile(userPathFrom, userPathTo));
  }
  public static boolean copyAFile (String inputPathFrom, String inputPathTo){
    Path pathFrom = Paths.get(inputPathFrom);
    Path pathTo = Paths.get(inputPathTo);
    try{
      List<String> content = Files.readAllLines(pathFrom);
      Files.write(pathTo, content);
      return true;
    }catch (IOException e){
      return false;
    }
  }
}
