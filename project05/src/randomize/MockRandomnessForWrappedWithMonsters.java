package randomize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents MockRandomness object  which involves mocking
 * random variables for a wrapped dungeon with monsters.
 */

public class MockRandomnessForWrappedWithMonsters extends Randomness {
  private List<Integer> values;
  /**
   * A constructor for MockRandomness.
   */

  public MockRandomnessForWrappedWithMonsters() {
    this.values = new ArrayList<>();

    values.addAll(Arrays.asList(73,
            29,
            57,
            6,
            48,
            20,
            0,
            85,
            81,
            31,
            12,
            81,
            43,
            53,
            22,
            2,
            8,
            17,
            41,
            71,
            47,
            67,
            10,
            19,
            41,
            34,
            45,
            19,
            37,
            41,
            45,
            35,
            60,
            6,
            29,
            48,
            35,
            44,
            23,
            31,
            30,
            0,
            0,
            10,
            9,
            47,
            24,
            5,
            2,
            14,
            45,
            31,
            34,
            13,
            39,
            38,
            35,
            35,
            32,
            49,
            46,
            31,
            5,
            2,
            5,
            3,
            7,
            2,
            1,
            15,
            1,
            28,
            1,
            16,
            2,
            21,
            1,
            21,
            3,
            8,
            2,
            3,
            0,
            4,
            2,
            1,
            6,
            2,
            4,
            1,
            2,
            5,
            6,
            1,
            4,
            5,
            2,
            2,
            4,
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
