package dungeon;

import treasure.Treasure;

import java.util.List;

/**
 * An interface that represents a player in the dungeon.
 */

public interface IPlayer {

  /**
   * Gets the position or room the player is currently in.
   * @return The room where the player is located in.
   */

  public IRoom getPosition();

  /**
   * Gets a description of player which includes
   * information about the treasure possessed by the player and
   * his/her location.
   * @return a description of the player.
   */

  public String getDescription();

  /**
   * Gets the treasures possessed by the player.
   * @return a list of treasures possessed by the player.
   */

  public List<Treasure> getTreasures();

  /**
   * Gets the name of the player.
   * @return the name of the player.
   */

  public String getName();

  /**
   * Moves the player from his/her current location to another one
   * based on the given direction.
   * @param direction the direction of the move to be made.
   */

  public void move(Direction direction);

  /**
   * Picks up the treasure located in the room
   * the player is currently in.
   * @return whether there were arrows to pick up.
   */

  public boolean pickUpTreasure();

  /**
   * Gets the number of arrows the player has.
   * @return the number of arrows the player has.
   */

  public int getNumOfArrows();

  /**
   * Picks up the arrows located in the room
   * the player is currently in.
   * @return whether there were arrows to pick up.
   */

  public boolean pickUpArrows();

  /**
   * Shoots one of the arrows.
   */

  public void shoot();

  /**
   * Gets the smell of the room.
   * @return the smell of the room.
   */

  public Smell getSmell();
}
