package animal;

/**
 * Sizes of the animal.
 * {@link #SMALL}
 * {@link #MEDIUM}
 * {@link #LARGE}
 */
public enum Size {
  /**
   * Small size.
   */

  SMALL(1, 100),

  /**
   * Medium size.
   */

  MEDIUM(5, 250),

  /**
   * Large size.
   */

  LARGE(10, 500);

  private final int area;
  private final int foodPortion;

  /**
   * Constructs a size in terms of the area and food portion.
   *
   * @param area        the area occupied in m^2
   * @param foodPortion the food portion needed
   */
  Size(int area, int foodPortion) {
    this.area = area;
    this.foodPortion = foodPortion;
  }

  /**
   * Get the area based on the size.
   *
   * @return the area
   */
  public int getArea() {
    return area;
  }

  /**
   * Get the food portion in grams based on the size.
   *
   * @return the food portion in g
   */

  public int getFoodPortion() {
    return foodPortion;
  }
}
