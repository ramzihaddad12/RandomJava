import java.io.InputStreamReader;

import javax.swing.*;

import dungeon.Dungeon;
import dungeon.DungeonGraphicView;
import dungeon.DungeonSwingController;
import dungeon.IDungeonController;
import dungeon.IView;
import dungeon.InputBox;
import randomize.MockRandomnessForUnwrappedWithMonsters;
import randomize.Randomness;

public class Main2 {
  /**
   * The method that displays a run of the game.
   * @param args the possible arguments needed.
   */

  public static void main(String[] args) {
    try {
//      int rows = Integer.parseInt(args[0]);
//      int columns = Integer.parseInt(args[1]);
//      int interconnectivity = Integer.parseInt(args[2]);
//      boolean wrapped = Boolean.parseBoolean(args[3]);
//      int percentage = Integer.parseInt(args[4]);
//      int numOfMonsters = Integer.parseInt(args[5]);

//      Dungeon dungeon = new Dungeon(interconnectivity, "player",
//              wrapped, rows, columns, percentage, numOfMonsters, new Randomness());

      InputBox frame = new InputBox();

      int rows = getInput(frame, "What is the number of rows desired for your dungeon? ");
      int columns = getInput(frame, "What is the number of columns desired for your dungeon? ");
      int inteconnectivity = getInput(frame, "What is the interconnectivity desired for your dungeon? ");
      int percentage = getInput(frame, "What is the the percentage of caves with treasure desired for your dungeon? ");
      int numOfMonsters = getInput(frame, "What is the the number of monsters desired for your dungeon? ");
      int input = JOptionPane.showConfirmDialog(null,
              "Wrapping of the dungeon?", "Select an Option...",JOptionPane.YES_NO_OPTION);
      Dungeon dungeon = new Dungeon(inteconnectivity, "player",
              input == 0, rows, columns, percentage, numOfMonsters, new Randomness());
//
//      Readable input = new InputStreamReader(System.in);
//      Appendable output = System.out;
//      new DungeonSwingController(dungeon).playGame(dungeon);


      IView view = new DungeonGraphicView(dungeon);
      IDungeonController controller = new DungeonSwingController(dungeon,view);
      controller.playGame();
    }

    catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }

  private static int getInput(InputBox frame, String displayMessage) {
    boolean gotValidRows = false;
    Integer rows = null;
    while (!gotValidRows) {
      String string = JOptionPane.showInputDialog(frame, displayMessage, 0);
      try {
        rows = Integer.parseInt(string);
        gotValidRows = true;
      }
      catch (NumberFormatException e) {
        gotValidRows = false;
      }

    }
    return rows;
  }

  private static boolean getInputForBoolean(InputBox frame, String displayMessage) {
    boolean gotValidRows = false;
    Boolean getBool = null;
    while (!gotValidRows) {
      String string = JOptionPane.showInputDialog(frame, displayMessage, 0);
      try {
        getBool = Boolean.parseBoolean(string);
        gotValidRows = true;
      }
      catch (NumberFormatException e) {
        gotValidRows = false;
      }

    }
    return getBool;
  }
}
