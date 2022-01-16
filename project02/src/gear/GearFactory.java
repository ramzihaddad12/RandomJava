package gear;

import randomize.Randomness;

/**
 * This class represents a gear factory.
 */

public class GearFactory {

  /**
   * A method that gets a belt gear.
   * @param name the name of the gear
   * @return a belt gear
   */

  public Gear getBelt(String name) {
    return new Belt(name);
  }

  /**
   * A method that gets a belt gear.
   * @param name the name of the gear
   * @param seed the random seed
   * @return a belt gear
   */

  public Gear getBelt(String name, int seed) {
    return new Belt(name, seed);
  }

  /**
   * A method that gets a belt gear.
   * @param name the name of the gear
   * @param randomness the random object
   * @return a belt gear
   */

  public Gear getBelt(String name, Randomness randomness) {
    return new Belt(name, randomness);
  }

  /**
   * A method that gets a Footwear gear.
   * @param name the name of the gear
   * @return a Footwear gear
   */


  public Gear getFootWear(String name) {
    return new Footwear(name);
  }

  /**
   * A method that gets a Footwear gear.
   * @param name the name of the gear
   * @param seed the random seed
   * @return a Footwear gear
   */


  public Gear getFootWear(String name, int seed) {
    return new Footwear(name, seed);
  }

  /**
   * A method that gets a Footwear gear.
   * @param name the name of the gear
   * @param randomness the random object
   * @return a Footwear gear
   */


  public Gear getFootWear(String name, Randomness randomness) {
    return new Footwear(name, randomness);
  }

  /**
   * A method that gets a Headgear.
   * @param name the name of the gear
   * @return a Headgear
   */

  public Gear getHeadgear(String name) {
    return new Headgear(name);
  }

  /**
   * A method that gets a Headgear.
   * @param name the name of the gear
   * @param seed the random seed
   * @return a Headgear
   */

  public Gear getHeadgear(String name, int seed) {
    return new Headgear(name, seed);
  }

  /**
   * A method that gets a Headgear.
   * @param name the name of the gear
   * @param randomness the random object
   * @return a Headgear
   */

  public Gear getHeadgear(String name, Randomness randomness) {
    return new Headgear(name, randomness);
  }

  /**
   * A method that gets a Potion gear.
   * @param name the name of the gear
   * @return a Potion gear
   */

  public Gear getPotion(String name) {
    return new Potion(name);
  }

  /**
   * A method that gets a Potion.
   * @param name the name of the gear
   * @param seed the random seed
   * @return a Potion
   */

  public Gear getPotion(String name, int seed) {
    return new Potion(name, seed);
  }

  /**
   * A method that gets a Potion.
   * @param name the name of the gear
   * @param randomness the random object
   * @return a Potion
   */

  public Gear getPotion(String name, Randomness randomness) {
    return new Potion(name, randomness);
  }

}
