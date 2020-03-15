import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;

public class MapIntroduction2 {
  public static void main(String[] args) {
    HashMap<String, String> myMap = new HashMap<>();
    myMap.put("978-1-60309-452-8", "A letter to Jo");
    myMap.put("978-1-60309-459-7", "Lupus");
    myMap.put("978-1-60309-444-3", "Red Panda and Moon Bear");
    myMap.put("978-1-60309-461-0", "The Lab");

    for (Map.Entry<String, String> entry : myMap.entrySet()) {
      System.out.println(entry.getValue() + " (ISBN: " + entry.getKey() + ")");
    }

    myMap.remove("978-1-60309-444-3");
    System.out.println("");

    String keyToRemove = "";
    for (Map.Entry<String, String> entry : myMap.entrySet()) {
      if (entry.getValue().equals("The Lab")) {
        keyToRemove = entry.getKey();
      }
    }

    myMap.remove(keyToRemove);

    myMap.put("978-1-60309-450-4", "They Called Us Enemy");
    myMap.put("978-1-60309-453-5", "Why Did We Trust Him?");

    System.out.println(myMap.containsKey("478-0-61159-424-8"));
    System.out.println(myMap.get("978-1-60309-453-5"));
  }
}
