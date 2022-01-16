package gear;

import randomize.Randomness;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class represents belt gear that could affect two abilities.
 */

public class Belt extends AbstractGear {

  /**
   * A constructor for the Belt taking in the name.
   * @param name the name of the belt gear
   */

  public Belt(String name) {
    super(name, 5, 10, 3, Size.DEFAULT, new int[] {1});
    this.size = generateRandomSize();
    this.abilitiesAffected = affectUpToTwoAbilities();
  }

  /**
   * A constructor for the Belt taking in the name and the random seed.
   * @param name the name of the belt gear
   * @param seed the random seed to generate the value
   */

  public Belt(String name, int seed) {
    super(name, 5, 10, 3, Size.DEFAULT, new int[] {1}, seed);
    this.randomness = new Randomness(seed);
    this.size = generateRandomSize();
    this.value = generateValue();
    this.abilitiesAffected = affectUpToTwoAbilities();
  }

  /**
   * A constructor for the Belt taking in the name and the random seed.
   * @param name the name of the belt gear
   * @param randomness the random object
   */

  public Belt(String name, Randomness randomness) {
    super(name, 5, 10, 3, Size.DEFAULT, new int[] {1}, randomness);
    this.size = generateRandomSize();
    this.abilitiesAffected = affectUpToTwoAbilities();
  }


  /**
   * A copy constructor for the Belt making a copy of a given
   * belt.
   * @param gear the belt to be copied
   */

  public Belt(Gear gear) {
    super(gear.getName(), gear.getValue(),
            gear.getLifespan(), gear.getSize(), gear.getAttributeToEffect());

    if (!gear.checkIfType(BeltHelper.getInstance())) {
      throw new IllegalArgumentException("Gear to be occupied must be of type belt");
    }
    this.size = gear.getSize();
  }

  protected Size generateRandomSize() {
    int min = 1;
    int max = 3;
    int value = randomness.generateValueBetween(min, max);

    if (value < 1 || value > 3) {
      throw new IllegalArgumentException("Value should be between 1 and 3");
    }

    if (value == 1) {
      return Size.SMALL;
    }

    else if (value == 2) {
      return Size.MEDIUM;
    }
    else {
      return Size.LARGE;
    }
  }


  @Override
  public boolean checkIfType(Gear other) {
    if (other instanceof AbstractGear) {
      AbstractGear abstractGear = (AbstractGear) other;
      return abstractGear.checkIfBeltType();
    }
    return false;
  }

  @Override
  protected boolean checkIfBeltType() {
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
  protected int compareFootWearType(Footwear gear) {
    return -1;
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractGear) {
      AbstractGear abstractGear = (AbstractGear) o;
      return -abstractGear.compareBeltType(this);
    }
    return -1;
  }

  @Override
  protected boolean equalsBelt(Belt belt) {
    return this.getValue() == belt.getValue()
            && this.getLifespan() == belt.getLifespan()
            && this.getName().equals(belt.getName())
            && this.getSize().equals(belt.getSize())
            && Arrays.equals(this.getAttributeToEffect(),belt.getAttributeToEffect());
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractGear) {
      AbstractGear abstractGear = (AbstractGear) other;
      return abstractGear.equalsBelt(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, lifeSpan, abilitiesAffected, size);
  }
}
