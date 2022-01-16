package weapon;

/**
 * This class represents an axe weapon.
 */

public class Axe extends AbstractWeapon {

  /**
   * A constructor for the Axe.
   */

  public Axe(String name) {
    super(name,new int[] {6, 10});
  }

  @Override
  protected boolean checkIfAxeType() {
    return true;
  }

  @Override
  public boolean checkIfType(Weapon other) {
    if (other instanceof AbstractWeapon) {
      AbstractWeapon weapon = (AbstractWeapon) other;
      return weapon.checkIfAxeType();
    }
    return false;
  }
}
