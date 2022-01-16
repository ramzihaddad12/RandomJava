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
  protected Size size;
  protected int[] abilitiesAffected;

  /**
   * A constructor for the AbstractGear taking in the name, the range of values,
   * and the life span of the gear.
   * @param name the name of the gear
   * @param min the min value of the gear
   * @param max the max value of the gear
   * @param lifeSpan the life span of the gear
   * @param size the size of the gear
   * @param abilitiesAffected the abilities affected by the gear
   */

  protected AbstractGear(String name, int min, int max,
                         int lifeSpan, Size size, int[] abilitiesAffected) {
    if (min > max) {
      throw new IllegalArgumentException("Max should be greater than the min");
    }

    if (lifeSpan < 0) {
      throw new IllegalArgumentException("Life span should be positive");
    }

    if (abilitiesAffected.length > 2) {
      throw new IllegalArgumentException("Can't affect more than two abilities");
    }
    this.randomness = new Randomness();
    this.name = name;
    this.min = min;
    this.max = max;
    this.value = generateValue();
    this.lifeSpan = lifeSpan;
    this.size = size;
    this.abilitiesAffected = abilitiesAffected;
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

  protected AbstractGear(String name, int min, int max, int lifeSpan,
                         Size size, int[] abilitiesAffected, int seed) {
    this(name, min, max, lifeSpan, size, abilitiesAffected);
    this.randomness = new Randomness(seed);
    this.value = generateValue();
    this.lifeSpan = lifeSpan;
    this.size = size;
    this.abilitiesAffected = abilitiesAffected;
  }

  /**
   * A constructor for the AbstractGear taking in the name, the range of values,
   * and the life span of the gear, given some seed.
   * @param name the name of the gear
   * @param min the min value of the gear
   * @param max the max value of the gear
   * @param lifeSpan the life span of the gear
   * @param randomness the random object
   */

  protected AbstractGear(String name, int min, int max, int lifeSpan,
                         Size size, int[] abilitiesAffected, Randomness randomness) {
    this(name, min, max, lifeSpan, size, abilitiesAffected);
    this.randomness = randomness;
    this.value = generateValue();
    this.lifeSpan = lifeSpan;
    this.size = size;
    this.abilitiesAffected = abilitiesAffected;
  }

  protected AbstractGear(String name, int value, int lifeSpan, Size size, int[] abilitiesAffected) {
    this.name = name;
    this.value = value;
    this.lifeSpan = lifeSpan;
    this.size = size;
    this.abilitiesAffected = abilitiesAffected;
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

  @Override
  public int getNumberOfUnits() {
    return size.getUnits();
  }

  @Override
  public Size getSize() {
    return size;
  }

  @Override
  public int[] getAttributeToEffect() {
    return abilitiesAffected;
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

  protected boolean equalsBelt(Belt belt) {
    return false;
  }

  protected boolean equalsPotion(Potion potion) {
    return false;
  }

  protected boolean equalsHeadgear(Headgear headgear) {
    return false;
  }

  protected boolean equalsFootwear(Footwear footwear) {
    return false;
  }


  @Override
  public String toString() {
    return String.format("%s is a gear with a value of %d, a lifespan"
            + " of %d, and a number of units of %d",
            getName(), getValue(), getLifespan(), getNumberOfUnits());
  }

  protected int[] affectAnyAbility() {
    int min = 1;
    int max = 4;
    int index = randomness.generateValueBetween(min, max);
    return new int[] {index};
  }

  protected int[] affectUpToTwoAbilities() {
    boolean affectsTwoAttributes = randomness.generateBoolean();
    if (affectsTwoAttributes) {
      return randomness.generate2ValueBetween(1, 5);
    }

    return affectAnyAbility();
  }


}
