package weapon;

/**
 * This class represents Flail helper singleton class that
 * returns an instance of Flail.
 */

public class FlailHelper {
  private static Flail instance = null;

  private FlailHelper() {
  }

  /**
   * A method that returns the only instance of the Flail.
   * @return the only instance of Flail
   */

  public static Flail getInstance() {
    if (instance == null) {
      instance = new Flail("");
    }
    return instance;
  }
}
