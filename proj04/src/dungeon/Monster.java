package dungeon;

/**
 * This interface represents a monster in the dungeon.
 */
public interface Monster {

  /**
   * Gets the health of the monster.
   * @return the health of the monster.
   */
  public Health getHealth();

  /**
   * Decreases the health of the monster.
   */
  public void decreaseHealth();


}
