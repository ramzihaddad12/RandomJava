package weapon;

import java.util.Arrays;
import java.util.Objects;

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

  /**
   * A copy constructor for the Flail.
   * @param flail the object to be copied
   */

  public Flail(Weapon flail) {
    super(flail.getName(), flail.getRange());
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

  @Override
  protected boolean equalsFlail(Flail flail) {
    return this.getName().equals(flail.getName())
            && Arrays.equals(this.getRange(),flail.getRange());
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractWeapon) {
      AbstractWeapon abstractGear = (AbstractWeapon) other;
      return abstractGear.equalsFlail(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, range);
  }
}
