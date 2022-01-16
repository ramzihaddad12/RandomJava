package randomize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents MockRandomness object  which involves mocking
 * random variables for an unwrapped dungeon with monsters.
 */

public class MockRandomnessForUnwrappedWithMonsters extends Randomness {
  private List<Integer> values;
  /**
   * A constructor for MockRandomness.
   */

  public MockRandomnessForUnwrappedWithMonsters() {
    this.values = new ArrayList<>();

    values.addAll(Arrays.asList(57,
            14,
            28,
            63,
            49,
            22,
            21,
            3,
            38,
            15,
            15,
            65,
            12,
            37,
            7,
            36,
            25,
            32,
            38,
            10,
            8,
            48,
            17,
            56,
            34,
            31,
            50,
            48,
            32,
            26,
            11,
            21,
            6,
            25,
            43,
            43,
            8,
            15,
            39,
            43,
            23,
            31,
            6,
            40,
            35,
            32,
            30,
            22,
            27,
            0,
            26,
            21,
            28,
            16,
            11,
            31,
            6,
            11,
            29,
            29,
            4,
            2,
            24,
            32,
            4,
            5,
            1,
            6,
            3,
            17,
            6,
            18,
            2,
            8,
            2,
            2,
            2,
            18,
            1,
            3,
            3,
            1,
            6,
            3,
            6,
            2,
            2,
            5,
            6,
            1,
            1,
            4,
            0,
            5,
            4,
            0,
            2,
            3,
            7,
            0));
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
