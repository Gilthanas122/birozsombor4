package aircraftcarrier;

public class F35 extends Aircraft {
  public F35() {
    super();
    setMaxAmmo(12);
    setBaseDamege(50);
  }

  @Override
  public String getType() {
    return "Type: F35";
  }

  @Override
  public String getStatus() {
    return this.getType() + ", Ammo: " + super.actualAmmo + ", Base Damage: " + super.baseDamege +
        ", All " + "damage: " + super.fight();
  }

  @Override
  public boolean isPriority() {
    return true;
  }

}
