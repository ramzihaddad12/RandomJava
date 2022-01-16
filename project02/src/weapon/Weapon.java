package weapon;

/**
 * This interface represents a general weapon in the role playing game.
 */

public interface Weapon {

  /**
   * A method that checks if this weapon is the
   * same type of the other weapon.
   * @param other the other weapon in question
   * @return whether this weapon is the same type as the other weapon
   */

  public boolean checkIfType(Weapon other);

  /**
   * A method that gets the range of the
   * damage of the weapon.
   * @return the range of the damage of the weapon
   */

  public int[] getRange();

  /**
   * A method that gets the name of the weapon.
   * @return the name of the weapon
   */

  public String getName();
}
