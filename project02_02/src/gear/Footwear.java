package gear;

/**
 * This class represents Footwear that affects the dexterity ability.
 */

public class Footwear extends AbstractGear {

  /**
   * A constructor for the Footwear taking in the name.
   * @param name the name of the Footwear gear
   */

  public Footwear(String name) {
    super(name, 5, 10, 3);
  }

  /**
   * A constructor for the Footwear taking in the name
   * and the random seed.
   * @param name the name of the Footwear gear
   * @param seed the random seed to generate the value
   */

  public Footwear(String name, int seed) {
    super(name, 5, 10, 3, seed);
  }

  /**
   * A copy constructor for the Footwear making a copy of a given
   * footwear.
   * @param footwear the Footwear to be copied
   */

  public Footwear(Gear footwear) {
    super(footwear.getName(), footwear.getValue(), footwear.getLifespan());
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
  public int getNumberOfUnits() {
    return getNumberOfUnitsForFootWearType();
  }
}
