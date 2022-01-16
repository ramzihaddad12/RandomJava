package dungeon;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class SetupPanel extends JOptionPane {
  JOptionPane row;
  JOptionPane column;
  JOptionPane interconnectivity;
  JOptionPane percentage;
  JOptionPane numOfMonsters;
  JOptionPane wrapping;

  public SetupPanel() {
    InputBox frame = new InputBox();
    int rows = getInput(frame, "What is the number of rows desired for your dungeon? ");
    int columns = getInput(frame, "What is the number of columns desired for your dungeon? ");
    int interconnectivity = getInput(frame, "What is the interconnectivity desired for your dungeon? ");
    int percentage = getInput(frame, "What is the the percentage of caves with treasure desired for your dungeon? ");
    int numOfMonsters = getInput(frame, "What is the the number of monsters desired for your dungeon? ");
    int input = JOptionPane.showConfirmDialog(null,
            "Wrapping of the dungeon?", "Select an Option...",JOptionPane.YES_NO_OPTION);
//      this.controller.instantiateModel(rows, columns, interconnectivity, percentage, numOfMonsters, input);
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
        //TODO: TELL USER OF INVALIDITY
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
