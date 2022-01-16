package gear;

/**
 * This class represents Potion helper singleton class that
 * returns an instance of Potion.
 */

public class PotionHelper {
  private static Potion instance = null;

  private PotionHelper() {
  }

  /**
   * A method that returns the only instance of the Potion.
   * @return the only instance of Potion
   */

  public static Potion getInstance() {
    if (instance == null) {
      instance = new Potion("");
    }
    return instance;
  }
}
