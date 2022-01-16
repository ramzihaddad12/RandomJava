package dungeon;

import treasure.Treasure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that implements the dungeon.IRoom interface
 * and represents a room in the dungeon.
 * A room could be a cave or a tunnel.
 */

public class Room implements IRoom {
  private int numOfEntrances;
  private List<Treasure> treasures;
  private Map<Direction, IRoom> possibleNextLocations;
  private final int[] positionInDungeon;
  private int numOfArrows;
  private Monster monster;

  /**
   * A constructor for the dungeon.Room class based on the position only.
   * @param positionInDungeon the position of the room in the dungeon.
   */

  public Room(int[] positionInDungeon) {
    if (positionInDungeon.length != 2) {
      throw new IllegalArgumentException("Position should be an array with length 2");
    }

    if (positionInDungeon[0] < 0 || positionInDungeon[1] < 0) {
      throw new IllegalArgumentException("Position should be a positive value");
    }
    this.numOfEntrances = 0;
    this.treasures = new ArrayList<>();
    this.possibleNextLocations = new HashMap<>();
    this.positionInDungeon = positionInDungeon;
    this.numOfArrows = 0;
    this.monster = null;
  }

  /**
   * A copy constructor for the dungeon.Room class.
   * @param room the object of type dungeon.IRoom to be copied.
   */

  public Room(IRoom room) {
    this.numOfEntrances = room.getNumberOfEntrances();
    this.treasures = room.getTreasures();
    this.positionInDungeon = room.getPosition();
    this.numOfArrows = room.getNumberOfArrows();
    if (room.hasAMonster()) {
      this.monster = room.getMonster();
    }
    this.possibleNextLocations = new HashMap<>(room.getNextRooms());
    for (Direction dir: room.getNextRooms().keySet()) {
//      System.out.println(dir);
      this.possibleNextLocations.put(dir, room.getNextRooms().get(dir));
    }
  }

  @Override
  public List<Treasure> getTreasures() {
    return new ArrayList<>(treasures);
  }

  @Override
  public void removeAllTreasures() {
    this.treasures.clear();
  }

  @Override
  public String getDescription() {
    String str = String.format("The room is on row %d and column %d in the dungeon."
                    + " It has %d entrances, and has %d sapphires,"
                    + " %d diamonds, %d rubies, and %d arrows. "
                    + "The possible next locations are %s",
            this.positionInDungeon[0],
            this.positionInDungeon[1],
            this.numOfEntrances,
            treasures.stream().filter(t -> t.equals(Treasure.SAPPHIRE)).toArray().length,
            treasures.stream().filter(t -> t.equals(Treasure.DIAMOND)).toArray().length,
            treasures.stream().filter(t -> t.equals(Treasure.RUBY)).toArray().length,
            this.numOfArrows,
            this.toString());
    if (hasAMonster()) {
      StringBuilder stringBuilder = new StringBuilder(str);
      stringBuilder.append(String.format("There is a monster here with a health of %s",
              getMonsterHealth()));
      return stringBuilder.toString();
    }

    return str;
  }

  @Override
  public void addTreasures(List<Treasure> treasuresToAdd) {
    if (this.isTunnel()) {
      throw new IllegalArgumentException("Tunnels do not possess treasure");
    }

    for (Treasure treasure: treasuresToAdd) {
      treasures.add(treasure);
    }
  }

  @Override
  public Map<Direction, IRoom> getNextRooms() {
    return new HashMap<>(possibleNextLocations);
//    return possibleNextLocations;
  }

  @Override
  public boolean isTunnel() {
    return numOfEntrances == 2;
  }

  @Override
  public int[] getPosition() {
    return new int[] {positionInDungeon[0], positionInDungeon[1]};
  }

  @Override
  public void connect(Direction direction, IRoom otherRoom) {
    if (!possibleNextLocations.containsKey(direction)) {
      possibleNextLocations.put(direction, otherRoom);
      numOfEntrances++;
      return;
    }
  }

  @Override
  public int getNumberOfEntrances() {
    return this.numOfEntrances;
  }

  /**
   * String representation of a room where
   * ^ represents going north, v represents going south,
   * <- represents going west and -> represents going east.
   * @return the string representation of a room
   */

  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(");

    if (possibleNextLocations.containsKey(Direction.WEST)) {
      stringBuilder.append("<-");
    }

    if (possibleNextLocations.containsKey(Direction.NORTH)) {
      stringBuilder.append("^");
    }

    if (possibleNextLocations.containsKey(Direction.SOUTH)) {
      stringBuilder.append("v");
    }

    if (possibleNextLocations.containsKey(Direction.EAST)) {
      stringBuilder.append("->");
    }
    stringBuilder.append(")");

    return stringBuilder.toString();
  }

  @Override
  public int getNumberOfArrows() {
    return this.numOfArrows;
  }

  @Override
  public void removeAllArrows() {
    this.numOfArrows = 0;
  }

  @Override
  public void addArrows(int numOfArrowsToAdd) {
    if (numOfArrowsToAdd < 0) {
      throw new IllegalArgumentException("Negative number not allowed");
    }
    this.numOfArrows += numOfArrowsToAdd;
  }

  @Override
  public void removeMonster() {
    this.monster = null;
  }

  @Override
  public void addMonster() {
    if (this.isTunnel()) {
      throw new IllegalArgumentException("Cannot add a monster to a tunnel");
    }

    if (this.monster != null) {
      throw new IllegalStateException("There is already a monster in the room");
    }
    this.monster = new Otyugh();
  }

  @Override
  public boolean hasAMonster() {
    return this.monster != null;
  }

  @Override
  public void hitMonster() {
    if (!hasAMonster()) {
      throw new IllegalArgumentException("No monster here!");
    }

    this.monster.decreaseHealth();

    if (this.monster.getHealth().equals(Health.ZERO_HEALTH)) {
      removeMonster();
    }
  }

  @Override
  public Health getMonsterHealth() {
    if (!hasAMonster()) {
      throw new IllegalArgumentException("There is no monster here!");
    }

    Health copyHealth = this.monster.getHealth();
    return copyHealth;
  }

  @Override
  public Monster getMonster() {
    if (!hasAMonster()) {
      throw new IllegalArgumentException("No monster!");
    }

    return this.monster;
  }

  @Override
  public boolean roomHasTreasure() {
    return !this.getTreasures().isEmpty();
  }

  @Override
  public boolean roomHasArrow() {
    return this.getNumberOfArrows() != 0;

  }
}
