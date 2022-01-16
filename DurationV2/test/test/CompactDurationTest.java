package test;

import duration.CompactDuration;
import duration.Duration;

/**
 * Test cases specifically for the CompactDuration implementation.
 */
public class CompactDurationTest extends AbstractDurationTest {
  @Override
  protected Duration hms(int hours, int minutes, int seconds) {
    return new CompactDuration(hours, minutes, seconds);
  }

  @Override
  protected Duration sec(long inSeconds) {
    return new CompactDuration(inSeconds);
  }
}
