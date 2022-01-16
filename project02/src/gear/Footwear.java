package gear;


import randomize.Randomness;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class represents Footwear that affects the dexterity ability.
 */

public class Footwear extends AbstractGear {

  /**
   * A constructor for the Footwear taking in the name.
   * @param name the name of the Footwear gear
   */

  public Footwear(String name) {
    super(name, 5, 10, 3, Size.DEFAULT, new int[]{3});
  }

  /**
   * A constructor for the Footwear taking in the name
   * and the random seed.
   * @param name the name of the Footwear gear
   * @param seed the random seed to generate the value
   */

  public Footwear(String name, int seed) {
    super(name, 5, 10, 3, Size.DEFAULT, new int[]{3}, seed);
    this.randomness = new Randomness(seed);

    this.value = generateValue();

  }

  /**
   * A constructor for the Footwear taking in the name
   * and the random seed.
   * @param name the name of the Footwear gear
   * @param randomness the random object
   */

  public Footwear(String name, Randomness randomness) {
    super(name, 5, 10, 3, Size.DEFAULT, new int[]{3}, randomness);
    this.randomness = randomness;
  }

  /**
   * A copy constructor for the Footwear making a copy of a given
   * footwear.
   * @param footwear the Footwear to be copied
   */

  public Footwear(Gear footwear) {
    super(footwear.getName(), footwear.getValue(),
            footwear.getLifespan(), footwear.getSize(), footwear.getAttributeToEffect());
    if (!footwear.checkIfType(FootWearHelper.getInstance())) {
      throw new IllegalArgumentException("Gear should be of type FootWear");
    }
  }

  @Override
  public boolean checkIfType(Gear other) {
    if (other instanceof AbstractGear) {
      AbstractGear abstractGear = (AbstractGear) other;
      return abstractGear.checkIfFootWearType();
    }
    return false;
  }

  @Override
  protected boolean checkIfFootWearType() {
    return true;
  }

  @Override
  protected int compareHeadGearType(Headgear gear) {
    return 1;
  }

  @Override
  protected int comparePotionType(Potion gear) {
    return 1;
  }

  @Override
  protected int compareBeltType(Belt gear) {
    return 1;
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractGear) {
      AbstractGear abstractGear = (AbstractGear) o;
      return -abstractGear.compareFootWearType(this);
    }
    return -1;
  }

  @Override
  protected boolean equalsFootwear(Footwear footwear) {
    return this.getValue() == footwear.getValue()
            && this.getLifespan() == footwear.getLifespan()
            && this.getName().equals(footwear.getName())
            && this.getSize().equals(footwear.getSize())
            && Arrays.equals(this.getAttributeToEffect(),footwear.getAttributeToEffect());
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractGear) {
      AbstractGear abstractGear = (AbstractGear) other;
      return abstractGear.equalsFootwear(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, lifeSpan, abilitiesAffected, size);
  }
}
