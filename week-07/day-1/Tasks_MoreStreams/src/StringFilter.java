import java.util.List;
import java.util.stream.Collectors;

public class StringFilter {
  public List<String> search(List<String> list) {
    return list.stream()
        .filter(string -> string.charAt(0) == 'a' && string.length() == 3)
        .collect(Collectors.toList());
  }
}
