import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        // Create the usual class wrapper and main method on your own.
        // Write a function called `sum` that returns the sum of numbers from zero to the given parameter
        Scanner input = new Scanner(System.in);
        System.out.println("Given number: ");
        int givenNumber = input.nextInt();
        System.out.println("The sum of the numbers from zero to " + givenNumber + " is: " + sum(givenNumber));
    }
    public static int sum(int max){
        int sum = 0;
        for (int i = 0; i < max; i++) {
            sum += i;
        }
        return sum;
    }
}
