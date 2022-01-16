package battle;


import gear.Gear;
import gear.Headgear;
import weapon.Weapon;

import java.util.List;

/**
 * This interface represents a player that can be equipped
 * with gear and weapons. A player has different abilities.
 */

public interface IPlayer {
  /**
   * A method that gets strength of the player.
   * @return the strength of the player
   */

  public int getStrength();

  /**
   * A method that gets constitution of the player.
   * @return the constitution of the player
   */

  public int getConstitution();

  /**
   * A method that gets dexterity of the player.
   * @return the dexterity of the player
   */

  public int getDexterity();

  /**
   * A method that gets charisma of the player.
   * @return the charisma of the player
   */

  public int getCharisma();

  /**
   * A method that gets health of the player.
   * @return the health of the player
   */

  public int getHealth();

  /**
   * A method that gets the total belt units of the player.
   * @return the total belt units of the player
   */

  public int getTotalBeltUnits();

  /**
   * A method that gets headgear equipped by the player.
   * @return the headgear equipped by the player
   */

  public Headgear getHeadGear();

  /**
   * A method that gets the potions equipped by the player.
   * @return the potions equipped by the player
   */

  public List<Gear> getPotions();

  /**
   * A method that gets the belts equipped by the player.
   * @return the belts equipped by the player
   */

  public List<Gear> getBelts();

  /**
   * A method that gets the footwear equipped by the player.
   * @return the footwear equipped by the player
   */

  public Gear getFootWear();

  /**
   * A method that gets the weapon(s) equipped by the player.
   * @return the weapon(s) equipped by the player
   */

  public List<Weapon> getWeapons();

  /**
   * A method that gets the name of the player.
   * @return the name of the player
   */
  public String getName();

  /**
   * A method that updates the abilities of the player.
   */

  public void update();

  /**
   * A method that equips a gear for the player.
   * @param gear the gear to be equipped by the player
   */

  public void equipGear(Gear gear);

  /**
   * A method that equips a weapon for the player.
   * @param weapon the weapon to be equipped by the player
   */

  public void equipWeapon(Weapon weapon);

  /**
   * A method that gets a description player
   * which includes information about the gear and weapon equipped.
   * @return  the description of the player
   */

  public String getDescription();

  /**
   * A method that gets the striking power of the player.
   * @return the striking power of the player
   */

  public int getStrikingPower();

  /**
   * A method that gets the avoidance ability of the player.
   * @return the avoidance ability of the player
   */

  public int getAvoidanceAbility();

  /**
   * A method that sets the health of the player.
   * @param newHealth the new health of the player
   */

  public void setHealth(int newHealth);

  /**
   * A method that gets the potential striking damage of the player.
   * @return the potential striking damage of the player
   */

  public int getPotentialStrikingDamage();


  /**
   * A method that checks if the player is dead.
   * @return whether the player is dead or not
   */

  public boolean isDead();
}
