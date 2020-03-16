import java.util.ArrayList;
import java.util.List;

public class PalindromeSearcher {
  public static void main(String[] args) {
    String input1 = "dog goat dad duck doodle never";
    String input2 = "apple";
    String input3 = "racecar";
    String input4 = "";
    System.out.println(palindromeSearcher(input1));
    System.out.println(palindromeSearcher(input2));
    System.out.println(palindromeSearcher(input3));
    System.out.println(palindromeSearcher(input4));
  }

  private static List<String> palindromeSearcher(String input) {
    List<String> palindromes = new ArrayList<>();
    String holder = "";
    char[] inputToCharArray = input.toCharArray();
    for (int i = 0; i < inputToCharArray.length; i++) {
      if (i == 0) {
        continue;
      }
      if (i + 2 < inputToCharArray.length) {
        if (inputToCharArray[i] == inputToCharArray[i + 2]) {
          holder += Character.toString(inputToCharArray[i]) +
              Character.toString(inputToCharArray[i + 1]) +
              Character.toString(inputToCharArray[i + 2]);
          palindromes.add(holder);
          holder = "";
          if (inputToCharArray[i - 1] == inputToCharArray[i + 3]) {
            holder += Character.toString(inputToCharArray[i - 1]) +
                Character.toString(inputToCharArray[i]) +
                Character.toString(inputToCharArray[i + 1]) +
                Character.toString(inputToCharArray[i + 2]) +
                Character.toString(inputToCharArray[i + 3]);
            palindromes.add(holder);
            holder = "";
            if (i - 2 > -1 && i + 4 < inputToCharArray.length &&
                inputToCharArray[i - 2] == inputToCharArray[i + 4]) {
              holder += Character.toString(inputToCharArray[i - 2]) +
                  Character.toString(inputToCharArray[i - 1]) +
                  Character.toString(inputToCharArray[i]) +
                  Character.toString(inputToCharArray[i + 1]) +
                  Character.toString(inputToCharArray[i + 2]) +
                  Character.toString(inputToCharArray[i + 3]) +
                  Character.toString(inputToCharArray[i + 4]);
              palindromes.add(holder);
              holder = "";
            }
          }
        }
        if (inputToCharArray[i] == inputToCharArray[i + 1] &&
            inputToCharArray[i - 1] == inputToCharArray[i + 2]) {
          holder += Character.toString(inputToCharArray[i - 1]) +
              Character.toString(inputToCharArray[i]) +
              Character.toString(inputToCharArray[i + 1]) +
              Character.toString(inputToCharArray[i + 2]);
          palindromes.add(holder);
          holder = "";
        }
      }
    }
    return palindromes;
  }
}
