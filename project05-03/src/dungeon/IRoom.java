package dungeon;

import treasure.Treasure;

import java.util.List;
import java.util.Map;

/**
 * An interface that represents a room in the dungeon.
 */

public interface IRoom {

  /**
   * Gets the treasures present in the room.
   * @return the list of treasures present in the room.
   */

  public List<Treasure> getTreasures();

  /**
   * Removes all the treasures present in the room.
   */


  public void removeAllTreasures();

  /**
   * Gets a description of the room which includes
   * information about the treasure in the room and
   * the possible moves from that room.
   * @return a description of the room.
   */

  public String getDescription();

  /**
   * Adds a list of treasures to the room.
   * @param treasuresToAdd the treasures to be added.
   */

  public void addTreasures(List<Treasure> treasuresToAdd);

  /**
   * Gets the possible next locations/rooms from the current room.
   * @return a map of rooms possible to go to from the current room along
   *          with the direction needed to go to those rooms.
   */

  public Map<Direction, IRoom> getNextRooms();

  /**
   * Checks if the room is a tunnel or not.
   * @return if the room is a tunnel or not.
   */

  public boolean isTunnel();

  /**
   * Gets the position of the room in the dungeon.
   * @return the position of the room in the dungeon based on the x, y coordinates.
   */

  public int[] getPosition();


  /**
   * Connects the room with another room.
   * @param direction the direction from this room to other room
   * @param otherRoom the room to connect with
   */
  public void connect(Direction direction, IRoom otherRoom);

  /**
   * Gets the position of the room in the dungeon.
   * @return the position of the room in the dungeon based on the x, y coordinates.
   */

  public int getNumberOfEntrances();

  /**
   * Gets the number of arrows present in the room.
   * @return the number of arrows present in the room.
   */

  public int getNumberOfArrows();

  /**
   * Removes all the arrows present in the room.
   */

  public void removeAllArrows();

  /**
   * Adds a number of arrows to the room.
   * @param numOfArrowsToAdd the number of arrows to be added.
   */

  public void addArrows(int numOfArrowsToAdd);

  /**
   * Removes the monster from the room, meaning the
   * monster has been killed.
   */

  public void removeMonster();

  /**
   * Adds a monster to the room.
   */

  public void addMonster();


  /**
   * Checks whether the room has a monster in it.
   * @return whether the room has a monster in it.
   */

  public boolean hasAMonster();


  /**
   * Hits the monster in the room by lowering its health.
   */

  public void hitMonster();

  /**
   * Gets the health of the monster in the room if there is one.
   */

  public Health getMonsterHealth();


  /**
   * Gets the monster in the room if it exists.
   * @return the monster in the room if it exists.
   */

  public Monster getMonster();

  //TODO
  public boolean roomHasTreasure();

  public boolean roomHasArrow();
}
