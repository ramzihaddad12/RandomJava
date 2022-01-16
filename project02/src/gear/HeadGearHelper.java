package gear;

/**
 * This class represents belt helper singleton class that
 * returns an instance of Headgear.
 */

public class HeadGearHelper {

  private static Headgear instance = null;

  private HeadGearHelper() {
  }

  /**
   * A method that returns the only instance of the Headgear.
   * @return the only instance of Headgear
   */

  public static Headgear getInstance() {
    if (instance == null) {
      instance = new Headgear("");
    }
    return instance;
  }
}
