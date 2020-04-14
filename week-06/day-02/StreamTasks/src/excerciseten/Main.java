package excerciseten;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Fox> myList = initTaskList();
    //get the greenFoxes
    List<Fox> greenFoxes = myList.stream()
        .filter(fox -> fox.getColor().equals(Color.green))
        .collect(Collectors.toList());
    System.out.println(greenFoxes.toString());
    //get greenFoxes who are younger than 5
    List<Fox> youngGreenFoxes = myList.stream()
        .filter(fox -> fox.getColor().equals(Color.green) && fox.getAge() < 5)
        .collect(Collectors.toList());
    System.out.println(youngGreenFoxes);
    //get frequencyByColor
    Map<Color, Long> frequencyByColor =
        myList.stream()
            .collect(Collectors.groupingBy(fox -> fox.getColor(), Collectors.counting()));
    frequencyByColor.forEach((k, v) -> System.out.println(k + " : " + v));
  }

  public static List<Fox> initTaskList() {
    return Arrays.asList(
        new Fox("Foxy", Color.black, 3),
        new Fox("Maxy", Color.white, 3),
        new Fox("Sanyi", Color.black, 10),
        new Fox("Karak", Color.red, 40),
        new Fox("Vuk", Color.green, 6),
        new Fox("RandomVuk", Color.green, 2)
    );
  }
}
