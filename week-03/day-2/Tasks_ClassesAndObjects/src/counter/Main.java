package counter;

public class Main {
  public static void main(String[] args) {
    Counter counter = new Counter(10);
    System.out.println(counter.get());
    counter.add(31);
    counter.add();
    System.out.println(counter.get());
    counter.reset();
    System.out.println(counter.get());
    System.out.println(counter.counter);
  }
}
