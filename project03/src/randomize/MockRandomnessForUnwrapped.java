package randomize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents MockRandomness object  which involves mocking
 * random variables for an unwrapped dungeon.
 */

public class MockRandomnessForUnwrapped extends Randomness {
  private List<Integer> values;
  /**
   * A constructor for MockRandomnessForUnwrapped.
   */

  public MockRandomnessForUnwrapped() {
    this.values = new ArrayList<>();

    values.addAll(Arrays.asList(
            61,
            78,
            56,
            6,
            51,
            37,
            10,
            38,
            29,
            72,
            65,
            33,
            20,
            14,
            11,
            63,
            36,
            41,
            9,
            44,
            30,
            29,
            56,
            44,
            10,
            42,
            45,
            54,
            11,
            50,
            38,
            37,
            21,
            0,
            12,
            38,
            9,
            33,
            6,
            11,
            6,
            32,
            11,
            19,
            3,
            12,
            40,
            10,
            6,
            34,
            1,
            25,
            31,
            21,
            37,
            19,
            10,
            21,
            15,
            30,
            18,
            33,
            25,
            18,
            1,
            3,
            28,
            2,
            35,
            9,
            11,
            14,
            24,
            3,
            4,
            2,
            5,
            3,
            5,
            7,
            2,
            3,
            0,
            2,
            7,
            2,
            6,
            1
    ));
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
