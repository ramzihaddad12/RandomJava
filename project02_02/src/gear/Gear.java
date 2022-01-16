package gear;

/**
 * This interface represents a general gear in the role playing game.
 */

public interface Gear extends Comparable<Gear> {

  /**
   * A method that gets the name of the gear.
   * @return the name of the gear
   */

  public String getName();

  /**
   * A method that gets the gear value.
   * @return the value of the gear
   */

  public int getValue();

  /**
   * A method that gets the life span of the gear.
   * @return the life span of the gear
   */

  public int getLifespan();

  /**
   * A method that checks if this gear is the
   * same type of the other gear.
   * @param other the other gear in question
   * @return whether this gear is the same type as the other gear
   */

  public boolean checkIfType(Gear other);

  /**
   * A method that gets the number of units for the gear.
   * @return the number of units for the gear
   */

  public int getNumberOfUnits();
}
