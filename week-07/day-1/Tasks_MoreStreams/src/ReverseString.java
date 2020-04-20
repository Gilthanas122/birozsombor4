public class ReverseString {
  public static void main(String[] args) {
    String example = "Almafa";
    System.out.println(getReverseOf(example));
  }

  public static String getReverseOf(String input) {
    String reversed = "";
    for (int i = input.length() - 1; i > -1; i--) {
      reversed += input.toCharArray()[i];
    }
    return reversed;
  }
}
