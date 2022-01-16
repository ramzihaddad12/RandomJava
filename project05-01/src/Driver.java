import controller.DungeonController;
import controller.DungeonSwingController;
import controller.GuiController;
import model.Dungeon;
import randomize.Randomness;
import view.DungeonGraphicView;
import view.IView;

import java.io.InputStreamReader;

/**
 * A driver class that allows the user to play the game
 * in either GUI mode (if no args supplied) or in
 * console-based mode if the arguments of the dungeon are supplied.
 */

public class Driver {

  /**
   * The method that displays a run of the game.
   * If no arguments are supplied, then the game will run in GUI mode.
   * @param args the possible arguments needed.
   *
   */

  public static void main(String[] args) {
    try {

      if (args == null || args.length == 0) {
        IView view = new DungeonGraphicView();
        GuiController controller = new DungeonSwingController(view);
        controller.playGame();
      }

      else {
        int rows = Integer.parseInt(args[0]);
        int columns = Integer.parseInt(args[1]);
        int interconnectivity = Integer.parseInt(args[2]);
        boolean wrapped = Boolean.parseBoolean(args[3]);
        int percentage = Integer.parseInt(args[4]);
        int numOfMonsters = Integer.parseInt(args[5]);
        int numOfPits = Integer.parseInt(args[6]);

        Dungeon dungeon = new Dungeon(interconnectivity, "player",
                wrapped, rows, columns, percentage, numOfMonsters, numOfPits, new Randomness());

        Readable input = new InputStreamReader(System.in);
        Appendable output = System.out;
        new DungeonController(output, input).playGame(dungeon);
      }
    }

    catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }
}
