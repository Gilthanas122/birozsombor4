import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToUpperCaseSpec {
  public static void main(String[] args) {
    List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
    List<String> collectionToUppercase = collection.stream()
        .map(string -> string.toUpperCase())
        .collect(Collectors.toList());
  }
}
