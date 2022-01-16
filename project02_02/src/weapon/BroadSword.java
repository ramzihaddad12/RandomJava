package weapon;

/**
 * This class represents an BroadSword weapon.
 */

public class BroadSword extends Sword {

  /**
   * A constructor for the BroadSword.
   */

  public BroadSword(String name) {
    super(name, new int[] {6, 10});
  }

  @Override
  protected boolean checkIfBroadSwordType() {
    return true;
  }

  @Override
  public boolean checkIfType(Weapon other) {
    if (other instanceof Weapon) {
      AbstractWeapon weapon = (AbstractWeapon) other;
      return weapon.checkIfBroadSwordType();
    }
    return false;
  }
}
