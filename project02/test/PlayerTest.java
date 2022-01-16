import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import battle.IPlayer;
import battle.Player;
import gear.Belt;
import gear.Footwear;
import gear.Gear;
import gear.Headgear;
import gear.Potion;
import org.junit.Before;
import org.junit.Test;
import randomize.Randomness;
import weapon.Axe;
import weapon.BroadSword;
import weapon.Flail;
import weapon.Katana;
import weapon.TwoHandedSword;
import weapon.Weapon;

import java.util.Arrays;

/**
 * This test class tests the different features for a player.
 */

public class PlayerTest {

  private IPlayer player;
  protected Randomness randomness;
  int seed = 50;

  /**
   * Creating the objects needed in the other tests.
   * */

  @Before
  public void setUp() {
    int seed = 50;
    randomness = new Randomness(seed);
    player = new Player("player1", randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), randomness.generateValueBetween(6, 18), seed);

  }

  /**
   * A method that tests the invalidity of having strength
   * greater than 18.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenStrengthIsGreaterThan18() {
    new Player("player", 19, 7, 8, 9);
  }

  /**
   * A method that tests the invalidity of having constitution
   * greater than 18.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenConstitutionIsGreaterThan18() {
    new Player("player",7, 19, 8, 9);
  }

  /**
   * A method that tests the invalidity of having dexterity
   * greater than 18.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenDexterityIsGreaterThan18() {
    new Player("player",8, 7, 19, 9);
  }

  /**
   * A method that tests the invalidity of having charisma
   * greater than 18.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenCharismaIsGreaterThan18() {
    new Player("player",9, 7, 8, 19);
  }

  /**
   * A method that tests the invalidity of having strength
   * less than 6.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenStrengthLessThan6() {
    new Player("player",5, 7, 8, 9);
  }

  /**
   * A method that tests the invalidity of having constitution
   * less than 6.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenConstitutionLessThan6() {
    new Player("player",7, 5, 8, 9);
  }

  /**
   * A method that tests the invalidity of having dexterity
   * less than 6.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenDexterityLessThan6() {
    new Player("player",8, 7, 5, 9);
  }

  /**
   * A method that tests the invalidity of having charisma
   * less than 6.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenCharismaLessThan6() {
    new Player("player",9, 7, 8, 5);
  }

  /**
   * A method that tests the getStrength method.
   */

  @Test
  public void testGetStrength() {
    int expectedValue = 17;
    assertEquals(expectedValue, player.getStrength());
  }

  /**
   * A method that tests the getConstitution method.
   */

  @Test
  public void testGetConstitution() {
    int expectedValue = 12;
    assertEquals(expectedValue, player.getConstitution());
  }

  /**
   * A method that tests the getDexterity method.
   */

  @Test
  public void testGetDexterity() {
    int expectedValue = 12;
    assertEquals(expectedValue, player.getDexterity());
  }

  /**
   * A method that tests the getCharisma method.
   */

  @Test
  public void testGetCharisma() {
    int expectedValue = 6;
    assertEquals(expectedValue, player.getCharisma());
  }

  /**
   * A method that tests the getName method.
   */

  @Test
  public void testGetName() {
    String expectedValue = "player1";
    assertEquals(expectedValue, player.getName());
  }

  /**
   * A method that tests the getHealth method.
   */

  @Test
  public void testGetHealth() {
    int expectedValue = 17 + 12 + 12 + 6;
    assertEquals(expectedValue, player.getHealth());
  }

  /**
   * A method that tests the getStrikingPower method.
   */

  @Test
  public void testGetStrikingPower() {
    int expectedValue = 26;
    assertEquals(expectedValue, player.getStrikingPower());
  }

  /**
   * A method that tests the getAvoidanceAbility method.
   */

  @Test
  public void testGetAvoidanceAbility() {
    int expectedValue = 14;
    assertEquals(expectedValue, player.getAvoidanceAbility());
  }

  /**
   * A method that tests the getPotentialStrikingDamage method.
   */

  @Test
  public void testGetPotentialStrikingDamage() {
    int expectedValue = 17;
    assertEquals(expectedValue, player.getPotentialStrikingDamage());
  }

  /**
   * A method that tests the getHeadGear method when no head gear equipped.
   */

  @Test
  public void testGetHeadGearWhenNoHeadGearEquipped() {
    assertNull(player.getHeadGear());
  }

  /**
   * A method that tests the getHeadGear method when head gear equipped.
   */

  @Test
  public void testGetHeadGearWhenHeadGearEquipped() {
    Gear headGear = new Headgear("headGear", seed);
    player.equipGear(headGear);
    assertEquals(headGear, player.getHeadGear());
  }

  /**
   * A method that tests the getHeadGear method when equipped
   * with head gear multiple times.
   */

  @Test
  public void testGetHeadGearWhenHeadGearEquippedMoreThanOnce() {
    Gear headGear = new Headgear("headGear", seed);
    Gear headGear2 = new Headgear("headGear2", seed);
    player.equipGear(headGear);

    try {
      player.equipGear(headGear2);
    }
    catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    assertEquals(headGear, player.getHeadGear());
  }

  /**
   * A method that tests the getFootWear method when no foot wear equipped.
   */

  @Test
  public void testGetFootWearWhenNoFootWearEquipped() {
    assertNull(player.getFootWear());
  }

  /**
   * A method that tests the getFootWear method when head gear equipped.
   */

  @Test
  public void testGetFootWearWhenFootWearEquipped() {
    Gear footwear = new Footwear("footwear", seed);
    player.equipGear(footwear);
    assertEquals(footwear, player.getFootWear());
  }

  /**
   * A method that tests the getFootWear method when equipped
   * with head gear multiple times.
   */

  @Test
  public void testGetFootWearWhenFootWearEquippedMoreThanOnce() {
    Gear footwear = new Footwear("footwear", seed);
    Gear footwear2 = new Footwear("footwear2", seed);
    player.equipGear(footwear);
    try {
      player.equipGear(footwear2);
    }
    catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    assertEquals(footwear, player.getFootWear());
  }

  /**
   * A method that tests the getPotions method when no potions equipped.
   */

  @Test
  public void testGetPotionsWhenNoPotionsEquipped() {
    assertTrue(player.getPotions().isEmpty());
  }

  /**
   * A method that tests the getPotions method when potions equipped.
   */

  @Test
  public void testGetPotionsWhenPotionsEquipped() {
    Gear potion1 = new Potion("potion1", seed);
    Gear potion2 = new Potion("potion2", seed);

    player.equipGear(potion1);
    player.equipGear(potion2);

    assertEquals(Arrays.asList(potion1, potion2), player.getPotions());
  }

  /**
   * A method that tests the getBelts method when no belts equipped.
   */

  @Test
  public void testGetBeltsWhenNoBeltsEquipped() {
    assertTrue(player.getBelts().isEmpty());
  }

  /**
   * A method that tests the getBelts method when belts equipped.
   */

  @Test
  public void testGetBeltsWhenBeltsEquipped() {
    Gear belt1 = new Belt("belt1", seed);
    Gear belt2 = new Belt("belt2", seed);

    player.equipGear(belt1);
    player.equipGear(belt2);

    assertEquals(Arrays.asList(belt1, belt2), player.getBelts());
  }

  /**
   * A method that tests the getWeapons method when no weapons equipped.
   */

  @Test
  public void testGetWeaponsWhenNoWeaponsEquipped() {
    assertTrue(player.getWeapons().isEmpty());
  }

  /**
   * A method that tests the getWeapons method when weapons equipped
   * with 2 katanas.
   */

  @Test
  public void testGetWeaponsWhenWeaponsEquippedWithTwoKatanas() {
    Weapon katana1 = new Katana("katana1");
    Weapon katana2 = new Katana("katana2");

    player.equipWeapon(katana1);
    player.equipWeapon(katana2);
    assertEquals(Arrays.asList(katana1, katana2), player.getWeapons());
  }

  /**
   * A method that tests the getWeapons method when weapons equipped
   * with 1 weapon.
   */

  @Test
  public void testGetWeaponsWhenWeaponsEquippedWithOneWeapon() {
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
    assertEquals(Arrays.asList(flail), player.getWeapons());
  }

  /**
   * A method that tests the equipWeapon method when weapon is null.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquipWeaponWhenWeaponIsNull() {
    player.equipWeapon(null);
  }

  /**
   * A method that tests the equipWeapon method when weapon is a flail.
   */

  @Test
  public void testEquipWeaponWhenWeaponIsFlail() {
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
    assertEquals(Arrays.asList(flail), player.getWeapons());
  }

  /**
   * A method that tests the equipWeapon method when weapon is an axe.
   */

  @Test
  public void testEquipWeaponWhenWeaponIsAxe() {
    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
    assertEquals(Arrays.asList(axe), player.getWeapons());
  }

  /**
   * A method that tests the equipWeapon method when weapon is a katana.
   */

  @Test
  public void testEquipWeaponWhenWeaponIsKatana() {
    Weapon katana = new Katana("katana");

    player.equipWeapon(katana);
    assertEquals(Arrays.asList(katana), player.getWeapons());
  }

  /**
   * A method that tests the equipWeapon method when weapon is a BroadSword.
   */

  @Test
  public void testEquipWeaponWhenWeaponIsBroadSword() {
    Weapon broadSword = new BroadSword("broadSword");

    player.equipWeapon(broadSword);
    assertEquals(Arrays.asList(broadSword), player.getWeapons());
  }

  /**
   * A method that tests the equipWeapon method when weapon is a TwoHandedSword.
   */

  @Test
  public void testEquipWeaponWhenWeaponIsTwoHandedSword() {
    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
    assertEquals(Arrays.asList(twoHandedSword), player.getWeapons());
  }
  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a Katana, when the first is TwoHandedSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponKatanaWhen1stWeaponIsTwoHandedSword() {
    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
    Weapon katana = new Katana("katana");

    player.equipWeapon(katana);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a BroadSword, when the first is TwoHandedSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponBroadSwordWhen1stWeaponIsTwoHandedSword() {
    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
    Weapon broadSword = new BroadSword("broadSword");

    player.equipWeapon(broadSword);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a TwoHandedSword, when the first is TwoHandedSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponTwoHandedSwordWhen1stWeaponIsTwoHandedSword() {
    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
    Weapon twoHandedSword1 = new TwoHandedSword("twoHandedSword1");

    player.equipWeapon(twoHandedSword1);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a Flail, when the first is TwoHandedSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponFlailWhen1stWeaponIsTwoHandedSword() {
    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a Axe, when the first is TwoHandedSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponAxeWhen1stWeaponIsTwoHandedSword() {
    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
  }
  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a Katana, when the first is BroadSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponKatanaWhen1stWeaponIsBroadSword() {
    Weapon broadSword = new BroadSword("broadSword");

    player.equipWeapon(broadSword);
    Weapon katana = new Katana("katana");

    player.equipWeapon(katana);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a TwoHandedSword, when the first is BroadSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponTwoHandedSwordWhen1stWeaponIsBroadSword() {
    Weapon broadSword = new BroadSword("broadSword");

    player.equipWeapon(broadSword);
    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a BroadSword, when the first is BroadSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponBroadSwordWhen1stWeaponIsBroadSword() {
    Weapon broadSword = new BroadSword("broadSword");

    player.equipWeapon(broadSword);
    Weapon broadSword1 = new BroadSword("broadSword1");

    player.equipWeapon(broadSword1);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , an Axe, when the first is BroadSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponAxeWhen1stWeaponIsBroadSword() {
    Weapon broadSword = new BroadSword("broadSword");

    player.equipWeapon(broadSword);
    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , an Flail, when the first is BroadSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponFlailWhen1stWeaponIsBroadSword() {
    Weapon broadSword = new BroadSword("broadSword");

    player.equipWeapon(broadSword);
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
  }
  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a Katana, when the first is Axe.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponKatanaWhen1stWeaponIsAxe() {
    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
    Weapon katana = new Katana("katana");

    player.equipWeapon(katana);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a TwoHandedSword, when the first is Axe.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponTwoHandedSwordWhen1stWeaponIsAxe() {
    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a BroadSword, when the first is Axe.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponBroadSwordWhen1stWeaponIsAxe() {
    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
    Weapon broadSword = new BroadSword("broadSword");

    player.equipWeapon(broadSword);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a Axe, when the first is Axe.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponAxeWhen1stWeaponIsAxe() {
    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
    Weapon axe1 = new Axe("axe1");

    player.equipWeapon(axe1);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a Flail, when the first is Axe.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponFlailWhen1stWeaponIsAxe() {
    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a Katana, when the first is Flail.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponWhen1stWeaponIsFlail() {
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
    Weapon katana = new Katana("katana");

    player.equipWeapon(katana);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a Axe, when the first is Flail.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponAxeWhen1stWeaponIsFlail() {
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a Flail, when the first is Flail.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponFlailWhen1stWeaponIsFlail() {
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
    Weapon flail1 = new Flail("flail1");

    player.equipWeapon(flail1);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a BroadSword, when the first is Flail.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponBroadSwordWhen1stWeaponIsFlail() {
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
    Weapon broadSword = new BroadSword("axe");

    player.equipWeapon(broadSword);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a TwoHandedSword, when the first is Flail.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponTwoHandedSwordWhen1stWeaponIsFlail() {
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
  }
  ////


  /**
   * A method that tests the equipWeapon method when equipping a second katana
   * when the first is a katana.
   */

  @Test
  public void testEquip2ndKatanaWhen1stWeaponIsKatana() {
    Weapon katana = new Katana("katana");
    Weapon katana2 = new Katana("katana2");

    player.equipWeapon(katana);
    player.equipWeapon(katana2);
    assertEquals(Arrays.asList(katana, katana2), player.getWeapons());
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a TwoHandedSword, when the first is a katana.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponTwoHandedSwordWhen1stWeaponIsKatana() {
    Weapon katana = new Katana("katana");

    player.equipWeapon(katana);
    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a BroadSword, when the first is a katana.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponBroadSwordWhen1stWeaponIsKatana() {
    Weapon katana = new Katana("katana");

    player.equipWeapon(katana);
    Weapon broadSword = new BroadSword("broadSword");

    player.equipWeapon(broadSword);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , an Axe, when the first is a katana.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponAxeWhen1stWeaponIsKatana() {
    Weapon katana = new Katana("katana");

    player.equipWeapon(katana);
    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * , a Flail, when the first is a katana.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponFlailWhen1stWeaponIsKatana() {
    Weapon katana = new Katana("katana");

    player.equipWeapon(katana);
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
  }

  ///

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * which the same object as first for Katanas.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponWhenSameReferences1stForKatanas() {
    Weapon katana = new Katana("katana");

    player.equipWeapon(katana);
    player.equipWeapon(katana);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * which the same object as first for TwoHandedSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponWhenSameReferences1stForTwoHandedSword() {
    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
    player.equipWeapon(twoHandedSword);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * which the same object as first for BroadSword.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponWhenSameReferences1stForBroadSword() {
    Weapon broadSword = new BroadSword("broadSword");

    player.equipWeapon(broadSword);
    player.equipWeapon(broadSword);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * which the same object as first for Axe.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponWhenSameReferences1stForAxe() {
    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
    player.equipWeapon(axe);
  }

  /**
   * A method that tests the equipWeapon method when equipping a second weapon
   * which the same object as first for Flail.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponWhenSameReferences1stForFlail() {
    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
    player.equipWeapon(flail);
  }

  /**
   * A method that tests the equipWeapon method when equipping a third weapon
   * , a TwoHandedSword, when the first two are katanas.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponTwoHandedSwordWhen2WeaponsAreKatanas() {
    Weapon katana = new Katana("katana");
    Weapon katana2 = new Katana("katana2");

    player.equipWeapon(katana);
    player.equipWeapon(katana2);
    assertEquals(Arrays.asList(katana, katana2), player.getWeapons());

    Weapon twoHandedSword = new TwoHandedSword("twoHandedSword");

    player.equipWeapon(twoHandedSword);
  }

  /**
   * A method that tests the equipWeapon method when equipping a third weapon
   * , a BroadSword, when the first two are katanas.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponBroadSwordWhen2WeaponsAreKatanas() {
    Weapon katana = new Katana("katana");
    Weapon katana2 = new Katana("katana2");

    player.equipWeapon(katana);
    player.equipWeapon(katana2);
    assertEquals(Arrays.asList(katana, katana2), player.getWeapons());

    Weapon broadSword = new BroadSword("broadSword");

    player.equipWeapon(broadSword);
  }

  /**
   * A method that tests the equipWeapon method when equipping a third weapon
   * , a Katana, when the first two are katanas.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponKatanaWhen2WeaponsAreKatanas() {
    Weapon katana = new Katana("katana");
    Weapon katana2 = new Katana("katana2");

    player.equipWeapon(katana);
    player.equipWeapon(katana2);
    assertEquals(Arrays.asList(katana, katana2), player.getWeapons());

    Weapon katana3 = new Katana("katana3");

    player.equipWeapon(katana3);
  }

  /**
   * A method that tests the equipWeapon method when equipping a third weapon
   * , an Axe, when the first two are katanas.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponAxeWhen2WeaponsAreKatanas() {
    Weapon katana = new Katana("katana");
    Weapon katana2 = new Katana("katana2");

    player.equipWeapon(katana);
    player.equipWeapon(katana2);
    assertEquals(Arrays.asList(katana, katana2), player.getWeapons());

    Weapon axe = new Axe("axe");

    player.equipWeapon(axe);
  }

  /**
   * A method that tests the equipWeapon method when equipping a third weapon
   * , a Flail, when the first two are katanas.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquip2ndWeaponFlailWhen2WeaponsAreKatanas() {
    Weapon katana = new Katana("katana");
    Weapon katana2 = new Katana("katana2");

    player.equipWeapon(katana);
    player.equipWeapon(katana2);
    assertEquals(Arrays.asList(katana, katana2), player.getWeapons());

    Weapon flail = new Flail("flail");

    player.equipWeapon(flail);
  }

  /**
   * A method that tests the equipGear method when gear is Headgear.
   */

  @Test
  public void testEquipGearWhenGearIsHeadGear() {
    Gear headgear = new Headgear("headgear", seed);

    player.equipGear(headgear);
    assertEquals(headgear, player.getHeadGear());
  }

  /**
   * A method that tests the equipGear method when gear is Footwear.
   */

  @Test
  public void testEquipGearWhenGearIsFootwear() {
    Gear footwear = new Footwear("footwear", seed);

    player.equipGear(footwear);
    assertEquals(footwear, player.getFootWear());
  }

  /**
   * A method that tests the equipGear method when gear is Belt.
   */

  @Test
  public void testEquipGearWhenGearIsBelt() {
    Gear belt = new Belt("belt", seed);

    player.equipGear(belt);
    assertEquals(Arrays.asList(belt), player.getBelts());
  }

  /**
   * A method that tests the equipGear method when gear is Potion.
   */

  @Test
  public void testEquipGearWhenGearIsPotion() {
    Gear potion = new Potion("potion",seed );

    player.equipGear(potion);
    assertEquals(Arrays.asList(potion), player.getPotions());
  }

  ///

  /**
   * A method that tests the equipGear method when gear is Headgear
   * when player already has Headgear.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquipGearWhenGearIsHeadGearWhenPlayerAlreadyHasHeadGear() {
    Gear headgear = new Headgear("headgear", seed);

    player.equipGear(headgear);
    assertEquals(headgear, player.getHeadGear());

    Gear headgear2 = new Headgear("headgear2", seed);
    player.equipGear(headgear2);
  }

  /**
   * A method that tests the equipGear method when gear is Footwear
   * when player already has Footwear.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquipGearWhenGearIsFootwearWhenPlayerAlreadyHasFootwear() {
    Gear footwear = new Footwear("footwear", seed);

    player.equipGear(footwear);
    assertEquals(footwear, player.getFootWear());

    Gear footwear2 = new Footwear("footwear2", seed);
    player.equipGear(footwear2);
  }

  /**
   * A method that tests the equipGear method when gear is Belt
   * when player has no more room for more belts.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquipGearWhenGearIsBeltWhenPlayerHasNoMoreRoomForBelts() {
    Gear belt = new Belt("belt", seed);
    Gear belt2 = new Belt("belt2", seed);
    Gear belt3 = new Belt("belt3", seed);
    Gear belt4 = new Belt("belt4", seed);
    Gear belt5 = new Belt("belt5", seed);


    player.equipGear(belt);
    player.equipGear(belt2);
    player.equipGear(belt3);
    player.equipGear(belt4);
    player.equipGear(belt5);
    assertEquals(Arrays.asList(belt, belt2, belt3, belt4, belt5), player.getBelts());
    Gear belt6 = new Belt("belt6", seed);
    player.equipGear(belt6);
  }

  /**
   * A method that tests the equipGear method when gear is Headgear
   * that makes player has a negative ability.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testEquipGearWhenGearIsHeadGearAndMakesPlayerHaveNegativeAbility() {
    Gear headgear = new Headgear("headgear", 10);

    player.equipGear(headgear);
    assertEquals(headgear, player.getHeadGear());

    Gear headgear2 = new Headgear("headgear2", seed);
    player.equipGear(headgear2);
  }

  /**
   * A method that tests the getDescription method.
   */

  @Test
  public void testGetDescription() {
    String expectedString = "The player's strength is 17, the constitution is 12,"
            + " the dexterity is 12, and the charisma is 6\r\n"
            + "The player has no weapons\r\n"
            + "The player has no gear";
    assertEquals(expectedString, player.getDescription());
  }

  /**
   * A method that tests the update method
   * when effect of headGear should be removed.
   */

  @Test
  public void testUpdateWhenEffectOfHeadGearShouldBeRemoved() {
    Gear headgear = new Headgear("headgear", 10);
    int expectedValue = 3;
    assertEquals(expectedValue, headgear.getLifespan());
    int expectedConstitution = player.getConstitution() + headgear.getValue();
    player.equipGear(headgear);
    assertEquals(expectedConstitution, player.getConstitution());
    for (int index = 0; index < expectedValue; index++) {
      player.update();
    }

    assertEquals(expectedConstitution - headgear.getValue(), player.getConstitution());
  }

  /**
   * A method that tests the update method
   * when effect of Footwear should be removed.
   */

  @Test
  public void testUpdateWhenEffectOfFootWearShouldBeRemoved() {
    Gear footwear = new Footwear("footwear", 10);
    int expectedValue = 3;
    assertEquals(expectedValue, footwear.getLifespan());
    int expectedDexterity = player.getDexterity() + footwear.getValue();
    player.equipGear(footwear);
    assertEquals(expectedDexterity, player.getDexterity());
    for (int index = 0; index < expectedValue; index++) {
      player.update();
    }

    assertEquals(expectedDexterity - footwear.getValue(), player.getDexterity());
  }

  /**
   * A method that tests the update method
   * when effect of belt should be removed.
   */

  @Test
  public void testUpdateWhenEffectOfBeltShouldBeRemoved() {
    Gear belt = new Belt("belt", 10);
    int expectedValue = 3;
    assertEquals(expectedValue, belt.getLifespan());
    assertTrue(Arrays.equals(belt.getAttributeToEffect(), new int[]{1}));

    int expectedStrength = player.getStrength() + belt.getValue();
    player.equipGear(belt);
    assertEquals(expectedStrength, player.getDexterity());

    for (int index = 0; index < expectedValue; index++) {
      player.update();
    }

    assertEquals(expectedStrength - belt.getValue(), player.getStrength());
  }

  /**
   * A method that tests the update method
   * when effect of potion should be removed.
   */

  @Test
  public void testUpdateWhenEffectOfPotionShouldBeRemoved() {
    Gear potion = new Potion("headgear", 10);
    int expectedValue = 3;
    assertEquals(expectedValue, potion.getLifespan());
    assertTrue(Arrays.equals(potion.getAttributeToEffect(), new int[]{3}));
    int expectedDexterity = player.getDexterity() + potion.getValue();
    player.equipGear(potion);
    assertEquals(expectedDexterity, player.getDexterity());
    for (int index = 0; index < expectedValue; index++) {
      player.update();
    }

    assertEquals(expectedDexterity - potion.getValue(), player.getDexterity());
  }

  /**
   * A method that tests the getHealth method.
   */

  @Test
  public void testSetHealth() {
    int expectedValue = 50;
    player.setHealth(expectedValue);

    assertEquals(expectedValue, player.getHealth());
  }

  /**
   * A method that tests the getHealth method when setting
   * health to below zero.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testSetHealthWhenHealthIsBelowZero() {
    int expectedValue = -1;
    player.setHealth(expectedValue);
  }


  /**
   * A method that tests the getHealth method.
   */

  @Test
  public void testisDead() {
    int expectedValue = 0;
    player.setHealth(expectedValue);

    assertTrue(player.isDead());

    player.setHealth(50);
    assertFalse(player.isDead());
  }




}
