package gear;

import randomize.Randomness;

/**
 * This class represents an abstract gear
 * where identical behaviours are defined.
 */

abstract class AbstractGear implements Gear {
  protected final String name;
  protected int min;
  protected int max;
  protected int value;
  protected int lifeSpan;
  protected Randomness randomness;

  /**
   * A constructor for the AbstractGear taking in the name, the range of values,
   * and the life span of the gear.
   * @param name the name of the gear
   * @param min the min value of the gear
   * @param max the max value of the gear
   * @param lifeSpan the life span of the gear
   */

  protected AbstractGear(String name, int min, int max, int lifeSpan) {
    this.randomness = new Randomness();
    this.name = name;
    this.min = min;
    this.max = max;
    this.value = generateValue();
    this.lifeSpan = lifeSpan;
  }

  /**
   * A constructor for the AbstractGear taking in the name, the range of values,
   * and the life span of the gear, given some seed.
   * @param name the name of the gear
   * @param min the min value of the gear
   * @param max the max value of the gear
   * @param lifeSpan the life span of the gear
   * @param seed the random seed
   */

  protected AbstractGear(String name, int min, int max, int lifeSpan, int seed) {
    this.randomness = new Randomness(seed);
    this.name = name;
    this.min = min;
    this.max = max;
    this.value = generateValue();
    this.lifeSpan = lifeSpan;
  }

  public AbstractGear(String name, int value, int lifeSpan) {
    this.name = name;
    this.value = value;
    this.lifeSpan = lifeSpan;
  }

  /**
   * A method that generates a random value based on the range.
   * @return a randomly generated value
   */

  protected int generateValue() {
    int value = randomness.generateValueBetween(min, max);
    boolean randomBoolean = randomness.generateBoolean();
    if (randomBoolean) {
      return value;
    }
    return -value;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public int getLifespan() {
    return lifeSpan;
  }

  @Override
  public String getName() {
    return name;
  }


  /**
   * A method that checks if this gear is of HeadGear type.
   * @return whether this gear is of HeadGear type
   */

  protected boolean checkIfHeadGearType() {
    return false;
  }

  /**
   * A method that checks if this gear is of Potion type.
   * @return whether this gear is of Potion type
   */

  protected boolean checkIfPotionType() {
    return false;
  }

  /**
   * A method that checks if this gear is of Belt type.
   * @return whether this gear is of Belt type
   */

  protected boolean checkIfBeltType() {
    return false;
  }

  /**
   * A method that checks if this gear is of FootWear type.
   * @return whether this FootWear is of Belt type
   */

  protected boolean checkIfFootWearType() {
    return false;
  }

  /**
   * Compares a Gear object with a Headgear object.
   * @param gear the Headgear object being compared with
   */

  protected int compareHeadGearType(Headgear gear) {
    return name.compareTo(gear.getName());
  }

  /**
   * Compares a Gear object with a Potion object.
   * @param gear the Potion object being compared with
   */

  protected int comparePotionType(Potion gear) {
    return name.compareTo(gear.getName());
  }

  /**
   * Compares a Gear object with a Belt object.
   * @param gear the Belt object being compared with
   */

  protected int compareBeltType(Belt gear) {
    return name.compareTo(gear.getName());
  }

  /**
   * Compares a Gear object with a Footwear object.
   * @param gear the Footwear object being compared with
   */

  protected int compareFootWearType(Footwear gear) {
    return name.compareTo(gear.getName());
  }

  /**
   * Gets the number of units associated with a head gear.
   * @return  the number of units associated with a head gear
   */

  protected int getNumberOfUnitsForHeadGearType() {
    return 1;
  }

  /**
   * Gets the number of units associated with a potion gear.
   * @return  the number of units associated with a potion gear
   */

  protected int getNumberOfUnitsForPotionType() {
    return 1;
  }

  /**
   * Gets the number of units associated with a foot wear.
   * @return  the number of units associated with a foot wear
   */

  protected int getNumberOfUnitsForFootWearType() {
    return 1;
  }

  /**
   * Gets the number of units associated with a belt gear.
   * @return  the number of units associated with a belt gear
   */

  protected int getNumberOfUnitsForBeltType() {
    return 1;
  }

  @Override
  public String toString() {
    return String.format("%s is a gear with a value of %d, a lifespan"
            + " of %d, and a number of units of %d",
            getName(), getValue(), getLifespan(), getNumberOfUnits());
  }
}
