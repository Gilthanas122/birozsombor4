package Anagram;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {

  @Test
  public void areTheyAnagrams_WithTwoAnagrams_ReturnTrue() {
    Anagram anagram = new Anagram();
    boolean result = anagram.AreTheyAnagrams("apple", "lepap");
    assertEquals(true, result);
  }

  @Test
  public void areTheyAnagrams_WithTwoNotAnagrams_ReturnFalse() {
    Anagram anagram = new Anagram();
    boolean result = anagram.AreTheyAnagrams("apple", "lepapsadqwd");
    assertEquals(false, result);
  }

  @Test
  public void areTheyAnagrams_WithTwoNotAnagramsWithSameSize_ReturnFalse() {
    Anagram anagram = new Anagram();
    boolean result = anagram.AreTheyAnagrams("apple", "papla");
    assertEquals(false, result);
  }
}