package randomize;

import java.util.Random;

/**
 * This class represents Randomness which involves creating
 * random variables.
 */

public class Randomness {

  private final Random random;

  /**
   * A constructor for Randomness.
   */

  public Randomness() {
    this.random = new Random();
  }

  /**
   * A method that generates a random integer between
   * two integers.
   * @param min minimum of range
   * @param max maximum of range
   * @return the generated random integer
   */

  public int generateValueBetween(int min, int max) {
    return min + random.nextInt(max - min + 1);
  }
}
