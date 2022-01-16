package test;

import duration.Duration;
import duration.HmsDuration;

/**
 * Tests for {@link Duration}s.
 */
public class HmsDurationTest extends AbstractDurationTest {

  @Override
  protected Duration hms(int hours, int minutes, int seconds) {
    return new HmsDuration(hours, minutes, seconds);
  }

  @Override
  protected Duration sec(long inSeconds) {
    return new HmsDuration(inSeconds);
  }
}
