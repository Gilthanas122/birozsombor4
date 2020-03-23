package gardenapp;

public class Flower extends Plant {
  public Flower(String color, int water) {
    super(color, water);
    this.itNeedsWater = getItNeedsWater();
  }

  @Override
  public boolean getItNeedsWater() {
    if (super.water < 5) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void setWater(double water) {
    double temp = this.getWater();
    this.water = (temp + (water * 0.75));
  }
}
