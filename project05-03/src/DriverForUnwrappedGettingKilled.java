import dungeon.Dungeon;
//import dungeon.DungeonController;
import dungeon.DungeonController;
import dungeon.IDungeonController;
import randomize.MockRandomnessForUnwrappedWithMonsters;

import java.io.StringReader;

/**
 * A driver class that displays going from start
 * to end in an unwrapped dungeon without visiting all rooms.
 */

public class DriverForUnwrappedGettingKilled {
  /**
   * The method that displays a run of the game.
   * @param args the possible arguments needed.
   */

  public static void main(String[] args) {
    StringReader input = new StringReader("S W 2 M W M W");
    Appendable output = new StringBuilder();

    Dungeon dungeon = new Dungeon(2, "Ben", false, 6, 8,
            20,4, new MockRandomnessForUnwrappedWithMonsters());

    IDungeonController controller = new DungeonController(output, input);
    controller.playGame(dungeon);
  }
}
