package weapon;

/**
 * This class represents an Katana weapon.
 */

public class Katana extends Sword {

  /**
   * A constructor for the Katana.
   */

  public Katana(String name) {
    super(name, new int[] {4, 6});
  }

  @Override
  protected boolean checkIfKatanaSwordType() {
    return true;
  }

  @Override
  public boolean checkIfType(Weapon other) {
    if (other instanceof AbstractWeapon) {
      AbstractWeapon weapon = (AbstractWeapon) other;
      return weapon.checkIfKatanaSwordType();
    }
    return false;
  }
}
