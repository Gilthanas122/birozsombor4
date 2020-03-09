import java.util.Arrays;
import java.util.Scanner;

public class PalindromeBuilder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        System.out.println(palindromeBuilder(userInput));
    }
    public static String palindromeBuilder(String input){
        char[] inputToCharArray = input.toCharArray();
        char[] reversedInput = new char[inputToCharArray.length];
        int indexCounter = 0;
        for (int i = inputToCharArray.length -1; i > -1 ; i--) {
            reversedInput[indexCounter] = inputToCharArray[i];
            indexCounter++;
        }
        for (char c : reversedInput) {
            input += c;
        }
        return input;
    }
}
