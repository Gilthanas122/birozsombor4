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

        int spaceCount = numberOfLines/2 - 1;
        int starsCount = 1;

        if (numberOfLines%2!=0){
            spaceCount = numberOfLines/2;
        }

        for (int i = 0; i < numberOfLines/2; i++) {
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

        if (numberOfLines%2!=0){
            for (int m = 0; m < numberOfLines; m++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        spaceCount++;
        starsCount-=2;

        for (int i = 0; i < numberOfLines/2; i++) {
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
