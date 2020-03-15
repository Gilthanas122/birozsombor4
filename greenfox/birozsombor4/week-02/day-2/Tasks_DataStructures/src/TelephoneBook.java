import java.util.HashMap;
import java.util.Map;

public class TelephoneBook {
  public static void main(String[] args) {
    HashMap<String, String> telephoneBook = new HashMap<>();
    telephoneBook.put("William A. Lathan", "405-709-1865");
    telephoneBook.put("John K. Miller", "402-247-8568");
    telephoneBook.put("Hortensia E. Foster", "606-481-6467");
    telephoneBook.put("Amanda D. Newland", "319-243-5613");
    telephoneBook.put("Brooke P. Askew", "307-687-2982");

    System.out.println("What is John K. Miller's phone number?");
    System.out.println(telephoneBook.get("John K. Miller"));

    System.out.println("Whose phone number is 307-687-2982?");
    String keySearchFor = "";
    for (Map.Entry<String, String> entry : telephoneBook.entrySet()) {
      if (entry.getValue().equals("307-687-2982")) {
        keySearchFor = entry.getKey();
      }
    }
    System.out.println(keySearchFor);

    System.out.println("Do we know Chris E. Myers' phone number?");
    System.out.println(telephoneBook.containsKey("Chris E. Myers'"));
  }
}
