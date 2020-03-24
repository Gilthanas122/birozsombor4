package zoo;

abstract public class Animal {
  protected String name;
  protected int age;
  protected String gender;
  protected int numberOfLegs;
  protected boolean isItPredator;

  public Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract String breed();
}
