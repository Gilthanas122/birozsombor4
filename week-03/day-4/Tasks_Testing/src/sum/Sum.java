package sum;

import java.util.ArrayList;

public class Sum {
  public int getSum(ArrayList<Integer> input) {
    if (input == null) {
      return 0;
    }
    int sum = 0;
    for (int number : input) {
      sum += number;
    }
    return sum;
  }
}
