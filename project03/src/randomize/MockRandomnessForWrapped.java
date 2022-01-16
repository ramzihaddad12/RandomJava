package randomize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents MockRandomness object  which involves mocking
 * random variables for a wrapped dungeon.
 */

public class MockRandomnessForWrapped extends Randomness {
  private List<Integer> values;
  /**
   * A constructor for MockRandomness.
   */

  public MockRandomnessForWrapped() {
    this.values = new ArrayList<>();

    values.addAll(Arrays.asList(14,
             61,
             77,
             22,
             2,
             0,
             24,
             34,
             85,
             37,
             61,
             11,
             47,
             22,
             81,
             53,
             43,
             58,
             20,
             43,
             74,
             1,
             64,
             37,
             39,
             7,
             54,
             0,
             13,
             8,
             38,
             46,
             62,
             31,
             54,
             57,
             12,
             29,
             46,
             21,
             42,
             11,
             49,
             47,
             43,
             8,
             16,
             8,
             2,
             37,
             31,
             0,
             4,
             21,
             35,
             2,
             1,
             3,
             7,
             3,
             7,
             1,
             7,
             19,
             2,
             4,
             3,
             20,
             3,
             21,
             1,
             12,
             1));
  }

  @Override
  public int generateValueBetween(int min, int max) {
    if (values.isEmpty()) {
      throw new IllegalArgumentException("No more values can be generated");
    }
    int value = values.get(0);
    values.remove(0);
    return value;
  }
}
