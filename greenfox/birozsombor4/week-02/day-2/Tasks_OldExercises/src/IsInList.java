import java.util.ArrayList;
import java.util.Arrays;

public class IsInList {
    public static void main(String... args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));
        checkNums(list);
        // Check if list contains all of the following elements: 4,8,12,16
        // Create a method that accepts list as an input
        // it should return "true" if it contains all, otherwise "false"

    }
    public static void checkNums(ArrayList<Integer> input){
        boolean containsAll = false;
        if (input.contains(4)){
            if(input.contains(8)){
                if (input.contains(12)){
                    if (input.contains(16)){
                        containsAll = true;
                    }else{
                        containsAll = false;
                    }
                }else{
                    containsAll = false;
                }
            }else{
                containsAll = false;
            }
        }else{
            containsAll = false;
        }
        System.out.println(containsAll);
    }
}
