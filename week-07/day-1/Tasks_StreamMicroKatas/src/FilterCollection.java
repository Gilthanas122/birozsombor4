import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterCollection {
  public static void main(String[] args) {
    List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
    List<String> collectionToUppercase = collection.stream()
        .filter(string -> string.length() < 4)
        .collect(Collectors.toList());
  }
}
