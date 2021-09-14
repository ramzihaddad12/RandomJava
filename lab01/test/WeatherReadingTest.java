import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import weather.StevensonReading;
import weather.WeatherReading;

/**
 * A JUnit test class for the WeatherReading class.
 */

public class WeatherReadingTest {
  private WeatherReading weatherReading;

  protected WeatherReading reading(double airTemperature, double dewPoint,
                                   double windSpeed, double totalRain) {
    return new StevensonReading(airTemperature, dewPoint, windSpeed, totalRain);
  }

  /**
   * A setup method that runs before any test and creates weatherReading object needed for tests.
   */

  @Before
  public void setUp() {
    weatherReading = reading(37.4, 20.1, 5.7, 41.2);
  }

  /**
   * A method that tests the invalidity of having a dew point greater than the air temperature.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidDewPoint() {
    reading(37.4, 38.1, 5.4, 41.2);
  }

  /**
   * A method that tests the invalidity of having a relative humidity greater than
   * 100 / the difference between the actual temperature and the dew point greater than 20.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRelativeHumidity() {
    reading(37.4, 10, 5.4, 41.2);
  }

  /**
   * A method that tests the invalidity of having a negative wind speed.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidWindSpeed() {
    reading(37.4, 20.1, -2.1, 41.2);
  }

  /**
   * A method that tests the invalidity of having negative total rain.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidTotalRain() {
    weatherReading = reading(37.4, 20.1, 5.7, -1.2);
  }

  /**
   * A method that tests the getTemperature method.
   */

  @Test
  public void testGetTemperature() {
    int expectedValue = 37;
    assertEquals(expectedValue, weatherReading.getTemperature());
  }

  /**
   * A method that tests the getDewPoint method.
   */

  @Test
  public void testGetDewPoint() {
    int expectedValue = 20;
    assertEquals(expectedValue, weatherReading.getDewPoint());
  }

  /**
   * A method that tests the getWindSpeed method.
   */

  @Test
  public void testGetWindSpeed() {
    int expectedValue = 6;
    assertEquals(expectedValue, weatherReading.getWindSpeed());
  }

  /**
   * A method that tests the getTotalRain method.
   */

  @Test
  public void testGetTotalRain() {
    int expectedValue = 41;
    assertEquals(expectedValue, weatherReading.getTotalRain());
  }

  /**
   * A method that tests the getRelativeHumidity method.
   */

  @Test
  public void testGetRelativeHumidity() {
    int expectedValue = (int) Math.round(100 - 5 * (37.4 - 20.1));
    assertEquals(expectedValue, weatherReading.getRelativeHumidity());
  }

  /**
   * A method that tests the getHeatIndex method.
   */

  @Test
  public void testGetHeatIndex() {
    double[][] heatIndexFormula
            = {{-8.78469475556, 0, 0},
                {1.61139411, 1, 0}, {2.33854883889, 0, 1}, {-0.14611605, 1, 1},
                {-0.012308094, 2, 0}, {-0.0164248277778, 0, 2},
                {0.002211732, 2, 1}, {0.00072546, 1, 2}, {-0.000003582, 2, 2}};
    double result = 0;
    for (int term = 0; term < heatIndexFormula.length; term++) {
      result += heatIndexFormula[term][0]
              * Math.pow(37.4, heatIndexFormula[term][1])
              * Math.pow(100 - 5 * (37.4 - 20.1), heatIndexFormula[term][2]);
    }

    int expectedValue = (int) Math.round(result);

    assertEquals(expectedValue, weatherReading.getHeatIndex());
  }

  /**
   * A method that tests the getWindChill method.
   */

  @Test
  public void testGetWindChill() {
    double[][] windChillFormula
            = {{35.74, 0, 0}, {0.6215, 1, 0}, {-35.75, 0, 0.16}, {0.4275, 1, 0.16}};
    double result = 0;
    for (int term = 0; term < windChillFormula.length; term++) {
      result += windChillFormula[term][0]
              * Math.pow(1.8 * 37.4 + 32, windChillFormula[term][1])
              * Math.pow(5.7, windChillFormula[term][2]);
    }

    int expectedValue = (int) Math.round(result);
    assertEquals(expectedValue, weatherReading.getWindChill());
  }

  /**
   * A method that tests the equals method.
   */

  @Test
  public void testEquals() {
    WeatherReading anotherWeatherReading = reading(37.3, 20.4, 5.8, 41.1);

    assertTrue(weatherReading.equals(weatherReading));
    assertTrue(weatherReading.equals(anotherWeatherReading));
    assertTrue(anotherWeatherReading.equals(weatherReading));
    assertFalse(weatherReading.equals(reading(34.2, 22.1, 6.4, 32.1)));
  }

  /**
   * A method that tests the toString method.
   */

  @Test
  public void testToString() {
    WeatherReading anotherWeatherReading = reading(37.3, 20.4, 5.8, 41.1);
    assertEquals(anotherWeatherReading.toString(), weatherReading.toString());
  }

  /**
   * A method that tests the hashCode method.
   */

  @Test
  public void testHashCode() {
    WeatherReading anotherWeatherReading = reading(37.3, 20.4, 5.8, 41.1);
    assertEquals(weatherReading.hashCode(), anotherWeatherReading.hashCode());
  }
}