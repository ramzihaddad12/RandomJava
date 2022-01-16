package gear;

/**
 * This class represents belt gear that could affect any one of the abilities.
 */

public class Potion extends AbstractGear {
  /**
   * A constructor for the Potion taking in the name.
   * @param name the name of the Potion gear
   */

  public Potion(String name) {
    super(name,5,10,3);
  }

  /**
   * A constructor for the Potion taking in the name
   * and the random seed.
   * @param name the name of the Potion gear
   * @param seed the random seed to generate the value
   */

  public Potion(String name, int seed) {
    super(name, 5, 10, 3, seed);
  }

  /**
   * A copy constructor for the Potion making a copy of a given
   * headgear.
   * @param potion the Potion to be copied
   */

  public Potion(Gear potion) {
    super(potion.getName(), potion.getValue(), potion.getLifespan());
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
  public int getNumberOfUnits() {
    return getNumberOfUnitsForPotionType();
  }
}
