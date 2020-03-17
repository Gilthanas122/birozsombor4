package counter;

public class Counter {
  int counter;
  int defaultValue;

  public Counter() {
    this.counter = 0;
  }

  public Counter(int counter) {
    this.counter = counter;
    defaultValue = counter;
  }

  public void add(int numberToAdd) {
    this.counter += numberToAdd;
  }

  public void add() {
    this.counter++;
  }

  public int get() {
    return counter;
  }

  public void reset() {
    this.counter = defaultValue;
  }

}
