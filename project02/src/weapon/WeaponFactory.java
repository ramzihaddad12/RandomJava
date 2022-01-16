package weapon;

import randomize.Randomness;

/**
 * This class represents a weapon factory.
 */

public class WeaponFactory {

  private Randomness randomness;

  /**
   * A constructor for the WeaponFactory.
   */

  public WeaponFactory() {
    this.randomness = new Randomness();
  }

  /**
   * A constructor for the WeaponFactory with a random seed.
   * @param seed the random seed
   */

  public WeaponFactory(int seed) {
    this.randomness = new Randomness(seed);
  }

  /**
   * A constructor for the WeaponFactory with a random seed.
   * @param randomness the random object
   */

  public WeaponFactory(Randomness randomness) {
    this.randomness = randomness;
  }

  /**
   * A method that gets a weapon at random.
   * @return a weapon
   */

  public Weapon getWeapon(String name) {
    int randomValue = randomness.generateValueBetween(1, 5);
    if (randomValue == 1) {
      return new Axe(name);
    }

    else if (randomValue == 2) {
      return new BroadSword(name);
    }

    else if (randomValue == 3) {
      return new Flail(name);
    }

    else if (randomValue == 4) {
      return new Katana(name);
    }

    return new TwoHandedSword(name);
  }
}
