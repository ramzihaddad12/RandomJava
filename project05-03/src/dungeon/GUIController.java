package dungeon;

import java.awt.event.KeyEvent;

public interface GUIController {

  /**
   * Execute a single game of the dungeon game given a dungeon Model. When the game is over,
   * the playGame method ends.
   *
   */
  void playGame();

  void handleCellClick(int row, int col);

  void handleKey(KeyEvent e);

  void instantiateModel(int rows,int columns,int inteconnectivity,int percentage,int numOfMonsters,int input);

  void restartingWithSameModel();
}
