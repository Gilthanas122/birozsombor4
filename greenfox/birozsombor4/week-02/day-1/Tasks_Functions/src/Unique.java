import java.util.Arrays;

public class Unique {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as a parameter
        //  Returns a list of numbers where every number in the list occurs only once

        //  Example
        System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
        //                                  {1, 1, 11, 11, 34, 34, 52, 61}
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
        int[] returnArray = new int[counter];
        int indexCounter = 0;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if(i> 0 && i < array.length){
                if (array[i] == array[i-1]){}
                else{
                    returnArray[indexCounter] = array[i];
                    indexCounter++;
                }
            }else if (i == 0){
                returnArray[indexCounter] = array[i];
                indexCounter++;
            }else{}
        }
        return Arrays.toString(returnArray);
    }
}
