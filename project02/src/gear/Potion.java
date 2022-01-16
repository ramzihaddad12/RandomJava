package gear;


import randomize.Randomness;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class represents belt gear that could affect any one of the abilities.
 */

public class Potion extends AbstractGear {
  /**
   * A constructor for the Potion taking in the name.
   * @param name the name of the Potion gear
   */

  public Potion(String name) {
    super(name,5,10,3, Size.DEFAULT, new int[] {1});
    this.abilitiesAffected = affectAnyAbility();

  }

  /**
   * A constructor for the Potion taking in the name
   * and the random seed.
   * @param name the name of the Potion gear
   * @param seed the random seed to generate the value
   */

  public Potion(String name, int seed) {
    super(name, 5, 10, 3, Size.DEFAULT, new int[] {1}, seed);
    this.randomness = new Randomness(seed);
    this.abilitiesAffected = affectAnyAbility();
    this.value = generateValue();
  }

  /**
   * A constructor for the Potion taking in the name
   * and the random seed.
   * @param name the name of the Potion gear
   * @param randomness the random object
   */

  public Potion(String name, Randomness randomness) {
    super(name, 5, 10, 3, Size.DEFAULT, new int[] {1}, randomness);
    this.abilitiesAffected = affectAnyAbility();
  }

  /**
   * A copy constructor for the Potion making a copy of a given
   * headgear.
   * @param potion the Potion to be copied
   */

  public Potion(Gear potion) {
    super(potion.getName(), potion.getValue(),
            potion.getLifespan(), potion.getSize(), potion.getAttributeToEffect());
    if (!potion.checkIfType(PotionHelper.getInstance())) {
      throw new IllegalArgumentException("Gear should be of type Potion");
    }
  }

  @Override
  public boolean checkIfType(Gear other) {
    if (other instanceof AbstractGear) {
      AbstractGear abstractGear = (AbstractGear) other;
      return abstractGear.checkIfPotionType();
    }
    return false;
  }

  @Override
  protected boolean checkIfPotionType() {
    return true;
  }

  @Override
  protected int compareHeadGearType(Headgear gear) {
    return 1;
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
      return -abstractGear.comparePotionType(this);
    }
    return -1;
  }

  @Override
  protected boolean equalsPotion(Potion potion) {
    return this.getValue() == potion.getValue()
            && this.getLifespan() == potion.getLifespan()
            && this.getName().equals(potion.getName())
            && this.getSize().equals(potion.getSize())
            && Arrays.equals(this.getAttributeToEffect(), potion.getAttributeToEffect());
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractGear) {
      AbstractGear abstractGear = (AbstractGear) other;
      return abstractGear.equalsPotion(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, lifeSpan, abilitiesAffected, size);
  }
}
