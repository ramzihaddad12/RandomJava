package weapon;

/**
 * This class represents an Flail weapon.
 */

public class Flail extends AbstractWeapon {

  /**
   * A constructor for the Flail.
   */

  public Flail(String name) {
    super(name, new int[] {8, 12});
  }

  @Override
  protected boolean checkIfFlailType() {
    return true;
  }

  @Override
  public boolean checkIfType(Weapon other) {
    if (other instanceof AbstractWeapon) {
      AbstractWeapon weapon = (AbstractWeapon) other;
      return weapon.checkIfFlailType();
    }
    return false;
  }
}
