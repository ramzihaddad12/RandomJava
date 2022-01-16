package randomize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents MockRandomness which involves mocking
 * random variables.
 */

public class MockRandomness extends Randomness {
  private List<Integer> values;

  /**
   * A constructor for MockRandomness.
   */

  public MockRandomness() {
    this.values = new ArrayList<>();

    for (int i = 6; i <= 17; i++) {
      values.add(i);
    }

    for (int i = 0; i < 5; i++) {
      values.add(-5);
    }

    for (int i = 0; i < 5; i++) {
      values.add(-5);
      values.add(2);
    }

    for (int i = 0; i < 10; i++) {
      values.add(-5);
      values.add(4);
    }

    for (int i = 0; i < 5; i++) {
      values.add(10);
    }

    for (int i = 0; i < 15; i++) {
      values.add(10);
      values.add(2);
    }

    for (int i = 0; i < 40; i++) {
      values.add(10);
      values.add(3);
    }

    values.addAll(Arrays.asList(79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,35));
    values.addAll(Arrays.asList(59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,36,10));

    values.add(1);
    values.add(1);
    values.add(1);
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

  @Override
  public boolean generateBoolean() {
    return true;
  }

  @Override
  public int[] generate2ValueBetween(int min, int max) {
    return new int[] {2, 3};
  }
}
