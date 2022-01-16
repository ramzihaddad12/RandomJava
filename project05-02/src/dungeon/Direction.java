package dungeon;

/**
 * An enum class that represents the possible directions to move.
 */

public enum Direction {
  NORTH, EAST, SOUTH, WEST;

  /**
   * Gets the opposite direction of a given direction.
   * @return the opposite direction of the given direction.
   */

  public Direction getOppositeDirection() {
    if (this.equals(Direction.EAST)) {
      return Direction.WEST;

    }

    if (this.equals(Direction.WEST)) {
      return Direction.EAST;

    }

    if (this.equals(Direction.NORTH)) {
      return Direction.SOUTH;

    }

    else {
      return Direction.NORTH;
    }
  }
}
