import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingList {
    public static void main(String[] args) {
        ArrayList<String> shoppingList = new ArrayList<>(Arrays.asList("eggs", "milk", "fish", "apples", "bread", "chicken"));

        System.out.println("Do we have milk on the list?");
        System.out.println(shoppingList.contains("milk"));

        System.out.println("Do we have bananas on the list?");
        System.out.println(shoppingList.contains("bananas"));
    }
}
