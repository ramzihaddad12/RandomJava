package dungeon;

/**
 * An interface that represents a dungeon
 * which is made up of connected tunnels and caves.
 */

public interface IDungeon {

  /**
   * Gets the x and y coordinates of the player
   * in the dungeon.
   *
   * @return the location of the player in the dungeon.
   */

  public int[] getPlayerLocation();


  /**
   * Determines whether the current room the player is in is a tunnel or not.
   * @return whether the current room the player is in is a tunnel or not.
   */

  public boolean isCurrentRoomTunnel();

  /**
   * Gets a description of the current room the player is in which includes
   * information about the treasure in the room and
   * the possible moves from that room.
   * @return a description of the room.
   */

  public String currentRoomDescription();

  /**
   * Moves the player in the dungeon given a direction.
   *
   * @param direction the direction to move.
   */

  public void movePlayer(Direction direction);

  /**
   * Makes the player in the dungeon pick up
   * the treasure from the room he/she is currently
   * at.
   *
   */

  public void pickUpTreasure();

  /**
   * Checks if the player in the dungeon has reached the final
   * destination.
   *
   * @return whether the player has reached the final destination.
   */

  public boolean isAtEnd();

  /**
   * Gets the start position of the player in the dungeon.
   * @return the start position of the player in the dungeon.
   */

  public int[] getStart();

  /**
   * Gets the end position of the player in the dungeon.
   * @return the end position of the player in the dungeon.
   */

  public int[] getEnd();

  /**
   * Gets a description of player which includes
   * information about the treasure possessed by the player and
   * his/her location.
   * @return a description of the player.
   */

  public String getPlayerDescription();

  /**
   * Gets a description of all rooms which includes
   * information about the treasure in the room and
   * the possible moves from that room.
   * @return a description of all rooms.
   */

  public String getRoomsDescription();

  /**
   * Gets the number of rows in the dungeon.
   * @return the number of rows in the dungeon.
   */

  public int getRows();

  /**
   * Gets the number of columns in the dungeon.
   * @return the number of columns in the dungeon.
   */

  public int getColumns();

  /**
   * Gets the interconnectivity of the dungeon.
   * @return the interconnectivity og the dungeon.
   */

  public int getInterConnectivity();

  /**
   * Gets whether the dungeon is wrapped or not.
   * @return whether the dungeon is wrapped or not.
   */

  public boolean isWrapped();

  /**
   * Gets the name of the player in the dungeon.
   * @return the name of the player in the dungeon.
   */

  public String getPlayerName();
}
