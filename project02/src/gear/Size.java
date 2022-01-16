package gear;

/**
 * This enum class represents the different sizes
 * available for the belt sizes.
 */

public enum Size {
  DEFAULT(0),
  SMALL(1),
  MEDIUM(2),
  LARGE(4);

  private final int units;

  /**
   * A constructor for the BeltSize taking in the units.
   * @param units the units corresponding to the belt size
   */

  Size(int units) {
    this.units = units;
  }

  /**
   * A method that get the units for a belt size.
   * @return  the units for a belt size
   */

  public int getUnits() {
    return units;
  }
}
