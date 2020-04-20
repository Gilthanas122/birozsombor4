import java.util.List;
import java.util.stream.Collectors;

public class ConvertToUppercase {
  public List<String> upperCase(List<String> list) {
    return list.stream()
        .map(String::toUpperCase)
        .collect(Collectors.toList());
  }
}
