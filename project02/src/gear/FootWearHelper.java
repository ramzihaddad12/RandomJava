package gear;

/**
 * This class represents Footwear helper singleton class that
 * returns an instance of Footwear.
 */

public class FootWearHelper {
  private static Footwear instance = null;

  private FootWearHelper() {
  }

  /**
   * A method that returns the only instance of the Footwear.
   * @return the only instance of Footwear
   */

  public static Footwear getInstance() {
    if (instance == null) {
      instance = new Footwear("");
    }
    return instance;
  }
}
