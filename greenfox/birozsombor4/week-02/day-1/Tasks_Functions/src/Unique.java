import java.util.Arrays;

public class Unique {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as a parameter
        //  Returns a list of numbers where every number in the list occurs only once

        //  Example
        System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
        //  should print: `[1, 11, 34, 52, 61]`
    }
    public static String unique(int [] array) {
        int counter = array.length;
        for (int i = 0; i < array.length ; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] == array[j]){
                    counter--;
                }
            }
        }
        System.out.println(counter);
        int[] returnArray = new int[counter];
        int newCounter = 0;
        for (int i = 0; i < array.length ; i++) {
            for (int j = i+1; j < array.length; j++) {
                returnArray[newCounter] = array[i];
                newCounter++;

                if (array[j] == array[i] && array[i] != 0){
                    array[i] = 0;
                }
            }
        }


        return Arrays.toString(returnArray);
    }
}
