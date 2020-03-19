package fibonacci;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {
  public int getFibonacciByIndex(int inputIndex) {
    if (inputIndex < 0) {
      return -1;
    }
    int searcherNumber = 0;
    ArrayList<Integer> fibonacciList = new ArrayList<>(Arrays.asList(0, 1));
    for (int i = 1; i <= inputIndex; i++) {
      fibonacciList.add(fibonacciList.get(i) + fibonacciList.get(i - 1));
    }
    return fibonacciList.get(inputIndex);
  }
}
