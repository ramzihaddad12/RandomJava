package animal;

/**
 * A specific breed or species of a monkey called SquirrelMonkey.
 */
public class SquirrelMonkey implements Species {
  private static SquirrelMonkey singleInstance = null;

  private SquirrelMonkey() {
  }

  /**
   * Gets the instance of SquirrelMonkey.
   *
   * @return the only instance of SquirrelMonkey
   */

  public static SquirrelMonkey getInstance() {
    if (singleInstance == null) {
      singleInstance = new SquirrelMonkey();
    }

    return singleInstance;
  }

  @Override
  public String toString() {
    return "SquirrelMonkey";
  }
}
