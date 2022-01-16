package model;

/**
 * This interface represents a monster in the dungeon
 * that is able to eat the player if they are in the same
 * room. A monster either has full health or half health.
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
