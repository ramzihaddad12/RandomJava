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
}
