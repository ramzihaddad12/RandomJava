package treasure;

import randomize.Randomness;

/**
 * This class represents a treasure factory.
 */

public class TreasureFactory {

  private Randomness randomness;

  /**
   * A constructor for the treasure.TreasureFactory.
   */

  public TreasureFactory() {
    this.randomness = new Randomness();
  }

  /**
   * A constructor for the treasure.TreasureFactory with a random seed.
   * @param randomness the random object.
   */

  public TreasureFactory(Randomness randomness) {
    this.randomness = randomness;
  }

  /**
   * A method that gets a treasure at random.
   * @return a treasure.
   */

  public Treasure getTreasure() {
    int randomValue = randomness.generateValueBetween(1, 3);
    if (randomValue == 1) {
      return Treasure.DIAMOND;
    }

    else if (randomValue == 2) {
      return Treasure.RUBY;
    }

    return Treasure.SAPPHIRE;
  }
}
