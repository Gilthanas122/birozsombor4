package sum;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class SumTest {

  @Test
  public void getSum_WithPositiveValues_ReturnsValid() {
    Sum sum = new Sum();
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 10));
    int sumResult = sum.getSum(numbers);
    assertEquals(20, sumResult);
  }

  @Test
  public void getSum_WithEmptyList_ReturnsZero() {
    Sum sum = new Sum();
    ArrayList<Integer> numbers = new ArrayList<>();
    int sumResult = sum.getSum(numbers);
    assertEquals(0, sumResult);
  }

  @Test
  public void getSum_WithOneElement_ReturnsThatElement() {
    Sum sum = new Sum();
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5));
    int sumResult = sum.getSum(numbers);
    assertEquals(5, sumResult);
  }

  @Test
  public void getSum_WithMixedValues_ReturnsValid() {
    Sum sum = new Sum();
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(-1, 1, -1, 1, 2));
    int sumResult = sum.getSum(numbers);
    assertEquals(2, sumResult);
  }

  @Test
  public void getSum_WithNull_ReturnsValid() {
    Sum sum = new Sum();
    ArrayList<Integer> numbers = null;
    int sumResult = sum.getSum(numbers);
    assertEquals(0, sumResult);
  }


}