import java.util.Scanner;

public class Cuboid {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("a = ");
    int a = input.nextInt();
    System.out.println("b = ");
    int b = input.nextInt();
    System.out.println("c = ");
    int c = input.nextInt();
    System.out.println(a + " , " + b + " , " + c);

    int surfaceArea = (2 * a * b) + (2 * b * c) + (2 * a * c);
    int volume = a * b * c;

    System.out.println("Surface area: " + surfaceArea);
    System.out.println("Volume: " + volume);
  }
}
