import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import gear.Belt;
import gear.BeltHelper;
import gear.FootWearHelper;
import gear.Footwear;
import gear.Gear;
import gear.HeadGearHelper;
import gear.Headgear;
import gear.Potion;
import gear.PotionHelper;
import gear.Size;
import org.junit.Before;
import org.junit.Test;
import randomize.Randomness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This test class tests the different features for a player.
 */

public class GearTest {

  private Gear headGear;
  private Gear potion;
  private Gear belt;
  private Gear footWear;

  protected Randomness randomness;
  int seed = 50;

  /**
   * Creating the objects needed in the other tests.
   */

  @Before
  public void setUp() {
    int seed = 50;
    randomness = new Randomness(seed);
    headGear = new Headgear("headGear", seed);
    potion = new Potion("potion", seed);
    belt = new Belt("belt", seed);
    footWear = new Footwear("footWear", seed);
  }

  /**
   * A method that tests the getName method for a headGear.
   */

  @Test
  public void testGetNameForHeadGear() {
    String expectedName = "headGear";
    assertEquals(expectedName, headGear.getName());
  }

  /**
   * A method that tests the getName method for a footWear.
   */

  @Test
  public void testGetNameForFootWear() {
    String expectedName = "footWear";
    assertEquals(expectedName, footWear.getName());
  }

  /**
   * A method that tests the getName method for a belt.
   */

  @Test
  public void testGetNameForBelt() {
    String expectedName = "belt";
    assertEquals(expectedName, belt.getName());
  }

  /**
   * A method that tests the getName method for a potion.
   */

  @Test
  public void testGetNameForPotion() {
    String expectedName = "potion";
    assertEquals(expectedName, potion.getName());
  }

  /**
   * A method that tests the getSize method for a headGear.
   */

  @Test
  public void testGetSizeForHeadGear() {
    Size expectedSize = Size.DEFAULT;
    assertEquals(expectedSize, headGear.getSize());
  }

  /**
   * A method that tests the getSize method for a footWear.
   */

  @Test
  public void testGetSizeForFootWear() {
    Size expectedSize = Size.DEFAULT;
    assertEquals(expectedSize, footWear.getSize());
  }

  /**
   * A method that tests the getSize method for a belt.
   */

  @Test
  public void testGetSizeForBelt() {
    Size expectedSize = Size.MEDIUM;
    assertEquals(expectedSize, belt.getSize());
  }

  /**
   * A method that tests the getSize method for a potion.
   */

  @Test
  public void testGetSizeForPotion() {
    Size expectedSize = Size.DEFAULT;
    assertEquals(expectedSize, potion.getSize());
  }

  /**
   * A method that tests the getLifespan method for a headGear.
   */

  @Test
  public void testGetLifeSpanForHeadGear() {
    int expectedLifeSpan = 3;
    assertEquals(expectedLifeSpan, headGear.getLifespan());
  }

  /**
   * A method that tests the getLifespan method for a footWear.
   */

  @Test
  public void testGetLifeSpanForFootWear() {
    int expectedLifeSpan = 3;
    assertEquals(expectedLifeSpan, footWear.getLifespan());
  }

  /**
   * A method that tests the getLifespan method for a belt.
   */

  @Test
  public void testGetLifeSpanForBelt() {
    int expectedLifeSpan = 3;
    assertEquals(expectedLifeSpan, belt.getLifespan());
  }

  /**
   * A method that tests the getLifespan method for a potion.
   */

  @Test
  public void testGetLifeSpanForPotion() {
    int expectedLifeSpan = 3;
    assertEquals(expectedLifeSpan, potion.getLifespan());
  }

  //
  /**
   * A method that tests the getNumberOfUnits method for a headGear.
   */

  @Test
  public void testGetNumberOfUnitsForHeadGear() {
    int expectedNumberofUnits = 0;
    assertEquals(expectedNumberofUnits, headGear.getNumberOfUnits());
  }

  /**
   * A method that tests the getNumberOfUnits method for a footWear.
   */

  @Test
  public void testGetNumberOfUnitsForFootWear() {
    int expectedNumberofUnits = 0;
    assertEquals(expectedNumberofUnits, footWear.getNumberOfUnits());
  }

  /**
   * A method that tests the getNumberOfUnits method for a belt.
   */

  @Test
  public void testGetNumberOfUnitsForBelt() {
    int expectedNumberofUnits = 2;
    assertEquals(expectedNumberofUnits, belt.getNumberOfUnits());
  }

  /**
   * A method that tests the getNumberOfUnits method for a potion.
   */

  @Test
  public void testGetNumberOfUnitsForPotion() {
    int expectedNumberofUnits = 0;
    assertEquals(expectedNumberofUnits, potion.getNumberOfUnits());
  }

  //
  /**
   * A method that tests the getValue method for a headGear.
   */

  @Test
  public void testGetValueForHeadGear() {
    int expectedValue = 6;
    assertEquals(expectedValue, headGear.getValue());
  }

  /**
   * A method that tests the getValue method for a footWear.
   */

  @Test
  public void testGetValueForFootWear() {
    int expectedValue = 6;
    assertEquals(expectedValue, footWear.getValue());
  }

  /**
   * A method that tests the getValue method for a belt.
   */

  @Test
  public void testGetValueForBelt() {
    int expectedValue = 5;
    assertEquals(expectedValue, belt.getValue());
  }

  /**
   * A method that tests the getValue method for a potion.
   */

  @Test
  public void testGetValueForPotion() {
    int expectedValue = 5;
    assertEquals(expectedValue, potion.getValue());
  }

  //
  /**
   * A method that tests the getAttributeToEffect method for a headGear.
   */

  @Test
  public void testGetAttributeToEffectForHeadGear() {
    int[] expectedValue = new int[] {2};
    assertTrue(Arrays.equals(expectedValue, headGear.getAttributeToEffect()));
  }

  /**
   * A method that tests the getAttributeToEffect method for a footWear.
   */

  @Test
  public void testGetAttributeToEffectForFootWear() {
    int[] expectedValue = new int[] {3};
    assertTrue(Arrays.equals(expectedValue, footWear.getAttributeToEffect()));
  }

  /**
   * A method that tests the getAttributeToEffect method for a belt.
   */

  @Test
  public void testGetAttributeToEffectForBelt() {
    int expectedValue = 2;

    assertEquals(expectedValue, belt.getAttributeToEffect().length);
  }

  /**
   * A method that tests the getAttributeToEffect method for a potion.
   */

  @Test
  public void testGetAttributeToEffectForPotion() {
    int[] expectedValue = new int[] {3};
    assertTrue(Arrays.equals(expectedValue, potion.getAttributeToEffect()));
  }

  //
  /**
   * A method that tests the checkIfType method for a footWear
   * and tests if footWear is of type Headgear.
   */

  @Test
  public void testCheckIfTypeHeadGearForFootWear() {
    assertFalse(footWear.checkIfType(HeadGearHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a footWear
   * and tests if footWear is of type FootWear.
   */

  @Test
  public void testCheckIfTypeFootWearForFootWear() {
    assertTrue(footWear.checkIfType(FootWearHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a footWear
   * and tests if footWear is of type Belt.
   */

  @Test
  public void testCheckIfTypeBeltForFootWear() {
    assertFalse(footWear.checkIfType(BeltHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a footWear
   * and tests if footWear is of type Potion.
   */

  @Test
  public void testCheckIfTypePotionForFootWear() {
    assertFalse(footWear.checkIfType(PotionHelper.getInstance()));
  }

  //
  /**
   * A method that tests the checkIfType method for a headGear
   * and tests if headGear is of type Headgear.
   */

  @Test
  public void testCheckIfTypeHeadGearForHeadGear() {
    assertTrue(headGear.checkIfType(HeadGearHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a headGear
   * and tests if headGear is of type FootWear.
   */

  @Test
  public void testCheckIfTypeFootWearForHeadGear() {
    assertFalse(headGear.checkIfType(FootWearHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a headGear
   * and tests if headGear is of type Belt.
   */

  @Test
  public void testCheckIfTypeBeltForHeadGear() {
    assertFalse(headGear.checkIfType(BeltHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a headGear
   * and tests if headGear is of type Potion.
   */

  @Test
  public void testCheckIfTypePotionForHeadGear() {
    assertFalse(headGear.checkIfType(PotionHelper.getInstance()));
  }

  //
  /**
   * A method that tests the checkIfType method for a belt
   * and tests if belt is of type Headgear.
   */

  @Test
  public void testCheckIfTypeHeadGearForBelt() {
    assertFalse(belt.checkIfType(HeadGearHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a belt
   * and tests if belt is of type FootWear.
   */

  @Test
  public void testCheckIfTypeFootWearForBelt() {
    assertFalse(belt.checkIfType(FootWearHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a belt
   * and tests if belt is of type Belt.
   */

  @Test
  public void testCheckIfTypeBeltForBelt() {
    assertTrue(belt.checkIfType(BeltHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a belt
   * and tests if belt is of type Potion.
   */

  @Test
  public void testCheckIfTypePotionForBelt() {
    assertFalse(belt.checkIfType(PotionHelper.getInstance()));
  }

  //
  /**
   * A method that tests the checkIfType method for a potion
   * and tests if potion is of type Headgear.
   */

  @Test
  public void testCheckIfTypeHeadGearForPotion() {
    assertFalse(potion.checkIfType(HeadGearHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a potion
   * and tests if potion is of type FootWear.
   */

  @Test
  public void testCheckIfTypeFootWearForPotion() {
    assertFalse(potion.checkIfType(FootWearHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a potion
   * and tests if potion is of type Belt.
   */

  @Test
  public void testCheckIfTypeBeltForPotion() {
    assertFalse(potion.checkIfType(BeltHelper.getInstance()));
  }

  /**
   * A method that tests the checkIfType method for a potion
   * and tests if potion is of type Potion.
   */

  @Test
  public void testCheckIfTypePotionForPotion() {
    assertTrue(potion.checkIfType(PotionHelper.getInstance()));
  }

  //
  /**
   * A method that tests the compareTo method for a potion
   * with a Headgear.
   */

  @Test
  public void testCompareToHeadGearForPotion() {
    assertTrue(potion.compareTo(HeadGearHelper.getInstance()) > 0);
  }

  /**
   * A method that tests the compareTo method for a potion
   * with a Footwear.
   */

  @Test
  public void testCompareToFootWearForPotion() {
    assertTrue(potion.compareTo(FootWearHelper.getInstance()) < 0);
  }

  /**
   * A method that tests the compareTo method for a potion
   * with a Belt.
   */

  @Test
  public void testCompareToBeltForPotion() {
    assertTrue(potion.compareTo(BeltHelper.getInstance()) < 0);
  }

  /**
   * A method that tests the compareTo method for a potion
   * with another potion.
   */

  @Test
  public void testCompareToPotionForPotion() {
    assertTrue(potion.compareTo(PotionHelper.getInstance())
            == potion.getName().compareTo(PotionHelper.getInstance().getName()));
  }

  //
  /**
   * A method that tests the compareTo method for a belt
   * with a Headgear.
   */

  @Test
  public void testCompareToHeadGearForBelt() {
    assertTrue(belt.compareTo(
            HeadGearHelper.getInstance()) > 0);
  }

  /**
   * A method that tests the compareTo method for a belt
   * with a Footwear.
   */

  @Test
  public void testCompareToFootWearForBelt() {
    assertTrue(belt.compareTo(FootWearHelper.getInstance()) < 0);
  }

  /**
   * A method that tests the compareTo method for a belt
   * with another Belt.
   */

  @Test
  public void testCompareToBeltForBelt() {
    assertTrue(belt.compareTo(BeltHelper.getInstance())
            == belt.getName().compareTo(BeltHelper.getInstance().getName()));

  }

  /**
   * A method that tests the compareTo method for a belt
   * with a potion.
   */

  @Test
  public void testCompareToPotionForBelt() {
    assertTrue(belt.compareTo(
            PotionHelper.getInstance()) > 0);
  }

  //
  /**
   * A method that tests the compareTo method for a headGear
   * with another Headgear.
   */

  @Test
  public void testCompareToHeadGearForHeadGear() {
    assertTrue(headGear.compareTo(HeadGearHelper.getInstance())
            == headGear.getName().compareTo(HeadGearHelper.getInstance().getName()));
  }

  /**
   * A method that tests the compareTo method for a headGear
   * with a Footwear.
   */

  @Test
  public void testCompareToFootWearForHeadGear() {
    assertTrue(headGear.compareTo(
            FootWearHelper.getInstance()) < 0);
  }

  /**
   * A method that tests the compareTo method for a headGear
   * with a Belt.
   */

  @Test
  public void testCompareToBeltForHeadGear() {
    assertTrue(headGear.compareTo(BeltHelper.getInstance()) < 0);

  }

  /**
   * A method that tests the compareTo method for a headGear
   * with a potion.
   */

  @Test
  public void testCompareToPotionForHeadGear() {
    assertTrue(headGear.compareTo(PotionHelper.getInstance()) < 0);
  }

  //
  /**
   * A method that tests the compareTo method for a footWear
   * with a Headgear.
   */

  @Test
  public void testCompareToHeadGearForFootwear() {
    assertTrue(footWear.compareTo(HeadGearHelper.getInstance()) > 0);

  }

  /**
   * A method that tests the compareTo method for a footWear
   * with another Footwear.
   */

  @Test
  public void testCompareToFootWearForFootwear() {
    assertTrue(footWear.compareTo(FootWearHelper.getInstance())
            == footWear.getName().compareTo(FootWearHelper.getInstance().getName()));
  }

  /**
   * A method that tests the compareTo method for a footWear
   * with a Belt.
   */

  @Test
  public void testCompareToBeltForFootwear() {
    assertTrue(footWear.compareTo(
            BeltHelper.getInstance()) > 0);

  }

  /**
   * A method that tests the compareTo method for a footWear
   * with a potion.
   */

  @Test
  public void testCompareToPotionForFootwear() {
    assertTrue(footWear.compareTo(PotionHelper.getInstance()) > 0);
  }

  /**
   * A method that tests sorting a list of
   * gears where all gears are present multiple times.
   */

  @Test
  public void testSortingListOfGearsWhereAllGearsArePresent() {

    Gear headGear2 = new Headgear("headGear2");
    Gear potion2 = new Potion("potion2");
    Gear footWear2 = new Footwear("footWear2");
    Gear belt2 = new Belt("belt2");

    List<Gear> list = new ArrayList<>(Arrays.asList(
            potion, footWear, headGear, belt, belt2, headGear2, footWear2, potion2));

    Collections.sort(list);
    assertEquals(headGear, list.get(0));
    assertEquals(headGear2, list.get(1));

    assertEquals(potion, list.get(2));
    assertEquals(potion2, list.get(3));

    assertEquals(belt, list.get(4));
    assertEquals(belt2, list.get(5));

    assertEquals(footWear, list.get(6));
    assertEquals(footWear2, list.get(7));
  }

  //
  /**
   * A method that tests the equals method for a footWear
   * with a Headgear.
   */

  @Test
  public void testEqualsHeadGearForFootwear() {
    assertFalse(footWear.equals(HeadGearHelper.getInstance()));

  }

  /**
   * A method that tests the equals method for a footWear
   * with another Footwear with different attributes.
   */

  @Test
  public void testEqualsFootWearForFootwearWhenTheyAreDifferent() {
    assertFalse(footWear.equals(FootWearHelper.getInstance()));
  }

  /**
   * A method that tests the equals method for a footWear
   * with another Footwear with same attributes.
   */

  @Test
  public void testEqualsFootWearForFootwearWhenTheyAreTheSame() {
    Gear footWear2 = new Footwear("footWear", 50);
    assertTrue(footWear.equals(footWear2));
    assertTrue(footWear2.equals(footWear));

  }

  /**
   * A method that tests the equals method for a footWear
   * with a Belt.
   */

  @Test
  public void testEqualsBeltForFootwear() {
    assertFalse(footWear.equals(BeltHelper.getInstance()));

  }

  /**
   * A method that tests the equals method for a footWear
   * with a potion.
   */

  @Test
  public void testEqualsPotionForFootwear() {
    assertFalse(footWear.equals(PotionHelper.getInstance()));
  }

  //
  /**
   * A method that tests the equals method for a headGear
   * with another Headgear with different attributes.
   */

  @Test
  public void testEqualsHeadGearForHeadgearWhenTheyAreDifferent() {
    assertFalse(headGear.equals(HeadGearHelper.getInstance()));

  }

  /**
   * A method that tests the equals method for a headGear
   * with another Headgear with same attributes.
   */

  @Test
  public void testEqualsHeadGearForHeadgearWhenTheyAreTheSame() {
    assertFalse(headGear.equals(HeadGearHelper.getInstance()));

    Gear headGear2 = new Headgear("headGear", 50);
    assertTrue(headGear.equals(headGear2));
    assertTrue(headGear2.equals(headGear));

  }

  /**
   * A method that tests the equals method for a headGear
   * with a Footwear.
   */

  @Test
  public void testEqualsFootWearForHeadgear() {
    assertFalse(headGear.equals(FootWearHelper.getInstance()));
  }

  /**
   * A method that tests the equals method for a headGear
   * with a Belt.
   */

  @Test
  public void testEqualsBeltForHeadgear() {
    assertFalse(headGear.equals(BeltHelper.getInstance()));

  }

  /**
   * A method that tests the equals method for a headGear
   * with a potion.
   */

  @Test
  public void testEqualsPotionForHeadgear() {
    assertFalse(headGear.equals(PotionHelper.getInstance()));
  }

  //
  /**
   * A method that tests the equals method for a potion
   * with a headGear.
   */

  @Test
  public void testEqualsHeadGearForPotion() {
    assertFalse(potion.equals(HeadGearHelper.getInstance()));
  }

  /**
   * A method that tests the equals method for a potion
   * with a Footwear.
   */

  @Test
  public void testEqualsFootWearForPotion() {
    assertFalse(potion.equals(FootWearHelper.getInstance()));
  }

  /**
   * A method that tests the equals method for a potion
   * with a Belt.
   */

  @Test
  public void testEqualsBeltForPotion() {
    assertFalse(potion.equals(BeltHelper.getInstance()));

  }
  /**
   * A method that tests the equals method for a potion
   * with another potion with different attributes.
   */

  @Test
  public void testEqualsPotionForPotionWhenTheyAreDifferent() {
    assertFalse(potion.equals(PotionHelper.getInstance()));
  }

  /**
   * A method that tests the equals method for a potion
   * with another potion with same attributes.
   */

  @Test
  public void testEqualsPotionForPotionWhenTheyAreTheSame() {
    Gear potion2 = new Potion("potion", 50);
    assertTrue(potion.equals(potion2));
    assertTrue(potion2.equals(potion));
  }

  //
  /**
   * A method that tests the equals method for a belt
   * with a headGear.
   */

  @Test
  public void testEqualsHeadGearForBelt() {
    assertFalse(belt.equals(HeadGearHelper.getInstance()));
  }

  /**
   * A method that tests the equals method for a belt
   * with a Footwear.
   */

  @Test
  public void testEqualsFootWearForBelt() {
    assertFalse(belt.equals(FootWearHelper.getInstance()));
  }

  /**
   * A method that tests the equals method for a belt
   * with a potion .
   */

  @Test
  public void testEqualsPotionForBelt() {
    assertFalse(belt.equals(PotionHelper.getInstance()));
  }
  /**
   * A method that tests the equals method for a belt
   * with another belt with different attributes.
   */

  @Test
  public void testEqualsBeltForBeltWhenTheyAreDifferent() {
    assertFalse(belt.equals(BeltHelper.getInstance()));

  }

  /**
   * A method that tests the equals method for a belt
   * with another belt with same attributes.
   */

  @Test
  public void testEqualsBeltForBeltWhenTheyAreTheSame() {
    assertTrue(belt.equals(belt));
  }

}