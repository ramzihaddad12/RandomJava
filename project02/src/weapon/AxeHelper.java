package weapon;

/**
 * This class represents Axe helper singleton class that
 * returns an instance of Axe.
 */

public class AxeHelper {
  private static Axe instance = null;

  private AxeHelper() {
  }

  /**
   * A method that returns the only instance of the Axe.
   * @return the only instance of Axe
   */

  public static Axe getInstance() {
    if (instance == null) {
      instance = new Axe("");
    }
    return instance;
  }
}
