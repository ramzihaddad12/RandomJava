package gear;

/**
 * This class represents headgear that could affect the constitution ability.
 */

public class Headgear extends AbstractGear {

  /**
   * A constructor for the Headgear taking in the name.
   * @param name the name of the Headgear
   */

  public Headgear(String name) {
    super(name,5, 10, 10);
  }

  /**
   * A constructor for the Headgear taking in the name
   * and the random seed.
   * @param name the name of the Headgear gear
   * @param seed the random seed to generate the value
   */

  public Headgear(String name, int seed) {
    super(name, 5, 10, 3, seed);
  }

  /**
   * A copy constructor for the Headgear making a copy of a given
   * headgear.
   * @param headgear the Headgear to be copied
   */

  public Headgear(Gear headgear) {
    super(headgear.getName(), headgear.getValue(), headgear.getLifespan());
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
  public int getNumberOfUnits() {
    return getNumberOfUnitsForHeadGearType();
  }
}
