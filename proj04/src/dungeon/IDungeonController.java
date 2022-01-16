package dungeon;

/**
 * Represents a Controller for Dungeon: handle user moves by executing them using the model;
 * convey move outcomes to the user in some form.
 */

public interface IDungeonController {

  /**
   * Execute a single game of the dungeon game given a dungeon Model. When the game is over,
   * the playGame method ends.
   *
   * @param m a non-null dungeon Model
   */
  void playGame(IDungeon m);
}
