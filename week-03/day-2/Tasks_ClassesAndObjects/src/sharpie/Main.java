package sharpie;

public class Main {
  public static void main(String[] args) {
    Sharpie sharpie1 = new Sharpie("Yellow", 10.23f);
    System.out.println("inkAmount before using: " + sharpie1.inkAmount);
    sharpie1.use();
    System.out.println("inkAmount after using: " + sharpie1.inkAmount);
  }
}
