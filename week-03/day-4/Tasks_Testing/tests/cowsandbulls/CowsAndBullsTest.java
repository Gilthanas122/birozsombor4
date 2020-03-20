package cowsandbulls;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class CowsAndBullsTest {

  CowsAndBulls cowsAndBulls;

  @Before
  public void before() {
    cowsAndBulls = new CowsAndBulls();
  }

  @Test
  public void counstructorState_WithDefaultValue_ReturnsValidValue() {
    assertEquals(CowsAndBulls.State.PLAYING, cowsAndBulls.state);
  }

  @Test
  public void counstructorCounter_WithDefaultValue_ReturnsValidValue() {
    assertEquals(0, cowsAndBulls.counter);
  }

  @Test
  public void counstructorRandomNumber_WithWrongNewValue_ReturnsMinusOne() {
    cowsAndBulls.setNumberToGuess(1111);
    assertEquals(-1, cowsAndBulls.numberToGuess);
  }

  @Test
  public void counstructorRandomNumber_WithRightNewValue_ReturnsRigthNewValue() {
    cowsAndBulls.setNumberToGuess(1234);
    assertEquals(1234, cowsAndBulls.numberToGuess);
  }

  @Test
  public void guess_WithWrongShortInput_ReturnsError() {
    assertEquals("Wrong Input!", cowsAndBulls.guess(123));
  }

  @Test
  public void guess_WithWrongLongInput_ReturnsError() {
    assertEquals("Wrong Input!", cowsAndBulls.guess(12345));
  }

  @Test
  public void guess_WithRightInput_ReturnsRightState() {
    cowsAndBulls.guess(1234);
    assertEquals(CowsAndBulls.State.PLAYING, cowsAndBulls.state);
  }

  @Test
  public void guess_WithRightInputAndSettedNumber_ReturnsRightState() {
    cowsAndBulls.setNumberToGuess(1234);
    cowsAndBulls.guess(1234);
    assertEquals(CowsAndBulls.State.FINISHED, cowsAndBulls.state);
  }

  @Test
  public void intToArrayList_With4DigitsNumber_ReturnsListWithDigitsAsAnElement() {
    ArrayList<Integer> template = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    ArrayList<Integer> result = cowsAndBulls.intToArrayList(1234);
    assertTrue(template.equals(result));
  }

  @Test
  public void intToArrayList_With9DigitsNumber_ReturnsListWithDigitsAsAnElement() {
    ArrayList<Integer> template = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    ArrayList<Integer> result = cowsAndBulls.intToArrayList(123456789);
    assertTrue(template.equals(result));
  }

  @Test
  public void intToArrayList_With10DigitsNumber_ReturnsListWithDigitsAsAnElement() {
    ArrayList<Integer> template = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 11));
    ArrayList<Integer> result = cowsAndBulls.intToArrayList(1234567811);
    assertFalse(template.equals(result));
  }

  @Test
  public void isItValidNumber_WithRightInput_ReturnsTrue() {
    int number = 1234;
    assertEquals(true, cowsAndBulls.isItValidNumber(number));
  }

  @Test
  public void isItValidNumber_WithWrongShortInput_ReturnsFalse() {
    int number = 123;
    assertEquals(false, cowsAndBulls.isItValidNumber(number));
  }

  @Test
  public void isItValidNumber_WithWrongLongInput_ReturnsFalse() {
    int number = 12345;
    assertEquals(false, cowsAndBulls.isItValidNumber(number));
  }

  @Test
  public void isItValidNumber_WithSameDigits_ReturnsFalse() {
    int number = 1111;
    assertEquals(false, cowsAndBulls.isItValidNumber(number));
  }

  @Test
  public void isItValidNumber_WithSimilarDigits_ReturnsFalse() {
    int number = 1231;
    assertEquals(false, cowsAndBulls.isItValidNumber(number));
  }
}