package aircraftcarrier;

public class F16 extends Aircraft {
  public F16() {
    super();
    setMaxAmmo(8);
    setBaseDamege(30);
  }

  @Override
  public String getType() {
    return "Type: F16";
  }

  @Override
  public String getStatus() {
    return this.getType() + ", Ammo: " + super.actualAmmo + ", Base Damage: " + super.baseDamege + ", All " +
        "damage: " + super.fight();
  }

  @Override
  public boolean isPriority() {
    return false;
  }
}
