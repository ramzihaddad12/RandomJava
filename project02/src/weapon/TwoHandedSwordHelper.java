package weapon;

/**
 * This class represents TwoHandedSword helper singleton class that
 * returns an instance of TwoHandedSword.
 */

public class TwoHandedSwordHelper {
  private static TwoHandedSword instance = null;

  private TwoHandedSwordHelper() {
  }

  /**
   * A method that returns the only instance of the TwoHandedSword.
   * @return the only instance of TwoHandedSword
   */

  public static TwoHandedSword getInstance() {
    if (instance == null) {
      instance = new TwoHandedSword("");
    }
    return instance;
  }
}
