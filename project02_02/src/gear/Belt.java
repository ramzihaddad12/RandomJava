package gear;

/**
 * This class represents belt gear that could affect two abilities.
 */

public class Belt extends AbstractGear {


  private BeltSize size;

  /**
   * A constructor for the Belt taking in the name.
   * @param name the name of the belt gear
   */

  public Belt(String name) {
    super(name, 5, 10, 3);
    this.size = generateRandomSize();
  }

  /**
   * A constructor for the Belt taking in the name and the random seed.
   * @param name the name of the belt gear
   * @param seed the random seed to generate the value
   */

  public Belt(String name, int seed) {
    super(name, 5, 10, 3, seed);
    this.size = generateRandomSize();
  }

  private BeltSize generateRandomSize() {
    int min = 1;
    int max = 3;
    int value = randomness.generateValueBetween(min, max);

    if (value == 1) {
      return BeltSize.SMALL;
    }

    else if (value == 2) {
      return BeltSize.MEDIUM;
    }
    else {
      return BeltSize.LARGE;
    }
  }

  /**
   * A copy constructor for the Belt making a copy of a given
   * belt.
   * @param belt the belt to be copied
   */

//  public Belt(Gear belt) {
//    super(belt.getName(), belt.getValue(), belt.getLifespan());
//    this.size = belt.getSize();
//  }

  /**
   * A method that gets the size of the belt.
   * @return  the size of the belt
   */

  public BeltSize getSize() {
    return size;
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
  public int getNumberOfUnitsForBeltType() {
    return size.getUnits();
  }

  @Override
  public int getNumberOfUnits() {
    return getNumberOfUnitsForBeltType();
  }
}
