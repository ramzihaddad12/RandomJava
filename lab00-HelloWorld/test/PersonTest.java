import static org.junit.Assert.assertEquals;

import cs5010.lab0.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Person class.
 */

public class PersonTest {

  private Person john;

  /**
   * A setup method that runs before any test and creates the objects needed for the tests.
   */

  @Before
  public void setUp() {
    john = new Person("john", "doe", 1989);
  }

  /**
   * A method that tests the first name of the person.
   */

  @Test
  public void testFirst() {
    assertEquals("john", john.getFirstName());
  }

  /**
   * A method that tests the second name of the person.
   */

  @Test
  public void testSecond() {
    assertEquals("doe", john.getLastName());
  }

  /**
   * A method that tests the year of birth of the person.
   */

  @Test
  public void testYearOfBirth() {
    assertEquals(1989, john.getYearOfBirth());
  }
}
