package weapon;

/**
 * This class represents an abstract sword
 * where identical behaviours are defined.
 */

public abstract class Sword extends AbstractWeapon {

  /**
   * A constructor for the Sword taking in the
   * range of the damage of the weapon.
   * @param range the range of the damage of the weapon
   */

  protected Sword(String name, int[] range) {
    super(name, range);
  }

//  @Override
//  public boolean checkIfSwordType() {
//    return true;
//  }

//  @Override
//  public boolean checkIfType(weapon.Weapon other) {
//    if (other instanceof weapon.Weapon) {
//      weapon.Weapon weapon = (weapon.Weapon) other;
//      return weapon.checkIfSwordType();
//    }
//    return false;
//  }

//  public abstract boolean checkIfSwordType(weapon.Sword other);
//
//  public boolean checkIfKatanaType() {
//    return false;
//  }
//
//  public boolean checkIfBroadSwordType() {
//    return false;
//  }
//
//  public boolean checkIfTwoHandedSwordType() {
//    return false;
//  }
}
