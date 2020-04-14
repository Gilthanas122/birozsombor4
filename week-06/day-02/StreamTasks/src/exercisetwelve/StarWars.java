package exercisetwelve;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StarWars {
  public static void main(String[] args) {
    System.out.println(nameOfTheHeaviestCharacter("files/swcharacters.csv"));
    System.out.println(averageHeightOfMales("files/swcharacters.csv"));
    System.out.println(averageHeightOfFemales("files/swcharacters.csv"));
  }

  public static List<String> getListFromFile(String fileName) {
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
    return lines;
  }

  public static String nameOfTheHeaviestCharacter(String fileName) {
    List<String> lines = getListFromFile(fileName);
    return lines.stream()
        .skip(1)
        .map(line -> new SWCharacter(line.split(";")[0], line.split(";")[1],
            line.split(";")[2], line.split(";")[3],
            line.split(";")[4], line.split(";")[5],
            line.split(";")[6], line.split(";")[7]))
        .filter(character -> !character.getMass().equals("unknown"))
        .sorted((character1, character2) -> Integer.valueOf(character2.getMass()).compareTo
            (Integer.valueOf(character1.getMass())))
        .findFirst()
        .get()
        .getName();
  }

  public static double averageHeightOfMales(String fileName) {
    List<String> lines = getListFromFile(fileName);
    return lines.stream()
        .skip(1)
        .map(line -> new SWCharacter(line.split(";")[0], line.split(";")[1],
            line.split(";")[2], line.split(";")[3],
            line.split(";")[4], line.split(";")[5],
            line.split(";")[6], line.split(";")[7]))
        .filter(character -> character.getGender().equals("male"))
        .filter(character -> !character.getHeight().equals("unknown"))
        .mapToInt(male -> Integer.valueOf(male.getHeight()))
        .average()
        .getAsDouble();
  }

  public static double averageHeightOfFemales(String fileName) {
    List<String> lines = getListFromFile(fileName);
    return lines.stream()
        .skip(1)
        .map(line -> new SWCharacter(line.split(";")[0], line.split(";")[1],
            line.split(";")[2], line.split(";")[3],
            line.split(";")[4], line.split(";")[5],
            line.split(";")[6], line.split(";")[7]))
        .filter(character -> character.getGender().equals("female"))
        .filter(character -> !character.getHeight().equals("unknown"))
        .mapToInt(male -> Integer.valueOf(male.getHeight()))
        .average()
        .getAsDouble();
  }
}
