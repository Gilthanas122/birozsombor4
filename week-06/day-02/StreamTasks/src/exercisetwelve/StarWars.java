package exercisetwelve;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StarWars {
  public static void main(String[] args) {
    System.out.println(nameOfTheHeaviestCharacter("files/swcharacters.csv"));
    System.out.println(averageHeightOfMales("files/swcharacters.csv"));
    System.out.println(averageHeightOfFemales("files/swcharacters.csv"));
    getAgeDistributionByGender("files/swcharacters.csv")
        .forEach((k, v) -> System.out.println(k + ":" + v));
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
        .collect(Collectors.toMap(swCharacter -> swCharacter.getName(), swCharacter -> {
          String holder = swCharacter.getMass();
          if (holder.contains(",")) {
            StringBuilder stringBuilder = new StringBuilder(holder);
            holder = stringBuilder.delete(holder.indexOf(','), holder.indexOf(',') + 1).toString();
          } else if (holder.contains(".")) {
            holder = holder.replace(".", "");
          }
          if (holder.isEmpty()) {
            holder = "unknown";
          }
          return holder;
        }))
        .entrySet()
        .stream()
        .filter(entry -> !entry.getValue().equals("unknown"))
        .sorted((entry1, entry2) -> Integer.valueOf(entry2.getValue()).compareTo
            (Integer.valueOf(entry1.getValue())))
        .findFirst()
        .get()
        .getKey();
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
        .collect(Collectors.toMap(swCharacter -> swCharacter, swCharacter -> {
          String holder = swCharacter.getHeight();
          if (holder.contains(",")) {
            StringBuilder stringBuilder = new StringBuilder(holder);
            holder = stringBuilder.delete(holder.indexOf(','), holder.indexOf(',') + 1).toString();
          } else if (holder.contains(".")) {
            holder = holder.replace(".", "");
          }
          if (holder.isEmpty()) {
            holder = "unknown";
          }
          return holder;
        }))
        .entrySet()
        .stream()
        .filter(entry -> !entry.getValue().equals("unknown"))
        .mapToInt(entry -> Integer.valueOf(entry.getValue()))
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
        .collect(Collectors.toMap(swCharacter -> swCharacter, swCharacter -> {
          String holder = swCharacter.getHeight();
          if (holder.contains(",")) {
            StringBuilder stringBuilder = new StringBuilder(holder);
            holder = stringBuilder.delete(holder.indexOf(','), holder.indexOf(',') + 1).toString();
          } else if (holder.contains(".")) {
            holder = holder.replace(".", "");
          }
          if (holder.isEmpty()) {
            holder = "unknown";
          }
          return holder;
        }))
        .entrySet()
        .stream()
        .filter(entry -> !entry.getValue().equals("unknown"))
        .mapToInt(entry -> Integer.valueOf(entry.getValue()))
        .average()
        .getAsDouble();
  }

  public static Map<String, Map<String, List<SWCharacter>>> getAgeDistributionByGender(String fileName) {
    List<String> lines = getListFromFile(fileName);
    return lines.stream()
        .map(line -> new SWCharacter(line.split(";")[0], line.split(";")[1],
            line.split(";")[2], line.split(";")[3],
            line.split(";")[4], line.split(";")[5],
            line.split(";")[6], line.split(";")[7]))
        .skip(1)
        .collect(Collectors.groupingBy(character -> {
              if (!character.getGender().equals("male") && !character.getGender().equals("female")) {
                return "other";
              } else {
                return character.getGender();
              }
            },
            Collectors.groupingBy(character -> {
              if (!character.getBirthYear().equals("unknown")) {
                if (Integer.valueOf(character.getBirthYear()) < 21) {
                  return "below 21";
                } else if (Integer.valueOf(character.getBirthYear()) >= 21 && Integer.valueOf(character.getBirthYear()) < 40) {
                  return "between 21 and 40";
                } else if (Integer.valueOf(character.getBirthYear()) >= 40) {
                  return "above 40";
                }
              } else {
                return "unknown";
              }
              return null;
            })));
  }

    //BEFORE, NEED SOME CHANGES IN SWCharacter
    /*public static String nameOfTheHeaviestCharacter(String fileName) {
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
  }*/

    /*public static double averageHeightOfMales(String fileName) {
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
  }*/

    /* public static Map<String, Map<String, Integer>> getAgeDistributionByGender(String fileName) {
     List<String> lines = getListFromFile(fileName);
     lines.stream()
         .map(line -> new SWCharacter(line.split(";")[0], line.split(";")[1],
             line.split(";")[2], line.split(";")[3],
             line.split(";")[4], line.split(";")[5],
             line.split(";")[6], line.split(";")[7]))
         .skip(1)
         .collect(Collectors.groupingBy(SWCharacter::getGender,
             Collectors.groupingBy(SWCharacter::getGroup)))
         .forEach((k,v) -> System.out.println(k + ": " + v));
     return null;
   }
 }*/
}
