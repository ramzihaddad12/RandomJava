package animal;

/**
 * A specific breed or species of a monkey called Howler.
 */
public class Howler implements Species {

  private static Howler singleInstance = null;

  private Howler() {
  }

  /**
   * Gets the instance of Howler.
   *
   * @return the only instance of Howler
   */

  public static Howler getInstance() {
    if (singleInstance == null) {
      singleInstance = new Howler();
    }

    return singleInstance;
  }

  @Override
  public String toString() {
    return "Howler";
  }
}
