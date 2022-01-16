package weapon;

/**
 * This class represents an abstract weapon
 * where identical behaviours are defined.
 */

public abstract class AbstractWeapon implements Weapon {

  protected final String name;
  protected final int[] range;

  /**
   * A constructor for the AbstractWeapon taking in the
   * range of the damage of the weapon.
   * @param range the range of the damage of the weapon
   */

  protected AbstractWeapon(String name, int[] range) {
    this.name = name;
    this.range = range;
  }

  @Override
  public int[] getRange() {
    return range;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public abstract boolean checkIfType(Weapon other);

  /**
   * A method that checks if this weapon is of Katana type.
   * @return whether this weapon is of Katana type
   */

  protected boolean checkIfKatanaSwordType() {
    return false;
  }

  /**
   * A method that checks if this weapon is of BroadSword type.
   * @return whether this weapon is of BroadSword type
   */

  protected boolean checkIfBroadSwordType() {
    return false;
  }

  /**
   * A method that checks if this weapon is of TwoHandedSword type.
   * @return whether this weapon is of TwoHandedSword type
   */

  protected boolean checkIfTwoHandedSwordType() {
    return false;
  }

  /**
   * A method that checks if this weapon is of Axe type.
   * @return whether this weapon is of Axe type
   */

  protected boolean checkIfAxeType() {
    return false;
  }

  /**
   * A method that checks if this weapon is of Flail type.
   * @return whether this weapon is of Flail type
   */

  protected boolean checkIfFlailType() {
    return false;
  }

  @Override
  public String toString() {
    return String.format("%s is a with a range from %d to %d inclusive",
            getName(), getRange()[0], getRange()[1]);
  }
}
