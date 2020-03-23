package gardenapp;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  private List<Plant> plants;

  public Garden() {
    this.plants = new ArrayList<>();
  }

  public void addPlants(Plant newPlant) {
    this.plants.add(newPlant);
  }

  public void info() {
    for (Plant p : this.plants) {
      if (p instanceof Tree) {
        System.out.println("The " + p.color + " Tree " + (((Tree) p).getItNeedsWater() ? "need " :
            "doesnt need ") + "water");
      } else {
        System.out.println("The " + p.color + " Flower " + (((Flower) p).getItNeedsWater() ?
            "need " :
            "doesnt need ") + "water");
      }
    }
  }

  public void irrigate(int waterAmount) {
    System.out.println("Watering with " + waterAmount);
    double waterAmountForOnePlant = getHowManyPlantNeedsWater(this.plants, waterAmount);
    for (Plant p : this.plants) {
      if (p.getItNeedsWater()) {
        if (p instanceof Tree) {
          ((Tree) p).setWater(waterAmountForOnePlant);
        } else {
          ((Flower) p).setWater(waterAmountForOnePlant);
        }
      }
    }
  }

  public double getHowManyPlantNeedsWater(List<Plant> plants, double waterAmount) {
    int counter = 0;
    for (Plant p : plants) {
      if (p.getItNeedsWater()) {
        counter++;
      }
    }
    return waterAmount / counter;
  }
}
