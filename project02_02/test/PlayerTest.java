import org.junit.Test;

import battle.Player;

/**
 * This test class tests the different features for a player.
 */

public class PlayerTest {

  /**
   * A method that tests the invalidity of having strength
   * greater than 18.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenStrengthIsGreaterThan18() {
    new Player(19, 7, 8, 9);
  }

  /**
   * A method that tests the invalidity of having constitution
   * greater than 18.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenConstitutionIsGreaterThan18() {
    new Player(7, 19, 8, 9);
  }

  /**
   * A method that tests the invalidity of having dexterity
   * greater than 18.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenDexterityIsGreaterThan18() {
    new Player(8, 7, 19, 9);
  }

  /**
   * A method that tests the invalidity of having charisma
   * greater than 18.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenCharismaIsGreaterThan18() {
    new Player(9, 7, 8, 19);
  }

  /**
   * A method that tests the invalidity of having strength
   * less than 6.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenStrengthLessThan6() {
    new Player(5, 7, 8, 9);
  }

  /**
   * A method that tests the invalidity of having constitution
   * less than 6.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenConstitutionLessThan6() {
    new Player(7, 5, 8, 9);
  }

  /**
   * A method that tests the invalidity of having dexterity
   * less than 6.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenDexterityLessThan6() {
    new Player(8, 7, 5, 9);
  }

  /**
   * A method that tests the invalidity of having charisma
   * less than 6.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWhenCharismaLessThan6() {
    new Player(9, 7, 8, 5);
  }

}
