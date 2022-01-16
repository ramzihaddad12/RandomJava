import static org.junit.Assert.assertEquals;

import animal.Animal;
import animal.Monkey;
import animal.Sex;
import animal.Size;
import animal.Species;
import animal.SpiderMonkey;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A tests that test the functionality of the monkey class.
 */
public class MonkeyTest {
  private static Animal spiderMonkey;

  protected static Animal monkey(String name, int age, Size size,
                                 Sex sex, int weight, String favFood, Species species) {
    return new Monkey(name, age, size, sex, weight, favFood, species);
  }

  /**
   * A setup method that runs before any test and creates a monkey object needed for tests.
   */

  @BeforeClass
  public static void setUp() {
    spiderMonkey = monkey("spidey", 1, Size.SMALL,
            Sex.MALE, 33, "Banana", SpiderMonkey.getInstance());
  }

  /**
   * A method that tests the invalidity of having a negative age.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidAge() {
    monkey("spidey", -1, Size.SMALL, Sex.MALE, 33, "Banana", SpiderMonkey.getInstance());
  }

  /**
   * A method that tests the invalidity of having a negative weight.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidWeight() {
    monkey("spidey", 1, Size.SMALL, Sex.MALE, -33, "Banana", SpiderMonkey.getInstance());
  }

  /**
   * A method that tests the invalidity of having a null sex.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidSex() {
    monkey("spidey", 1, Size.SMALL, null, -33, "Banana", SpiderMonkey.getInstance());
  }

  /**
   * A method that tests the invalidity of having a null size.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidSize() {
    monkey("spidey", 1, null, Sex.MALE, -33, "Banana", SpiderMonkey.getInstance());
  }

  /**
   * A method that tests the invalidity of having a null species.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidSpecies() {
    monkey("spidey", 1, null, Sex.MALE, -33, "Banana", null);
  }

  /**
   * A method that tests the getId method.
   */

  @Test
  public void testGetId() {
    int expectedValue = 0;
    assertEquals(expectedValue, spiderMonkey.getId());
  }

  /**
   * A method that tests the getName method.
   */

  @Test
  public void testGetName() {
    String expectedValue = "spidey";
    assertEquals(expectedValue, spiderMonkey.getName());
  }

  /**
   * A method that tests the getAge method.
   */

  @Test
  public void testGetAge() {
    int expectedValue = 1;
    assertEquals(expectedValue, spiderMonkey.getAge());
  }

  /**
   * A method that tests the getSize method.
   */

  @Test
  public void testGetSize() {
    Size expectedValue = Size.SMALL;
    assertEquals(expectedValue, spiderMonkey.getSize());
  }

  /**
   * A method that tests the getSex method.
   */

  @Test
  public void testGetSex() {
    Sex expectedValue = Sex.MALE;
    assertEquals(expectedValue, spiderMonkey.getSex());
  }

  /**
   * A method that tests the getWeight method.
   */

  @Test
  public void testGetWeight() {
    int expectedValue = 33;
    assertEquals(expectedValue, spiderMonkey.getWeight());
  }

  /**
   * A method that tests the getFavFood method.
   */

  @Test
  public void testGetFavFood() {
    String expectedValue = "Banana";
    assertEquals(expectedValue, spiderMonkey.getFavFood());
  }

  /**
   * A method that tests the getSpecies method.
   */

  @Test
  public void testGetSpecies() {
    Species expectedValue = SpiderMonkey.getInstance();
    assertEquals(expectedValue, spiderMonkey.getSpecies());
  }

  /**
   * A method that tests the setAge method.
   */

  @Test
  public void testSetAge() {
    Animal anotherSpiderMonkey = monkey("Spo", 1, Size.SMALL,
            Sex.MALE, 33, "Banana", SpiderMonkey.getInstance());
    anotherSpiderMonkey.setAge(3);
    int expectedValue = 3;
    assertEquals(expectedValue, anotherSpiderMonkey.getAge());
  }

  /**
   * A method that tests the setAge method if invalid new age.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testSetAgeIfInvalidNewAge() {
    Animal anotherSpiderMonkey = monkey("Spo", 1, Size.SMALL,
            Sex.MALE, 33, "Banana", SpiderMonkey.getInstance());
    anotherSpiderMonkey.setAge(-3);
  }

  /**
   * A method that tests the setSize method.
   */

  @Test
  public void testSetSize() {
    Animal anotherSpiderMonkey = monkey("Spo", 1, Size.SMALL,
            Sex.MALE, 33, "Banana", SpiderMonkey.getInstance());
    anotherSpiderMonkey.setSize(Size.MEDIUM);
    Size expectedSize = Size.MEDIUM;
    assertEquals(expectedSize, anotherSpiderMonkey.getSize());
  }

  /**
   * A method that tests the setSize method if null new size.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testSetSizeIfInvalidNewSize() {
    Animal anotherSpiderMonkey = monkey("Spo", 1, Size.SMALL,
            Sex.MALE, 33, "Banana", SpiderMonkey.getInstance());
    anotherSpiderMonkey.setSize(null);
  }

  /**
   * A method that tests the setSex method.
   */

  @Test
  public void testSetSex() {
    Animal anotherSpiderMonkey = monkey("Spo", 1, Size.SMALL,
            Sex.MALE, 33, "Banana", SpiderMonkey.getInstance());
    anotherSpiderMonkey.setSex(Sex.OTHER);
    Sex expectedSex = Sex.OTHER;
    assertEquals(expectedSex, anotherSpiderMonkey.getSex());
  }

  /**
   * A method that tests the setSex method if null new sex.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testSetSexIfInvalidNewSex() {
    Animal anotherSpiderMonkey = monkey("Spo", 1, Size.SMALL,
            Sex.MALE, 33, "Banana", SpiderMonkey.getInstance());
    anotherSpiderMonkey.setSex(null);
  }

  /**
   * A method that tests the setWeight method.
   */

  @Test
  public void testSetWeight() {
    Animal anotherSpiderMonkey = monkey("Spo", 1, Size.SMALL,
            Sex.MALE, 33, "Banana", SpiderMonkey.getInstance());
    anotherSpiderMonkey.setWeight(37);
    int expectedValue = 37;
    assertEquals(expectedValue, anotherSpiderMonkey.getWeight());
  }

  /**
   * A method that tests the setWeight method if invalid new weight.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testSetWeightIfInvalidNewWeight() {
    Animal anotherSpiderMonkey = monkey("Spo", 1, Size.SMALL,
            Sex.MALE, 33, "Banana", SpiderMonkey.getInstance());
    anotherSpiderMonkey.setWeight(-3);
  }

  /**
   * A method that tests the setFavFood method.
   */

  @Test
  public void testSetFavFood() {
    Animal anotherSpiderMonkey = monkey("Spo", 1, Size.SMALL,
            Sex.MALE, 33, "Banana", SpiderMonkey.getInstance());
    anotherSpiderMonkey.setFavFood("Burger");
    String expectedValue = "Burger";
    assertEquals(expectedValue, anotherSpiderMonkey.getFavFood());
  }
}
