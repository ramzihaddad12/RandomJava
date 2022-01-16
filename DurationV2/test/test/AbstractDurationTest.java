package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import duration.CompactDuration;
import duration.Duration;
import duration.HmsDuration;
import org.junit.Test;


/** 
 * Tests for {@link Duration}s. 
 */
public abstract class AbstractDurationTest {

  private static long s1 = 328375982;
  private static long s2 = 299699;

  private Duration d1h23m45 = hms(1, 23, 45);
  private Duration d2h03m00 = hms(2, 3, 0);
  private Duration d457h03m00 = hms(457, 3, 0);

  /*
   * Leave this section alone: It contains two abstract methods to create
   * Durations, and concrete implementations of this testing class will supply
   * particular implementations of Duration to be used within your tests.
   */
  /**
   * Constructs an instance of the class under test representing the duration
   * given in hours, minutes, and seconds.
   *
   * @param hours   the hours in the duration
   * @param minutes the minutes in the duration
   * @param seconds the seconds in the duration
   * @return an instance of the class under test
   */
  protected abstract Duration hms(int hours, int minutes, int seconds);

  /**
   * Constructs an instance of the class under test representing the duration
   * given in seconds.
   *
   * @param inSeconds the total seconds in the duration
   * @return an instance of the class under test
   */
  protected abstract Duration sec(long inSeconds);

  /** Class for running HmsDuration tests. */
  public static final class HmsDurationTest extends AbstractDurationTest {
    @Override
    protected Duration hms(int hours, int minutes, int seconds) {
      return new HmsDuration(hours, minutes, seconds);
    }

    @Override
    protected Duration sec(long inSeconds) {
      return new HmsDuration(inSeconds);
    }
  }

  /** Class for running CompatcDuration tests. */
  public static final class CompactDurationTest extends AbstractDurationTest {
    @Override
    protected Duration hms(int hours, int minutes, int seconds) {
      return new CompactDuration(hours, minutes, seconds);
    }

    @Override
    protected Duration sec(long inSeconds) {
      return new CompactDuration(inSeconds);
    }
  }

  // The interesting tests for Durations begin here.
  // Note how all the tests are defined in terms of hms(...) and sec(...),
  // rather than being defined using "new CompactDuration(...)"
  // or "new HmsDuration(...)". In this way, they're *abstracted* over
  // which kind of Duration they're testing -- because it shouldn't matter!
  // When JUnit runs, it will find the two classes above, and instantiate them.
  // They in turn specialize the hms(...) and sec(...) methods to produce the
  // two kinds of Durations, but they inherit all the test methods below.
  // That means JUnit will run all the test methods below twice: once for
  // CompactDurations and once for HmsDurations.
  // It's almost like AbstractDurationTest is a "factory" for making tests,
  // and in fact, this is a variation on a pattern we'll see again later
  // in the course.

  @Test
  public void zeroIsZero() {
    assertEquals(0, hms(0, 0, 0).inSeconds());
  }

  @Test
  public void asHmsWorks() {
    assertEquals("1:23:45", d1h23m45.asHms());
    assertEquals("2:03:00", d2h03m00.asHms());
    assertEquals("457:03:00", d457h03m00.asHms());
  }

  @Test
  public void equalsWorks() {
    assertEquals(hms(1, 23, 45), d1h23m45);
    assertEquals(d1h23m45, d1h23m45);
    assertEquals(sec(s1), sec(s1));
    assertEquals(sec(s2), sec(s2));

    assertNotEquals(sec(s1), sec(s2));
    assertNotEquals(sec(s2), sec(s1));
    assertNotEquals(d1h23m45, d2h03m00);
    assertNotEquals(d2h03m00, d1h23m45);
    assertNotEquals(hms(1, 23, 44), hms(1, 23, 45));
  }

  @Test
  public void hashCodeIsHashOfSeconds() {
    assertEquals(Long.hashCode(s1), sec(s1).hashCode());
    assertEquals(Long.hashCode(s2), sec(s2).hashCode());
    assertEquals(Long.hashCode(d1h23m45.inSeconds()), d1h23m45.hashCode());
    assertEquals(Long.hashCode(d457h03m00.inSeconds()), d457h03m00.hashCode());
  }

  @Test
  public void hmsConstructorCarriesMinutesAndSeconds() {
    assertEquals("2:33:45", hms(1, 93, 45).asHms());
    assertEquals("2:34:08", hms(2, 33, 68).asHms());
    assertEquals("4:34:34", hms(2, 33, 7294).asHms());
  }

  @Test(expected = IllegalArgumentException.class)
  public void hmsConstructorDisallowsNegative() {
    hms(2, 4, -9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void secondsConstructorDisallowsNegative() {
    sec(-1);
  }

  @Test
  public void inSecondsIsInverseOfSecondsConstructor() {
    assertEquals(s1, sec(s1).inSeconds());
    assertEquals(s2, sec(s2).inSeconds());

    assertEquals(sec(s1), sec(sec(s1).inSeconds()));
    assertEquals(sec(s2), sec(sec(s2).inSeconds()));

    assertEquals(d1h23m45, sec(d1h23m45.inSeconds()));
    assertEquals(d2h03m00, sec(d2h03m00.inSeconds()));
    assertEquals(d457h03m00, sec(d457h03m00.inSeconds()));
  }

  @Test
  public void d1h23m03plusd2h14m45is3h37m48() {
    assertEquals(hms(3, 37, 48), hms(1, 23, 3).plus(hms(2, 14, 45)));
  }

  @Test
  public void plusCarries() {
    assertEquals(hms(3, 38, 18), hms(1, 23, 33).plus(hms(2, 14, 45)));
    assertEquals(hms(4, 19, 48), hms(1, 23, 3).plus(hms(2, 56, 45)));
    assertEquals(hms(4, 20, 18), hms(1, 23, 33).plus(hms(2, 56, 45)));
  }

  @Test
  public void addWorks() {
    assertEquals(s1 + s2, sec(s1).plus(sec(s2)).inSeconds());
    assertEquals(2 * s1 + s2, sec(2 * s1).plus(sec(s2)).inSeconds());
  }
}
