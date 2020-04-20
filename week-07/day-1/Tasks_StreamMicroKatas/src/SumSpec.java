import java.util.Arrays;
import java.util.List;

public class SumSpec {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    int sum = numbers.stream()
        .mapToInt(x -> Integer.valueOf(x))
        .sum();
    System.out.println(sum);
  }
}
