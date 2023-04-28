package transmission;

import java.util.Arrays;
import java.util.List;

/**
 * Automatic transmission of a car which relies on the speed of the car,
 * and the gear number it is on given the speed thresholds for each
 * of the six gears.
 */

public class AutomaticTransmission extends AbstractTransmission {
  private final List<Integer> speedThresholds;
  private int speed;
  private int gearNumber;


  /**
   * Constructs an automatic transmission in terms of the speed of the car and the speed thresholds
   * for each of the 6 available gears.
   *
   * @param threshold1 the speed thresholds for gear2
   * @param threshold2 the speed thresholds for gear3
   * @param threshold3 the speed thresholds for gear4
   * @param threshold4 the speed thresholds for gear5
   * @param threshold5 the speed thresholds for gear6
   * @throws IllegalArgumentException if speed thresholds not mathematically possible
   */
  public AutomaticTransmission(int threshold1, int threshold2,
                               int threshold3, int threshold4, int threshold5)
          throws IllegalArgumentException {
    List<Integer> speedThresholds = Arrays.asList(threshold1, threshold2,
            threshold3, threshold4, threshold5);
    checkValidity(speedThresholds);
    this.speedThresholds = speedThresholds;
    this.speed = 0;
    this.gearNumber = 0;
  }

  @Override
  public void increaseSpeed() {
    int speedIncrement = 1;
    speed += speedIncrement;
    gearNumber = calculateGearNumber(speed, speedThresholds);
  }

  @Override
  public void decreaseSpeed() throws IllegalStateException {
    int speedDecrement = 1;
    if (speed < speedDecrement) {
      throw new IllegalStateException("Speed cannot be negative");
    }
    speed -= speedDecrement;
    gearNumber = calculateGearNumber(speed, speedThresholds);
  }

  @Override
  public int getSpeed() {
    return speed;
  }

  @Override
  public int getGear() {
    return gearNumber;
  }
}
