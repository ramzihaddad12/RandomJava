import static org.junit.Assert.assertEquals;

import animal.Howler;
import animal.Species;
import animal.SpiderMonkey;
import animal.SquirrelMonkey;
import org.junit.Test;

/**
 * A tests that test the functionality of the species interface.
 */

public class SpeciesTest {
  /**
   * A method that tests the validity of SpiderMonkey being a singleton.
   */

  @Test
  public void testSpiderMonkey() {
    Species spiderMonkey = SpiderMonkey.getInstance();
    Species anotherSpiderMonkey = SpiderMonkey.getInstance();
    assertEquals(spiderMonkey, anotherSpiderMonkey);
  }

  /**
   * A method that tests the validity of SquirrelMonkey being a singleton.
   */

  @Test
  public void testSquirrelMonkey() {
    Species squirrelMonkey = SquirrelMonkey.getInstance();
    Species anotherSquirrelMonkey = SquirrelMonkey.getInstance();
    assertEquals(squirrelMonkey, anotherSquirrelMonkey);
  }

  /**
   * A method that tests the validity of Howler being a singleton.
   */

  @Test
  public void testHowler() {
    Species howlerMonkey = Howler.getInstance();
    Species anotherHowlerMonkey = Howler.getInstance();
    assertEquals(howlerMonkey, anotherHowlerMonkey);
  }
}
