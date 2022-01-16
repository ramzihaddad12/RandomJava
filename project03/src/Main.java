import dungeon.Direction;
import dungeon.Dungeon;
import dungeon.IDungeon;
import randomize.Randomness;

import java.util.Arrays;
import java.util.Stack;

/**
 * A main class that displays going from start
 * to end in a wrapped dungeon with visiting all rooms.
 */

public class Main {

  /**
   * The method that displays a run of the game.
   * @param args the possible arguments needed.
   */

  public static void main(String[] args) {
    int rows = Integer.parseInt(args[0]);
    int columns = Integer.parseInt(args[1]);

    int interconnectivity = Integer.parseInt(args[2]);

    boolean wrapped = Boolean.parseBoolean(args[3]);

    int percentage = Integer.parseInt(args[4]); //todo

    Dungeon dungeon = new Dungeon(interconnectivity, "player",
            wrapped, rows, columns, percentage, new Randomness());
    System.out.println("The player's starting position is: " + Arrays.toString(dungeon.getStart()));
    System.out.println("The player's ending position is: " + Arrays.toString(dungeon.getEnd()));
    System.out.println(dungeon.toString());

    dfs(dungeon.getStart(), dungeon.getEnd(), dungeon, rows, columns);
  }

  private static int[] goWest(IDungeon dungeon, int[] currPosition) {
    dungeon.movePlayer(Direction.WEST);
    System.out.println("Moved west");
    printing(dungeon);
    int nextX = currPosition[0] ;
    int nextY = currPosition[1] - 1;
    return new int[] {nextX, nextY};
  }

  private static int[] goSouth(IDungeon dungeon, int[] currPosition) {
    dungeon.movePlayer(Direction.SOUTH);
    System.out.println("Moved south");
    printing(dungeon);
    int nextX = currPosition[0] + 1;
    int nextY = currPosition[1];
    return new int[] {nextX, nextY};
  }

  private static int[] goEast(IDungeon dungeon, int[] currPosition) {
    dungeon.movePlayer(Direction.EAST);
    System.out.println("Moved east");
    printing(dungeon);
    int nextX = currPosition[0];
    int nextY = currPosition[1] + 1;
    return new int[] {nextX, nextY};
  }

  private static int[] goNorth(IDungeon dungeon, int[] currPosition) {
    dungeon.movePlayer(Direction.NORTH);
    System.out.println("Moved north");
    printing(dungeon);
    int nextX = currPosition[0] - 1;
    int nextY = currPosition[1];
    return new int[] {nextX, nextY};
  }

  private static void dfs(int[] start, int[] end, IDungeon dungeon, int rows, int columns) {
    Stack<int[]> stack = new Stack<>();
    stack.add(start);
    Direction oppositeDirection = null;

    int moves = 0;
    while (!stack.isEmpty() && moves < 50) {
      int[] currPosition = stack.pop();
      String str = dungeon.currentRoomDescription();

      if (str.contains("1 sapphires") || str.contains("1 diamonds") || str.contains("1 rubies")) {
        System.out.println("There is treasure here! Picking up treasure...");
        dungeon.pickUpTreasure();
        System.out.println("Description of player becomes: " + dungeon.getPlayerDescription());
        System.out.println("Description of current room becomes: "
                + dungeon.currentRoomDescription());
      }
      int nextX;
      int nextY;
      System.out.println("*************");
      System.out.println();

      if (oppositeDirection == null) {
        if (str.contains("<-") ) {
          oppositeDirection = Direction.EAST;
          int[] next = goWest(dungeon, currPosition);
          nextX = next[0];
          nextY = next[1];
        }

        else if (str.contains("v")) {
          oppositeDirection = Direction.NORTH;
          int[] next = goSouth(dungeon, currPosition);
          nextX = next[0];
          nextY = next[1];
        }

        else if (str.contains("->")) {
          oppositeDirection = Direction.WEST;
          int[] next = goEast(dungeon, currPosition);
          nextX = next[0];
          nextY = next[1];
        }

        else if (str.contains("^")) {
          oppositeDirection = Direction.SOUTH;
          int[] next = goNorth(dungeon, currPosition);
          nextX = next[0];
          nextY = next[1];
        }

        else {
          nextX = currPosition[0];
          nextY = currPosition[1];
        }

      }

      else {
        if (str.contains("<-") && !oppositeDirection.equals(Direction.WEST)) {
          oppositeDirection = Direction.EAST;
          int[] next = goWest(dungeon, currPosition);
          nextX = next[0];
          nextY = next[1];
        }

        else if (str.contains("v") && !oppositeDirection.equals(Direction.SOUTH)) {
          oppositeDirection = Direction.NORTH;
          int[] next = goSouth(dungeon, currPosition);
          nextX = next[0];
          nextY = next[1];
        }

        else if (str.contains("->") && !oppositeDirection.equals(Direction.EAST)) {
          oppositeDirection = Direction.WEST;
          int[] next = goEast(dungeon, currPosition);
          nextX = next[0];
          nextY = next[1];
        }

        else if (str.contains("^") && !oppositeDirection.equals(Direction.NORTH)) {
          oppositeDirection = Direction.SOUTH;
          int[] next = goNorth(dungeon, currPosition);
          nextX = next[0];
          nextY = next[1];
        }

        else {
          if (oppositeDirection.equals(Direction.WEST)) {
            oppositeDirection = Direction.EAST;
            int[] next = goWest(dungeon, currPosition);
            nextX = next[0];
            nextY = next[1];
          }

          else if (oppositeDirection.equals(Direction.SOUTH)) {
            oppositeDirection = Direction.NORTH;
            int[] next = goSouth(dungeon, currPosition);
            nextX = next[0];
            nextY = next[1];
          }

          else if (oppositeDirection.equals(Direction.EAST)) {
            oppositeDirection = Direction.WEST;
            int[] next = goEast(dungeon, currPosition);
            nextX = next[0];
            nextY = next[1];
          }

          else {
            oppositeDirection = Direction.SOUTH;
            int[] next = goNorth(dungeon, currPosition);
            nextX = next[0];
            nextY = next[1];
          }

        }
      }

      if (nextX == rows) {
        nextX = 0;
      }

      else if (nextX == -1) {
        nextX = rows - 1;
      }

      if (nextY == columns) {
        nextY = 0;
      }

      else if (nextY == -1) {
        nextY = columns - 1;
      }

      if (nextX == end[0] && nextY == end[1]) {
        return;
      }

      stack.push(new int[] {nextX, nextY});
      moves++;

    }

    return;

  }

  private static boolean printing(IDungeon dungeon) {
    System.out.println("Description of player: " + dungeon.getPlayerDescription());
    System.out.println("Description of current room: " + dungeon.currentRoomDescription());
    System.out.println("Is the current room a tunnel: " + dungeon.isCurrentRoomTunnel());
    System.out.println("Is the player at the end position: " + dungeon.isAtEnd());
    if (dungeon.isAtEnd()) {
      System.out.println("AT ENDDDDDD");
      return true;
    }
    return false;
  }
}
