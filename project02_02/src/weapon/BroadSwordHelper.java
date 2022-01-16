package weapon;

/**
 * This class represents BroadSword helper singleton class that
 * returns an instance of BroadSword.
 */

public class BroadSwordHelper {
  private static BroadSword instance = null;

  private BroadSwordHelper() {
  }

  /**
   * A method that returns the only instance of the BroadSword.
   * @return the only instance of BroadSword
   */

  public static BroadSword getInstance() {
    if (instance == null) {
      instance = new BroadSword("");
    }
    return instance;
  }
}
