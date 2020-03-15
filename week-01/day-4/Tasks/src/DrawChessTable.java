import java.util.Scanner;

public class DrawChessTable {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("How many lines do you want? ");
    int howManyLines = input.nextInt();

    for (int i = 1; i <= howManyLines; i++) {
      if (i % 2 == 0) {
        System.out.print(" ");
      }
      System.out.print("% % % %");
      System.out.println("");
    }
  }
}
