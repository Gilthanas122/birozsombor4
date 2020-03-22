package animal;

public class Animal {
  public int hunger;
  public int thirst;

  public void setHunger(int hunger) {
    this.hunger = hunger;
  }

  public void setThirst(int thirst) {
    this.thirst = thirst;
  }

  public int getHunger() {
    return hunger;
  }

  public int getThirst() {
    return thirst;
  }

  public Animal() {
    this.hunger = 50;
    this.thirst = 50;
  }

  public void eat() {
    this.hunger--;
  }

  public void drink() {
    this.thirst--;
  }

  public void play() {
    this.hunger++;
    this.thirst++;
  }

}