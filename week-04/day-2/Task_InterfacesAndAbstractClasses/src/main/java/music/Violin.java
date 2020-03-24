package main.java.music;

public class Violin extends StringedInstrument {
  public Violin() {
    super.numberOfStrings = 4;
  }

  @Override
  void sound() {
    System.out.println("Screech");
  }
}
