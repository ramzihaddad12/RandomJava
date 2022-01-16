import static org.junit.Assert.assertEquals;

import animal.Animal;
import animal.Howler;
import animal.Monkey;
import animal.Sex;
import animal.Size;
import animal.SpiderMonkey;
import animal.SquirrelMonkey;
import house.AnimalsWithLocation;
import house.House;
import house.Sign;
import org.junit.Test;
import sanctuary.MonkeySanctuary;
import sanctuary.Sanctuary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * A tests that test the functionality of the sanctuary class.
 */

public class SanctuaryTest {
  /**
   * A method that tests the monkey sanctuary constructor.
   */

  @Test
  public void testSanctuaryConstructor() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    int expectedNumberOfCagesInIsolation = 10;
    assertEquals(expectedNumberOfCagesInIsolation, sanctuary.getNumberOfCagesInIsolation());

    int expectedNumberOfEnclosures = 2;
    assertEquals(expectedNumberOfEnclosures, sanctuary.getNumberOfEnclosures());

    List<Integer> expectedList = Arrays.asList(7, 9);
    assertEquals(expectedList, sanctuary.getCapacitiesOfEnclosures());
  }

  /**
   * A method that tests the monkey sanctuary constructor when the
   * number of enclosures is not the same as number of capacities present.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testSanctuaryConstructorWhenCapacitiesProvidedNotEqualToNumberOfEnclosures() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9, 10));
  }

  /**
   * A method that tests the monkey sanctuary constructor when the number of enclosures is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testSanctuaryConstructorWhenNumberOfEnclosuresIsNegative() {
    Sanctuary sanctuary = new MonkeySanctuary(10, -2, Arrays.asList(7, 9));
  }

  /**
   * A method that tests the monkey sanctuary constructor
   * when the number of isolation cages is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testSanctuaryConstructorWhenNumberOfIsolationCagesIsNegative() {
    Sanctuary sanctuary = new MonkeySanctuary(-1, 2, Arrays.asList(7, 9));
  }

  /**
   * A method that tests the getNumberOfCagesInIsolation method for the sanctuary.
   */

  @Test
  public void testGetNumberOfCagesInIsolation() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    int expectedValue = 10;
    assertEquals(expectedValue, sanctuary.getNumberOfCagesInIsolation());
  }

  /**
   * A method that tests the getNumberOfEnclosures method for the sanctuary.
   */

  @Test
  public void testGetNumberOfEnclosures() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    int expectedValue = 2;
    assertEquals(expectedValue, sanctuary.getNumberOfEnclosures());
  }

  /**
   * A method that tests the getCapacitiesOfEnclosures method for the sanctuary.
   */

  @Test
  public void testGetCapacitiesOfEnclosures() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    List<Integer> expectedList = Arrays.asList(7, 9);
    assertEquals(expectedList, sanctuary.getCapacitiesOfEnclosures());
  }

  /**
   * A method that tests the expandIsolation method for the sanctuary.
   */

  @Test
  public void testExpandIsolation() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    sanctuary.expandIsolation(15);
    int expectedValue = 15;
    assertEquals(expectedValue, sanctuary.getNumberOfCagesInIsolation());
  }

  /**
   * A method that tests the expandIsolation method for the sanctuary
   * when new capacity is less than current one.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testExpandIsolationWhenNewCapacityIsNegative() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    sanctuary.expandIsolation(8);
  }

  /**
   * A method that tests the expandEnclosures method for the sanctuary.
   */

  @Test
  public void testExpandEnclosures() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    sanctuary.expandEnclosures(3, Arrays.asList(10, 11, 12));
    int expectedValue = 5;
    assertEquals(expectedValue, sanctuary.getNumberOfEnclosures());
    List<Integer> expectedList = Arrays.asList(7, 9, 10, 11, 12);
    assertEquals(expectedList, sanctuary.getCapacitiesOfEnclosures());
  }

  /**
   * A method that tests the expandEnclosures method
   * for the sanctuary when new capacity is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testExpandEnclosuresWhenNewCapacityIsNegative() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    sanctuary.expandEnclosures(-3, Arrays.asList(10, 11, 12));
  }

  /**
   * A method that tests the expandEnclosures method
   * for the sanctuary when number of new enclosures not equal to number of provided capacities.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testExpandEnclosuresWhenNumberOfNewEnclosuresNotEqualToNumberOfProvidedCapacities() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    sanctuary.expandEnclosures(3, Arrays.asList(10, 11));
  }

  /**
   * A method that tests the expandExistingEnclosure method for the sanctuary.
   */

  @Test
  public void testExpandExistingEnclosures() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    sanctuary.expandExistingEnclosure(2, 11);
    int expectedValue = 2;
    assertEquals(expectedValue, sanctuary.getNumberOfEnclosures());
    List<Integer> expectedList = Arrays.asList(7, 11);
    assertEquals(expectedList, sanctuary.getCapacitiesOfEnclosures());
  }

  /**
   * A method that tests the expandExistingEnclosure method
   * for the sanctuary when new capacity is less than current one.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testExpandExistingEnclosuresWhenNewCapacityIsNegative() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    sanctuary.expandExistingEnclosure(1, 5);
  }

  /**
   * A method that tests the expandExistingEnclosure method
   * for the sanctuary when enclosure number is valid.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testExpandExistingEnclosuresWhenEnclosureNumberisInvalid() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));
    sanctuary.expandExistingEnclosure(3, 10);
  }

  /**
   * A method that tests the getAnimalsInIsolation method for one animal.
   */

  @Test
  public void testGetAnimalsInIsolation() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Banana", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));

    assertEquals(howlerMonkey, sanctuary.getAnimalsInIsolation().get(0));
  }

  /**
   * A method that tests the getAnimalsInEnclosures method for one animal.
   */

  @Test
  public void testGetAnimalsInEnclosures() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Banana", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));

    assertEquals(spiderMonkey, sanctuary.getAnimalsInEnclosures().get(0).get(0));
    assertEquals(squirrelMonkey, sanctuary.getAnimalsInEnclosures().get(1).get(0));
  }

  /**
   * A method that tests the moveToIsolation method for one animal.
   */

  @Test
  public void testMoveToIsolationForOneAnimal() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    sanctuary.moveToIsolation(spiderMonkey);

    int expectedValue = 1;
    assertEquals(expectedValue, sanctuary.getAnimalsInIsolation().size());
    assertEquals(spiderMonkey, sanctuary.getAnimalsInIsolation().get(0));
  }

  /**
   * A method that tests the moveToIsolation method when id already exists in isolation.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToIsolationWhenIdAlreadyExistsInIsolation() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    sanctuary.moveToIsolation(spiderMonkey);
    sanctuary.moveToIsolation(spiderMonkey);
  }

  /**
   * A method that tests the moveToIsolation method when no more room isolation.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToIsolationWhenNoMoreRoom() {
    Sanctuary sanctuary = new MonkeySanctuary(1, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    sanctuary.moveToIsolation(spiderMonkey);
    sanctuary.moveToIsolation(squirrelMonkey);
  }

  /**
   * A method that tests the moveToIsolation method for multiple animals.
   */

  @Test
  public void testMoveToIsolationForManyAnimals() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));

    int expectedValue = 3;
    assertEquals(expectedValue, sanctuary.getAnimalsInIsolation().size());
    assertEquals(spiderMonkey, sanctuary.getAnimalsInIsolation().get(0));
    assertEquals(squirrelMonkey, sanctuary.getAnimalsInIsolation().get(1));
    assertEquals(howlerMonkey, sanctuary.getAnimalsInIsolation().get(2));
  }

  /**
   * A method that tests the moveToIsolation method when ids already exists in isolation.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToIsolationWhenIdsAlreadyExistsInIsolation() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
  }

  /**
   * A method that tests the moveFromIsolationToEnclosure method for one animal.
   */

  @Test
  public void testMoveFromIsolationToEnclosureForOneAnimal() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));

    sanctuary.moveFromIsolationToEnclosure(spiderMonkey.getId());

    int expectedValue = 2;
    int expectedValue2 = 1;
    assertEquals(expectedValue, sanctuary.getAnimalsInIsolation().size());
    assertEquals(expectedValue2, sanctuary.getAnimalsInEnclosures().get(0).size());
    assertEquals(spiderMonkey, sanctuary.getAnimalsInEnclosures().get(0).get(0));
    assertEquals(squirrelMonkey, sanctuary.getAnimalsInIsolation().get(0));
    assertEquals(howlerMonkey, sanctuary.getAnimalsInIsolation().get(1));
  }

  /**
   * A method that tests the moveFromIsolationToEnclosure method when animal is not in isolation.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMoveFromIsolationToEnclosureWhenAnimalNotInIsolation() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey));
    sanctuary.moveFromIsolationToEnclosure(howlerMonkey.getId());
  }

  /**
   * A method that tests the moveFromIsolationToEnclosure method
   * for one animal when no more enclosures available for that species.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMoveFromIsolationToEnclosureWhenNoMoreEnclosuresForSpecificSpecies() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));

    sanctuary.moveFromIsolationToEnclosure(howlerMonkey.getId());
  }

  /**
   * A method that tests the moveFromIsolationToEnclosure method
   * for one animal when not enough capacity available.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMoveFromIsolationToEnclosureWhenNotEnoughCapacityAvailable() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal anotherSpiderMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", SpiderMonkey.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, anotherSpiderMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));

    sanctuary.moveFromIsolationToEnclosure(anotherSpiderMonkey.getId());
  }

  /**
   * A method that tests the moveFromIsolationToEnclosure method for multiple animals.
   */

  @Test
  public void testMoveFromIsolationToEnclosureForManyAnimals() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));

    int expectedValue = 1;
    assertEquals(expectedValue, sanctuary.getAnimalsInIsolation().size());
    assertEquals(spiderMonkey, sanctuary.getAnimalsInEnclosures().get(0).get(0));
    assertEquals(squirrelMonkey, sanctuary.getAnimalsInEnclosures().get(1).get(0));
    assertEquals(howlerMonkey, sanctuary.getAnimalsInIsolation().get(0));
  }

  /**
   * A method that tests the removeFromIsolation method for one animal.
   */

  @Test
  public void testRemoveFromIsolationForOneAnimal() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    assertEquals(spiderMonkey, sanctuary.removeFromIsolation(spiderMonkey.getId()));
  }

  /**
   * A method that tests the removeFromIsolation method when animal not in isolation.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveFromIsolationWhenAnimalNotInIsolation() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey));
    sanctuary.removeFromIsolation(howlerMonkey.getId());
  }

  /**
   * A method that tests the removeFromIsolation method for many animals.
   */

  @Test
  public void testRemoveFromIsolationForManyAnimal() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    assertEquals(Arrays.asList(spiderMonkey, squirrelMonkey), sanctuary.removeFromIsolation(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId())));
  }

  /**
   * A method that tests the removeFromIsolation method when animals not in isolation.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveFromIsolationWhenAnimalsNotInIsolation() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey));
    sanctuary.removeFromIsolation(Arrays.asList(spiderMonkey.getId(), howlerMonkey.getId()));
  }

  /**
   * A method that tests the removeFromEnclosure method for one animal.
   */

  @Test
  public void testRemoveFromEnclosureForOneAnimal() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));
    assertEquals(spiderMonkey, sanctuary.removeFromEnclosure(spiderMonkey.getId()));
  }

  /**
   * A method that tests the removeFromEnclosure method when animal not in enclosure.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveFromEnclosureWhenAnimalNotInEnclosure() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));
    sanctuary.removeFromEnclosure(howlerMonkey.getId());
  }

  /**
   * A method that tests the removeFromEnclosure method for many animals.
   */

  @Test
  public void testRemoveFromEnclosureForManyAnimal() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));
    assertEquals(Arrays.asList(spiderMonkey, squirrelMonkey), sanctuary.removeFromEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId())));
  }

  /**
   * A method that tests the removeFromEnclosure method when animals not in enclosure.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveFromEnclosureWhenAnimalsNotInEnclosure() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));
    sanctuary.removeFromEnclosure(Arrays.asList(spiderMonkey.getId(), howlerMonkey.getId()));
  }

  /**
   * A method that tests the changeAnimalAge method.
   */

  @Test
  public void testChangeAnimalAge() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalAge(spiderMonkey.getId(), 2);
    int expectedValue = 2;
    assertEquals(expectedValue, sanctuary.getAnimalsInIsolation().get(0).getAge());
  }

  /**
   * A method that tests the changeAnimalAge method when id does not exist.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testChangeAnimalAgeWhenIdNonExistent() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalAge(6, 3);
  }

  /**
   * A method that tests the changeAnimalAge method when age is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testChangeAnimalAgeWhenAgeIsNegative() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalAge(spiderMonkey.getId(), -3);
  }

  /**
   * A method that tests the changeAnimalSize method.
   */

  @Test
  public void changeAnimalSize() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalSize(spiderMonkey.getId(), Size.MEDIUM);
    Size expectedSize = Size.MEDIUM;
    assertEquals(expectedSize, sanctuary.getAnimalsInIsolation().get(0).getSize());
  }

  /**
   * A method that tests the changeAnimalSize method when id does not exist.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testChangeAnimalSizeWhenIdNonExistent() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalSize(6, Size.MEDIUM);
  }

  /**
   * A method that tests the changeAnimalSize method when size is null.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testChangeAnimalAgeWhenSizeIsNull() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalSize(spiderMonkey.getId(), null);
  }

  /**
   * A method that tests the changeAnimalSex method.
   */

  @Test
  public void changeAnimalSex() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalSex(spiderMonkey.getId(), Sex.OTHER);
    Sex expectedSex = Sex.OTHER;
    assertEquals(expectedSex, sanctuary.getAnimalsInIsolation().get(0).getSex());
  }

  /**
   * A method that tests the changeAnimalSex method when id does not exist.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testChangeAnimalSexWhenIdNonExistent() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalSex(6, Sex.OTHER);
  }

  /**
   * A method that tests the changeAnimalSex method when sex is null.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testChangeAnimalAgeWhenSexIsNull() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalSex(spiderMonkey.getId(), null);
  }

  /**
   * A method that tests the changeAnimalWeight method.
   */

  @Test
  public void testChangeAnimalWeight() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalWeight(spiderMonkey.getId(), 40);
    int expectedValue = 40;
    assertEquals(expectedValue, sanctuary.getAnimalsInIsolation().get(0).getWeight());
  }

  /**
   * A method that tests the changeAnimalWeight method when id does not exist.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testChangeAnimalWeightWhenIdNonExistent() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalAge(6, 40);
  }

  /**
   * A method that tests the changeAnimalWeight method when weight is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testChangeAnimalWeightWhenWeightIsNegative() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalWeight(spiderMonkey.getId(), -30);
  }

  /**
   * A method that tests the changeAnimalFavFood method.
   */

  @Test
  public void testChangeAnimalFavFood() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalFavFood(spiderMonkey.getId(), "Apple");
    String expectedValue = "Apple";
    assertEquals(expectedValue, sanctuary.getAnimalsInIsolation().get(0).getFavFood());
  }

  /**
   * A method that tests the changeAnimalFavFood method when id does not exist.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testChangeAnimalFavFoodWhenIdNonExistent() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.changeAnimalFavFood(6, "Apple");
  }


  /**
   * A method that tests the getAllSigns method.
   */

  @Test
  public void testGetAllSigns() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));
    List<List<Sign>> allSigns = sanctuary.getAllSigns();

    Sign signOfSpiderMonkey = allSigns.get(0).get(0);

    assertEquals(spiderMonkey.getName(), signOfSpiderMonkey.getName());
    assertEquals(spiderMonkey.getSize(), signOfSpiderMonkey.getSize());
    assertEquals(spiderMonkey.getFavFood(), signOfSpiderMonkey.getFavFood());

    Sign signOfSquirrelMonkey = allSigns.get(1).get(0);

    assertEquals(squirrelMonkey.getName(), signOfSquirrelMonkey.getName());
    assertEquals(squirrelMonkey.getSize(), signOfSquirrelMonkey.getSize());
    assertEquals(squirrelMonkey.getFavFood(), signOfSquirrelMonkey.getFavFood());
  }

  /**
   * A method that tests the getFoodList method.
   */

  @Test
  public void testGetFoodList() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Banana", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));

    Map<String, Integer> foodList = sanctuary.getFoodList();

    int expectedValueForBanana = 600;
    int actualValueForBanana = foodList.get("Banana");
    assertEquals(expectedValueForBanana, actualValueForBanana);

    int expectedValueForLollipop = 250;
    int actualValueForLollipop = foodList.get("Lollipop");
    assertEquals(expectedValueForLollipop, actualValueForLollipop);
  }

  /**
   * A method that tests the getLocationOfMonkeys method.
   */

  @Test
  public void testGetLocationOfMonkeys() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Banana", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));

    List<AnimalsWithLocation> monkeysList = sanctuary.getLocationOfMonkeys();
    int expectedValue = 3;
    assertEquals(expectedValue, monkeysList.size());

    int expectedPosition = 1;
    assertEquals(howlerMonkey, monkeysList.get(0).getAnimal());
    assertEquals(House.ISOLATION, monkeysList.get(0).getHouse());
    assertEquals(expectedPosition, monkeysList.get(0).getPosition());

    expectedPosition = 2;
    assertEquals(squirrelMonkey, monkeysList.get(1).getAnimal());
    assertEquals(House.ENCLOSURE, monkeysList.get(1).getHouse());
    assertEquals(expectedPosition, monkeysList.get(1).getPosition());

    expectedPosition = 1;
    assertEquals(spiderMonkey, monkeysList.get(2).getAnimal());
    assertEquals(House.ENCLOSURE, monkeysList.get(2).getHouse());
    assertEquals(expectedPosition, monkeysList.get(2).getPosition());
  }

  /**
   * A method that tests the getLocationOfSpecies method.
   */

  @Test
  public void testGetLocationOfSpecies() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Banana", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));

    Map<String, List<AnimalsWithLocation>> speciesList = sanctuary.getLocationOfSpecies();
    int expectedValue = 1;
    List<AnimalsWithLocation> listOfSpiderMonkeys = speciesList.get("SpiderMonkey");
    List<AnimalsWithLocation> listOfSquirrelMonkeys = speciesList.get("SquirrelMonkey");
    List<AnimalsWithLocation> listOfHowlerMonkeys = speciesList.get("Howler");

    assertEquals(expectedValue, listOfSpiderMonkeys.size());
    assertEquals(expectedValue, listOfSquirrelMonkeys.size());
    assertEquals(expectedValue, listOfHowlerMonkeys.size());

    int expectedPosition = 1;
    assertEquals(howlerMonkey, listOfHowlerMonkeys.get(0).getAnimal());
    assertEquals(House.ISOLATION, listOfHowlerMonkeys.get(0).getHouse());
    assertEquals(expectedPosition, listOfHowlerMonkeys.get(0).getPosition());

    expectedPosition = 2;
    assertEquals(squirrelMonkey, listOfSquirrelMonkeys.get(0).getAnimal());
    assertEquals(House.ENCLOSURE, listOfSquirrelMonkeys.get(0).getHouse());
    assertEquals(expectedPosition, listOfSquirrelMonkeys.get(0).getPosition());

    expectedPosition = 1;
    assertEquals(spiderMonkey, listOfSpiderMonkeys.get(0).getAnimal());
    assertEquals(House.ENCLOSURE, listOfSpiderMonkeys.get(0).getHouse());
    assertEquals(expectedPosition, listOfSpiderMonkeys.get(0).getPosition());
  }

  /**
   * A method that tests the lookUp method.
   */

  @Test
  public void testLookUp() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Banana", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));

    List<AnimalsWithLocation> listOfSpiderMonkeys = sanctuary.lookUp("SpiderMonkey");
    List<AnimalsWithLocation> listOfSquirrelMonkeys = sanctuary.lookUp("SquirrelMonkey");
    List<AnimalsWithLocation> listOfHowlerMonkeys = sanctuary.lookUp("Howler");
    int expectedValue = 1;

    assertEquals(expectedValue, listOfSpiderMonkeys.size());
    assertEquals(expectedValue, listOfSquirrelMonkeys.size());
    assertEquals(expectedValue, listOfHowlerMonkeys.size());

    int expectedPosition = 1;
    assertEquals(howlerMonkey, listOfHowlerMonkeys.get(0).getAnimal());
    assertEquals(House.ISOLATION, listOfHowlerMonkeys.get(0).getHouse());
    assertEquals(expectedPosition, listOfHowlerMonkeys.get(0).getPosition());

    expectedPosition = 2;
    assertEquals(squirrelMonkey, listOfSquirrelMonkeys.get(0).getAnimal());
    assertEquals(House.ENCLOSURE, listOfSquirrelMonkeys.get(0).getHouse());
    assertEquals(expectedPosition, listOfSquirrelMonkeys.get(0).getPosition());

    expectedPosition = 1;
    assertEquals(spiderMonkey, listOfSpiderMonkeys.get(0).getAnimal());
    assertEquals(House.ENCLOSURE, listOfSpiderMonkeys.get(0).getHouse());
    assertEquals(expectedPosition, listOfSpiderMonkeys.get(0).getPosition());
  }

  /**
   * A method that tests the lookUp method when the species inputted is not in the sanctuary.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testLookUpWhenSpeciesNotPresent() {
    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, animal.Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Banana", Howler.getInstance());

    sanctuary.moveToIsolation(Arrays.asList(spiderMonkey, squirrelMonkey, howlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));

    List<AnimalsWithLocation> listOfSpiderMonkeys = sanctuary.lookUp("NotAvailableSpecies");
  }
}