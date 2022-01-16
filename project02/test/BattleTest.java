import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import battle.Battle;
import battle.IBattle;
import battle.IPlayer;
import battle.Player;
import org.junit.Before;
import org.junit.Test;
import randomize.MockRandomness;
import randomize.Randomness;
import weapon.AxeHelper;


/**
 * This test class tests the different features for a battle.
 */

public class BattleTest {
  private Player p1;
  private Player p2;
  private IBattle battle;

  /**
   * Creating the objects needed in the other tests.
   */

  @Before
  public void setUp() {
    Randomness randomness = new MockRandomness();
    p1 = new Player("p1", randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18),
             randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), randomness);
    p2 = new Player("p2", randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), randomness);
    battle = new Battle(p1, p2, randomness);
  }

  /**
   * A method that tests the equip gears for both players.
   */

  @Test
  public void testEquipGears() {
    battle.equipGears();

    String expectedDescriptionForP1 = "The player's strength is 6, the constitution is 17,"
            + " the dexterity is 208, and the charisma is 9\r\n"
            +  "The player has no weapons\r\n"
            +  "Gear name is potion 62, its type is Potion,"
            +  " its value is 10, and its lifespan is 3 \r\n" 
            +  "Gear name is potion 63, its type is Potion,"
            +  " its value is 10, and its lifespan is 3 \r\n"
            +  "Gear name is potion 64, its type is Potion,"
            +  " its value is 10, and its lifespan is 3 \r\n"
            +  "Gear name is potion 65, its type is Potion,"
            +  " its value is 10, and its lifespan is 3 \r\n"
            +  "Gear name is potion 66, its type is Potion," 
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 67, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 68, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 69, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 70, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 71, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 72, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 73, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 74, its type is Potion" 
            + ", its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 75, its type is Potion," 
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 76, its type is Potion"
            + ", its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 77, its type is Potion"
            + ", its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 78, its type is Potion"
            + ", its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 79, its type is Potion"
            + ", its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 80, its type is Potion"
            + ", its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is belt 36, its type is Belt, its value is 10, and its lifespan is 3 \r\n";

    String expectedDescriptionForP2 = "The player's strength is 12, the constitution is 23,"
            + " the dexterity is 204, and the charisma is 10\r\n"
            + "The player has no weapons\r\n"
            + "Gear name is potion 11, its type is Potion,"
            + " its value is -5, and its lifespan is 3 \r\n"
            + "Gear name is potion 44, its type is Potion, "
            + "its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 45, its type is Potion, "
            + "its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 46, its type is Potion, "
            + "its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 47, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 48, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 49, its type is Potion, "
            + "its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 50, its type is Potion, "
            + "its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 51, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 52, its type is Potion, "
            + "its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 53, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 54, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 55, its type is Potion, "
            + "its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 56, its type is Potion, "
            + "its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 57, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 58, its type is Potion, "
            + "its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 59, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 60, its type is Potion,"
            + " its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is potion 61, its type is Potion, "
            + "its value is 10, and its lifespan is 3 \r\n"
            + "Gear name is belt 38, its type is Belt,"
            + " its value is 10, and its lifespan is 3 \r\n";

    assertEquals(expectedDescriptionForP1, p1.getDescription());
    assertEquals(expectedDescriptionForP2, p2.getDescription());

    int expectedStrength1 = 6;
    int expectedStrength2 = 12;
    assertEquals(expectedStrength1, p1.getStrength());
    assertEquals(expectedStrength2, p2.getStrength());

    int expectedConstitution1 = 17;
    int expectedConstitution2 = 23;
    assertEquals(expectedConstitution1, p1.getConstitution());
    assertEquals(expectedConstitution2, p2.getConstitution());

    int expectedDexterity1 = 208;
    int expectedDexterity2 = 204;
    assertEquals(expectedDexterity1, p1.getDexterity());
    assertEquals(expectedDexterity2, p2.getDexterity());

    int expectedCharisma1 = 9;
    int expectedCharisma2 = 10;
    assertEquals(expectedCharisma1, p1.getCharisma());
    assertEquals(expectedCharisma2, p2.getCharisma());

  }


  /**
   * A method that tests the equip weapon for both players.
   */

  @Test
  public void testEquipWeapon() {
    battle.equipGears();
    battle.equipWeapons();

    assertTrue(p1.getWeapons().get(0).checkIfType(AxeHelper.getInstance()));
    assertTrue(p2.getWeapons().get(0).checkIfType(AxeHelper.getInstance()));
  }

  /**
   * A method that tests the attack method.
   */

  @Test
  public void testAttack() {
    battle.equipGears();
    battle.equipWeapons();
    battle.attack();

    assertNull(battle.getWinner());
  }

  /**
   * A method that tests the getWinner method.
   */

  @Test
  public void testGetWinner() {
    int seed = -10;
    Randomness randomness = new MockRandomness();
    IPlayer p1 = new Player("player1", randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), seed);
    IPlayer p2 = new Player("player2", randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), seed);
    IBattle battle = new Battle(p1, p2, seed);
    battle.equipGears();
    battle.equipWeapons();

    while (battle.getWinner() == null) {
      battle.attack();
    }
    String expectedResult = "player1";
    assertEquals(expectedResult, battle.getWinner());
  }

  /**
   * A method that tests the whoseTurnIsIt method.
   */

  @Test
  public void testWhoseTurnIsIt() {
    battle.equipGears();
    battle.equipWeapons();
    String expectedResult = "p2";
    assertEquals(expectedResult, battle.whoseTurnIsIt());
    battle.attack();
    expectedResult = "p1";

    assertEquals(expectedResult, battle.whoseTurnIsIt());
  }

  /**
   * A method that tests the rematch method.
   */

  @Test
  public void testRematch() {
    int seed = -10;
    Randomness randomness = new MockRandomness();
    IPlayer p1 = new Player("player1", randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), seed);
    IPlayer p2 = new Player("player2", randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), seed);
    IBattle battle = new Battle(p1, p2, seed);
    battle.equipGears();
    battle.equipWeapons();

    final int expectedHealthForP1 = p1.getHealth();
    final int expectedHealthForP2 = p2.getHealth();

    while (battle.getWinner() == null) {
      battle.attack();
    }
    battle.rematch();
    assertEquals(expectedHealthForP2, p2.getHealth());
    assertEquals(expectedHealthForP1, p1.getHealth());
  }

  /**
   * A method that tests the rematch method when game is still in progress.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testRematchWhenGameIsInProgress() {
    battle.equipGears();
    battle.equipWeapons();

    battle.attack();
    battle.attack();
    battle.attack();
    battle.attack();

    battle.rematch();
  }

  /**
   * A method that tests the getHealthOfPlayer1 method.
   */

  @Test
  public void testGetHealthOfPlayer1() {
    battle.equipGears();
    battle.equipWeapons();

    battle.attack();

    int expectedHealth = 30;
    assertEquals(expectedHealth, battle.getHealthOfPlayer1());

  }

  /**
   * A method that tests the getHealthOfPlayer2 method.
   */

  @Test
  public void testGetHealthOfPlayer2() {
    battle.equipGears();
    battle.equipWeapons();

    battle.attack();

    int expectedHealth = 54;
    assertEquals(expectedHealth, battle.getHealthOfPlayer2());

  }



}
