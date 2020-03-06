import java.util.Scanner;

public class DrawDiagonal {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // square like this:
        //
        //
        // %%%%%
        // %%  %
        // % % %
        // %  %%
        // %%%%%
        //
        // The square should have as many lines as the number was
        Scanner input = new Scanner(System.in);
        System.out.println("Give me a number: ");
        int numberOfLines = input.nextInt();

        int spaceBefore = 0;
        int spaceAfter = numberOfLines-3-spaceBefore; //-3 --> -2-1


        for (int i = 0; i < numberOfLines ; i++) {
            if (i == 0 || i == (numberOfLines-1)){
                for (int j = 0; j < numberOfLines ; j++) {
                    System.out.print("%");
                }
            }else{
                System.out.print("%");
                for (int k = 0; k < spaceBefore; k++) {
                    System.out.print(" ");
                }
                System.out.print("%");
                for (int l = 0; l < spaceAfter; l++) {
                    System.out.print(" ");
                }
                System.out.print("%");
                spaceBefore++;
                spaceAfter--;
            }
            System.out.println("");
        }

    }
}
