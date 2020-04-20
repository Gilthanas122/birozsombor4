import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatCollection {
  public static void main(String[] args) {
    List<List<String>> collection = Arrays.asList(Arrays.asList("Viktor", "Farcic"), Arrays.asList("John", "Doe",
        "Third"));
    List<String> flattenCollection = collection.stream()
        .map(item -> item.stream())
        .flatMap(x -> x)
        .collect(Collectors.toList());
    System.out.println(flattenCollection);
  }
}
