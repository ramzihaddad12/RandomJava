package weapon;

import java.util.Arrays;
import java.util.Objects;

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

  /**
   * A copy constructor for the Katana.
   * @param katana the object to be copied
   */

  public Katana(Weapon katana) {
    super(katana.getName(), katana.getRange());
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

  @Override
  protected boolean equalsKatana(Katana katana) {
    return this.getName().equals(katana.getName())
            && Arrays.equals(this.getRange(),katana.getRange());
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractWeapon) {
      AbstractWeapon abstractGear = (AbstractWeapon) other;
      return abstractGear.equalsKatana(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, range);
  }
}
