import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import dungeon.Direction;
import dungeon.Dungeon;
import dungeon.IDungeon;
import org.junit.Before;
import org.junit.Test;
import randomize.MockRandomnessForUnwrapped;
import randomize.MockRandomnessForWrapped;
import randomize.Randomness;

import java.util.Arrays;

/**
 * A test that tests all the different methods
 * of the IDungeon interface.
 */

public class IDungeonTest {

  private IDungeon dungeon;
  /**
   * Sets up all the variables needed before testing.
   */

  @Before
  public void setUp() {
    dungeon = new Dungeon(2,
            "Ben", true, 6, 8, 20, new MockRandomnessForWrapped());
  }

  /**
   * Tests the dungeon constructor.
   */

  @Test
  public void testDungeonConstructor() {
    int[] expectedLocation = new int[] {3, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertTrue(Arrays.equals(expectedLocation,dungeon.getStart()));
    int[] expectedEnd = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedEnd, dungeon.getEnd()));

    String expectedDungeonString = "(<-v->) (<-v->) (<-^) "
            + "  (^->)   (<-^v)  (->)    (<-^v)  (v->)   \n"
            + "(^)     (^v)    (v->)   (<-v)   (^v)    (v)     (^->)   (<-^v)  \n"
            + "(<-)    (^v)    (^)     (^v)    (^v)    (^v)    (v)     (^->)   \n"
            + "(<-->)  (<-^v)  (->)    (<-^v->)(<-^)   (^v->)  (<-^)   (->)    \n"
            + "(->)    (<-^)   (v->)   (<-^v->)(<-->)  (<-^v)  (->)    (<-v)   \n"
            + "(<-)    (->)    (<-^v)  (^v)    (v)     (^->)   (<-v->) (<-^->) \n";
    assertEquals(expectedDungeonString, dungeon.toString());

    String expectedRoomsDescription = "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 0 and column 4 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 0 and column 6 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 1 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 3 in the dungeon. "
            +  "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 7 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 2 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            +   " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            +   " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 2 and column 7 in the dungeon."
            +    " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 3 and column 0 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 1 in the dungeon. "
            +  "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            +  "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            +   " It has 4 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            +   " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 4 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 5 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 5 and column 1 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 5 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 5 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^->)";

    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

    String expectedPlayerDescription = "Ben is in room (->) which is at row 3,"
            +  " column 7. Player has 0 sapphires, 0 diamonds, 0 rubies";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());

  }

  /**
   * Tests the dungeon constructor when row passed is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenRowIsNegative() {
    new Dungeon(0, "Ben", true, -1, 4, 30, new Randomness());
  }

  /**
   * Tests the dungeon constructor when column passed is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenColumnIsNegative() {
    new Dungeon(0, "Ben", true, 4, -4, 30, new Randomness());
  }

  /**
   * Tests the dungeon constructor when interconnectivity passed is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenInterConnectivityIsNegative() {
    new Dungeon(-6, "Ben", true, 4, 4, 30, new Randomness());
  }

  /**
   * Tests the dungeon constructor when percentage passed is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenPercentageIsNegative() {
    new Dungeon(0, "Ben", true, 4, 4, -5, new Randomness());
  }

  /**
   * Tests the dungeon constructor when percentage passed is greater than 100.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenPercentageIsGreaterThan100() {
    Dungeon invalidDungeon = new Dungeon(0, "Ben", true, 4, 4, 105, new Randomness());
  }

  /**
   * Tests the dungeon constructor when column passed is less than 4.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenColumnsLessThan4() {
    Dungeon invalidDungeon = new Dungeon(0, "Ben", true, 4, 2,
            20, new Randomness());
  }

  /**
   * Tests the dungeon constructor when rows passed is less than 4.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testDungeonConstructorWhenRowsLessThan4() {
    Dungeon invalidDungeon = new Dungeon(0, "Ben", true, 2, 4,
            20, new Randomness());
  }

  /**
   * Tests the getPlayerLocation method.
   */

  @Test
  public void testGetPlayerLocation() {
    int[] expectedLocation = new int[] {3, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
  }

  /**
   * Tests the movePlayer method to move randomly in
   * the dungeon.
   */

  @Test
  public void testMovePlayer() {
    dungeon.movePlayer(Direction.EAST);
    int[] expectedLocation = new int[] {3, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {4, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
  }

  /**
   * Tests the movePlayer method to visit all rooms for a
   * wrapped dungeon.
   */

  @Test
  public void testMovePlayerToVisitAllRoomsForWrappedDungeon() {
    int[] expectedLocation = new int[] {3, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {4, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {4, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {4, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {0, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    dungeon.pickUpTreasure();
    expectedLocation = new int[] {5, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {5, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {4, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {4, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {2, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {3, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {3, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {3, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {5, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    dungeon.pickUpTreasure();
    expectedLocation = new int[] {5, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {5, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {5, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    dungeon.pickUpTreasure();
    expectedLocation = new int[] {4, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {4, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {5, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {4, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {4, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {3, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    dungeon.pickUpTreasure();
    expectedLocation = new int[] {3, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {1, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {2, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {1, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {2, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {3, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {5, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {0, 4};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {5, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 3};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {4, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {5, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {5, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {0, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {2, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {2, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {2, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {1, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    dungeon.pickUpTreasure();
    expectedLocation = new int[] {0, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 5};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {0, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 6};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
  }

  /**
   * Tests the movePlayer method to go from start to end
   * without visiting all rooms for a wrapped dungeon.
   */

  @Test
  public void testMovePlayerFromStartToEndForWrappedDungeon() {
    int[] expectedLocation = new int[] {3, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {0, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.NORTH);
    dungeon.pickUpTreasure();
    expectedLocation = new int[] {5, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {0, 2};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
  }

  /**
   * Tests the movePlayer method to visit all rooms for an
   * unwrapped dungeon.
   */

  @Test
  public void testMovePlayerToVisitAllRoomsForUnwrappedDungeon() {
    Dungeon unwrappedDungeon = new Dungeon(2, "player",
            false, 6, 8, 20, new MockRandomnessForUnwrapped());
    int[] expectedLocation = new int[] {5, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 5};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 4};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 3};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {5, 1};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 1};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {4, 0};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {5, 0};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 0};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {4, 1};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {5, 1};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {5, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {1, 1};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {1, 0};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {2, 0};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {3, 0};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 1};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 1};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {3, 1};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {3, 0};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 0};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 0};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {1, 1};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {1, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {2, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {3, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {4, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {5, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {5, 3};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {5, 4};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {5, 5};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {5, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    unwrappedDungeon.pickUpTreasure();
    expectedLocation = new int[] {2, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {3, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {4, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {3, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {3, 5};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {4, 5};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 5};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 5};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {2, 4};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {3, 4};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {4, 4};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 4};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {3, 3};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {4, 3};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 3};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 4};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 4};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 4};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {1, 5};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 5};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {0, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    unwrappedDungeon.pickUpTreasure();
    expectedLocation = new int[] {2, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {1, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 5};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 4};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 3};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 1};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 0};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));
    unwrappedDungeon.pickUpTreasure();
    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {0, 1};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {0, 2};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {0, 3};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 3};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {2, 3};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

  }

  /**
   * Tests the movePlayer method to go from start to end
   * without visiting all rooms for an unwrapped dungeon.
   */

  @Test
  public void testMovePlayerFromStartToEndForUnwrappedDungeon() {
    Dungeon unwrappedDungeon = new Dungeon(2, "player",
            false, 6, 8, 20, new MockRandomnessForUnwrapped());
    int[] expectedLocation = new int[] {5, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {4, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {3, 7};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {3, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {3, 6};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {3, 5};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 5};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {2, 4};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

    unwrappedDungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {2, 3};
    assertTrue(Arrays.equals(expectedLocation,unwrappedDungeon.getPlayerLocation()));

  }

  /**
   * Tests the movePlayer method when moving in an impossible direction.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMovePlayerWhenMovingInImpossibleDirection() {
    dungeon.movePlayer(Direction.EAST);
    int[] expectedLocation = new int[] {3, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    dungeon.movePlayer(Direction.SOUTH);
  }

  /**
   * Tests the getStart method.
   */

  @Test
  public void testGetStart() {
    int[] expectedStart = new int[] {3, 7};
    assertTrue(Arrays.equals(expectedStart,dungeon.getStart()));
  }

  /**
   * Tests the getEnd method.
   */

  @Test
  public void testGetEnd() {
    int[] expectedEnd = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedEnd, dungeon.getEnd()));
  }

  /**
   * Tests the isAtEnd method.
   */

  @Test
  public void testIsAtEnd() {
    dungeon.movePlayer(Direction.EAST);
    int[] expectedLocation = new int[] {3, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.EAST);
    expectedLocation = new int[] {3, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {2, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {1, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.NORTH);
    expectedLocation = new int[] {0, 1};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.WEST);
    expectedLocation = new int[] {0, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    assertFalse(dungeon.isAtEnd());

    dungeon.movePlayer(Direction.SOUTH);
    expectedLocation = new int[] {1, 7};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));

    assertTrue(dungeon.isAtEnd());
  }

  /**
   * Tests the pickUpTreasure method when treasure is present in room.
   */

  @Test
  public void testPickUpTreasureWhenTreasureIsPresentInRoom() {
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.EAST);

    String expectedPlayerDescription = "Ben is in room (<-^) which is at row 0,"
            +  " column 2. Player has 0 sapphires, 0 diamonds, 0 rubies";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    String expectedRoomsDescription = "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 0 and column 4 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 0 and column 6 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 1 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 3 in the dungeon. "
            +  "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 7 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 2 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            +   " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            +   " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 2 and column 7 in the dungeon."
            +    " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 3 and column 0 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 1 in the dungeon. "
            +  "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            +  "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            +   " It has 4 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            +   " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 4 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 5 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 5 and column 1 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 5 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 5 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^->)";

    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());
    dungeon.movePlayer(Direction.NORTH);
    dungeon.pickUpTreasure();
    expectedPlayerDescription = "Ben is in room (<-^v) which is at row 5,"
            +  " column 2. Player has 1 sapphires, 0 diamonds, 0 rubies";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    expectedRoomsDescription = "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 0 and column 4 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 0 and column 6 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 1 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 3 in the dungeon. "
            +  "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 7 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 2 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            +   " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            +   " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 2 and column 7 in the dungeon."
            +    " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 3 and column 0 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 1 in the dungeon. "
            +  "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            +  "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            +   " It has 4 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            +   " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 4 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 5 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 5 and column 1 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 5 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 5 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^->)";

    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

  }

  /**
   * Tests the pickUpTreasure method when treasure is not present in room.
   */

  @Test
  public void testPickUpTreasureWhenTreasureIsNotPresentInRoom() {
    dungeon.movePlayer(Direction.EAST);
    int[] expectedLocation = new int[] {3, 0};
    assertTrue(Arrays.equals(expectedLocation,dungeon.getPlayerLocation()));
    dungeon.pickUpTreasure();


    String expectedPlayerDescription = "Ben is in room (<-->) which is at row 3,"
            +  " column 0. Player has 0 sapphires, 0 diamonds, 0 rubies";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
    String expectedRoomsDescription = "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 0 and column 4 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 0 and column 6 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 1 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 3 in the dungeon. "
            +  "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 7 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 2 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            +   " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            +   " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 2 and column 7 in the dungeon."
            +    " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 3 and column 0 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 1 in the dungeon. "
            +  "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            +  "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            +   " It has 4 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            +   " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 4 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 5 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 5 and column 1 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 5 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 5 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^->)";

    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

  }

  /**
   * Tests the toString method.
   */

  @Test
  public void testToString() {
    String expectedDungeonString = "(<-v->) (<-v->) (<-^) "
            + "  (^->)   (<-^v)  (->)    (<-^v)  (v->)   \n"
            + "(^)     (^v)    (v->)   (<-v)   (^v)    (v)     (^->)   (<-^v)  \n"
            + "(<-)    (^v)    (^)     (^v)    (^v)    (^v)    (v)     (^->)   \n"
            + "(<-->)  (<-^v)  (->)    (<-^v->)(<-^)   (^v->)  (<-^)   (->)    \n"
            + "(->)    (<-^)   (v->)   (<-^v->)(<-->)  (<-^v)  (->)    (<-v)   \n"
            + "(<-)    (->)    (<-^v)  (^v)    (v)     (^->)   (<-v->) (<-^->) \n";
    assertEquals(expectedDungeonString, dungeon.toString());
  }

  /**
   * Tests the getRoomsDescription method when treasure is not picked up in room.
   */

  @Test
  public void testGetRoomsDescriptionWhenTreasureIsNotPickedUpInRoom() {
    dungeon.movePlayer(Direction.EAST);
    dungeon.pickUpTreasure();
    String expectedRoomsDescription = "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 0 and column 4 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 0 and column 6 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 1 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 3 in the dungeon. "
            +  "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 7 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 2 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            +   " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            +   " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 2 and column 7 in the dungeon."
            +    " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 3 and column 0 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 1 in the dungeon. "
            +  "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            +  "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            +   " It has 4 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            +   " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 4 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 5 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 5 and column 1 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 5 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 5 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^->)";

    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

  }

  /**
   * Tests the getRoomsDescription method when treasure is picked up in room.
   */

  @Test
  public void testGetRoomsDescriptionWhenTreasureIsPickedUpInRoom() {
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.EAST);
    String expectedRoomsDescription = "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 0 and column 4 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 0 and column 6 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 1 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 3 in the dungeon. "
            +  "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 7 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 2 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            +   " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            +   " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 2 and column 7 in the dungeon."
            +    " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 3 and column 0 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 1 in the dungeon. "
            +  "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            +  "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            +   " It has 4 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            +   " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 4 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 5 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 5 and column 1 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 5 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 5 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^->)";

    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());
    dungeon.movePlayer(Direction.NORTH);
    dungeon.pickUpTreasure();
    expectedRoomsDescription = "\nThe room is on row 0 and column 0 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 1 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 0 and column 2 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 0 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 0 and column 4 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 5 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 0 and column 6 in the dungeon."
            + " It has 3 entrances, and has 1 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 0 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 1 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 1 and column 3 in the dungeon. "
            +  "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 1 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 1 and column 5 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 1 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 1 and column 7 in the dungeon."
            +  " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 2 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 2 and column 1 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 2 in the dungeon."
            +   " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^)\n"
            + "The room is on row 2 and column 3 in the dungeon."
            +   " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 5 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 2 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v)\n"
            + "The room is on row 2 and column 7 in the dungeon."
            +    " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 3 and column 0 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 3 and column 1 in the dungeon. "
            +  "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 3 and column 2 in the dungeon. "
            +  "It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 3 and column 3 in the dungeon."
            +   " It has 4 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 3 and column 4 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 5 in the dungeon."
            +   " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v->)\n"
            + "The room is on row 3 and column 6 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 3 and column 7 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 0 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (->)\n"
            + "The room is on row 4 and column 1 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^)\n"
            + "The room is on row 4 and column 2 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (v->)\n"
            + "The room is on row 4 and column 3 in the dungeon."
            +  " It has 4 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v->)\n"
            + "The room is on row 4 and column 4 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 4 and column 6 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 1 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 4 and column 7 in the dungeon."
            +  " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-v)\n"
            + "The room is on row 5 and column 0 in the dungeon."
            +  " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-)\n"
            + "The room is on row 5 and column 1 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (->)\n"
            + "The room is on row 5 and column 2 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)\n"
            + "The room is on row 5 and column 3 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^v)\n"
            + "The room is on row 5 and column 4 in the dungeon."
            + " It has 1 entrances, and has 0 sapphires, 0 diamonds, 0 rubies. "
            + "The possible next locations are (v)\n"
            + "The room is on row 5 and column 5 in the dungeon."
            + " It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (^->)\n"
            + "The room is on row 5 and column 6 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 1 diamonds, 0 rubies."
            + " The possible next locations are (<-v->)\n"
            + "The room is on row 5 and column 7 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^->)";

    assertEquals(expectedRoomsDescription, dungeon.getRoomsDescription());

  }

  /**
   * Tests the getPlayerDescription method when player has treasure.
   */

  @Test
  public void testGetPlayerDescriptionWhenPlayerHasTreasure() {
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.EAST);

    String expectedPlayerDescription = "Ben is in room (<-^) which is at row 0,"
            +  " column 2. Player has 0 sapphires, 0 diamonds, 0 rubies";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());

    dungeon.movePlayer(Direction.NORTH);

    dungeon.pickUpTreasure();
    expectedPlayerDescription = "Ben is in room (<-^v) which is at row 5,"
            +  " column 2. Player has 1 sapphires, 0 diamonds, 0 rubies";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
  }

  /**
   * Tests the getPlayerDescription method when player has no treasure.
   */

  @Test
  public void testGetPlayerDescriptionWhenPlayerHasNoTreasure() {
    dungeon.movePlayer(Direction.EAST);
    dungeon.pickUpTreasure();


    String expectedPlayerDescription = "Ben is in room (<-->) which is at row 3,"
            +  " column 0. Player has 0 sapphires, 0 diamonds, 0 rubies";
    assertEquals(expectedPlayerDescription, dungeon.getPlayerDescription());
  }

  /**
   * Tests the currentRoomDescription method when treasure is not picked up in room.
   */

  @Test
  public void testCurrentRoomDescriptionWhenTreasureIsNotPickedUpInRoom() {
    dungeon.movePlayer(Direction.EAST);
    dungeon.pickUpTreasure();
    String expectedRoomDescription = "The room is on row 3 and column 0 in the dungeon. "
            + "It has 2 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-->)";

    assertEquals(expectedRoomDescription, dungeon.currentRoomDescription());

  }

  /**
   * Tests the currentRoomDescription method when treasure is picked up in room.
   */

  @Test
  public void testCurrentRoomDescriptionWhenTreasureIsPickedUpInRoom() {
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.movePlayer(Direction.EAST);
    dungeon.movePlayer(Direction.NORTH);
    dungeon.pickUpTreasure();
    String expectedRoomDescription = "The room is on row 5 "
            + "and column 2 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies."
            + " The possible next locations are (<-^v)";


    assertEquals(expectedRoomDescription, dungeon.currentRoomDescription());

  }

  /**
   * Tests the isCurrentRoomTunnel method.
   */

  @Test
  public void testIsCurrentRoomTunnel() {
    dungeon.movePlayer(Direction.EAST);
    assertTrue(dungeon.isCurrentRoomTunnel());

    dungeon.movePlayer(Direction.EAST);
    assertFalse(dungeon.isCurrentRoomTunnel());

    dungeon.movePlayer(Direction.NORTH);
    assertTrue(dungeon.isCurrentRoomTunnel());

    dungeon.movePlayer(Direction.NORTH);
    assertTrue(dungeon.isCurrentRoomTunnel());

    dungeon.movePlayer(Direction.NORTH);
    assertFalse(dungeon.isCurrentRoomTunnel());

    dungeon.movePlayer(Direction.WEST);
    assertFalse(dungeon.isCurrentRoomTunnel());

    dungeon.movePlayer(Direction.WEST);
    assertTrue(dungeon.isCurrentRoomTunnel());
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
    boolean expected = true;
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



}
