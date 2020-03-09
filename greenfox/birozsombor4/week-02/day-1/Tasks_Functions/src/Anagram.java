import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String firstString = "god";
        String secondString = "dog";
        String thirdString = "green";
        String fourthString = "fox";

        System.out.println(isItAnagram(firstString, secondString));
        System.out.println(isItAnagram(thirdString,fourthString));

    }
    public static boolean isItAnagram(String input1, String input2){
        if (input1.length() == input2.length()){
            char[] inputOneToArray = input1.toCharArray();
            char[] inputTwoToArray = input2.toCharArray();
            Arrays.sort(inputOneToArray);
            Arrays.sort(inputTwoToArray);
            if(Arrays.equals(inputOneToArray, inputTwoToArray)) {
                return true;
            }
            return false;
        }else {
            return false;
        }
    }
    public static boolean isItPalindrom(String input1, String input2){
        char[] inputArrayOne = input1.toCharArray();
        char[] inputArrayOneReversed = new char[inputArrayOne.length];
        int indexCounter = 0;

        for (int i = inputArrayOne.length-1; i > -1; i--) {
            inputArrayOneReversed[indexCounter] = inputArrayOne[i];
            indexCounter++;
        }

        String reversedString = "";
        for (int i = 0; i < inputArrayOneReversed.length; i++) {
            reversedString+=inputArrayOneReversed[i];
        }
        if (reversedString.contentEquals(input2)){
            return true;
        }else{
            return false;
        }
    }
}
