package battle;



import gear.Belt;
import gear.BeltHelper;
import gear.FootWearHelper;
import gear.Footwear;
import gear.Gear;
import gear.HeadGearHelper;
import gear.Headgear;
import gear.Potion;
import gear.PotionHelper;
import randomize.Randomness;
import weapon.AxeHelper;
import weapon.BroadSwordHelper;
import weapon.FlailHelper;
import weapon.KatanaHelper;
import weapon.TwoHandedSwordHelper;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * This class represents a player that can be equipped
 * with gear and weapons.
 */

public class Player {
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  private int health;
  private int numOfTurns;

  private Gear headGear;
  private int lifeSpanOfHeadGear;

  List<List<Integer>> listForPotions;
  List<Gear> potions;

  private List<List<Integer>> listForBelts;
  List<Gear> belts;
  private final int maxUnitsOfBelts = 10;

  private Gear footWear;
  private int lifeSpanOfFootWear;

  private List<Weapon> weapons;
  private int[] damageRange;

  private Randomness randomness;

  /**
   * A constructor for the Player class.
   * @param strength the strength of the player (should be between 6 and 18)
   * @param constitution the constitution of the player (should be between 6 and 18)
   * @param dexterity the dexterity of the player (should be between 6 and 18)
   * @param charisma the charisma of the player (should be between 6 and 18)
   */

  public Player(int strength, int constitution, int dexterity, int charisma) {

    if (strength < 6 || strength > 18 || constitution < 6 || constitution > 18
            || dexterity < 6 || dexterity > 18 || charisma < 6 || charisma > 18) {
      throw new IllegalArgumentException("Inputs should be between 8 and 18");
    }
    this.strength = strength;
    this.constitution = constitution;
    this.dexterity = dexterity;
    this.charisma = charisma;
    this.health = strength + constitution + dexterity + charisma;
    this.numOfTurns = 0;
    this.headGear = null;
    this.lifeSpanOfHeadGear = 0;
    this.listForPotions = new ArrayList<>();
    this.potions = new ArrayList<>();
    this.listForBelts = new ArrayList<>();
    this.belts = new ArrayList<>();
    this.footWear = null;
    this.lifeSpanOfFootWear = 0;
    this.weapons = new ArrayList<>();
    this.damageRange = new int[2];
    this.randomness = new Randomness();
  }

  /**
   * A constructor for the Player class.
   * @param strength the strength of the player (should be between 6 and 18)
   * @param constitution the constitution of the player (should be between 6 and 18)
   * @param dexterity the dexterity of the player (should be between 6 and 18)
   * @param charisma the charisma of the player (should be between 6 and 18)
   * @param seed the random seed
   */

  public Player(int strength, int constitution, int dexterity, int charisma, int seed) {
    this(strength,constitution, dexterity, charisma);
    this.randomness = new Randomness(seed);
  }

  /**
   * A copy constructor for the Player making a copy of a given
   * Player.
   * @param player the Player to be copied
   */

  public Player(Player player) {
    new Player(player.getStrength(), player.getConstitution(), player.getDexterity(), player.getCharisma());
  }

  /**
   * A method that gets strength of the player.
   * @return the strength of the player
   */

  public int getStrength() {
    return strength;
  }

  /**
   * A method that gets constitution of the player.
   * @return the constitution of the player
   */

  public int getConstitution() {
    return constitution;
  }

  /**
   * A method that gets dexterity of the player.
   * @return the dexterity of the player
   */

  public int getDexterity() {
    return dexterity;
  }

  /**
   * A method that gets charisma of the player.
   * @return the charisma of the player
   */

  public int getCharisma() {
    return charisma;
  }

  /**
   * A method that gets health of the player.
   * @return the health of the player
   */

  public int getHealth() {
    return health;
  }

  /**
   * A method that gets the total belt units of the player.
   * @return the total belt units of the player
   */

  public int getTotalBeltUnits() {
    int totalBeltUnits = 0;
    for (Gear gear: belts) {
      totalBeltUnits += gear.getNumberOfUnits();
    }
    return totalBeltUnits;
  }

  /**
   * A method that gets headgear equipped by the player.
   * @return the headgear equipped by the player
   */

  public Headgear getHeadGear() {
    return new Headgear(headGear);
  }

  /**
   * A method that gets the potions equipped by the player.
   * @return the potions equipped by the player
   */

  public List<Gear> getPotions() {
    return new ArrayList<>(potions);
  }

  /**
   * A method that gets the belts equipped by the player.
   * @return the belts equipped by the player
   */

  public List<Gear> getBelts() {
    return new ArrayList<>(belts);
  }

  /**
   * A method that gets the footwear equipped by the player.
   * @return the footwear equipped by the player
   */

  public Gear getFootWear() {
    return new Footwear(footWear);
  }

  /**
   * A method that gets the weapon(s) equipped by the player.
   * @return the weapon(s) equipped by the player
   */

  public List<Weapon> getWeapons() {
    return weapons;
  }

  /**
   * A method that updates the abilities of the player.
   */

  public void update() {
    numOfTurns++;
    updateHeadGear();
    updateFootWear();
    updatePotion();
    updateBelts();
  }

  private void removeEffectHelper(List<List<Integer>> listOfGear, List<Gear> gears) {
    for (int index = 0; index < listOfGear.size(); index++) {
      List<Integer> gear = listOfGear.get(index);
      int lifeSpan = gear.get(0);
      int gearValue = gear.get(1);
      if (lifeSpan == numOfTurns) {
        for (int pointer = 2; pointer < gear.size(); pointer++) {
          int i = gear.get(pointer);
          affectAbilityHelper(-gearValue, i);
        }
        listOfGear.remove(index);
        gears.remove(index);
      }
    }
  }

  private void updateBelts() {
    removeEffectHelper(listForBelts, belts);
  }

  private void updatePotion() {
    removeEffectHelper(listForPotions, potions);
  }

  private void updateFootWear() {
    if (footWear != null && numOfTurns >= lifeSpanOfFootWear) {
      this.dexterity -= footWear.getValue();
    }
  }

  private void updateHeadGear() {
    if (headGear != null && numOfTurns >= lifeSpanOfHeadGear) {
      this.constitution -= headGear.getValue();
    }
  }

  /**
   * A method that equips a gear for the player.
   * @param gear the gear to be equipped by the player
   */

  public void equipGear(Gear gear) {
    if (gear == null) {
      throw new IllegalArgumentException("Null values not supported");
    }

    if (gear.checkIfType(HeadGearHelper.getInstance())) {
      equipHeadGear(gear);
    }

    else if (gear.checkIfType(PotionHelper.getInstance())) {
      equipPotion(gear);
    }

    else if (gear.checkIfType(BeltHelper.getInstance())) {
      equipBelt(gear);
    }

    else if (gear.checkIfType(FootWearHelper.getInstance())) {
      equipFootwear(gear);
    }
  }

  private void equipFootwear(Gear gear) {
    if (footWear != null) {
      throw new IllegalArgumentException("battle.Player already wearing footwear");
    }
    affectAbilityHelper(gear.getValue(), 3);
    footWear = gear;
    lifeSpanOfFootWear = numOfTurns + gear.getLifespan();
  }

  private void equipBelt(Gear gear) {
    (Belt) gear
    //TODO: check
    if (maxUnitsOfBelts - getTotalBeltUnits() < gear.getNumberOfUnits()) {
      throw new IllegalArgumentException("No more capacity to wear belt");
    }

    boolean affectsTwoAttributes = randomness.generateBoolean();
    List<Integer> beltList = new ArrayList<>();
    beltList.add(gear.getLifespan());
    beltList.add(gear.getValue());

    if (affectsTwoAttributes) {
      int[] indices = affectAnyTwoAbilities(gear);
      beltList.add(indices[0]);
      beltList.add(indices[1]);
    }

    else {
      int index = affectAnyAbility(gear);
      beltList.add(index);
    }

    //TODO: Pass by value
    belts.add(gear);
    listForBelts.add(beltList);
  }

  private void equipPotion(Gear gear) {
    int index = affectAnyAbility(gear);
    listForPotions.add(Arrays.asList(numOfTurns + gear.getLifespan(), gear.getValue(), index));
    potions.add(new Potion(gear));
  }

  private void equipHeadGear(Gear gear) {
    if (headGear != null) {
      throw new IllegalArgumentException("battle.Player already wearing headgear");
    }
    affectAbilityHelper(gear.getValue(), 2);
    headGear = gear;
    lifeSpanOfHeadGear = numOfTurns + gear.getLifespan();
  }

  private void affectAbilityHelper(int value, int index) {
    if (index < 1 || index > 4) {
      throw new IllegalArgumentException("Index must be between 1 and 4 (inclusive");
    }

    if (index == 1) {
      if (strength + value < 0) {
        throw new IllegalArgumentException("Can't equip gear, attribute will become below 0");
      }
      this.strength += value;
    }

    else if (index == 2) {
      if (constitution + value < 0) {
        throw new IllegalArgumentException("Can't equip gear, attribute will become below 0");
      }
      this.constitution += value;
    }

    else if (index == 3) {
      if (dexterity + value < 0) {
        throw new IllegalArgumentException("Can't equip gear, attribute will become below 0");
      }
      this.dexterity += value;
    }

    else if (index == 4) {
      if (charisma + value < 0) {
        throw new IllegalArgumentException("Can't equip gear, attribute will become below 0");
      }
      this.charisma += value;
    }
  }

  private int affectAnyAbility(Gear gear) {
    int min = 1;
    int max = 4;
    int index = randomness.generateValueBetween(min, max);
    affectAbilityHelper(gear.getValue(), index);
    return index;
  }

  private int[] affectAnyTwoAbilities(Gear gear) {
    //https://stackoverflow.com/questions/22584244/how-to-generate-6-different-random-numbers-in-java
    int[] indices = new Random().ints(1, 5).distinct().limit(2).toArray();
    affectAbilityHelper(gear.getValue(), indices[0]);
    affectAbilityHelper(gear.getValue(), indices[1]);
    return indices;
  }

  /**
   * A method that equips a weapon for the player.
   * @param weapon the weapon to be equipped by the player
   */

  public void equipWeapon(Weapon weapon) {
    if (weapon == null) {
      throw new IllegalArgumentException("Null values not supported");
    }

    if (weapons.size() == 1 && (weapons.get(0).checkIfType(AxeHelper.getInstance())
            || weapons.get(0).checkIfType(FlailHelper.getInstance())
            || weapons.get(0).checkIfType(BroadSwordHelper.getInstance())
            || weapons.get(0).checkIfType(TwoHandedSwordHelper.getInstance()))) {
      throw new IllegalArgumentException("Already equipped with weapon");
    }

    if (weapons.size() == 2) {
      throw new IllegalArgumentException("Already equipped with weapon");
    }

    if (weapons.size() == 1 && weapons.get(0).checkIfType(KatanaHelper.getInstance())
            && !weapon.checkIfType(KatanaHelper.getInstance())) {
      throw new IllegalArgumentException("Already equipped with weapon");
    }

    this.weapons.add(weapon);
    this.damageRange = weapon.getRange();
//    if (weapon.checkIfType(weapon.AxeHelper.getInstance())) {
//      this.weapons.add(weapon);
//      this.damageRange = weapon.getRange();
//    }
//
//    else if (weapon.checkIfType(weapon.FlailHelper.getInstance())){
//      this.weapons.add(weapon);
//      this.damageRange = weapon.getRange();
//    }
//
//    else if (weapon.checkIfType(weapon.TwoHandedSwordHelper.getInstance())){
//      this.weapons.add(weapon);
//      this.damageRange = weapon.getRange();
//    }
//
//    else if (weapon.checkIfType(weapon.BroadSwordHelper.getInstance())){
//      this.weapons.add(weapon);
//      this.damageRange = weapon.getRange();
//    }
//
//    else if (weapon.checkIfType(weapon.KatanaHelper.getInstance())){
//      this.weapons.add(weapon);
//      this.damageRange = weapon.getRange();
//    }
  }

  /**
   * A method that gets the striking power of the player.
   * @return the striking power of the player
   */

  public int getStrikingPower() {
    int min = 1;
    int max = 10;
    int strikingPower = strength + randomness.generateValueBetween(min, max);
    return strikingPower;
  }

  /**
   * A method that gets the avoidance ability of the player.
   * @return the avoidance ability of the player
   */

  public int getAvoidanceAbility() {
    int min = 1;
    int max = 6;
    int avoidanceAbility = dexterity + randomness.generateValueBetween(min, max);
    return avoidanceAbility;
  }

  /**
   * A method that sets the health of the player.
   * @param newHealth the new health of the player
   */

  public void setHealth(int newHealth) {
    if (newHealth < 0) {
      throw new IllegalArgumentException("Health cannot be negative");
    }
    this.health = newHealth;
  }

  /**
   * A method that gets the potential striking damage of the player.
   * @return the potential striking damage of the player
   */

  public int getPotentialStrikingDamage() {
    int randomValue = randomness.generateValueBetween(damageRange[0], damageRange[1]);;

    if (weapons.isEmpty() || weapons.get(0) == null) {
      return strength;
    }

    if (weapons.get(0) .checkIfType(weapon.FlailHelper.getInstance()) && dexterity < 14) {
      randomValue = randomness.generateValueBetween(damageRange[0] / 2, damageRange[1] / 2);
    }

    else if (weapons.get(0).checkIfType(weapon.TwoHandedSwordHelper.getInstance()) || strength < 14) {
      randomValue = randomness.generateValueBetween(damageRange[0] / 2, damageRange[1] / 2);
    }

    int potentialStrikingDamage = strength + randomValue;
    return potentialStrikingDamage;
  }


  /**
   * A method that checks if the player is dead.
   * @return whether the player is dead or not
   */

  public boolean isDead() {
    return this.health <= 0;
  }

  //TODO: complete
  @Override
  public String toString() {
    return String.format("The player has a strength of %d, a constitution of %d, a dexterity of %d, and a charisma of %d. The player is carrying ",
             getStrength(), getConstitution(), getDexterity(), getCharisma());
  }
}
