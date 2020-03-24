package charsequence;

public class Shifter implements CharSequence {
  public String getText() {
    return text;
  }

  private String text;

  public Shifter(String text, int shiftNumber) {
    this.text = shiftIt(text, shiftNumber);
  }

  private String shiftIt(String text, int shiftNumber) {
    if (shiftNumber >= text.length()) {
      System.out.println("The shiftNumber is too much!");
      return "";
    }
    String toShift = text.substring(0, shiftNumber);
    return new String(text.substring(shiftNumber, text.length()) + toShift);
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

}
