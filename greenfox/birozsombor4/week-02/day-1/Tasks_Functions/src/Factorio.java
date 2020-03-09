import java.util.Scanner;

public class Factorio {
    public static void main(String[] args) {
        //  Create the usual class wrapper
        //  and main method on your own.
        // - Create a function called `factorio`
        //   that returns it's input's factorial
        Scanner input = new Scanner(System.in);
        System.out.print("Your number: ");
        int userInput = input.nextInt();
        System.out.println("The factorial of this (" + userInput + ") number is: " + factorio(userInput));
    }
    public static int factorio(int input) {
        if (input == 0) {
            return 0;
        }
        int sum = 1;
        for (int i = input; i > 0; i--) {
            sum *= i;
        }
        return sum;
    }
}
