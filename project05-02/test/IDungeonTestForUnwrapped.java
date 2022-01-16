import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import dungeon.Direction;
import dungeon.Dungeon;
import dungeon.IDungeon;
import org.junit.Before;
import org.junit.Test;
import randomize.MockRandomnessForUnwrappedWithMonsters;
import randomize.Randomness;

import java.util.Arrays;

/**
 * A test that tests all the different methods
 * of the IDungeon interface.
 */

public class IDungeonTestForUnwrapped {

  private IDungeon dungeon;
  /**
   * Sets up all the variables needed before testing.
   */

  @Before
  public void setUp() {
    dungeon = new Dungeon(2,
            "Ben", false, 6, 8, 20, 4, new MockRandomnessForUnwrappedWithMonsters());
  }

  /**
   * Tests the dungeon constructor.
   */

  @Test
  public void testDungeonConstructor() {
    int[] expectedLocation = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertTrue(Arrays.equals(expectedLocation,dungeon.getStart()));
    int[] expectedEnd = new int[] {1, 6};
    assertTrue(Arrays.equals(expectedEnd, dungeon.getEnd()));

    String expectedDungeonString =
            "(->)    (<-v)   (->)    (<-v)   (v->)   (<-->)  (<-v->) (<-v)   \n"
            +  "(v->)   (<-^v->)(<-->)  (<-^v)  (^->)   (<-)    (^)     (^v)    \n"
            +  "(^)     (^v)    (->)    (<-^)   (->)    (<-v->) (<-v->) (<-^)   \n"
            +  "(v->)   (<-^->) (<-v->) (<-->)  (<-->)  (<-^v)  (^v->)  (<-)    \n"
            +  "(^->)   (<-v)   (^)     (->)    (<-v->) (<-^v)  (^v)    (v)     \n"
            +  "(->)    (<-^->) (<-->)  (<-->)  (<-^)   (^->)   (<-^->) (<-^)   \n";
    assertEquals(expectedDungeonString, dungeon.toString());

    String expectedRoomsDescription = "\nThe room is on row 0 and column 0 in the dungeon. "
            +  "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (->)\n"
            +  "The room is on row 0 and column 1 in the dungeon. "
            +  "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-v)\n"
            +  "The room is on row 0 and column 2 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            +  " The possible next locations are (->)\n"
            +  "The room is on row 0 and column 3 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-v)\n"
            +  "The room is on row 0 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (v->)\n"
            +   "The room is on row 0 and column 5 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-->)\n"
            +  "The room is on row 0 and column 6 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
            +  "The possible next locations are (<-v->)\n"
            +  "The room is on row 0 and column 7 in the dungeon. "
            +  "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-v)\n"
            +  "The room is on row 1 and column 0 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (v->)\n"
            +  "The room is on row 1 and column 1 in the dungeon."
            +  " It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            +   " The possible next locations are (<-^v->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            +  "The room is on row 1 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-->)\n"
            +  "The room is on row 1 and column 3 in the dungeon."
            +  " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-^v)\n"
            +  "The room is on row 1 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (^->)\n"
            +  "The room is on row 1 and column 5 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-)\n"
            +  "The room is on row 1 and column 6 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            +  " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            +  "The room is on row 1 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (^v)\n"
            +  "The room is on row 2 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            +  "The room is on row 2 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (^v)\n"
            +  "The room is on row 2 and column 2 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            +  " The possible next locations are (->)\n"
            +  "The room is on row 2 and column 3 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-^)\n"
            +  "The room is on row 2 and column 4 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (->)\n"
            +  "The room is on row 2 and column 5 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-v->)\n"
            +  "The room is on row 2 and column 6 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-v->)\n"
            +   "The room is on row 2 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^)\n"
            +  "The room is on row 3 and column 0 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (v->)\n"
            +  "The room is on row 3 and column 1 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^->)\n"
            +  "The room is on row 3 and column 2 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-v->)\n"
            +  "The room is on row 3 and column 3 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-->)\n"
            +  "The room is on row 3 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-->)\n"
            +  "The room is on row 3 and column 5 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-^v)\n"
            +  "The room is on row 3 and column 6 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            +  " The possible next locations are (^v->)\n"
            +  "The room is on row 3 and column 7 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            +  " The possible next locations are (<-)\n"
            +  "The room is on row 4 and column 0 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            +  " The possible next locations are (^->)\n"
            +  "The room is on row 4 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-v)\n"
            +  "The room is on row 4 and column 2 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (^)\n"
            +  "The room is on row 4 and column 3 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows."
            +  " The possible next locations are (->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            +  "The room is on row 4 and column 4 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-v->)\n"
            +  "The room is on row 4 and column 5 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^v)\n"
            +  "The room is on row 4 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (^v)\n"
            +  "The room is on row 4 and column 7 in the dungeon"
            +  ". It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (v)\n"
            +  "The room is on row 5 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (->)\n"
            +  "The room is on row 5 and column 1 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-^->)\n"
            +  "The room is on row 5 and column 2 in the dungeon. "
            +  "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-->)\n"
            +  "The room is on row 5 and column 3 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-->)\n"
            +  "The room is on row 5 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            +  " The possible next locations are (<-^)\n"
            +  "The room is on row 5 and column 5 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (^->)\n"
            +  "The room is on row 5 and column 6 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            +  " The possible next locations are (<-^->)\n"
            +  "The room is on row 5 and column 7 in the dungeon. "
            +   "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^)";

    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +   " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows. "
            + "The player smells a PUNGENT";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
  }

  /**
   * Tests the dungeon constructor when row passed is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenRowIsNegative() {
    new Dungeon(0, "Ben", true, -1, 4, 30,4,
            new Randomness());
  }

  /**
   * Tests the dungeon constructor when column passed is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenColumnIsNegative() {
    new Dungeon(0, "Ben", true, 4, -4, 30, 4,
            new Randomness());
  }

  /**
   * Tests the dungeon constructor when interconnectivity passed is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenInterConnectivityIsNegative() {
    new Dungeon(-6, "Ben", true, 4, 4, 30,4,
            new Randomness());
  }

  /**
   * Tests the dungeon constructor when percentage passed is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenPercentageIsNegative() {
    new Dungeon(0, "Ben", true, 4, 4, -5,4,
            new Randomness());
  }

  /**
   * Tests the dungeon constructor when percentage passed is greater than 100.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenPercentageIsGreaterThan100() {
    Dungeon invalidDungeon = new Dungeon(0, "Ben", true, 4, 4, 105,
            4, new Randomness());
  }

  /**
   * Tests the dungeon constructor when column passed is less than 4.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenColumnsLessThan4() {
    Dungeon invalidDungeon = new Dungeon(0, "Ben", true, 4, 2,
            20, 4, new Randomness());
  }

  /**
   * Tests the dungeon constructor when rows passed is less than 4.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenRowsLessThan4() {
    Dungeon invalidDungeon = new Dungeon(0, "Ben", true, 2, 4,
            20, 4, new Randomness());
  }

  /**
   * Tests the dungeon constructor when number of monsters passed is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenNumberOfMonstersIsNegative() {
    Dungeon invalidDungeon = new Dungeon(0, "Ben", true, 6, 8,
            20, -1, new Randomness());
  }

  /**
   * Tests the dungeon constructor when number of monsters passed is greater
   * than the number of rooms in the dungeon.
   */

  @Test(expected = IllegalArgumentException.class)
  public void
          testDungeonConstructorWhenNumberOfMonstersIsGreaterThanTheNumberOfRoomsInTheDungeon() {
    Dungeon invalidDungeon = new Dungeon(0, "Ben", true, 6, 8,
            20, 50, new Randomness());
  }

  /**
   * Tests the getPlayerLocation method.
   */

  @Test
  public void testGetPlayerLocation() {
    int[] expectedLocation = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
  }

  /**
   * Tests the movePlayer method to move randomly in
   * the dungeon.
   */

  @Test
  public void testMovePlayer() {
    dungeon.movePlayer(Direction.WEST);
    int[] expectedLocation = new int[] {4, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {5, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
  }

  /**
   * Tests the movePlayer method to visit all rooms for an
   * unwrapped dungeon and killing all monsters.
   */

  @Test
  public void testMovePlayerToVisitAllRoomsAndKillAllMonstersForUnwrappedDungeon() {
    int[] expectedLocation = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {4, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    dungeon.pickUpArrows();
    expectedLocation = new int[] {5, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {5, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    dungeon.pickUpArrows();
    expectedLocation = new int[] {4, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    //kill nearby monster
    dungeon.shoot(1, Direction.NORTH);
    dungeon.shoot(1, Direction.NORTH);

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    //kill nearby monster
    System.out.println(dungeon.getPlayerDescription());
    dungeon.shoot(1, Direction.WEST);
    dungeon.shoot(1, Direction.WEST);

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {1, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {2, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {1, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {0, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    dungeon.pickUpArrows();
    expectedLocation = new int[] {1, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {1, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {1, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {2, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    dungeon.pickUpArrows();
    dungeon.pickUpTreasure();
    expectedLocation = new int[] {2, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {2, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    dungeon.pickUpArrows();
    expectedLocation = new int[] {0, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {0, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {1, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    dungeon.pickUpArrows();
    expectedLocation = new int[] {1, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {2, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {3, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {4, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    //kill nearby monster
    dungeon.shoot(2, Direction.WEST);
    dungeon.shoot(2, Direction.WEST);
    expectedLocation = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {4, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {4, 3};
    dungeon.pickUpTreasure();
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {4, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    ///
    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {5, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    dungeon.pickUpArrows();
    expectedLocation = new int[] {5, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {5, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 7};
    dungeon.pickUpTreasure();
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {5, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    dungeon.pickUpArrows();
    expectedLocation = new int[] {3, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    dungeon.pickUpArrows();
    expectedLocation = new int[] {3, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {2, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {2, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {2, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {2, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {2, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {1, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {1, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {0, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {0, 6};
    dungeon.pickUpTreasure();
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    //kill nearby monster
    dungeon.shoot(1, Direction.SOUTH);
    dungeon.shoot(1, Direction.SOUTH);

    dungeon.movePlayer(Direction.SOUTH);
    dungeon.pickUpArrows();
    expectedLocation = new int[] {1, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
  }

  /**
   * Tests the movePlayer method to go from start to end
   * without visiting all rooms and without killing all monsters
   * for an unwrapped dungeon.
   */

  @Test
  public void testMovePlayerFromStartToEndForUnwrappedDungeon() {
    int[] expectedLocation = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {2, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {2, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    //kill nearby monster
    dungeon.shoot(1, Direction.SOUTH);
    dungeon.shoot(1, Direction.SOUTH);

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
  }

  /**
   * Tests the movePlayer method when moving in an impossible direction.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMovePlayerWhenMovingInImpossibleDirection() {
    dungeon.movePlayer(Direction.EAST);
  }

  /**
   * Tests the getStart method.
   */

  @Test
  public void testGetStart() {
    int[] expectedStart = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedStart,dungeon.getStart()));
  }

  /**
   * Tests the getEnd method.
   */

  @Test
  public void testGetEnd() {
    int[] expectedEnd = new int[] {1, 6};
    assertTrue(Arrays.equals(expectedEnd, dungeon.getEnd()));
  }

  /**
   * Tests the isAtEnd method.
   */

  @Test
  public void testIsAtEnd() {
    int[] expectedLocation = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {2, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {2, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    //kill nearby monster
    dungeon.shoot(1, Direction.SOUTH);
    dungeon.shoot(1, Direction.SOUTH);

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertTrue(dungeon.isAtEnd());
  }

  /**
   * Tests the pickUpTreasure method when treasure is present in room.
   */

  @Test
  public void testPickUpTreasureWhenTreasureIsPresentInRoom() {
    //kill nearby monster
    dungeon.shoot(2, Direction.WEST);
    dungeon.shoot(2, Direction.WEST);


    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    String expectedRoomsDescription =
          "\nThe room is on row 0 and column 0 in the dungeon. "
          + "It has 1 entrances, and has 0 sapphires,"
          + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
          + "The room is on row 0 and column 1 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          + "The possible next locations are (<-v)\n"
          + "The room is on row 0 and column 2 in the dungeon."
          + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
          + "The possible next locations are (->)\n"
          + "The room is on row 0 and column 3 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (<-v)\n"
          + "The room is on row 0 and column 4 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (v->)\n"
          + "The room is on row 0 and column 5 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (<-->)\n"
          + "The room is on row 0 and column 6 in the dungeon. "
          + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
          + "The possible next locations are (<-v->)\n"
          + "The room is on row 0 and column 7 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          + "The possible next locations are (<-v)\n"
          + "The room is on row 1 and column 0 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          + "The possible next locations are (v->)\n"
          + "The room is on row 1 and column 1 in the dungeon. "
          + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
          + " The possible next locations are (<-^v->)"
          + "There is a monster here with a health of FULL_HEALTH\n"
          + "The room is on row 1 and column 2 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (<-->)\n"
          + "The room is on row 1 and column 3 in the dungeon."
          + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (<-^v)\n"
          + "The room is on row 1 and column 4 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (^->)\n"
          + "The room is on row 1 and column 5 in the dungeon."
          + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (<-)\n"
          + "The room is on row 1 and column 6 in the dungeon."
          + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
          + " The possible next locations are (^)"
          + "There is a monster here with a health of FULL_HEALTH\n"
          + "The room is on row 1 and column 7 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (^v)\n"
          + "The room is on row 2 and column 0 in the dungeon."
          + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (^)"
          + "There is a monster here with a health of FULL_HEALTH\n"
          + "The room is on row 2 and column 1 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (^v)\n"
          + "The room is on row 2 and column 2 in the dungeon."
          + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
          + " The possible next locations are (->)\n"
          + "The room is on row 2 and column 3 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          + "The possible next locations are (<-^)\n"
          + "The room is on row 2 and column 4 in the dungeon."
          + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          + "The possible next locations are (->)\n"
          + "The room is on row 2 and column 5 in the dungeon."
          + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          + "The possible next locations are (<-v->)\n"
          + "The room is on row 2 and column 6 in the dungeon."
          + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (<-v->)\n"
          + "The room is on row 2 and column 7 in the dungeon. "
          + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (<-^)\n"
          + "The room is on row 3 and column 0 in the dungeon. "
          + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (v->)\n"
          + "The room is on row 3 and column 1 in the dungeon."
          + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          + "The possible next locations are (<-^->)\n"
          + "The room is on row 3 and column 2 in the dungeon. "
          + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (<-v->)\n"
          + "The room is on row 3 and column 3 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (<-->)\n"
          + "The room is on row 3 and column 4 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          + "The possible next locations are (<-->)\n"
          + "The room is on row 3 and column 5 in the dungeon."
          + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          + " The possible next locations are (<-^v)\n"
          + "The room is on row 3 and column 6 in the dungeon."
          + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
          + "The possible next locations are (^v->)\n"
          + "The room is on row 3 and column 7 in the dungeon."
          + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
          + "The possible next locations are (<-)\n"
          + "The room is on row 4 and column 0 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
          + "he possible next locations are (^->)\n"
          + "The room is on row 4 and column 1 in the dungeon."
          + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          + "The possible next locations are (<-v)\n"
          + "The room is on row 4 and column 2 in the dungeon."
          + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          +  "The possible next locations are (^)\n"
          + "The room is on row 4 and column 3 in the dungeon."
          +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows."
          +   " The possible next locations are (->)\n"
          + "The room is on row 4 and column 4 in the dungeon."
          +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          +      " The possible next locations are (<-v->)\n"
          + "The room is on row 4 and column 5 in the dungeon."
          +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          +      " The possible next locations are (<-^v)\n"
          + "The room is on row 4 and column 6 in the dungeon."
          +      " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          +      "The possible next locations are (^v)\n"
          + "The room is on row 4 and column 7 in the dungeon."
          +      " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
          +      "The possible next locations are (v)\n"
          + "The room is on row 5 and column 0 in the dungeon. "
          +         "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          +         "The possible next locations are (->)\n"
          + "The room is on row 5 and column 1 in the dungeon. "
          +          "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
          +          "The possible next locations are (<-^->)\n"
          + "The room is on row 5 and column 2 in the dungeon."
          +          " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          +          " The possible next locations are (<-->)\n"
          + "The room is on row 5 and column 3 in the dungeon. "
          +       "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          +       " The possible next locations are (<-->)\n"
          + "The room is on row 5 and column 4 in the dungeon. "
          +        "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
          +        " The possible next locations are (<-^)\n"
          + "The room is on row 5 and column 5 in the dungeon."
          +     " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          +     " The possible next locations are (^->)\n"
          + "The room is on row 5 and column 6 in the dungeon."
          +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
          +     " The possible next locations are (<-^->)\n"
          + "The room is on row 5 and column 7 in the dungeon."
          +     " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
          +     " The possible next locations are (<-^)";

    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    assertTrue(dungeon.pickUpTreasure());
    expectedPlayerDescription = "Ben is in room (->) which is at row 4, column 3."
            + " The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows. "
            + "The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    expectedRoomsDescription =
        "\nThe room is on row 0 and column 0 in the dungeon. "
        + "It has 1 entrances, and has 0 sapphires,"
        + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
        + "The room is on row 0 and column 1 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        + "The possible next locations are (<-v)\n"
        + "The room is on row 0 and column 2 in the dungeon."
        + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
        + "The possible next locations are (->)\n"
        + "The room is on row 0 and column 3 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (<-v)\n"
        + "The room is on row 0 and column 4 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (v->)\n"
        + "The room is on row 0 and column 5 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (<-->)\n"
        + "The room is on row 0 and column 6 in the dungeon. "
        + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
        + "The possible next locations are (<-v->)\n"
        + "The room is on row 0 and column 7 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        + "The possible next locations are (<-v)\n"
        + "The room is on row 1 and column 0 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        + "The possible next locations are (v->)\n"
        + "The room is on row 1 and column 1 in the dungeon. "
        + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
        + " The possible next locations are (<-^v->)"
        + "There is a monster here with a health of FULL_HEALTH\n"
        + "The room is on row 1 and column 2 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (<-->)\n"
        + "The room is on row 1 and column 3 in the dungeon."
        + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (<-^v)\n"
        + "The room is on row 1 and column 4 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (^->)\n"
        + "The room is on row 1 and column 5 in the dungeon."
        + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (<-)\n"
        + "The room is on row 1 and column 6 in the dungeon."
        + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
        + " The possible next locations are (^)"
        + "There is a monster here with a health of FULL_HEALTH\n"
        + "The room is on row 1 and column 7 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (^v)\n"
        + "The room is on row 2 and column 0 in the dungeon."
        + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (^)"
        + "There is a monster here with a health of FULL_HEALTH\n"
        + "The room is on row 2 and column 1 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (^v)\n"
        + "The room is on row 2 and column 2 in the dungeon."
        + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
        + " The possible next locations are (->)\n"
        + "The room is on row 2 and column 3 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        + "The possible next locations are (<-^)\n"
        + "The room is on row 2 and column 4 in the dungeon."
        + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        + "The possible next locations are (->)\n"
        + "The room is on row 2 and column 5 in the dungeon."
        + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        + "The possible next locations are (<-v->)\n"
        + "The room is on row 2 and column 6 in the dungeon."
        + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (<-v->)\n"
        + "The room is on row 2 and column 7 in the dungeon. "
        + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (<-^)\n"
        + "The room is on row 3 and column 0 in the dungeon. "
        + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (v->)\n"
        + "The room is on row 3 and column 1 in the dungeon."
        + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (<-^->)\n"
        + "The room is on row 3 and column 2 in the dungeon. "
        + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (<-v->)\n"
        + "The room is on row 3 and column 3 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (<-->)\n"
        + "The room is on row 3 and column 4 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        + "The possible next locations are (<-->)\n"
        + "The room is on row 3 and column 5 in the dungeon."
        + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        + " The possible next locations are (<-^v)\n"
        + "The room is on row 3 and column 6 in the dungeon."
        + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
        + "The possible next locations are (^v->)\n"
        + "The room is on row 3 and column 7 in the dungeon."
        + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
        + "The possible next locations are (<-)\n"
        + "The room is on row 4 and column 0 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
        + "he possible next locations are (^->)\n"
        + "The room is on row 4 and column 1 in the dungeon."
        + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        + "The possible next locations are (<-v)\n"
        + "The room is on row 4 and column 2 in the dungeon."
        + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        +  "The possible next locations are (^)\n"
        + "The room is on row 4 and column 3 in the dungeon."
        +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        +   " The possible next locations are (->)\n"
        + "The room is on row 4 and column 4 in the dungeon."
        +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        +      " The possible next locations are (<-v->)\n"
        + "The room is on row 4 and column 5 in the dungeon."
        +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        +      " The possible next locations are (<-^v)\n"
        + "The room is on row 4 and column 6 in the dungeon."
        +      " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        +      "The possible next locations are (^v)\n"
        + "The room is on row 4 and column 7 in the dungeon."
        +      " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
        +      "The possible next locations are (v)\n"
        + "The room is on row 5 and column 0 in the dungeon. "
        +         "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        +         "The possible next locations are (->)\n"
        + "The room is on row 5 and column 1 in the dungeon. "
        +          "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
        +          "The possible next locations are (<-^->)\n"
        + "The room is on row 5 and column 2 in the dungeon."
        +          " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        +          " The possible next locations are (<-->)\n"
        + "The room is on row 5 and column 3 in the dungeon. "
        +       "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        +       " The possible next locations are (<-->)\n"
        + "The room is on row 5 and column 4 in the dungeon. "
        +        "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
        +        " The possible next locations are (<-^)\n"
        + "The room is on row 5 and column 5 in the dungeon."
        +     " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        +     " The possible next locations are (^->)\n"
        + "The room is on row 5 and column 6 in the dungeon."
        +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
        +     " The possible next locations are (<-^->)\n"
        + "The room is on row 5 and column 7 in the dungeon."
        +     " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
        +     " The possible next locations are (<-^)";
    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

  }

  /**
   * Tests the pickUpTreasure method when treasure is not present in room.
   */

  @Test
  public void testPickUpTreasureWhenTreasureIsNotPresentInRoom() {
    //kill nearby monster
    dungeon.shoot(2, Direction.WEST);
    dungeon.shoot(2, Direction.WEST);

    assertFalse(dungeon.pickUpTreasure());
    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    String expectedRoomsDescription =
            "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
            + "The room is on row 0 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 0 and column 6 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v->)\n"
            + "The room is on row 1 and column 1 in the dungeon. "
            + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^v->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 1 and column 3 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 2 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            + " The possible next locations are (->)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 7 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 0 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 3 and column 1 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (<-)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
            + "he possible next locations are (^->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (^)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows."
            +   " The possible next locations are (->)\n"
            + "The room is on row 4 and column 4 in the dungeon."
            +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-v->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (^v)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 5 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 3 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 4 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)";
    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

  }

  /**
   * Tests the toString method.
   */

  @Test
  public void testToString() {
    String expectedDungeonString =
            "(->)    (<-v)   (->)    (<-v)   (v->)   (<-->)  (<-v->) (<-v)   \n"
            +  "(v->)   (<-^v->)(<-->)  (<-^v)  (^->)   (<-)    (^)     (^v)    \n"
            +  "(^)     (^v)    (->)    (<-^)   (->)    (<-v->) (<-v->) (<-^)   \n"
            +  "(v->)   (<-^->) (<-v->) (<-->)  (<-->)  (<-^v)  (^v->)  (<-)    \n"
            +  "(^->)   (<-v)   (^)     (->)    (<-v->) (<-^v)  (^v)    (v)     \n"
            +  "(->)    (<-^->) (<-->)  (<-->)  (<-^)   (^->)   (<-^->) (<-^)   \n";
    assertEquals(expectedDungeonString, dungeon.toString());
  }

  /**
   * Tests the getRoomsDescription method when treasure is not picked up in room.
   */

  @Test
  public void testGetRoomsDescriptionWhenTreasureIsNotPickedUpInRoom() {
    //kill nearby monster
    dungeon.shoot(2, Direction.WEST);
    dungeon.shoot(2, Direction.WEST);
    String expectedRoomsDescription =
            "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
            + "The room is on row 0 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 0 and column 6 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v->)\n"
            + "The room is on row 1 and column 1 in the dungeon. "
            + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^v->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 1 and column 3 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 2 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            + " The possible next locations are (->)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 7 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 0 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 3 and column 1 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (<-)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
            + "he possible next locations are (^->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (^)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows."
            +   " The possible next locations are (->)\n"
            + "The room is on row 4 and column 4 in the dungeon."
            +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-v->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (^v)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 5 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 3 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 4 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)";
    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

  }

  /**
   * Tests the getRoomsDescription method when treasure is picked up in room.
   */

  @Test
  public void testGetRoomsDescriptionWhenTreasureIsPickedUpInRoom() {
    //kill nearby monster
    dungeon.shoot(2, Direction.WEST);
    dungeon.shoot(2, Direction.WEST);

    String expectedRoomsDescription =
            "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
            + "The room is on row 0 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 0 and column 6 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v->)\n"
            + "The room is on row 1 and column 1 in the dungeon. "
            + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^v->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 1 and column 3 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 2 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            + " The possible next locations are (->)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 7 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 0 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 3 and column 1 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (<-)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
            + "he possible next locations are (^->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (^)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows."
            +   " The possible next locations are (->)\n"
            + "The room is on row 4 and column 4 in the dungeon."
            +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-v->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (^v)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 5 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 3 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 4 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)";
    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    assertTrue(dungeon.pickUpTreasure());

    expectedRoomsDescription =
            "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
            + "The room is on row 0 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 0 and column 6 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v->)\n"
            + "The room is on row 1 and column 1 in the dungeon. "
            + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^v->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 1 and column 3 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 2 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            + " The possible next locations are (->)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 7 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 0 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 3 and column 1 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (<-)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
            + "he possible next locations are (^->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (^)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +   " The possible next locations are (->)\n"
            + "The room is on row 4 and column 4 in the dungeon."
            +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-v->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (^v)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 5 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 3 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 4 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)";
    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

  }

  /**
   * Tests the getPlayerDescription method when player has treasure.
   */

  @Test
  public void testGetPlayerDescriptionWhenPlayerHasTreasure() {
    //kill nearby monster
    dungeon.shoot(2, Direction.WEST);
    dungeon.shoot(2, Direction.WEST);


    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    assertTrue(dungeon.pickUpTreasure());
    expectedPlayerDescription = "Ben is in room (->) which is at row 4, column 3."
            + " The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            + " The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
  }

  /**
   * Tests the getPlayerDescription method when player has no treasure.
   */

  @Test
  public void testGetPlayerDescriptionWhenPlayerHasNoTreasure() {
    //kill nearby monster
    dungeon.shoot(2, Direction.WEST);
    dungeon.shoot(2, Direction.WEST);

    assertFalse(dungeon.pickUpTreasure());
    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
  }

  /**
   * Tests the currentRoomDescription method when treasure is not picked up in room.
   */

  @Test
  public void testCurrentRoomDescriptionWhenTreasureIsNotPickedUpInRoom() {
    assertFalse(dungeon.pickUpTreasure());
    String expectedRoomDescription =
            "The room is on row 4 and column 5 in the dungeon. It has 3 entrances,"
            +  " and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)";

    assertEquals(expectedRoomDescription, dungeon.currentRoomDescription());

  }

  /**
   * Tests the currentRoomDescription method when treasure is picked up in room.
   */

  @Test
  public void testCurrentRoomDescriptionWhenTreasureIsPickedUpInRoom() {
    //kill nearby monster
    dungeon.shoot(2, Direction.WEST);
    dungeon.shoot(2, Direction.WEST);

    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);

    assertTrue(dungeon.pickUpTreasure());
    String expectedRoomDescription =
            "The room is on row 4 and column 3 in the dungeon. It has 1 entrances, "
            +  "and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (->)";


    assertEquals(expectedRoomDescription, dungeon.currentRoomDescription());

  }

  /**
   * Tests the isCurrentRoomTunnel method.
   */

  @Test
  public void testIsCurrentRoomTunnel() {
    assertFalse(dungeon.isCurrentRoomTunnel());

    dungeon.movePlayer(Direction.NORTH);
    assertFalse(dungeon.isCurrentRoomTunnel());


    dungeon.movePlayer(Direction.NORTH);
    assertFalse(dungeon.isCurrentRoomTunnel());


    dungeon.movePlayer(Direction.EAST);
    assertFalse(dungeon.isCurrentRoomTunnel());


    dungeon.movePlayer(Direction.EAST);
    assertTrue(dungeon.isCurrentRoomTunnel());


    dungeon.movePlayer(Direction.NORTH);
    assertTrue(dungeon.isCurrentRoomTunnel());

    dungeon.movePlayer(Direction.NORTH);
    assertTrue(dungeon.isCurrentRoomTunnel());

    dungeon.movePlayer(Direction.WEST);
    assertFalse(dungeon.isCurrentRoomTunnel());

    //kill nearby monster
    dungeon.shoot(1, Direction.SOUTH);
    dungeon.shoot(1, Direction.SOUTH);

    dungeon.movePlayer(Direction.SOUTH);
    assertFalse(dungeon.isCurrentRoomTunnel());
  }

  /**
   * Tests the getRows method.
   */

  @Test
  public void testGetRows() {
    int expectedRows = 6;
    assertEquals(expectedRows, dungeon.getRows());
  }

  /**
   * Tests the getColumns method.
   */

  @Test
  public void testGetColumns() {
    int expectedColumns = 8;
    assertEquals(expectedColumns, dungeon.getColumns());
  }

  /**
   * Tests the getInterConnectivity method.
   */

  @Test
  public void testGetInterConnectivity() {
    int expectedInterconnectivity = 2;
    assertEquals(expectedInterconnectivity, dungeon.getInterConnectivity());
  }

  /**
   * Tests the isWrapped method.
   */

  @Test
  public void testIsWrapped() {
    boolean expected = false;
    assertEquals(expected, dungeon.isWrapped());
  }

  /**
   * Tests the isWrapped method.
   */

  @Test
  public void testGetPlayerName() {
    String expectedName = "Ben";
    assertEquals(expectedName, dungeon.getPlayerName());
  }

  /**
   * Tests the getNumberOfMonsters method.
   */

  @Test
  public void testGetNumberOfMonsters() {
    int expectedMonsters = 4;
    assertEquals(expectedMonsters, dungeon.getNumberOfMonsters());
  }

  ///////////////////////////////////////////
  ///////////////////////////////////////////
  ///////////////////////////////////////////

  /**
   * Tests the pickUpArrows method when treasure is present in room.
   */

  @Test
  public void testPickUpArrowsWhenArrowIsPresentInRoom() {
    String expectedPlayerDescription =
          "Ben is in room (<-^v) which is at row 4, column 5. "
          + "The room is a tunnel : false."
          + " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
          + " The player smells a PUNGENT";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    String expectedRoomsDescription =
            "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
            + "The room is on row 0 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 0 and column 6 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v->)\n"
            + "The room is on row 1 and column 1 in the dungeon. "
            + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^v->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 1 and column 3 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 2 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            + " The possible next locations are (->)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 7 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 0 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 3 and column 1 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (<-)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
            + "he possible next locations are (^->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (^)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows."
            +   " The possible next locations are (->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 4 and column 4 in the dungeon."
            +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-v->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (^v)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 5 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 3 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 4 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)";
    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());
    dungeon.movePlayer(Direction.SOUTH);
    dungeon.movePlayer(Direction.EAST);
    assertTrue(dungeon.pickUpArrows());
    expectedPlayerDescription = "Ben is in room (<-^->) which is at row 5, column 6."
            + " The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 4 arrows."
            + " The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    expectedRoomsDescription =
            "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
            + "The room is on row 0 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 0 and column 6 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v->)\n"
            + "The room is on row 1 and column 1 in the dungeon. "
            + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^v->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 1 and column 3 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 2 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            + " The possible next locations are (->)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 7 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 0 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 3 and column 1 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (<-)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
            + "he possible next locations are (^->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (^)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows."
            +   " The possible next locations are (->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 4 and column 4 in the dungeon."
            +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-v->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (^v)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 5 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 3 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 4 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)";
    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

  }

  /**
   * Tests the pickUpArrows method when arrows not present in room.
   */

  @Test
  public void testPickUpArrowsWhenArrowsNotPresentInRoom() {
    assertFalse(dungeon.pickUpArrows());
    String expectedPlayerDescription =
            "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows. "
            + "The player smells a PUNGENT";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    String expectedRoomsDescription =
            "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
            + "The room is on row 0 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 0 and column 6 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v->)\n"
            + "The room is on row 1 and column 1 in the dungeon. "
            + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^v->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 1 and column 3 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 2 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            + " The possible next locations are (->)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 7 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 0 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 3 and column 1 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (<-)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
            + "he possible next locations are (^->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (^)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows."
            +   " The possible next locations are (->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 4 and column 4 in the dungeon."
            +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-v->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (^v)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 5 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 3 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 4 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)";
    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());
  }

  /**
   * Tests the getRoomsDescription method when arrows not picked up in room.
   */

  @Test
  public void testGetRoomsDescriptionWhenArrowsIsNotPickedUpInRoom() {
    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a PUNGENT";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    String expectedRoomsDescription =
            "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
            + "The room is on row 0 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 0 and column 6 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v->)\n"
            + "The room is on row 1 and column 1 in the dungeon. "
            + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^v->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 1 and column 3 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 2 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            + " The possible next locations are (->)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 7 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 0 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 3 and column 1 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (<-)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
            + "he possible next locations are (^->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (^)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows."
            +   " The possible next locations are (->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 4 and column 4 in the dungeon."
            +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-v->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (^v)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 5 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 3 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 4 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)";
    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

  }

  /**
   * Tests the getRoomsDescription method when arrows picked up in room.
   */

  @Test
  public void testGetRoomsDescriptionWhenArrowsPickedUpInRoom() {
    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows. "
            + "The player smells a PUNGENT";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    String expectedRoomsDescription =
            "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
            + "The room is on row 0 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 0 and column 6 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v->)\n"
            + "The room is on row 1 and column 1 in the dungeon. "
            + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^v->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 1 and column 3 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 2 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            + " The possible next locations are (->)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 7 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 0 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 3 and column 1 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (<-)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
            + "he possible next locations are (^->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (^)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows."
            +   " The possible next locations are (->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 4 and column 4 in the dungeon."
            +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-v->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (^v)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 5 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 3 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 4 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)";
    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());
    dungeon.movePlayer(Direction.SOUTH);
    dungeon.movePlayer(Direction.EAST);
    assertTrue(dungeon.pickUpArrows());
    expectedPlayerDescription = "Ben is in room (<-^->) which is at row 5, column 6."
            + " The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 4 arrows."
            + " The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    expectedRoomsDescription =
            "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (->)\n"
            + "The room is on row 0 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 0 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 0 and column 6 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v->)\n"
            + "The room is on row 1 and column 1 in the dungeon. "
            + "It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^v->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 1 and column 3 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 1 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 2 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 1 arrows."
            + " The possible next locations are (->)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 2 and column 7 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 0 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (v->)\n"
            + "The room is on row 3 and column 1 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The possible next locations are (<-)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. T"
            + "he possible next locations are (^->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-v)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (^)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies, and 0 arrows."
            +   " The possible next locations are (->)"
            + "There is a monster here with a health of FULL_HEALTH\n"
            + "The room is on row 4 and column 4 in the dungeon."
            +     " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-v->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            +      " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +      " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (^v)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 1 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 0 in the dungeon. "
            + "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (->)\n"
            + "The room is on row 5 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            +  "The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 3 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 5 and column 4 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The possible next locations are (<-^)";
    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());
  }

  /**
   * Tests the getPlayerDescription method when player has arrows.
   */

  @Test
  public void testGetPlayerDescriptionWhenPlayerHasArrows() {
    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a PUNGENT";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
  }

  /**
   * Tests the getPlayerDescription method when player has no arrows.
   */

  @Test
  public void testGetPlayerDescriptionWhenPlayerHasNoArrows() {
    //kill nearby monster
    dungeon.shoot(2, Direction.WEST);
    dungeon.shoot(2, Direction.WEST);
    dungeon.shoot(2, Direction.WEST);

    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            + " The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
  }

  /**
   * Tests the currentRoomDescription method when arrows not picked up in room.
   */

  @Test
  public void testCurrentRoomDescriptionWhenArrowsNotPickedUpInRoom() {
    String expectedRoomDescription =
            "The room is on row 4 and column 5 in the dungeon. It has 3 entrances,"
            +  " and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^v)";

    assertEquals(expectedRoomDescription, dungeon.currentRoomDescription());
  }

  /**
   * Tests the currentRoomDescription method when arrows is picked up in room.
   */

  @Test
  public void testCurrentRoomDescriptionWhenArrowsPickedUpInRoom() {
    dungeon.movePlayer(Direction.SOUTH);
    dungeon.movePlayer(Direction.EAST);

    assertTrue(dungeon.pickUpArrows());
    String expectedRoomDescription = "The room is on row 5 and column 6 in the dungeon. "
            +  "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows."
            +  " The possible next locations are (<-^->)";

    assertEquals(expectedRoomDescription, dungeon.currentRoomDescription());
  }

  /**
   * Tests the shoot method when the correct distance and
   * direction are specified.
   */

  @Test
  public void testShootWhenCorrectDistanceAndDirectionSpecified() {
    int expectedNumberOfMonsters = 4;
    assertEquals(expectedNumberOfMonsters, dungeon.getNumberOfMonsters());

    String expectedPlayerDescription =
            "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows. "
            + "The player smells a PUNGENT";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());

    //kill nearby monster
    assertEquals(0, dungeon.shoot(2, Direction.WEST));
    assertEquals(1, dungeon.shoot(2, Direction.WEST));

    assertEquals(expectedNumberOfMonsters - 1, dungeon.getNumberOfMonsters());

    expectedPlayerDescription =
            "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows. "
            + "The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
  }

  /**
   * Tests the shoot method when the player has no more arrows.
   */

  @Test(expected = IllegalStateException.class)
  public void testShootWhenPlayerHasNoMoreArrows() {
    int expectedNumberOfMonsters = 4;
    assertEquals(expectedNumberOfMonsters, dungeon.getNumberOfMonsters());

    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5. "
            + "The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a PUNGENT";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());

    //kill nearby monster
    assertEquals(0, dungeon.shoot(2, Direction.WEST));
    assertEquals(1, dungeon.shoot(2, Direction.WEST));

    assertEquals(expectedNumberOfMonsters - 1, dungeon.getNumberOfMonsters());

    expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5. "
            + "The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());

    dungeon.shoot(2, Direction.WEST);
    dungeon.shoot(2, Direction.WEST);
  }

  /**
   * Tests the shoot method for an invalid direction.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testShootForInvalidDirection() {
    int expectedNumberOfMonsters = 4;
    assertEquals(expectedNumberOfMonsters, dungeon.getNumberOfMonsters());

    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a PUNGENT";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());

    //kill nearby monster
    assertEquals(0, dungeon.shoot(2, Direction.WEST));
    assertEquals(1, dungeon.shoot(2, Direction.WEST));

    assertEquals(expectedNumberOfMonsters - 1, dungeon.getNumberOfMonsters());

    expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());

    dungeon.shoot(2, Direction.EAST);
  }

  /**
   * Tests the shoot method for an invalid distance.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testShootForInvalidDistance() {
    int expectedNumberOfMonsters = 4;
    assertEquals(expectedNumberOfMonsters, dungeon.getNumberOfMonsters());

    String expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false. "
            +  "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows. "
            + "The player smells a PUNGENT";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());

    //kill nearby monster
    assertEquals(0, dungeon.shoot(2, Direction.WEST));
    assertEquals(1, dungeon.shoot(2, Direction.WEST));

    assertEquals(expectedNumberOfMonsters - 1, dungeon.getNumberOfMonsters());

    expectedPlayerDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());

    dungeon.shoot(-1, Direction.WEST);
  }

  /**
   * Tests the shoot method when arrow passes
   * through a crooked tunnel.
   */

  @Test
  public void testShootWhenArrowPassesThroughACrookedTunnel() {
    int expectedNumberOfMonsters = 4;
    assertEquals(expectedNumberOfMonsters, dungeon.getNumberOfMonsters());
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.SOUTH);
    dungeon.pickUpArrows();
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.WEST);
    dungeon.pickUpArrows();
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.EAST);
    //kill nearby monster
    assertEquals(0, dungeon.shoot(1, Direction.NORTH));
    assertEquals(1, dungeon.shoot(1, Direction.NORTH));
    assertEquals(expectedNumberOfMonsters - 1, dungeon.getNumberOfMonsters());

    //////////////////////////////////////////////////
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.EAST);
    //kill nearby monster
    assertEquals(0, dungeon.shoot(2, Direction.WEST));
    assertEquals(1, dungeon.shoot(2, Direction.WEST));
    assertEquals(expectedNumberOfMonsters - 2, dungeon.getNumberOfMonsters());
  }

  /**
   * Tests the shoot method should take in an exact distance.
   */

  @Test
  public void testShootShouldTakeInAnExactDistance() {
    int expectedNumberOfMonsters = 4;
    assertEquals(expectedNumberOfMonsters, dungeon.getNumberOfMonsters());
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.SOUTH);
    dungeon.pickUpArrows();
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.WEST);
    dungeon.pickUpArrows();
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.EAST);
    //kill nearby monster
    assertEquals(-1, dungeon.shoot(2, Direction.NORTH));
    assertEquals(-1, dungeon.shoot(2, Direction.NORTH));
    assertEquals(expectedNumberOfMonsters , dungeon.getNumberOfMonsters());
  }

  /**
   * Tests the shoot method return false if arrow
   * is not able to complete distance.
   */

  @Test
  public void testShootIfArrowIsNotAbleToCompleteDistance() {
    int expectedNumberOfMonsters = 4;
    assertEquals(expectedNumberOfMonsters, dungeon.getNumberOfMonsters());
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.SOUTH);
    dungeon.pickUpArrows();
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.WEST);
    dungeon.pickUpArrows();
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.EAST);
    //kill nearby monster
    assertEquals(0, dungeon.shoot(1, Direction.NORTH));
    assertEquals(1, dungeon.shoot(1, Direction.NORTH));
    assertEquals(expectedNumberOfMonsters - 1 , dungeon.getNumberOfMonsters());

    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);

    assertEquals(-1, dungeon.shoot(2, Direction.WEST));
    assertEquals(expectedNumberOfMonsters - 1 , dungeon.getNumberOfMonsters());
  }

  /**
   * Tests the isGameOver method when player bumps into a fully
   * healthy monster.
   */

  @Test
  public void testIsGameOverWhenPlayerGetsEatenByFullyHealthyMonster() {
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);

    assertTrue(dungeon.isGameOver());
    assertFalse(dungeon.isDidPlayerWin());
  }

  /**
   * Tests the isGameOver method when player bumps into a half
   * healthy monster.
   */

  @Test
  public void testIsGameOverWhenPlayerGetsEatenByHalfHealthyMonster() {
    dungeon.shoot(2, Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);

    assertTrue(dungeon.isGameOver());
    assertFalse(dungeon.isDidPlayerWin());
  }

  /**
   * Tests the isGameOver method when player reaches end successfully.
   */

  @Test
  public void testIsGameOverWhenPlayerReachesEndSuccessfully() {
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.WEST);

    //kill nearby monster
    dungeon.shoot(1, Direction.SOUTH);
    dungeon.shoot(1, Direction.SOUTH);

    dungeon.movePlayer(Direction.SOUTH);
    assertTrue(dungeon.isGameOver());
    assertTrue(dungeon.isDidPlayerWin());
  }

  /**
   * Tests the isDidPlayerWin method when player bumps into a fully
   * healthy monster.
   */

  @Test
  public void testDidPlayerWinWhenPlayerGetsEatenByFullyHealthyMonster() {
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    assertFalse(dungeon.isDidPlayerWin());
  }

  /**
   * Tests the isDidPlayerWin method when player bumps into a half
   * healthy monster.
   */

  @Test
  public void testDidPlayerWinWhenPlayerGetsEatenByHalfHealthyMonster() {
    dungeon.shoot(2, Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);

    assertFalse(dungeon.isDidPlayerWin());
  }

  /**
   * Tests the isDidPlayerWin method when player reaches end successfully.
   */

  @Test
  public void testDidPlayerWinWhenPlayerReachesEndSuccessfully() {
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.WEST);

    //kill nearby monster
    dungeon.shoot(1, Direction.SOUTH);
    dungeon.shoot(1, Direction.SOUTH);

    dungeon.movePlayer(Direction.SOUTH);
    assertTrue(dungeon.isDidPlayerWin());
  }

  /**
   * Tests the movePlayer method when player bumps into a fully
   * healthy monster.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMovePlayerWhenPlayerMovesIntoARoomWithAFullyHealthyMonster() {
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);

    assertTrue(dungeon.isGameOver());
    assertFalse(dungeon.isDidPlayerWin());

    dungeon.movePlayer(Direction.EAST);
  }

  /**
   * Tests the movePlayer method when player bumps into a half
   * healthy monster.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMovePlayerWhenPlayerMovesIntoARoomWithAHalfHealthyMonster() {
    dungeon.shoot(2, Direction.WEST);
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.WEST);

    assertTrue(dungeon.isGameOver());
    assertFalse(dungeon.isDidPlayerWin());

    dungeon.movePlayer(Direction.EAST);
  }

  /**
   * Test that the smell is very pungent when it should be so.
   */

  @Test
  public void testWhenSmellIsVeryPungent() {
    dungeon.movePlayer(Direction.WEST);
    String expectedDescription = "Ben is in room (<-v->) which is at row 4, column 4."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a VERY_PUNGENT";
    assertEquals(expectedDescription, dungeon.getPlayerDescription());
  }

  /**
   * Test that the smell is pungent when it should be so.
   */

  @Test
  public void testWhenSmellIsPungent() {
    String expectedDescription = "Ben is in room (<-^v) which is at row 4, column 5."
            + " The room is a tunnel : false."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows. "
            + "The player smells a PUNGENT";
    assertEquals(expectedDescription, dungeon.getPlayerDescription());
  }

  /**
   * Test that there is no smell when it should be so.
   */

  @Test
  public void testWhenNoSmell() {
    dungeon.movePlayer(Direction.WEST);
    dungeon.movePlayer(Direction.SOUTH);
    dungeon.movePlayer(Direction.WEST);

    String expectedPlayerDescription = "Ben is in room (<-->) which is at row 5, column 3."
            + " The room is a tunnel : true."
            +  " Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows. "
            + "The player smells a NO_SMELL";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
  }
}
