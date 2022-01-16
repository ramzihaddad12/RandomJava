package gear;

/**
 * This class represents belt helper singleton class that
 * returns an instance of Belt.
 */

public class BeltHelper {
  private static Belt instance = null;

  private BeltHelper() {
  }

  /**
   * A method that returns the only instance of the Belt.
   * @return the only instance of Belt
   */

  public static Belt getInstance() {
    if (instance == null) {
      instance = new Belt("");
    }
    return instance;
  }
}
