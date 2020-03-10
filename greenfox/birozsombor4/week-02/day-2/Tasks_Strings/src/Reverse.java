import java.util.Arrays;

public class Reverse {
    public static void main(String... args){
        String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

        // Create a method that can reverse a String, which is passed as the parameter
        // Use it on this reversed string to check it!
        // Try to solve this using charAt() first, and optionally anything else after.

        System.out.println(reverse(toBeReversed));
        System.out.println(reverseWithBuilder(toBeReversed));
    }
    public static String reverse (String input){
        char[]inputToCharArray = input.toCharArray();
        char[]inputReversed = new char[inputToCharArray.length];
        int indexCounter = input.length()-1;
        for (int i = 0; i < input.length(); i++) {
            inputReversed[indexCounter] = input.charAt(i);
            indexCounter--;
        }
        String reversedString = "";
        for (int i = 0; i < inputReversed.length; i++) {
            //reversedString.concat(Character.toString(inputReversed[i]));
            reversedString += inputReversed[i];
        }
        return reversedString;

    }
    public static String reverseWithBuilder(String input){
        StringBuilder builder = new StringBuilder(input);
        return builder.reverse().toString();
    }
}