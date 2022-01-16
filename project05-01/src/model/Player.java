package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A class the implements the IPlayer interface
 * and represents a player in the dungeon that is able
 * to roam around, and becomes victorious when
 * he/she reaches the end of the dungeon.
 */

public class Player implements IPlayer {

  private String name;
  private List<Treasure> treauresCollected;
  private IRoom room;
  private int numOfArrows;
  private Smell smell;

  /**
   * A constructor for the player.
   * @param name the name of the player.
   * @param room the room the player is in.
   */
  public Player(String name, IRoom room) {

    if (room == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }

    this.name = name;
    this.room = room;
    this.treauresCollected = new ArrayList<>();
    this.numOfArrows = 3;
    this.smell = null;
  }

  /**
   * A copy constructor for the player.
   * @param player the player object to be copied.
   */
  public Player(Player player) {
    if (player == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    this.name = player.name;
    this.room = player.room;
    this.treauresCollected = player.treauresCollected;
    this.numOfArrows = player.getNumOfArrows();
    this.smell = player.getSmell();
  }

  @Override
  public IRoom getPosition() {
    return new Room(this.room);
  }

  @Override
  public String getDescription() {
    return String.format("%s is in room %s which is at row %d,"
                    + " column %d. The room is a tunnel : %s. "
                    + "Player has %d sapphires, %d diamonds, %d rubies, and %d arrows"
                    + ". The player smells a %s"
                    + ". The player is in danger of falling: %s",
            name, room.toString(),
            room.getPosition()[0],
            room.getPosition()[1],
            room.isTunnel(),
            treauresCollected.stream().filter(t -> t.equals(Treasure.SAPPHIRE)).toArray().length,
            treauresCollected.stream().filter(t -> t.equals(Treasure.DIAMOND)).toArray().length,
            treauresCollected.stream().filter(t -> t.equals(Treasure.RUBY)).toArray().length,
            numOfArrows,
            getSmell().toString(),
            isInDanger());
  }

  @Override
  public List<Treasure> getTreasures() {
    return new ArrayList<>(treauresCollected);
  }

  @Override
  public String getName() {
    return new String(name);
  }

  @Override
  public void move(Direction direction) {
    if (direction == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }

    Map<Direction, IRoom> possibleNextRooms = room.getNextRooms();

    if (!possibleNextRooms.containsKey(direction)) {
      throw new IllegalArgumentException("Impossible to move to that direction!");
    }

    else {
      this.room = possibleNextRooms.get(direction);
    }
  }

  @Override
  public boolean pickUpTreasure() {
    if (this.room.getTreasures().isEmpty()) {
      return false;
    }

    this.treauresCollected.addAll(this.room.getTreasures());
    this.room.removeAllTreasures();
    return true;
  }

  @Override
  public int getNumOfArrows() {
    return numOfArrows;
  }

  @Override
  public boolean pickUpArrows() {
    if (this.room.getNumberOfArrows() == 0) {
      return false;
    }
    this.numOfArrows += this.room.getNumberOfArrows();
    this.room.removeAllArrows();
    return true;
  }

  @Override
  public void shoot() {
    numOfArrows--;
  }

  private void getSmellHelper() {
    if (getPosition().hasAMonster()) {
      this.smell = Smell.VERY_PUNGENT;
      return;
    }

    List<IRoom> roomsFromLevel1 = new ArrayList<>();
    for (IRoom room : getPosition().getNextRooms().values()) {
      if (room.hasAMonster()) {
        this.smell = Smell.VERY_PUNGENT;
        return;
      }
      roomsFromLevel1.add(room);
    }

    int countOfMonsterNearby = 0;
    for (IRoom room : roomsFromLevel1) {
      for (IRoom nextRooms: room.getNextRooms().values()) {
        if (countOfMonsterNearby > 1) {
          this.smell = Smell.VERY_PUNGENT;
          return;
        }

        if (nextRooms.hasAMonster()) {
          countOfMonsterNearby++;
        }
      }

    }
    if (countOfMonsterNearby == 1) {
      this.smell = Smell.PUNGENT;
    }

    else {
      this.smell = Smell.NO_SMELL;
    }

    return;

  }

  @Override
  public Smell getSmell() {
    getSmellHelper();
    Smell copySmell = this.smell;
    return copySmell;
  }

  @Override
  public boolean isInDanger() {
    if (room.hasPit()) {
      return true;
    }

    for (IRoom nextRoom: room.getNextRooms().values()) {
      if (nextRoom.hasPit()) {
        return true;
      }
    }

    return false;
  }

  @Override
  public void removeAllTreasures() {
    this.treauresCollected.clear();
  }
}
