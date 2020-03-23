package aircraftcarrier;

import java.util.ArrayList;
import java.util.List;

public class AircraftCarrier {
  private List<Aircraft> aircrafts;
  private int initialAmmo;
  private int storeOfAmmo;
  private int healthPoint;

  public AircraftCarrier(int initialAmmo, int healthPoint) {
    this.aircrafts = new ArrayList<>();
    this.initialAmmo = initialAmmo;
    this.storeOfAmmo = this.initialAmmo;
    this.healthPoint = healthPoint;
  }

  public void add(Aircraft newAircraft) {
    this.aircrafts.add(newAircraft);
  }

  public int getHowMuchAmmoNeed() {
    int need = 0;
    for (Aircraft a : this.aircrafts) {
      if (a.actualAmmo != a.maxAmmo) {
        need += a.maxAmmo;
      }
    }
    return need;
  }

  public void fillAllAircraft() {
    for (Aircraft a : this.aircrafts) {
      this.storeOfAmmo = a.refill(this.storeOfAmmo);
    }
  }

  public void fillAllPriority() {
    for (Aircraft a : this.aircrafts) {
      if (a.isPriority()) {
        this.storeOfAmmo = a.refill(this.storeOfAmmo);
      }
    }
  }

  public void fillTheRest() {
    for (Aircraft a : this.aircrafts) {
      if (a.isPriority() == false && this.storeOfAmmo - a.maxAmmo > 0) {
        this.storeOfAmmo = a.refill(this.storeOfAmmo);
      }
    }
  }

  public void fill() {
    int need = getHowMuchAmmoNeed();
    if (this.storeOfAmmo > need) {
      fillAllAircraft();
    } else {
      fillAllPriority();
      fillTheRest();
    }
  }

  public void fight(AircraftCarrier anotherAircraftCarrier) {
    anotherAircraftCarrier.healthPoint -= this.getTotalDamage();
  }

  public int getTotalDamage() {
    int holder = 0;
    for (Aircraft a : this.aircrafts) {
      holder += a.fight();
    }
    return holder;
  }

  public String getInfoAboutCarrier() {
    return "HP: " + this.healthPoint + ", Aircraft count: " + this.aircrafts.size() +
        ", Ammo Storage: " + storeOfAmmo + ", All Damage: " + getTotalDamage() +
        "\nAircrafts:\n";
  }

  public String getStatus() {
    if (this.healthPoint <= 0) {
      return "It's dead Jim :(";
    }

    String ret = getInfoAboutCarrier();
    String line = "";

    for (Aircraft a : this.aircrafts) {
      line = a.getStatus() + "\n";
      ret += line;
      line = "";
    }
    return ret;
  }
}
