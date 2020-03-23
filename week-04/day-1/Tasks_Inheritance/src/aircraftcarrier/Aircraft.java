package aircraftcarrier;

public class Aircraft {
  int maxAmmo;
  int baseDamege;
  int actualAmmo;

  public Aircraft() {
    this.actualAmmo = 0;
    this.maxAmmo = 0;
    this.baseDamege = 0;
  }

  public void setMaxAmmo(int maxAmmo) {
    this.maxAmmo = maxAmmo;
  }

  public void setBaseDamege(int baseDamege) {
    this.baseDamege = baseDamege;
  }

  public int fight() {
    return maxAmmo * baseDamege;
  }

  public int refill(int numberOfAmmoToRefill) {
    this.actualAmmo = this.maxAmmo;
    return numberOfAmmoToRefill - this.maxAmmo;
  }

  public String getType() {
    return "Type: Aircraft";
  }

  public String getStatus() {
    return this.getType() + ", Ammo: " + this.maxAmmo + ", Base Damage: " + this.baseDamege + ", All " +
        "damage: " + fight();
  }

  public boolean isPriority() {
    return false;
  }
}
