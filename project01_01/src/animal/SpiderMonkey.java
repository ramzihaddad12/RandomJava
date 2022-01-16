package animal;

/**
 * A specific breed or species of a monkey called SpiderMonkey.
 */
public class SpiderMonkey implements Species {
  private static SpiderMonkey singleInstance = null;

  private SpiderMonkey() {
  }

  /**
   * Gets the instance of SpiderMonkey.
   *
   * @return the only instance of SpiderMonkey
   */

  public static SpiderMonkey getInstance() {
    if (singleInstance == null) {
      singleInstance = new SpiderMonkey();
    }

    return singleInstance;
  }

  @Override
  public String toString() {
    return "SpiderMonkey";
  }
}
