package dungeon;

import treasure.Treasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A class the implements the dungeon.IPlayer interface
 * and represents a player in the dungeon.
 */

public class Player implements IPlayer {

  private String name;
  private List<Treasure> treauresCollected;
  private IRoom room;

  /**
   * A constructor for the player.
   * @param name the name of the player.
   * @param room the room the player is in.
   */
  public Player(String name, IRoom room) {
    this.name = name;
    this.room = room;
    this.treauresCollected = new ArrayList<>();
  }

  @Override
  public IRoom getPosition() {
    return new Room(this.room);
  }

  @Override
  public String getDescription() {
    return String.format("%s is in room %s which is at row %d,"
                    + " column %d. Player has %d sapphires, %d diamonds, %d rubies",
            name, room.toString(),
            room.getPosition()[0],
            room.getPosition()[1],
            treauresCollected.stream().filter(t -> t.equals(Treasure.SAPPHIRE)).toArray().length,
            treauresCollected.stream().filter(t -> t.equals(Treasure.DIAMOND)).toArray().length,
            treauresCollected.stream().filter(t -> t.equals(Treasure.RUBY)).toArray().length);
  }

  @Override
  public List<Treasure> getTreasures() {
    return new ArrayList<>(treauresCollected);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void move(Direction direction) {
    Map<Direction, IRoom> possibleNextRooms = room.getNextRooms();

    if (!possibleNextRooms.containsKey(direction)) {
      throw new IllegalArgumentException("Impossible to move to that direction!");
    }

    else {
      this.room = possibleNextRooms.get(direction);
    }
  }

  @Override
  public void pickUpTreasure() {
    this.treauresCollected.addAll(this.room.getTreasures());
    this.room.removeAllTreasures();
  }
}
