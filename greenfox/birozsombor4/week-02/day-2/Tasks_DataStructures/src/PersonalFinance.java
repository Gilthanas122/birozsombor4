import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PersonalFinance {
    public static void main(String[] args) {
        ArrayList<Integer> ourExpenses = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));

        System.out.println("How much did we spend? ");
        System.out.println(sumAll(ourExpenses));

        System.out.println("Which was our greatest expense?");
        System.out.println(getGreatestValue(ourExpenses));

        System.out.println("Which was our cheapest spending?");
        System.out.println(getSmallestValue(ourExpenses));

        System.out.println("What was the average amount of our spendings?");
        System.out.println(getAverage(ourExpenses));


    }
    public static int sumAll(ArrayList<Integer> inputList){
        int sum = 0;
        for(int i : inputList){
            sum+=i;
        }
        return sum;
    }
    public static int getGreatestValue(ArrayList<Integer> inputList){
        ArrayList<Integer> holder = new ArrayList<>(inputList);
        Collections.sort(holder);
        return holder.get(holder.size()-1);
    }
    public static int getSmallestValue(ArrayList<Integer> inputList){
        ArrayList<Integer> holder = new ArrayList<>(inputList);
        Collections.sort(holder);
        return holder.get(0);
    }
    public static int getAverage(ArrayList<Integer> inputList){
        int sum = 0;
        for(int i : inputList){
            sum+=i;
        }
        int average = sum/inputList.size();
        return average;
    }
}
