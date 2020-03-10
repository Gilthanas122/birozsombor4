import java.util.ArrayList;
import java.util.Arrays;

public class ListIntroduction2 {
    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<>(Arrays.asList("Apple", "Avocado", "Blueberries", "Durian", "Lychee"));
        ArrayList<String> listB = new ArrayList<>(listA);
        System.out.println(listA.contains("Durian"));
        listB.remove("Durian");
        listA.add(4, "Kiwifruit");
        listA.equals(listB);
        listA.indexOf("Avocado");
        listB.indexOf("Durian");
        listB.addAll(Arrays.asList("PassionFruit", "Pomelo"));
        System.out.println(listA.get(2));



    }
}
