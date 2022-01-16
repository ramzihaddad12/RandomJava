package weapon;

/**
 * This class represents an TwoHandedSword weapon.
 */

public class TwoHandedSword extends Sword {

  /**
   * A constructor for the TwoHandedSword.
   */

  public TwoHandedSword(String name) {
    super(name, new int[] {8, 12});
  }

  @Override
  protected boolean checkIfTwoHandedSwordType() {
    return true;
  }

  @Override
  public boolean checkIfType(Weapon other) {
    if (other instanceof AbstractWeapon) {
      AbstractWeapon weapon = (AbstractWeapon) other;
      return weapon.checkIfTwoHandedSwordType();
    }
    return false;
  }
}
