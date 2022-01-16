import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import lookandsay.LookAndSayIterator;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


/** Test class for the LookAndSayIterator. */

public class LookAndSayIteratorTest {

  /** Test of the 2 argument LookAndSayIterator constructor when start seed is greater than end. */

  @Test(expected = IllegalArgumentException.class)
  public void testLookAndSayIterator2ArgumentConstructorWhenStartGreaterThanEnd() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(
            new BigInteger("2243"), new BigInteger("1"));
  }

  /** Test of the 2 argument LookAndSayIterator constructor when start seed contains zeroes. */

  @Test(expected = IllegalArgumentException.class)
  public void testLookAndSayIterator2ArgumentConstructorWhenStartHasZeroes() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(
            new BigInteger("22043"), new BigInteger("323248"));
  }

  /** Test of the 2 argument LookAndSayIterator constructor when start seed is not positive. */

  @Test(expected = IllegalArgumentException.class)
  public void testLookAndSayIterator2ArgumentConstructorWhenStartIsNotPositive() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(
            new BigInteger("-1"), new BigInteger("1"));
  }

  /** Test of the 1 argument LookAndSayIterator constructor when
   *  start seed is greater than the default end. */

  @Test(expected = IllegalArgumentException.class)
  public void testLookAndSayIterator1ArgumentConstructorWhenStartGreaterThanEnd() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger("9999999999"
            + "9999999999"
            + "9999999999"
            + "9999999999"
            + "9999999999"
            + "9999999999"
            + "9999999999"
            + "9999999999"
            + "9999999999"
            + "99999999999"));
  }

  /** Test of the 1 argument LookAndSayIterator constructor when start seed contains zeroes. */

  @Test(expected = IllegalArgumentException.class)
  public void testLookAndSayIterator1ArgumentConstructorWhenStartHasZeroes() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger("22043"));
  }

  /** Test of the 1 argument LookAndSayIterator constructor when start seed is not positive. */

  @Test(expected = IllegalArgumentException.class)
  public void testLookAndSayIterator1ArgumentConstructorWhenStartIsNotPositive() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger("-1"));
  }

  /** Test of the 2 argument LookAndSayIterator constructor. */

  @Test
  public void testLookAndSayIterator2ArgumentConstructor() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger("1"),
            new BigInteger("13211311123113112211"));
    assertFalse(lookAndSayIterator.hasPrevious());
    List<String> expectedValues = new ArrayList<>(Arrays.asList(
            "1",
            "11",
            "21",
            "1211",
            "111221",
            "312211",
            "13112221",
            "1113213211",
            "31131211131221"
    ));

    for (int i = 0; i < expectedValues.size(); i++) {
      assertTrue(lookAndSayIterator.hasNext());
      assertEquals(new BigInteger(expectedValues.get(i)), lookAndSayIterator.next());
    }
    assertFalse(lookAndSayIterator.hasNext());
  }

  /** Test of the 1 argument LookAndSayIterator constructor. */

  @Test
  public void testLookAndSayIterator1ArgumentConstructor() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger("1"));
    assertFalse(lookAndSayIterator.hasPrevious());
    List<String> expectedValues = new ArrayList<>(Arrays.asList(
            "1",
            "11",
            "21",
            "1211",
            "111221",
            "312211",
            "13112221",
            "1113213211",
            "31131211131221",
            "13211311123113112211",
            "11131221133112132113212221",
            "3113112221232112111312211312113211",
            "1321132132111213122112311311222113111221131221",
            "11131221131211131231121113112221121321132132211331222113112211",
            "311311222113111231131112132112311321322112111312211312111322212311322113212221"
    ));

    for (int i = 0; i < expectedValues.size(); i++) {
      assertTrue(lookAndSayIterator.hasNext());
      assertEquals(new BigInteger(expectedValues.get(i)), lookAndSayIterator.next());
    }

    assertFalse(lookAndSayIterator.hasNext());
  }


  /** Test of the default LookAndSayIterator constructor. */

  @Test
  public void testLookAndSayIteratorDefaultConstructor() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator();
    assertFalse(lookAndSayIterator.hasPrevious());
    List<String> expectedValues = new ArrayList<>(Arrays.asList(
            "1",
            "11",
            "21",
            "1211",
            "111221",
            "312211",
            "13112221",
            "1113213211",
            "31131211131221",
            "13211311123113112211",
            "11131221133112132113212221",
            "3113112221232112111312211312113211",
            "1321132132111213122112311311222113111221131221",
            "11131221131211131231121113112221121321132132211331222113112211",
            "311311222113111231131112132112311321322112111312211312111322212311322113212221"
    ));

    for (int i = 0; i < expectedValues.size(); i++) {
      assertTrue(lookAndSayIterator.hasNext());
      assertEquals(new BigInteger(expectedValues.get(i)), lookAndSayIterator.next());
    }

    assertFalse(lookAndSayIterator.hasNext());
  }

  /** Test of the hasNext method when true. */

  @Test
  public void testHasNextWhenTrue() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger("112321"));
    List<String> expectedValues = new ArrayList<>(Arrays.asList("112321",
            "2112131211",
            "1221121113111221",
            "112221123113312211",
            "21322112132123112221",
            "121113222112111312111213213211",
            "1112311332211231131112311211131211131221",
            "31121321232221121321133112132112311311123113112211",
            "1321121113121112133221121113122123211211131221121321133112132113212221",
            "11131221123113111231121123222112311311221"
                    + "1121312211231131122211211131221232112111312211312113211"));

    for (int i = 0; i < expectedValues.size(); i++) {
      assertTrue(lookAndSayIterator.hasNext());
      assertEquals(new BigInteger(expectedValues.get(i)), lookAndSayIterator.next());
    }
  }

  /** Test of the hasNext method when false when next has more than 100 digits. */

  @Test
  public void testHasNextWhenFalseWhenNextHasMoreThan100Digits() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger(
            "111312211231131112311211"
                    + "232221123113112211121312211231131122211211131221232112111312211312113211"));

    assertTrue(lookAndSayIterator.hasNext());
    lookAndSayIterator.next();
    assertFalse(lookAndSayIterator.hasNext());
  }

  /** Test of the next method when next exists. */

  @Test
  public void testNextWhenANextExists() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger("112321"));
    List<String> expectedValues = new ArrayList<>(Arrays.asList("112321",
            "2112131211",
            "1221121113111221",
            "112221123113312211",
            "21322112132123112221",
            "121113222112111312111213213211",
            "1112311332211231131112311211131211131221",
            "31121321232221121321133112132112311311123113112211",
            "1321121113121112133221121113122123211211131221121321133112132113212221",
            "11131221123113111231121123222112311311221"
                    + "1121312211231131122211211131221232112111312211312113211"));

    for (int i = 0; i < expectedValues.size(); i++) {
      assertTrue(lookAndSayIterator.hasNext());
      assertEquals(new BigInteger(expectedValues.get(i)), lookAndSayIterator.next());
    }
  }

  /** Test of the next method when next does not exist. */

  @Test(expected = NoSuchElementException.class)
  public void testNextWhenANextDoesNotExists() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger(
            "111312211231131112311211"
            + "232221123113112211121312211231131122211211131221232112111312211312113211"));
    assertEquals(new BigInteger("11131221123113111231121123222112311311221"
            + "1121312211231131122211211131221232112111312211312113211"),
            lookAndSayIterator.next());
    lookAndSayIterator.next();
  }

  /** Test of the hasPrevious method when true. */

  @Test
  public void testHasPreviousWhenTrue() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger("112321"));
    assertTrue(lookAndSayIterator.hasPrevious());
  }

  /** Test of the hasPrevious method when false when the seed has an odd number of digits. */

  @Test
  public void testHasPreviousWhenFalseBecauseOddNumberOfDigits() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger("13311"));
    assertFalse(lookAndSayIterator.hasPrevious());
  }

  /** Test of the prev method when a previous element exists. */

  @Test
  public void testPrevWhenAPreviousExists() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger("112321"));
    assertEquals(new BigInteger("13311"), lookAndSayIterator.prev());
  }

  /** Test of the prev method when a previous element does not exist. */

  @Test(expected = NoSuchElementException.class)
  public void testPrevWhenAPreviousDoesNotExists() {
    LookAndSayIterator lookAndSayIterator = new LookAndSayIterator(new BigInteger("13311"));
    lookAndSayIterator.prev();
  }

}
