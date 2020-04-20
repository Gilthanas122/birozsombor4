import java.util.Arrays;
import java.util.List;

public class AverageValue {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(7, 1, 2, 3, 4, 5, 6, 7);
    System.out.println(getAverage(numbers));
  }

  public static Double getAverage(List<Integer> inputList) {
    return inputList.stream()
        .mapToDouble(Double::valueOf)
        .average()
        .getAsDouble();
  }
}
