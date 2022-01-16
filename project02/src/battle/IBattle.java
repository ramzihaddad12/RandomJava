package battle;

/**
 * This interface represents a battle where 2 players fight in turn based manner
 * until one emerges victorious.
 */

public interface IBattle {
  /**
   * A method that equips gears from the bag of equipment for both players.
   */

  public void equipGears();

  /**
   * A method that equips a weapon for both players.
   */

  public void equipWeapons();

  /**
   * A method where the player whose turn it is, attacks.
   */

  public void attack();

  /**
   * A method that gets the first player.
   * @return the first player
   */

  public String getPlayer1Description();

  /**
   * A method that gets the second player.
   * @return the second player
   */

  public String getPlayer2Description();

  /**
   * A method that gets the bag of equipment present
   * in the battle arena.
   * @return the bag of equipment
   */

  public IBagOfEquipment getBagOfEquipment();

  /**
   * A method that returns the winner player.
   * @return the winning player
   */

  public String getWinner();

  /**
   * A method that restarts the battle.
   */

  public void rematch();

  /**
   * A method that gets health of player 1.
   * @return the health of player 1
   */

  public int getHealthOfPlayer1();

  /**
   * A method that gets health of player 2.
   * @return the health of player 2
   */

  public int getHealthOfPlayer2();

  /**
   * A method that determines whose turn it is.
   * @return the name of the player whose turn it is
   */

  public String whoseTurnIsIt();
}
