import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args) {
        // Write a program that asks for two numbers and prints the bigger one
        Scanner input = new Scanner(System.in);
        System.out.println("Give me an integer: ");
        int a = input.nextInt();
        System.out.println("Give me one more integer: ");
        int b = input.nextInt();

        if (a > b) {
            System.out.println(a + " > " + b);
        } else if (a < b) {
            System.out.println(a + " < " + b);
        } else {
            System.out.println(a + " = " + b);
        }
    }
}
