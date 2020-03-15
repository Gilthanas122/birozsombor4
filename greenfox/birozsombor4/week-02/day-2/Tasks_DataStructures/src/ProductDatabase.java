import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
  public static void main(String[] args) {
    HashMap<String, Integer> database = new HashMap<>();
    database.put("Eggs", 200);
    database.put("Milk", 200);
    database.put("Fish", 400);
    database.put("Apples", 150);
    database.put("Bread", 50);
    database.put("Chicken", 550);

    System.out.println("How much is the fish?");
    System.out.println(database.get("Fish"));

    System.out.println("What is the most expensive product?");
    System.out.println(getTheGreatestValue(database));

    System.out.println("What is the average price?");
    System.out.println(sumAll(database) / database.size());

    System.out.println("How many products' price is below 300?");
    System.out.println(howManyProductsBelow(database, 300));

    System.out.println("Is there anything we can buy for exactly 125?");
    System.out.println(isThereAnyProductFor(database, 125));

    System.out.println("What is the cheapest product?");
    System.out.println(getTheCheapestProduct(database));


  }

  public static int sumAll(HashMap<String, Integer> inputMap) {
    int sum = 0;
    for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
      sum += entry.getValue();
    }
    return sum;
  }

  public static int getTheGreatestValue(HashMap<String, Integer> inputMap) {
    ArrayList<Integer> prizes = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
      prizes.add(entry.getValue());
    }
    Collections.sort(prizes);
    return prizes.get(prizes.size() - 1);
  }

  public static int howManyProductsBelow(HashMap<String, Integer> inputMap, int limit) {
    int numberOfProducts = 0;
    for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
      if (entry.getValue() < limit) {
        numberOfProducts++;
      }
    }
    return numberOfProducts;
  }

  public static boolean isThereAnyProductFor(HashMap<String, Integer> inputMap, int value) {
    for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
      if (entry.getValue() == value) {
        return true;
      }
    }
    return false;
  }

  public static String getTheCheapestProduct(HashMap<String, Integer> inputMap) {
    ArrayList<Integer> prizes = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
      prizes.add(entry.getValue());
    }
    Collections.sort(prizes);
    String cheapestProduct = "";
    for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
      if (entry.getValue() == prizes.get(0)) {
        cheapestProduct = entry.getKey();
      }
    }
    return cheapestProduct;
  }
}
