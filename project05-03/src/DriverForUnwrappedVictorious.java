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

public class DriverForUnwrappedVictorious {
  /**
   * The method that displays a run of the game.
   * @param args the possible arguments needed.
   */

  public static void main(String[] args) {

    StringReader input = new StringReader("M W M S"
            + " P arrow"
            + " M W M W M W M W "
            + "M E"
            + " M N"
            + " M W "
            + "P arrow "
            + "M N M E M N"
            + " S N 1 S N 1 "
            + "M N "
            + "S W 1 S W 1"
            + " M W M S M N M E M N M W M E M S P arrow M E M E M S M W P arrow P treasure "
            + "M E M N M N M W P arrow M E M S M W M W P arrow M S M S M E M S M N M E"
            + " M E M E M S S W 2 S W 2 M W M W P treasure M E M E M S M E P arrow M E"
            + " M E M N P treasure M S M W M N M N M E P arrow M W P arrow M N M W M W M E M E M E"
            + " M N M N M W M W M W M S M E M W M N M E M E P treasure S S 1 S S 1 M S P arrow");

    Appendable output = new StringBuilder();
    Dungeon dungeon = new Dungeon(2, "Ben", false, 6, 8,
            20,4, new MockRandomnessForUnwrappedWithMonsters());

    IDungeonController controller = new DungeonController(output, input);
    controller.playGame(dungeon);
    System.out.println(output);
  }
}
