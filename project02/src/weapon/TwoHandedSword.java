package weapon;

import java.util.Arrays;
import java.util.Objects;

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

  /**
   * A copy constructor for the TwoHandedSword.
   * @param twoHandedSword the object to be copied
   */

  public TwoHandedSword(Weapon twoHandedSword) {
    super(twoHandedSword.getName(), twoHandedSword.getRange());
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

  @Override
  protected boolean equalsTwoHandedSword(TwoHandedSword twoHandedSword) {
    return this.getName().equals(twoHandedSword.getName())
            && Arrays.equals(this.getRange(),twoHandedSword.getRange());
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractWeapon) {
      AbstractWeapon abstractGear = (AbstractWeapon) other;
      return abstractGear.equalsTwoHandedSword(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, range);
  }
}
