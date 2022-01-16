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
import weapon.Axe;
import weapon.AxeHelper;
import weapon.BroadSword;
import weapon.BroadSwordHelper;
import weapon.Flail;
import weapon.FlailHelper;
import weapon.Katana;
import weapon.KatanaHelper;
import weapon.TwoHandedSword;
import weapon.TwoHandedSwordHelper;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * This class represents a player that can be equipped
 * with gear and weapons.
 */

public class Player implements IPlayer {
  private String name;
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
  private int maxUnitsOfBelts;
  private int maxForAbilities;

  private Gear footWear;
  private int lifeSpanOfFootWear;

  private List<Weapon> weapons;
  private int[] damageRange;

  private Randomness randomness;

  private int randValueForAvoidanceAbility;
  private int randValueForStrikingPower;

  /**
   * A constructor for the Player class.
   * @param strength the strength of the player (should be between 6 and 18)
   * @param constitution the constitution of the player (should be between 6 and 18)
   * @param dexterity the dexterity of the player (should be between 6 and 18)
   * @param charisma the charisma of the player (should be between 6 and 18)
   */

  public Player(String name, int strength, int constitution, int dexterity, int charisma) {

    if (strength < 6 || strength > 18 || constitution < 6 || constitution > 18
            || dexterity < 6 || dexterity > 18 || charisma < 6 || charisma > 18) {
      throw new IllegalArgumentException("Inputs should be between 6 and 18");
    }
    this.name = name;
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
    this.randValueForAvoidanceAbility = randomness.generateValueBetween(1, 6);
    this.randValueForStrikingPower = randomness.generateValueBetween(1, 10);
    this.maxUnitsOfBelts = 10;
    this.maxForAbilities = 400;
  }

  /**
   * A constructor for the Player class.
   * @param strength the strength of the player (should be between 6 and 18)
   * @param constitution the constitution of the player (should be between 6 and 18)
   * @param dexterity the dexterity of the player (should be between 6 and 18)
   * @param charisma the charisma of the player (should be between 6 and 18)
   * @param seed the random seed
   */

  public Player(String name, int strength, int constitution,
                int dexterity, int charisma, int seed) {
    this(name, strength,constitution, dexterity, charisma);
    this.randomness = new Randomness(seed);
    this.randValueForAvoidanceAbility = randomness.generateValueBetween(1, 6);
    this.randValueForStrikingPower = randomness.generateValueBetween(1, 10);
  }

  /**
   * A constructor for the Player class.
   * @param strength the strength of the player (should be between 6 and 18)
   * @param constitution the constitution of the player (should be between 6 and 18)
   * @param dexterity the dexterity of the player (should be between 6 and 18)
   * @param charisma the charisma of the player (should be between 6 and 18)
   * @param rand the random object
   */

  public Player(String name, int strength, int constitution,
                int dexterity, int charisma, Randomness rand) {
    this(name, strength,constitution, dexterity, charisma);
    this.randomness = rand;
    this.randValueForAvoidanceAbility = randomness.generateValueBetween(1, 6);
    this.randValueForStrikingPower = randomness.generateValueBetween(1, 10);
  }

  /**
   * A copy constructor for the Player making a copy of a given
   * Player.
   * @param player the Player to be copied
   */

  public Player(IPlayer player) {
    this.name = player.getName();
    this.strength = player.getStrength();
    this.constitution = player.getConstitution();
    this.dexterity = player.getDexterity();
    this.charisma = player.getCharisma();
  }

  @Override
  public int getStrength() {
    return strength;
  }

  @Override
  public int getConstitution() {
    return constitution;
  }

  @Override
  public int getDexterity() {
    return dexterity;
  }

  @Override
  public int getCharisma() {
    return charisma;
  }

  @Override
  public int getHealth() {
    return health;
  }

  @Override
  public int getTotalBeltUnits() {
    int totalBeltUnits = 0;
    for (Gear gear: belts) {
      totalBeltUnits += gear.getNumberOfUnits();
    }
    return totalBeltUnits;
  }

  @Override
  public Headgear getHeadGear() {
    if (headGear == null) {
      return null;
    }
    return new Headgear(headGear);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<Gear> getPotions() {
    if (potions.isEmpty()) {
      return new ArrayList<>();
    }

    return new ArrayList<>(potions);
  }

  @Override
  public List<Gear> getBelts() {
    if (belts.isEmpty()) {
      return new ArrayList<>();
    }

    return new ArrayList<>(belts);
  }

  @Override
  public Gear getFootWear() {
    if (footWear == null) {
      return null;
    }
    return new Footwear(footWear);
  }

  @Override
  public List<Weapon> getWeapons() {
    if (weapons.isEmpty()) {
      return new ArrayList<>();
    }
    return new ArrayList<>(weapons);
  }

  @Override
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
          affectAbilityHelper(-gearValue, new int[] {i});
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

  @Override
  public void equipGear(Gear gear) {
    if (gear == null) {
      throw new IllegalArgumentException("Null values not supported");
    }

    boolean equipped = false;
    checkIfPossible(gear.getValue(), gear.getAttributeToEffect());
    if (gear.checkIfType(HeadGearHelper.getInstance())) {
      equipped = equipHeadGear(gear);
      if (equipped) {
        affectAbilityHelper(gear.getValue(), gear.getAttributeToEffect());
      }
    }

    else if (gear.checkIfType(PotionHelper.getInstance())) {
      equipped = equipPotion(gear);
      if (equipped) {
        affectAbilityHelper(gear.getValue(), gear.getAttributeToEffect());
      }
    }

    else if (gear.checkIfType(BeltHelper.getInstance())) {
      equipped = equipBelt(gear);
      if (equipped) {
        affectAbilityHelper(gear.getValue(), gear.getAttributeToEffect());
      }
    }

    else if (gear.checkIfType(FootWearHelper.getInstance())) {
      equipped = equipFootwear(gear);
      if (equipped) {
        affectAbilityHelper(gear.getValue(), gear.getAttributeToEffect());
      }
    }

    if (!equipped) {
      throw new IllegalArgumentException("Gear can't be equipped");
    }

  }

  private boolean equipFootwear(Gear gear) {
    if (footWear != null) {
      return false;
    }
    footWear = new Footwear(gear);
    lifeSpanOfFootWear = numOfTurns + gear.getLifespan();
    return true;
  }

  private boolean equipBelt(Gear gear) {
    if (maxUnitsOfBelts - getTotalBeltUnits() < gear.getNumberOfUnits()) {
      return false;
    }

    List<Integer> beltList = new ArrayList<>();
    beltList.add(gear.getLifespan());
    beltList.add(gear.getValue());

    for (int index : gear.getAttributeToEffect()) {
      beltList.add(index);
    }

    belts.add(new Belt(gear));
    listForBelts.add(beltList);
    return true;
  }

  private boolean equipPotion(Gear gear) {
    listForPotions.add(Arrays.asList(numOfTurns + gear.getLifespan(),
            gear.getValue(), gear.getAttributeToEffect()[0]));
    potions.add(new Potion(gear));
    return true;
  }

  private boolean equipHeadGear(Gear gear) {
    if (headGear != null) {
      return false;
    }
    headGear = new Headgear(gear);
    lifeSpanOfHeadGear = numOfTurns + gear.getLifespan();
    return true;
  }

  private void checkIfPossible(int value, int[] indices) {
    for (int index : indices) {
      if (index < 1 || index > 4) {
        throw new IllegalArgumentException("Index must be between 1 and 4 (inclusive");
      }

      if (index == 1) {
        if (strength + value < 0 || strength + value > maxForAbilities) {
          throw new IllegalArgumentException("Can't equip gear,"
                  + " attribute will become out of range");
        }
      }

      else if (index == 2) {
        if (constitution + value < 0 || constitution + value > maxForAbilities) {
          throw new IllegalArgumentException("Can't equip gear,"
                  + " attribute will become out of range");
        }
      }

      else if (index == 3) {
        if (dexterity + value < 0 || dexterity + value > maxForAbilities) {
          throw new IllegalArgumentException("Can't equip gear,"
                  + " attribute will become out of range");
        }
      }

      else if (index == 4) {
        if (charisma + value < 0 || charisma + value > maxForAbilities) {
          throw new IllegalArgumentException("Can't equip gear, "
                  + "attribute will become out of range");
        }
      }
    }
  }

  private void affectAbilityHelper(int value, int[] indices) {
    for (int index : indices) {
      if (index < 1 || index > 4) {
        throw new IllegalArgumentException("Index must be between 1 and 4 (inclusive");
      }

      if (index == 1) {
        this.strength += value;
      }

      else if (index == 2) {
        this.constitution += value;
      }

      else if (index == 3) {
        this.dexterity += value;
      }

      else {
        this.charisma += value;
      }

    }
  }

  @Override
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

    if (weapons.size() == 1 && weapons.get(0).checkIfType(KatanaHelper.getInstance())
            && weapon.equals(weapons.get(0))) {
      throw new IllegalArgumentException("Already equipped with weapon");
    }

    this.damageRange = weapon.getRange();

    if (weapon.checkIfType(AxeHelper.getInstance())) {
      this.weapons.add(new Axe(weapon));
    }

    else if (weapon.checkIfType(FlailHelper.getInstance())) {
      this.weapons.add(new Flail(weapon));
    }

    else if (weapon.checkIfType(TwoHandedSwordHelper.getInstance())) {
      this.weapons.add(new TwoHandedSword(weapon));
    }

    else if (weapon.checkIfType(BroadSwordHelper.getInstance())) {
      this.weapons.add(new BroadSword(weapon));
    }

    else if (weapon.checkIfType(KatanaHelper.getInstance())) {
      this.weapons.add(new Katana(weapon));
    }
  }

  @Override
  public String getDescription() {
    List<Gear> allGear = new ArrayList<>();
    if (headGear != null) {
      allGear.add(headGear);
    }

    if (footWear != null) {
      allGear.add(footWear);
    }

    allGear.addAll(potions);
    allGear.addAll(belts);

    Collections.sort(allGear);

    return getAbilitiesDescription() + "\r\n"
            + getWeaponDescription() + "\r\n" + getGearDescription(allGear);
  }

  private String getAbilitiesDescription() {
    return String.format("The player's strength is %d,"
            +  " the constitution is %d,"
            + " the dexterity is %d, and the charisma is %d",
            strength, constitution, dexterity, charisma);
  }

  private String getWeaponDescription() {
    if (weapons.isEmpty()) {
      return "The player has no weapons";
    }

    if (weapons.size() == 2) {
      return String.format("The player has 2 katana weapon , %s "
                      + "and %s, and its damage ranges from %d to %d",
              weapons.get(0).getName(), weapons.get(1).getName(), damageRange[0], damageRange[1]);
    }

    String weaponType = "Flail";
    if (weapons.get(0).checkIfType(AxeHelper.getInstance())) {
      weaponType = "Axe";
    }

    else if (weapons.get(0).checkIfType(BroadSwordHelper.getInstance())) {
      weaponType = "BroadSword";
    }

    else if (weapons.get(0).checkIfType(TwoHandedSwordHelper.getInstance())) {
      weaponType = "TwoHandedSword";
    }

    else if (weapons.get(0).checkIfType(KatanaHelper.getInstance())) {
      weaponType = "Katana";
    }


    return String.format("The player's weapon , %s, is of type %s,"
                    + " and its damage ranges from %d to %d",
            weapons.get(0).getName(), weaponType, damageRange[0], damageRange[1]);
  }

  private String getGearDescription(List<Gear> allGears) {
    if (allGears.isEmpty()) {
      return "The player has no gear";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (Gear gear: allGears) {
      String gearType = "";

      if (gear.checkIfType(BeltHelper.getInstance())) {
        gearType = "Belt";
      }

      else if (gear.checkIfType(HeadGearHelper.getInstance())) {
        gearType = "Headgear";
      }

      else if (gear.checkIfType(FootWearHelper.getInstance())) {
        gearType = "Footwear";
      }

      else {
        gearType = "Potion";
      }
      stringBuilder.append(String.format("Gear name is %s, its type is %s, "
                      + "its value is %d, and its lifespan is %d %n",
              gear.getName(), gearType, gear.getValue(), gear.getLifespan()));
    }

    return stringBuilder.toString();
  }

  @Override
  public int getStrikingPower() {
    return strength + randValueForStrikingPower;
  }

  @Override
  public int getAvoidanceAbility() {
    return dexterity + randValueForAvoidanceAbility;
  }

  @Override
  public void setHealth(int newHealth) {
    if (newHealth < 0) {
      throw new IllegalArgumentException("Health cannot be negative");
    }
    this.health = newHealth;
  }

  @Override
  public int getPotentialStrikingDamage() {

    if (weapons.isEmpty() || weapons.get(0) == null) {
      return strength;
    }
    int randomValue = randomness.generateValueBetween(damageRange[0], damageRange[1]);

    if (weapons.get(0) .checkIfType(weapon.FlailHelper.getInstance()) && dexterity < 14) {
      randomValue = randomness.generateValueBetween(damageRange[0] / 2, damageRange[1] / 2);
    }

    else if (weapons.get(0).checkIfType(weapon.TwoHandedSwordHelper.getInstance())
            || strength < 14) {
      randomValue = randomness.generateValueBetween(damageRange[0] / 2, damageRange[1] / 2);
    }

    int potentialStrikingDamage = strength + randomValue;
    return potentialStrikingDamage;
  }

  @Override
  public boolean isDead() {
    return this.health <= 0;
  }


}
