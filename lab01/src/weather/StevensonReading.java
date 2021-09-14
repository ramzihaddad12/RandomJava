package weather;

/**
 * Stevenson Reading of the weather which relies on the air temperature,
 * dew point, wind speed, and the total rain.
 */

public final class StevensonReading implements WeatherReading {
  private final double airTemperature;
  private final double dewPoint;
  private final double windSpeed;
  private final double relativeHumidity;
  private final double heatIndex;
  private final double windChill;
  private final double totalRain;
  private final double[][] heatIndexFormula
          = {{-8.78469475556, 0, 0},
              {1.61139411, 1, 0}, {2.33854883889, 0, 1}, {-0.14611605, 1, 1},
              {-0.012308094, 2, 0}, {-0.0164248277778, 0, 2},
              {0.002211732, 2, 1}, {0.00072546, 1, 2}, {-0.000003582, 2, 2}};
  private final double[][] windChillFormula
          = {{35.74, 0, 0}, {0.6215, 1, 0}, {-35.75, 0, 0.16}, {0.4275, 1, 0.16}};

  /**
   * Constructs a weather reading in terms of the air temperature, dew point, wind speed, and
   * the total rain.
   *
   * @param airTemperature the temperature of the air in Celsius
   * @param dewPoint       the dew point in Celsius
   * @param windSpeed      the speed of wind in miles per hour
   * @param totalRain      the total rain received in the last 24 hours in mm
   * @throws IllegalArgumentException if any argument is negative or is not mathematically possible
   */

  public StevensonReading(double airTemperature, double dewPoint,
                          double windSpeed, double totalRain) throws IllegalArgumentException {
    if (airTemperature - dewPoint < 0 || airTemperature - dewPoint > 20) {
      throw new IllegalArgumentException(
              "Difference between the air temperature and dew point must be between 0 and 20.");
    }

    if (windSpeed < 0 || totalRain < 0) {
      throw new IllegalArgumentException("Parameters cannot be negative.");
    }

    this.airTemperature = airTemperature;
    this.dewPoint = dewPoint;
    this.windSpeed = windSpeed;
    this.totalRain = totalRain;
    this.relativeHumidity = 100 - 5 * (airTemperature - dewPoint);
    this.heatIndex = compute(heatIndexFormula, airTemperature, relativeHumidity);
    this.windChill = compute(windChillFormula, celsiusToFahrenheit(airTemperature), windSpeed);
  }

  private double compute(double[][] formula, double firstParameter, double secondParameter) {
    double result = 0;
    for (int term = 0; term < formula.length; term++) {
      result += formula[term][0]
              * Math.pow(firstParameter, formula[term][1])
              * Math.pow(secondParameter, formula[term][2]);
    }
    return result;
  }

  private double celsiusToFahrenheit(double airTemperature) {
    return 1.8 * airTemperature + 32;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + getTemperature();
    result = 31 * result + getDewPoint();
    result = 31 * result + getWindSpeed();
    result = 31 * result + getTotalRain();
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof WeatherReading)) {
      return false;
    }

    WeatherReading that = (WeatherReading) o;

    return getTemperature() == that.getTemperature() && getDewPoint() == that.getDewPoint()
            && getWindSpeed() == that.getWindSpeed() && getTotalRain() == that.getTotalRain();
  }

  @Override
  public String toString() {
    return String.format("Reading: T = %d, D = %d, v = %d, rain = %d",
            getTemperature(), getDewPoint(), getWindSpeed(), getTotalRain());
  }

  /**
   * Get the temperature of this reading rounded to the nearest integer.
   *
   * @return the temperature
   */

  @Override
  public int getTemperature() {
    return (int) Math.round(airTemperature);
  }

  /**
   * Get the dew point for this reading rounded to the nearest integer.
   *
   * @return the dew point
   */

  @Override
  public int getDewPoint() {
    return (int) Math.round(dewPoint);
  }

  /**
   * Get the wind speed for this reading rounded to the nearest integer.
   *
   * @return the wind speed
   */

  @Override
  public int getWindSpeed() {
    return (int) Math.round(windSpeed);
  }

  /**
   * Get the total rain of this reading (in mm).
   *
   * @return the total rain
   */

  @Override
  public int getTotalRain() {
    return (int) Math.round(totalRain);
  }

  /**
   * Get the relative humidity of this weather reading rounded to the nearest
   * integer.
   *
   * @return the relative humidity
   */

  @Override
  public int getRelativeHumidity() {
    return (int) Math.round(relativeHumidity);
  }

  /**
   * Get the heat index for this weather reading rounded to the nearest integer.
   *
   * @return the heat index
   */

  @Override
  public int getHeatIndex() {
    return (int) Math.round(heatIndex);
  }

  /**
   * Get the wind chill rounded to the nearest integer.
   *
   * @return the wind chill
   */

  @Override
  public int getWindChill() {
    return (int) Math.round(windChill);
  }
}
