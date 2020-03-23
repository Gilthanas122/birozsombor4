package gardenapp;

public class Plant {
  protected String color;
  protected boolean itNeedsWater;

  protected double water;

  public Plant(String color, int water) {
    this.color = color;
    this.water = water;
    this.itNeedsWater = getItNeedsWater();
  }

  public boolean getItNeedsWater() {
    if (water > 0) {
      return true;
    } else {
      return false;
    }
  }

  public void setWater(double water) {
    this.water = water;
  }

  public double getWater() {
    return water;
  }
}
