import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // diamond like this:
        //
        //
        //    *
        //   ***
        //  *****
        // *******
        //  *****
        //   ***
        //    *
        //
        // The diamond should have as many lines as the number was
        Scanner input = new Scanner(System.in);
        System.out.println("Give me a number: ");
        int numberOfLines = input.nextInt();

        int spaceCount = numberOfLines - 1;
        int starsCount = 1;

        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < spaceCount; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < starsCount; k++) {
                System.out.print("*");
            }
            spaceCount--;
            starsCount += 2;
            System.out.println("");
        }

        spaceCount+=2;
        starsCount-=4;

        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < spaceCount; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < starsCount; k++) {
                System.out.print("*");
            }
            spaceCount++;
            starsCount-=2;
            System.out.println("");
        }


    }
}
