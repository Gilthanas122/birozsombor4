import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommaSeparated {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(3, 44);
    System.out.println(getString(numbers));
  }

  public static String getString(List<Integer> list) {
    return list.stream()
        .map(i -> i % 2 != 0 ? new String("o" + i) : new String("e" + i))
        .collect(Collectors.joining(","));
  }
}