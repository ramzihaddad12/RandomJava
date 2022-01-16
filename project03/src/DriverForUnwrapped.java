import dungeon.Direction;
import dungeon.Dungeon;
import randomize.MockRandomnessForUnwrapped;

import java.util.Arrays;

/**
 * A driver class that displays going from start
 * to end in an unwrapped dungeon without visiting all rooms.
 */

public class DriverForUnwrapped {
  /**
   * The method that displays a run of the game.
   * @param args the possible arguments needed.
   */

  public static void main(String[] args) {

    Dungeon dungeon = new Dungeon(2, "player", false, 6, 8, 20, new MockRandomnessForUnwrapped());

    System.out.println(dungeon.toString());
    System.out.println("The player's starting position is: " + Arrays.toString(dungeon.getStart()));
    System.out.println("The player's ending position is: " + Arrays.toString(dungeon.getEnd()));

    System.out.println("*************");
    System.out.println();
    dungeon.movePlayer(Direction.NORTH);
    System.out.println("Moved north");
    System.out.println("Description of player: " + dungeon.getPlayerDescription());
    System.out.println("Description of current room: " + dungeon.currentRoomDescription());
    System.out.println("Is the current room a tunnel: " + dungeon.isCurrentRoomTunnel());
    System.out.println("Is the player at the end position: " + dungeon.isAtEnd());

    System.out.println("*************");
    System.out.println();
    dungeon.movePlayer(Direction.NORTH);
    System.out.println("Moved north");
    System.out.println("Description of player: " + dungeon.getPlayerDescription());
    System.out.println("Description of current room: " + dungeon.currentRoomDescription());
    System.out.println("Is the current room a tunnel: " + dungeon.isCurrentRoomTunnel());
    System.out.println("Is the player at the end position: " + dungeon.isAtEnd());

    System.out.println("*************");
    System.out.println();
    dungeon.movePlayer(Direction.WEST);
    System.out.println("Moved west");
    System.out.println("Description of player: " + dungeon.getPlayerDescription());
    System.out.println("Description of current room: " + dungeon.currentRoomDescription());
    System.out.println("Is the current room a tunnel: " + dungeon.isCurrentRoomTunnel());
    System.out.println("Is the player at the end position: " + dungeon.isAtEnd());

    System.out.println("*************");
    System.out.println();
    dungeon.movePlayer(Direction.NORTH);
    System.out.println("Moved north");
    System.out.println("Description of player: " + dungeon.getPlayerDescription());
    System.out.println("Description of current room: " + dungeon.currentRoomDescription());
    System.out.println("There is treasure here! Picking up treasure...");
    dungeon.pickUpTreasure();
    System.out.println("Description of player becomes: " + dungeon.getPlayerDescription());
    System.out.println("Description of current room becomes: " + dungeon.currentRoomDescription());
    System.out.println("Is the current room a tunnel: " + dungeon.isCurrentRoomTunnel());
    System.out.println("Is the player at the end position: " + dungeon.isAtEnd());

    System.out.println("*************");
    System.out.println();
    dungeon.movePlayer(Direction.SOUTH);
    System.out.println("Moved south");
    System.out.println("Description of player: " + dungeon.getPlayerDescription());
    System.out.println("Description of current room: " + dungeon.currentRoomDescription());
    System.out.println("Is the current room a tunnel: " + dungeon.isCurrentRoomTunnel());
    System.out.println("Is the player at the end position: " + dungeon.isAtEnd());

    System.out.println("*************");
    System.out.println();
    dungeon.movePlayer(Direction.WEST);
    System.out.println("Moved west");
    System.out.println("Description of player: " + dungeon.getPlayerDescription());
    System.out.println("Description of current room: " + dungeon.currentRoomDescription());
    System.out.println("Is the current room a tunnel: " + dungeon.isCurrentRoomTunnel());
    System.out.println("Is the player at the end position: " + dungeon.isAtEnd());

    System.out.println("*************");
    System.out.println();
    dungeon.movePlayer(Direction.NORTH);
    System.out.println("Moved north");
    System.out.println("Description of player: " + dungeon.getPlayerDescription());
    System.out.println("Description of current room: " + dungeon.currentRoomDescription());
    System.out.println("Is the current room a tunnel: " + dungeon.isCurrentRoomTunnel());
    System.out.println("Is the player at the end position: " + dungeon.isAtEnd());

    System.out.println("*************");
    System.out.println();
    dungeon.movePlayer(Direction.WEST);
    System.out.println("Moved west");
    System.out.println("Description of player: " + dungeon.getPlayerDescription());
    System.out.println("Description of current room: " + dungeon.currentRoomDescription());
    System.out.println("Is the current room a tunnel: " + dungeon.isCurrentRoomTunnel());
    System.out.println("Is the player at the end position: " + dungeon.isAtEnd());

    System.out.println("*************");
    System.out.println();
    dungeon.movePlayer(Direction.WEST);
    System.out.println("Moved west");
    System.out.println("Description of player: " + dungeon.getPlayerDescription());
    System.out.println("Description of current room: " + dungeon.currentRoomDescription());
    System.out.println("Is the current room a tunnel: " + dungeon.isCurrentRoomTunnel());
    System.out.println("Is the player at the end position: " + dungeon.isAtEnd());



    System.out.println("*************");
    System.out.println();
    System.out.println("Player has reached end! Hurray!");
  }
}
