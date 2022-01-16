package battle;

import randomize.Randomness;
import weapon.WeaponFactory;

/**
 * This class represents a battle where 2 players fight in turn based manner
 * until one emerges victorious.
 */

public class Battle {
  private Player player1;
  private Player player2;
  private BagOfEquipment bagOfEquipment;
  private boolean isPlayer1Turn;
  private boolean isBattleOver;
  private Player winner;
  private WeaponFactory weaponFactory;
  private Randomness randomness;
  private int initialHealthForPlayer1 = 0;
  private int initialHealthForPlayer2 = 0;

  /**
   * A constructor for the Battle class.
   * @param player1 the first player entering the battle
   * @param player2 the second player entering the battle
   */

  public Battle(Player player1, Player player2) {
    this.player1 = player1;
    this.player2 = player2;
    this.bagOfEquipment = new BagOfEquipment();
    this.isPlayer1Turn = player1.getCharisma() >= player2.getCharisma();
    this.isBattleOver = false;
    this.winner = null;
    this.weaponFactory = new WeaponFactory();
    this.randomness = new Randomness();
    this.initialHealthForPlayer1 = player1.getHealth();
    this.initialHealthForPlayer2 = player2.getHealth();
  }

  /**
   * A constructor for the Battle class.
   * @param player1 the first player entering the battle
   * @param player2 the second player entering the battle
   * @param seed random seed
   */

  public Battle(Player player1, Player player2, int seed) {
    this.player1 = player1;
    this.player2 = player2;
    this.bagOfEquipment = new BagOfEquipment();
    this.isPlayer1Turn = player1.getCharisma() >= player2.getCharisma();
    this.isBattleOver = false;
    this.winner = null;
    this.weaponFactory = new WeaponFactory();
    this.randomness = new Randomness(seed);
  }

  /**
   * A method that equips gears from the bag of equipment for a player.
   * @param player the player to be equipped
   */

  public void equipGears(Player player) {
    int numberOfGearsWithPlayer = 0;
    while (numberOfGearsWithPlayer < 20) {
      int index = randomness.generateValueBetween(0, bagOfEquipment.getBag().size() - 1);
      numberOfGearsWithPlayer += equipPlayerHelper(player, index);
    }
  }

  /**
   * A method that equips a weapon for a player.
   * @param player the player to be equipped
   */

  public void equipWeapon(Player player) {
    player.equipWeapon(weaponFactory.getWeapon(""));

    try {
      player.equipWeapon(weaponFactory.getWeapon(""));
    }
    catch (IllegalArgumentException e) {
      //TODO:HOW
    }
  }

  private int equipPlayerHelper(Player player, int index) {
    try {
      player.equipGear(bagOfEquipment.getBag().get(index));
      bagOfEquipment.remove(index);
      return 1;
    }
    catch (IllegalArgumentException e) {
      System.out.println("Can't get item");
      return 0;
    }
  }

  /**
   * A method that gets the first player.
   * @return the first player
   */

  public Player getPlayer1() {
    return new Player(player1);
  }

  /**
   * A method that gets the second player.
   * @return the second player
   */

  public Player getPlayer2() {
    return new Player(player2);
  }

  /**
   * A method that gets the bag of equipment present
   * in the battle arena.
   * @return the bag of equipment
   */

  public BagOfEquipment getBagOfEquipment() {
    return new BagOfEquipment(bagOfEquipment);
  }

  /**
   * A method where a given attacking player attacks a given defending player.
   * @param attackingPlayer the attacking player
   * @param defendingPlayer the defending player
   */

  private void attack(Player attackingPlayer, Player defendingPlayer) {
    if (isBattleOver) {
      throw new IllegalArgumentException("Game is over dead");
    }
    System.out.println(attackingPlayer.getStrikingPower());
    if (attackingPlayer.getStrikingPower() > defendingPlayer.getAvoidanceAbility()) {
      int potentialStrikingDamage = attackingPlayer.getPotentialStrikingDamage();
      int actualDamage = potentialStrikingDamage - defendingPlayer.getConstitution();
      if (actualDamage > 0) {
        defendingPlayer.setHealth(defendingPlayer.getHealth() - actualDamage);

        if (defendingPlayer.isDead()) {
          isBattleOver = true;
        }
      }
    }
    attackingPlayer.update();
  }

  public void player1Attacks() {
    if (!isPlayer1Turn){
      throw new IllegalArgumentException("It is player 2's turn now!");
    }
    attack(player1, player2);
    if (isBattleOver) {
      winner = player1;
    }
  }

  public void player2Attacks() {
    if (isPlayer1Turn){
      throw new IllegalArgumentException("It is player 1's turn now!");
    }
    attack(player2, player1);
    if (isBattleOver) {
      winner = player2;
    }
  }

  public Player getWinner() {
    if (!isBattleOver) {
      return null;
    }

    return new Player(winner);
  }

  public void rematch() {
    if (!isBattleOver) {
      throw new IllegalArgumentException("Game is still in progress. Can't request rematch");
    }
    isBattleOver = false;
    player1.setHealth(initialHealthForPlayer1);
    player2.setHealth(initialHealthForPlayer2);
    isPlayer1Turn = player1.getDexterity() >= player2.getDexterity();
  }
}
