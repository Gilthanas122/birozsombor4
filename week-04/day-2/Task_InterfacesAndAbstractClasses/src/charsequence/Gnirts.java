package charsequence;

import java.util.stream.IntStream;

public class Gnirts implements CharSequence {
  private String text;

  public Gnirts(String text) {
    this.text = text;
  }


  @Override
  public int length() {
    return this.text.length();
  }

  @Override
  public char charAt(int index) {
    return this.text.charAt(index);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return this.text.subSequence(start, end);
  }

  @Override
  public IntStream chars() {
    return this.text.chars();
  }

  @Override
  public IntStream codePoints() {
    return this.text.codePoints();
  }
}

