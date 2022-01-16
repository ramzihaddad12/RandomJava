import static org.junit.Assert.assertEquals;

import animal.Size;
import org.junit.Test;


/**
 * A tests that test the functionality of the size enum class.
 */

public class SizeTest {

  /**
   * A method that tests the getArea method.
   */

  @Test
  public void testGetArea() {
    int expectedValueForSmall = 1;
    int expectedValueForMedium = 5;
    int expectedValueForLarge = 10;

    assertEquals(expectedValueForSmall, Size.SMALL.getArea());
    assertEquals(expectedValueForMedium, Size.MEDIUM.getArea());
    assertEquals(expectedValueForLarge, Size.LARGE.getArea());

  }

  /**
   * A method that tests the getFoodPortion method.
   */

  @Test
  public void testGeFoodPortion() {
    int expectedValueForSmall = 100;
    int expectedValueForMedium = 250;
    int expectedValueForLarge = 500;

    assertEquals(expectedValueForSmall, Size.SMALL.getFoodPortion());
    assertEquals(expectedValueForMedium, Size.MEDIUM.getFoodPortion());
    assertEquals(expectedValueForLarge, Size.LARGE.getFoodPortion());
  }
}
