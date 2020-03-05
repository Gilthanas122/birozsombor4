import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // pyramid like this:
        //
        //
        //    *
        //   ***
        //  *****
        // *******
        //
        // The pyramid should have as many lines as the number was
        Scanner input = new Scanner(System.in);
        System.out.println("Give me a number: ");
        int a = input.nextInt();

        for (int i = 0; i < a; i++) {
            for (int j = 0; j <= i; j++){
                System.out.println();
                System.out.print("*");
            }
            System.out.println("");
        }

    }
}
