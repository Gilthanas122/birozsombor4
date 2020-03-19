package extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by aze on 2017.04.04..
 */
public class Extension {
  int add(int a, int b) {
    return a + b;
  }

  int maxOfThree(int a, int b, int c) {
    if (a > b && a > c) {
      return a;
    } else if (b > a && b > c) {
      return b;
    } else {
      return c;
    }
  }

  float median(List<Integer> pool) {
    float median = 0;
    Collections.sort(pool);
    if (pool.size() % 2 != 0) {
      int index = pool.size() / 2;
      System.out.println(index);
      median = pool.get(index);
    } else {
      int index = pool.size() / 2 - 1;
      median = ((pool.get(index) + pool.get(index + 1)) / 2);
    }
    return median;
  }

  boolean isVowel(char c) {
    return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c);
  }

  String translate(String hungarian) {
    String teveReturn = "";
    ArrayList<Character> teve = new ArrayList<Character>();
    char[] arrayHolder = hungarian.toCharArray();
    for (char c : arrayHolder) {
      teve.add(c);
    }
    int length = teve.size();
    for (int i = 0; i < length; i++) {
      char c = teve.get(i);
      if (isVowel(c)) {
        teve.add(i, 'v');
        teve.add(i, c);
        i += 2;
        length += 2;
      }
    }
    for (char c : teve) {
      teveReturn += c;
    }
    return teveReturn;
  }
}

// Check out the folder. There's a work file and a test file.

//  -  Run the tests, all 10 should be green (passing).
//  -  The implementations though are not quite good.
//  -  Create tests that'll fail, and will show how the implementations are wrong(You can assume that the implementation of join and split are good)
//  -  After creating the tests, fix the implementations
//  -  Check again, if you can create failing tests
//  -  Implement if needed