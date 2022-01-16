package weapon;

import java.util.Arrays;
import java.util.Objects;

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

  /**
   * A copy constructor for the Axe.
   * @param axe the object to be copied
   */

  public Axe(Weapon axe) {
    super(axe.getName(), axe.getRange());
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

  @Override
  protected boolean equalsAxe(Axe axe) {
    return this.getName().equals(axe.getName())
            && Arrays.equals(this.getRange(),axe.getRange());
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractWeapon) {
      AbstractWeapon abstractGear = (AbstractWeapon) other;
      return abstractGear.equalsAxe(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, range);
  }
}
