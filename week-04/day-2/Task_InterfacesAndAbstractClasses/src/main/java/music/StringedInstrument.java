package main.java.music;

abstract public class StringedInstrument extends Instrument {
  protected int numberOfStrings;

  abstract void sound();

  @Override
  public void play() {
    sound();
  }

}
