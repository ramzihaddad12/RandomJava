import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import transmission.AutomaticTransmission;
import transmission.Transmission;

/**
 * Tests for {@link Transmission}s.
 */

public abstract class AbstractTransmissionTest {
  private Transmission bmwTransmission =
          transmission(5, 10, 15, 30, 45);
  private Transmission vwTransmission =
          transmission(5, 10, 15, 30, 45);
  private Transmission benzTransmission =
          transmission(5, 10, 15, 30, 45);

  /**
   * Constructs an instance of the class under test representing the transmission.
   *
   * @param threshold1 the speed thresholds for gear2
   * @param threshold2 the speed thresholds for gear3
   * @param threshold3 the speed thresholds for gear4
   * @param threshold4 the speed thresholds for gear5
   * @param threshold5 the speed thresholds for gear6
   * @return an instance of the class under test
   */

  protected abstract Transmission transmission(int threshold1, int threshold2,
                                               int threshold3, int threshold4, int threshold5);

  /**
   * Class for running AutomaticTransmission tests.
   */

  public static final class AutomaticTransmissionTest extends AbstractTransmissionTest {
    @Override
    protected Transmission transmission(int threshold1, int threshold2,
                                        int threshold3, int threshold4, int threshold5) {
      return new AutomaticTransmission(threshold1, threshold2, threshold3, threshold4, threshold5);
    }
  }

  /**
   * A method that tests the invalidity of having a negative speed threshold.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfNegativeSpeedThreshold() {
    transmission(5, 10, -15, 30, 45);
  }

  /**
   * A method that tests the invalidity of having a speed threshold of 0.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfZeroSpeedThreshold() {
    transmission(5, 10, 0, 30, 45);
  }

  /**
   * A method that tests the invalidity of having a speed threshold that is not in increasing order.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfUnsortedSpeedThreshold() {
    transmission(5, 10, 5, 30, 45);
  }

  /**
   * A method that tests the invalidity of having duplicate speed thresholds.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfDuplicateSpeedThreshold() {
    transmission(5, 10, 10, 30, 45);
  }

  /**
   * A method that tests the toString method.
   */

  @Test
  public void testToString() {
    Transmission unEqualTransmission =
            transmission(10, 20, 30, 40, 50);
    for (int index = 0; index < 10; index++) {
      unEqualTransmission.increaseSpeed();
    }
    assertEquals(bmwTransmission.toString(), vwTransmission.toString());
    assertNotEquals(bmwTransmission.toString(), unEqualTransmission.toString());
  }

  /**
   * A method that tests the increaseSpeed method.
   */

  @Test
  public void testIncreaseSpeed() {
    int expectedGearBefore = 0;
    for (int index = 0; index < 4; index++) {
      bmwTransmission.increaseSpeed();
    }
    int expectedSpeedAfter = 4;
    int expectedGearAfter = expectedGearBefore + 1;
    assertEquals(expectedSpeedAfter, bmwTransmission.getSpeed());
    assertEquals(expectedGearAfter, bmwTransmission.getGear());
  }

  /**
   * A method that tests the increaseSpeed method when the speed is greater than last threshold.
   */

  @Test
  public void testIncreaseSpeedWhenSpeedGreaterThanLastThreshold() {
    for (int index = 0; index < 45; index++) {
      bmwTransmission.increaseSpeed();
    }
    int expectedGear = 6;
    int expectedSpeed = 45;
    assertEquals(expectedSpeed, bmwTransmission.getSpeed());
    assertEquals(expectedGear, bmwTransmission.getGear());

    bmwTransmission.increaseSpeed();
    assertEquals(expectedGear, bmwTransmission.getGear());
  }

  /**
   * A method that tests the decreaseSpeed method.
   */

  @Test
  public void testDecreaseSpeed() {
    for (int index = 0; index < 15; index++) {
      vwTransmission.increaseSpeed();
    }
    int expectedGearBefore = 4;

    vwTransmission.decreaseSpeed();
    int expectedSpeedAfter = 14;
    int expectedGearAfter = expectedGearBefore - 1;
    assertEquals(expectedSpeedAfter, vwTransmission.getSpeed());
    assertEquals(expectedGearAfter, vwTransmission.getGear());
  }

  /**
   * A method that test the invalidity of decreasing speed to a negative value.
   */

  @Test(expected = IllegalStateException.class)
  public void testDecreaseSpeedToNegative() {
    benzTransmission.decreaseSpeed();
  }

  /**
   * A method that tests the initial gear value.
   */

  @Test
  public void testGetGearWhenIdle() {
    int expectedGearNumber = 0;
    assertEquals(expectedGearNumber, benzTransmission.getGear());
  }

  /**
   * A method that tests the getSpeed method.
   */

  @Test
  public void testGetSpeed() {
    for (int index = 0; index < 40; index++) {
      benzTransmission.increaseSpeed();
    }
    int expectedValue = 40;
    assertEquals(expectedValue, benzTransmission.getSpeed());
  }

  /**
   * A method that tests the getGear method.
   */

  @Test
  public void testGetGear() {
    for (int index = 0; index < 40; index++) {
      benzTransmission.increaseSpeed();
    }
    int expectedGear = 5;
    assertEquals(expectedGear, benzTransmission.getGear());
  }
}