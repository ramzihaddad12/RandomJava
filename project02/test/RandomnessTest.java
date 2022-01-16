import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import randomize.Randomness;


/**
 * This test class tests the Randomness
 * class and its different functionalities.
 */

public class RandomnessTest {

  private Randomness randomness;

  /**
   * Creating the objects needed in the other tests.
   */

  @Before
  public void setUp() {
    int seed = 50;
    randomness = new Randomness(seed);
  }

  /**
   * A method that tests the generateValueBetween method.
   */

  @Test
  public void testGenerateValueBetweenMethod() {
    int expectedValue = 17;
    assertEquals(expectedValue, randomness.generateValueBetween(6, 18));
  }

  /**
   * A method that tests the generateBoolean method.
   */

  @Test
  public void testGenerateBoolean() {
    boolean expectedValue = true;
    assertEquals(expectedValue, randomness.generateBoolean());
  }


}
