import dungeon.Dungeon;
//import dungeon.DungeonController;
import dungeon.DungeonController;
import dungeon.IDungeonController;
import randomize.MockRandomnessForWrappedWithMonsters;

import java.io.StringReader;

/**
 * A driver class that displays going from start
 * to end in a wrapped dungeon without visiting all rooms.
 */

public class DriverForWrappedGettingKilled {

  /**
   * The method that displays a run of the game.
   * @param args the possible arguments needed.
   */

  public static void main(String[] args) {
    StringReader input = new StringReader("M S M N P arrow M W M E M N P arrow "
            + "M N M N M N P arrow M S M S M W M N M S M S M W "
            + "M S M W M E M N M N M W M S M N M N M E M N M W");

    Appendable output = new StringBuilder();
    Dungeon dungeon = new Dungeon(2, "Ben", true, 6, 8,
            20,4, new MockRandomnessForWrappedWithMonsters());

    IDungeonController controller = new DungeonController(output, input);
    controller.playGame(dungeon);
    System.out.println(output);
  }
}
