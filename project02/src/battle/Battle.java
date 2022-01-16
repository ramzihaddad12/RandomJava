package battle;

import gear.Gear;
import randomize.Randomness;
import weapon.WeaponFactory;

import java.util.List;

/**
 * This class represents a battle where 2 players fight in turn based manner
 * until one emerges victorious.
 */

public class Battle implements IBattle {
  private IPlayer player1;
  private IPlayer player2;
  private IBagOfEquipment bagOfEquipment;
  private boolean isPlayer1Turn;
  private boolean isBattleOver;
  private IPlayer winner;
  private WeaponFactory weaponFactory;
  private Randomness randomness;
  private int initialHealthForPlayer1 = 0;
  private int initialHealthForPlayer2 = 0;
  private final List<Gear> bag;

  /**
   * A constructor for the Battle class.
   * @param player1 the first player entering the battle
   * @param player2 the second player entering the battle
   */

  public Battle(IPlayer player1, IPlayer player2) {
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
    this.bag = bagOfEquipment.getBag();
  }

  /**
   * A constructor for the Battle class.
   * @param player1 the first player entering the battle
   * @param player2 the second player entering the battle
   * @param seed random seed
   */

  public Battle(IPlayer player1, IPlayer player2, int seed) {
    this.player1 = player1;
    this.player2 = player2;
    this.bagOfEquipment = new BagOfEquipment(seed);
    this.isPlayer1Turn = player1.getCharisma() >= player2.getCharisma();
    this.isBattleOver = false;
    this.winner = null;
    this.weaponFactory = new WeaponFactory(seed);
    this.randomness = new Randomness(seed);
    this.initialHealthForPlayer1 = player1.getHealth();
    this.initialHealthForPlayer2 = player2.getHealth();
    this.bag = bagOfEquipment.getBag();
  }

  /**
   * A constructor for the Battle class.
   * @param player1 the first player entering the battle
   * @param player2 the second player entering the battle
   * @param randomness randomness object
   */

  public Battle(IPlayer player1, IPlayer player2, Randomness randomness) {
    this.player1 = player1;
    this.player2 = player2;
    this.bagOfEquipment = new BagOfEquipment(randomness);
    this.isPlayer1Turn = player1.getCharisma() >= player2.getCharisma();
    this.isBattleOver = false;
    this.winner = null;
    this.weaponFactory = new WeaponFactory(randomness);
    this.randomness = randomness;
    this.initialHealthForPlayer1 = player1.getHealth();
    this.initialHealthForPlayer2 = player2.getHealth();
    this.bag = bagOfEquipment.getBag();
  }

  @Override
  public void equipGears() {
    if (isBattleOver) {
      throw new IllegalArgumentException("Battle is over");
    }
    equipGearsForPlayer(player1);
    equipGearsForPlayer(player2);
  }

  private void equipGearsForPlayer(IPlayer player) {
    int numberOfGearsWithPlayer = 0;
    while (numberOfGearsWithPlayer < 20) {
      int index = randomness.generateValueBetween(0, bag.size() - 1);
      numberOfGearsWithPlayer += equipPlayerHelper(player, index);
    }
  }

  @Override
  public void equipWeapons() {
    if (isBattleOver) {
      throw new IllegalArgumentException("Battle is over");
    }
    equipWeaponForPlayer(player1);
    equipWeaponForPlayer(player2);

    return;
  }

  private void equipWeaponForPlayer(IPlayer player) {
    try {
      player.equipWeapon(weaponFactory.getWeapon("weapon 1"));
      player.equipWeapon(weaponFactory.getWeapon("weapon 2"));

    }
    catch (IllegalArgumentException e) {
      return;
    }
    return;
  }

  private int equipPlayerHelper(IPlayer player, int index) {
    try {
      player.equipGear(bag.get(index));
      bag.remove(index);
      bagOfEquipment.remove(index);
      return 1;
    }
    catch (IllegalArgumentException e) {
      return 0;
    }
  }

  @Override
  public String getPlayer1Description() {
    return player1.getDescription();
  }

  @Override
  public String getPlayer2Description() {
    return player2.getDescription();
  }

  @Override
  public IBagOfEquipment getBagOfEquipment() {
    IBagOfEquipment copy = new BagOfEquipment(bagOfEquipment);
    return copy;
  }

  private void attackHelper(IPlayer attackingPlayer, IPlayer defendingPlayer) {
    if (isBattleOver) {
      throw new IllegalArgumentException("Battle is over");
    }
    if (attackingPlayer.getStrikingPower() > defendingPlayer.getAvoidanceAbility()) {
      int potentialStrikingDamage = attackingPlayer.getPotentialStrikingDamage();
      int actualDamage = potentialStrikingDamage - defendingPlayer.getConstitution();
      if (actualDamage > 0) {
        if (defendingPlayer.getHealth() - actualDamage <= 0) {

          isBattleOver = true;
          defendingPlayer.setHealth(0);
          return;
        }
        defendingPlayer.setHealth(defendingPlayer.getHealth() - actualDamage);

        if (defendingPlayer.isDead()) {
          isBattleOver = true;
        }
      }
    }
    attackingPlayer.update();
  }

  @Override
  public void attack() {
    if (isBattleOver) {
      throw new IllegalArgumentException("Battle is over. ");
    }

    if (isPlayer1Turn) {
      attackHelper(player1, player2);
      if (isBattleOver) {
        winner = player1;
      }
    }

    else {
      attackHelper(player2, player1);
      if (isBattleOver) {
        winner = player2;
      }
    }
    isPlayer1Turn = !isPlayer1Turn;
  }

  @Override
  public String getWinner() {
    if (!isBattleOver) {
      return null;
    }

    return winner.getName();
  }

  @Override
  public void rematch() {
    if (!isBattleOver) {
      throw new IllegalArgumentException("Game is still in progress. Can't request rematch");
    }
    isBattleOver = false;
    player1.setHealth(initialHealthForPlayer1);
    player2.setHealth(initialHealthForPlayer2);
    isPlayer1Turn = player1.getDexterity() >= player2.getDexterity();
    winner = null;
  }

  @Override
  public int getHealthOfPlayer1() {
    return player1.getHealth();
  }

  @Override
  public int getHealthOfPlayer2() {
    return player2.getHealth();
  }

  @Override
  public String whoseTurnIsIt() {
    if (isPlayer1Turn) {
      return player1.getName();
    }

    return player2.getName();
  }
}
