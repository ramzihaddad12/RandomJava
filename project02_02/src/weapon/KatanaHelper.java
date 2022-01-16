package weapon;

/**
 * This class represents Katana helper singleton class that
 * returns an instance of Katana.
 */

public class KatanaHelper {
  private static Katana instance = null;

  private KatanaHelper() {
  }

  /**
   * A method that returns the only instance of the Katana.
   * @return the only instance of Katana
   */

  public static Katana getInstance() {
    if (instance == null) {
      instance = new Katana("");
    }
    return instance;
  }
}
