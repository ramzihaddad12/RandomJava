package gear;

import randomize.Randomness;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class represents headgear that could affect the constitution ability.
 */

public class Headgear extends AbstractGear {

  /**
   * A constructor for the Headgear taking in the name.
   * @param name the name of the Headgear
   */

  public Headgear(String name) {
    super(name,5, 10, 3, Size.DEFAULT, new int[]{2});
  }

  /**
   * A constructor for the Headgear taking in the name
   * and the random seed.
   * @param name the name of the Headgear gear
   * @param seed the random seed to generate the value
   */

  public Headgear(String name, int seed) {
    super(name, 5, 10, 3, Size.DEFAULT, new int[] {2}, seed);
    this.randomness = new Randomness(seed);
    this.value = generateValue();
  }

  /**
   * A constructor for the Headgear taking in the name
   * and the random seed.
   * @param name the name of the Headgear gear
   * @param randomness the random object
   */

  public Headgear(String name, Randomness randomness) {
    super(name, 5, 10, 3, Size.DEFAULT, new int[] {2}, randomness);
  }

  /**
   * A copy constructor for the Headgear making a copy of a given
   * headgear.
   * @param headgear the Headgear to be copied
   */

  public Headgear(Gear headgear) {
    super(headgear.getName(), headgear.getValue(),
            headgear.getLifespan(), headgear.getSize(), headgear.getAttributeToEffect());
    if (!headgear.checkIfType(HeadGearHelper.getInstance())) {
      throw new IllegalArgumentException("Gear should be of type Headgear");
    }
  }

  @Override
  public boolean checkIfType(Gear other) {
    if (other instanceof AbstractGear) {
      AbstractGear abstractGear = (AbstractGear) other;
      return abstractGear.checkIfHeadGearType();
    }
    return false;
  }

  @Override
  protected boolean checkIfHeadGearType() {
    return true;
  }

  @Override
  protected int comparePotionType(Potion gear) {
    return -1;
  }

  @Override
  protected int compareBeltType(Belt gear) {
    return -1;
  }

  @Override
  protected int compareFootWearType(Footwear gear) {
    return -1;
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractGear) {
      AbstractGear abstractGear = (AbstractGear) o;
      return -abstractGear.compareHeadGearType(this);
    }
    return -1;
  }

  @Override
  protected boolean equalsHeadgear(Headgear headgear) {
    return this.getValue() == headgear.getValue()
            && this.getLifespan() == headgear.getLifespan()
            && this.getName().equals(headgear.getName())
            && this.getSize().equals(headgear.getSize())
            && Arrays.equals(this.getAttributeToEffect(), headgear.getAttributeToEffect());
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractGear) {
      AbstractGear abstractGear = (AbstractGear) other;
      return abstractGear.equalsHeadgear(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, lifeSpan, abilitiesAffected, size);
  }
}
