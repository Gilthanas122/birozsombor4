package Anagram;

import java.util.ArrayList;

public class Anagram {
  public boolean AreTheyAnagrams(String input1, String input2) {
    if (input1.length() != input2.length()) {
      return false;
    } else {
      ArrayList<Character> input1Chars = new ArrayList<>();
      for (char c : input1.toCharArray()) {
        input1Chars.add(c);
      }
      ArrayList<Character> input2Chars = new ArrayList<>();
      for (char c : input2.toCharArray()) {
        input2Chars.add(c);
      }
      for (int i = 0; i < input1Chars.size(); i++) {
        if (input2Chars.contains(input1Chars.get(i))) {
          input2Chars.remove(input2Chars.indexOf(input1Chars.get(i)));
          input1Chars.remove(i);
          i = -1;
        }
      }
      if (input1Chars.size() == 0 && input2Chars.size() == 0) {
        return true;
      } else {
        return false;
      }
    }
  }

}
