import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
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

import java.util.Arrays;


/**
 * This test class tests the different features for a weapon.
 */


public class WeaponTest {
  private Weapon katana;
  private Weapon twoHandedSword;
  private Weapon broadSword;
  private Weapon axe;
  private Weapon flail;

  protected Randomness randomness;
  int seed = 50;

  /**
   * Creating the objects needed in the other tests.
   */

  @Before
  public void setUp() {
    int seed = 50;
    randomness = new Randomness(seed);
    katana = new Katana("katana");
    twoHandedSword = new TwoHandedSword("twoHandedSword");
    broadSword = new BroadSword("broadSword");
    axe = new Axe("axe");
    flail = new Flail("flail");
  }
  //
  /**
   * A method that tests the checkIfType method for a katana
   * and tests if katana is of type katana.
   */

  @Test
  public void testCheckIfTypeKatanaForKatana() {
    assertTrue(katana.checkIfType(KatanaHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a katana
   * and tests if katana is of type TwoHandedSword.
   */

  @Test
  public void testCheckIfTypeTwoHandedSwordForKatana() {
    assertFalse(katana.checkIfType(TwoHandedSwordHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a katana
   * and tests if katana is of type BroadSword.
   */

  @Test
  public void testCheckIfTypeBroadSwordForKatana() {
    assertFalse(katana.checkIfType(BroadSwordHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a katana
   * and tests if katana is of type Axe.
   */

  @Test
  public void testCheckIfTypeAxeForKatana() {
    assertFalse(katana.checkIfType(AxeHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a katana
   * and tests if katana is of type Flail.
   */

  @Test
  public void testCheckIfTypeFlailForKatana() {
    assertFalse(katana.checkIfType(FlailHelper.getInstance()));
  }

  //
  /**
   * A method that tests the checkIfType method for a TwoHandedSword
   * and tests if TwoHandedSword is of type katana.
   */

  @Test
  public void testCheckIfTypeKatanaForTwoHandedSword() {
    assertFalse(twoHandedSword.checkIfType(KatanaHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a TwoHandedSword
   * and tests if TwoHandedSword is of type TwoHandedSword.
   */

  @Test
  public void testCheckIfTypeTwoHandedSwordForTwoHandedSword() {
    assertTrue(twoHandedSword.checkIfType(TwoHandedSwordHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a TwoHandedSword
   * and tests if TwoHandedSword is of type BroadSword.
   */

  @Test
  public void testCheckIfTypeBroadSwordForTwoHandedSword() {
    assertFalse(twoHandedSword.checkIfType(BroadSwordHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a TwoHandedSword
   * and tests if TwoHandedSword is of type Axe.
   */

  @Test
  public void testCheckIfTypeAxeForTwoHandedSword() {
    assertFalse(twoHandedSword.checkIfType(AxeHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a TwoHandedSword
   * and tests if TwoHandedSword is of type Flail.
   */

  @Test
  public void testCheckIfTypeFlailForTwoHandedSword() {
    assertFalse(twoHandedSword.checkIfType(FlailHelper.getInstance()));
  }

  //
  /**
   * A method that tests the checkIfType method for a BroadSword
   * and tests if BroadSword is of type katana.
   */

  @Test
  public void testCheckIfTypeKatanaForBroadSword() {
    assertFalse(broadSword.checkIfType(KatanaHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a BroadSword
   * and tests if BroadSword is of type TwoHandedSword.
   */

  @Test
  public void testCheckIfTypeTwoHandedSwordForBroadSword() {
    assertFalse(broadSword.checkIfType(TwoHandedSwordHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a BroadSword
   * and tests if BroadSword is of type BroadSword.
   */

  @Test
  public void testCheckIfTypeBroadSwordForBroadSword() {
    assertTrue(broadSword.checkIfType(BroadSwordHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a BroadSword
   * and tests if BroadSword is of type Axe.
   */

  @Test
  public void testCheckIfTypeAxeForBroadSword() {
    assertFalse(broadSword.checkIfType(AxeHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a BroadSword
   * and tests if BroadSword is of type Flail.
   */

  @Test
  public void testCheckIfTypeFlailForBroadSword() {
    assertFalse(broadSword.checkIfType(FlailHelper.getInstance()));
  }

  //
  /**
   * A method that tests the checkIfType method for an Axe
   * and tests if Axe is of type katana.
   */

  @Test
  public void testCheckIfTypeKatanaForAxe() {
    assertFalse(axe.checkIfType(KatanaHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for an Axe
   * and tests if Axe is of type TwoHandedSword.
   */

  @Test
  public void testCheckIfTypeTwoHandedSwordForAxe() {
    assertFalse(axe.checkIfType(TwoHandedSwordHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for an Axe
   * and tests if Axe is of type BroadSword.
   */

  @Test
  public void testCheckIfTypeBroadSwordForAxe() {
    assertFalse(axe.checkIfType(BroadSwordHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for an Axe
   * and tests if Axe is of type Axe.
   */

  @Test
  public void testCheckIfTypeAxeForAxe() {
    assertTrue(axe.checkIfType(AxeHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for an Axe
   * and tests if Axe is of type Flail.
   */

  @Test
  public void testCheckIfTypeFlailForAxe() {
    assertFalse(axe.checkIfType(FlailHelper.getInstance()));
  }

  //
  /**
   * A method that tests the checkIfType method for a Flail
   * and tests if Flail is of type katana.
   */

  @Test
  public void testCheckIfTypeKatanaForFlail() {
    assertFalse(flail.checkIfType(KatanaHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a Flail
   * and tests if Flail is of type TwoHandedSword.
   */

  @Test
  public void testCheckIfTypeTwoHandedSwordForFlail() {
    assertFalse(flail.checkIfType(TwoHandedSwordHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a Flail
   * and tests if Flail is of type BroadSword.
   */

  @Test
  public void testCheckIfTypeBroadSwordForFlail() {
    assertFalse(flail.checkIfType(BroadSwordHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a Flail
   * and tests if Flail is of type Axe.
   */

  @Test
  public void testCheckIfTypeAxeForFlail() {
    assertFalse(flail.checkIfType(AxeHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a Flail
   * and tests if Flail is of type Flail.
   */

  @Test
  public void testCheckIfTypeFlailForFlail() {
    assertTrue(flail.checkIfType(FlailHelper.getInstance()));
  }

  /**
   * A method that tests the getRange method for a katana.
   */

  @Test
  public void testGetRangeForKatana() {
    int[] expectedValue = new int[] {4, 6};
    assertTrue(Arrays.equals(expectedValue, katana.getRange()));
  }

  /**
   * A method that tests the getRange method for a twoHandedSword.
   */

  @Test
  public void testGetRangeForTwoHandedSword() {
    int[] expectedValue = new int[] {8, 12};
    assertTrue(Arrays.equals(expectedValue, twoHandedSword.getRange()));
  }

  /**
   * A method that tests the getRange method for a broadSword.
   */

  @Test
  public void testGetRangeForBroadSword() {
    int[] expectedValue = new int[] {6, 10};
    assertTrue(Arrays.equals(expectedValue, broadSword.getRange()));
  }

  /**
   * A method that tests the getRange method for an axe.
   */

  @Test
  public void testGetRangeForAxe() {
    int[] expectedValue = new int[] {6, 10};
    assertTrue(Arrays.equals(expectedValue, axe.getRange()));
  }

  /**
   * A method that tests the getRange method for a flail.
   */

  @Test
  public void testGetRangeForFlail() {
    int[] expectedValue = new int[] {8, 12};
    assertTrue(Arrays.equals(expectedValue, flail.getRange()));
  }

  //
  /**
   * A method that tests the getName method for a katana.
   */

  @Test
  public void testGetNameForKatana() {
    String expectedValue = "katana";
    assertEquals(expectedValue, katana.getName());
  }

  /**
   * A method that tests the getName method for a twoHandedSword.
   */

  @Test
  public void testGetNameForTwoHandedSword() {
    String expectedValue = "twoHandedSword";
    assertEquals(expectedValue, twoHandedSword.getName());
  }

  /**
   * A method that tests the getName method for a broadSword.
   */

  @Test
  public void testGetNameForBroadSword() {
    String expectedValue = "broadSword";
    assertEquals(expectedValue, broadSword.getName());
  }

  /**
   * A method that tests the getName method for an axe.
   */

  @Test
  public void testGetNameForAxe() {
    String expectedValue = "axe";
    assertEquals(expectedValue, axe.getName());
  }

  /**
   * A method that tests the getName method for a flail.
   */

  @Test
  public void testGetNameForFlail() {
    String expectedValue = "flail";
    assertEquals(expectedValue, flail.getName());
  }


}
