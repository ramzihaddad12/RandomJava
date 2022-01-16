import dungeon.Dungeon;
//import dungeon.DungeonController;
import dungeon.DungeonController;
import randomize.Randomness;

import java.io.InputStreamReader;

/**
 * A main class that allows the user to play the game
 * for an unwrapped dungeon.
 */

public class Main {

  /**
   * The method that displays a run of the game.
   * @param args the possible arguments needed.
   */

  public static void main(String[] args) {
    try {
      int rows = Integer.parseInt(args[0]);
      int columns = Integer.parseInt(args[1]);
      int interconnectivity = Integer.parseInt(args[2]);
      boolean wrapped = Boolean.parseBoolean(args[3]);
      int percentage = Integer.parseInt(args[4]);
      int numOfMonsters = Integer.parseInt(args[5]);

      Dungeon dungeon = new Dungeon(interconnectivity, "player",
              wrapped, rows, columns, percentage, numOfMonsters, new Randomness());

      Readable input = new InputStreamReader(System.in);
      Appendable output = System.out;
      new DungeonController(output, input).playGame(dungeon);
    }

    catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }
}
