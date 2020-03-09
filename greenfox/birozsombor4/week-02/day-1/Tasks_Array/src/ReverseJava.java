import java.util.Arrays;
import java.util.Collections;

public class ReverseJava {
    public static void main(String[] args) {
        // - Create an array variable named `numbers`
        //   with the following content: `[3, 4, 5, 6, 7]`
        // - Reverse the order of the elements in `numbers`
        // - Print the elements of the reversed `numbers`
        int [] numbers = {3, 4, 5, 6, 7};
        int [] reverseNumbers = numbers.clone();
        int j = 0;
        for (int i = numbers.length-1; i > -1; i--) {
            reverseNumbers[j] = numbers[i];
            j++;
        }
        System.out.println("Before reverse: " + Arrays.toString(numbers));
        System.out.println("After reversing: " + Arrays.toString(reverseNumbers));

    }
}
