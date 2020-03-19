package countletters;

import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.Test;

public class CountLettersTest {

  @Test
  public void getLetterOccurences_WithTheRightTemplate_ReturnsTheSameMap() {
    CountLetters countLetters = new CountLetters();
    String inputWord = "apple";
    HashMap<Character, Integer> inputWordLettersAndOcc = new HashMap<>();
    inputWordLettersAndOcc.put('a', 1);
    inputWordLettersAndOcc.put('p', 2);
    inputWordLettersAndOcc.put('l', 1);
    inputWordLettersAndOcc.put('e', 1);

    HashMap<Character, Integer> result = countLetters.getLetterOccurences(inputWord);

    assertTrue(inputWordLettersAndOcc.equals(result));
  }

  @Test
  public void getLetterOccurences_WithTheWrongTemplate_ReturnsTheAnotherMap() {
    CountLetters countLetters = new CountLetters();
    String inputWord = "apple";
    HashMap<Character, Integer> inputWordLettersAndOcc = new HashMap<>();
    inputWordLettersAndOcc.put('a', 1);
    inputWordLettersAndOcc.put('p', 2);
    inputWordLettersAndOcc.put('l', 1);
    inputWordLettersAndOcc.put('e', 12345);

    HashMap<Character, Integer> result = countLetters.getLetterOccurences(inputWord);

    assertFalse(inputWordLettersAndOcc.equals(result));
  }
}