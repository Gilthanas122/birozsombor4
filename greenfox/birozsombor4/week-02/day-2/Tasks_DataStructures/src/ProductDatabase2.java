import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductDatabase2 {
    public static void main(String[] args) {
        HashMap<String, Integer> database = new HashMap<>();
        database.put("Eggs", 200);
        database.put("Milk", 200);
        database.put("Fish", 400);
        database.put("Apples", 150);
        database.put("Bread", 50);
        database.put("Chicken", 550);

        System.out.println("Which products cost less than 201? (just the name)");
        System.out.println(whichProductsLessThan(database, 201));

        System.out.println("Which products cost more than 150? (name + price)");
        System.out.println(whichProductsMoreThan(database, 150));
    }
    public static ArrayList<String> whichProductsLessThan(HashMap<String, Integer> inputMap, int limit){
        ArrayList<String> products = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : inputMap.entrySet()){
            if (entry.getValue() < limit){
                products.add(entry.getKey());
            }
        }
        return products;
    }
    public static ArrayList<String> whichProductsMoreThan(HashMap<String, Integer> inputMap, int limit){
        ArrayList<String> products = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : inputMap.entrySet()){
            if (entry.getValue() > limit){
                products.add(entry.getKey() + " (" + entry.getValue() + ")");
            }
        }
        return products;
    }
}
