package weapon;

import java.util.Arrays;
import java.util.Objects;

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

  /**
   * A copy constructor for the BroadSword.
   * @param broadSword the object to be copied
   */

  public BroadSword(Weapon broadSword) {
    super(broadSword.getName(), broadSword.getRange());
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

  @Override
  protected boolean equalsBroadSword(BroadSword broadSword) {
    return this.getName().equals(broadSword.getName())
            && Arrays.equals(this.getRange(),broadSword.getRange());
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractWeapon) {
      AbstractWeapon abstractGear = (AbstractWeapon) other;
      return abstractGear.equalsBroadSword(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, range);
  }
}
