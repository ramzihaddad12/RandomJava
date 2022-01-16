package controller;

import randomize.Randomness;

import java.awt.event.KeyEvent;

/**
 * A GUIController that communicates with a Graphical view
 * to display the dungeon.
 */
public interface GuiController {

  /**
   * Execute a single game of the dungeon game.
   */
  void playGame();

  /**
   * Handles the cell click given the row and column of the click
   * from the view.
   * @param row the row location of the click.
   * @param col the column location of the click.
   */
  void handleCellClick(int row, int col);

  /**
   * Handles a keyboard event given the key event
   * from the view.
   * @param e the key event that occurred.
   */
  void handleKey(KeyEvent e);

  /**
   * Instantiates the model needed to communicate with.
   * @param rows the number of rows of the dungeon.
   * @param columns the number of columns of the dungeon.
   * @param interconnectivity the interconnectivity of the dungeon.
   * @param percentage the percentage of caves with treasure in the dungeon.
   * @param numOfMonsters the number of monsters in the dungeon.
   * @param wrapping whether the dungeon is wrapping or not.
   */
  void instantiateModel(int rows, int columns, int interconnectivity,
                        int percentage, int numOfMonsters, int wrapping, int numOfPits,
                        Randomness randomness);

  /**
   * Restarts the game with the same exact dungeon.
   */

  void restartingWithSameModel();
}
