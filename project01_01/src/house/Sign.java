package house;

import animal.Size;

/**
 * A sign represents a placard for an animal, based on
 * its name, size, and favorite food.
 */
public class Sign {
  private final String name;
  private final Size size;
  private final String favFood;

  /**
   * Constructs a sign in terms of the namesex, weight, and favorite food.
   *
   * @param name    the name of the monkey
   * @param size    the size of the monkey
   * @param favFood the favorite food of the monkey
   */
  public Sign(String name, Size size, String favFood) {
    this.name = name;
    this.size = size;
    this.favFood = favFood;
  }

  /**
   * Coverts the sign to string.
   */

  public String toString() {
    return String.format("%s's size is %s and its favorite food is %s",
            name, size.toString(), favFood);
  }

  public String getName() {
    return name;
  }

  public Size getSize() {
    return size;
  }

  public String getFavFood() {
    return favFood;
  }
}
