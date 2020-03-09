import java.util.Scanner;

public class DiagonalMatrix {
    public static void main(String[] args) {
        // - Create (dynamically) a two dimensional array
        //   with the following matrix. Use a loop!
        //
        //   1 0 0 0
        //   0 1 0 0
        //   0 0 1 0
        //   0 0 0 1
        //
        // - Print this two dimensional array to the output
        Scanner input = new Scanner(System.in);
        System.out.println("Number of rows: ");
        int numberOfRows = input.nextInt();
        int numberOfColumns = 0;
        while(!(numberOfColumns >= numberOfRows)) {
            System.out.println("Number of columns: ");
            numberOfColumns = input.nextInt();
            if (numberOfColumns < numberOfRows){
                System.out.println("numberOfColumns must to be equal or greater than numberOfRows");
            }
        }
        int [][] matrix = new int[numberOfRows][numberOfColumns];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][i] = 1;
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
