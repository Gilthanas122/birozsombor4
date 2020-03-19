package fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

  @Test
  public void getFibonacciByIndex_WithPositiveNumberv1_ReturnsTheRightNumber() {
    Fibonacci fibonacci = new Fibonacci();
    int[] fibonacciNumbers = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
    int fibonacciByIndex = fibonacci.getFibonacciByIndex(5);
    assertEquals(fibonacciNumbers[5], fibonacciByIndex);
  }

  @Test
  public void getFibonacciByIndex_WithPositiveNumberv2_ReturnsTheRightNumber() {
    Fibonacci fibonacci = new Fibonacci();
    int[] fibonacciNumbers = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
    int fibonacciByIndex = fibonacci.getFibonacciByIndex(9);
    assertEquals(fibonacciNumbers[9], fibonacciByIndex);
  }

  @Test
  public void getFibonacciByIndex_WithPositiveNumber_ReturnsTheRightNumber() {
    Fibonacci fibonacci = new Fibonacci();
    int[] fibonacciNumbers = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
    int fibonacciByIndex = fibonacci.getFibonacciByIndex(0);
    assertEquals(fibonacciNumbers[0], fibonacciByIndex);
  }

  @Test
  public void getFibonacciByIndex_WithNegativeNumber_ReturnsMinusOne() {
    Fibonacci fibonacci = new Fibonacci();
    int[] fibonacciNumbers = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
    int fibonacciByIndex = fibonacci.getFibonacciByIndex(-678);
    assertEquals(-1, fibonacciByIndex);
  }
}