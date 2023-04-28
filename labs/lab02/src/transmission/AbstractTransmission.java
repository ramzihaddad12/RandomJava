package transmission;

import java.util.Collections;
import java.util.List;

abstract class AbstractTransmission implements Transmission {
  @Override
  public String toString() {
    return String.format("Transmission (speed = %d, gear = %d)", getSpeed(), getGear());
  }

  //checks the validity of the speed thresholds
  protected static void checkValidity(List<Integer> speedThresholds)
          throws IllegalArgumentException {
    if (speedThresholds.size() != 5 || Collections.min(speedThresholds) <= 0) {
      throw new IllegalArgumentException(
              "Speed thresholds should be of size 5 and contain positive values");
    }
    for (int index = 0; index < speedThresholds.size() - 1; index++) {
      if (speedThresholds.get(index) >= speedThresholds.get(index + 1)) {
        throw new IllegalArgumentException("Speed threshold are not sorted or are not distinct");
      }
    }
  }

  //calculates the gear number based on where the current speed is in the list of speed thresholds
  protected static int calculateGearNumber(int speed, List<Integer> speedThresholds) {
    if (speed == 0) {
      return 0;
    }
    if (0 < speed  && speed < speedThresholds.get(0)) {
      return 1;
    }

    for (int i = 0; i < speedThresholds.size() - 1; i++) {
      if (speedThresholds.get(i) <= speed && speed < speedThresholds.get(i + 1)) {
        return i + 2;
      }
    }
    return 6;
  }
}
