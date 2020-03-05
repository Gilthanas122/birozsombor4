import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input,
        // Then prints "Odd" if the number is odd, or "Even" if it is even.
        Scanner input = new Scanner(System.in);
        System.out.println("Give me an integer: ");
        int a = input.nextInt();

        if (a % 2 == 0) {
            System.out.println("This number is an even number.");
        } else {
            System.out.println("This number is an odd number.");
        }

    }
}
