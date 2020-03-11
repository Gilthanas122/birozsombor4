import java.util.ArrayList;

public class Candyshop {
  public static void main(String... args) {
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("Cupcake");
    arrayList.add(2);
    arrayList.add("Brownie");
    arrayList.add(false);

    // Accidentally we added "2" and "false" to the list.
    // Your task is to change from "2" to "Croissant" and change from "false" to "Ice cream"
    // No, don't just remove the lines
    // Create a method called sweets() which takes the list as a parameter.

    System.out.println(sweets(arrayList));
    // Expected output: "Cupcake", "Croissant", "Brownie", "Ice cream"
  }

  public static ArrayList<Object> sweets(ArrayList<Object> input) {
    for (Object object : input) {
      if (object.equals(2)) {
        input.set(input.indexOf(object), "Croissant");
      } else if (object.equals(false)) {
        input.set(input.indexOf(object), "Ice cream");
      }
    }
    return input;
  }
}
