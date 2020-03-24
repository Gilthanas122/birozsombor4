package zoo;

public class Reptile extends Animal {
  protected boolean isItADino;
  protected boolean isItALizard;

  public Reptile(String name) {
    super(name);
  }

  @Override
  public String breed() {
    return "laying eggs";
  }
}
