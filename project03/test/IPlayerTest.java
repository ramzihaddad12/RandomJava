import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import dungeon.Direction;
import dungeon.IPlayer;
import dungeon.IRoom;
import dungeon.Player;
import dungeon.Room;
import org.junit.Before;
import org.junit.Test;
import treasure.Treasure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * A test that tests all the different methods
 * of the IPlayer interface.
 */

public class IPlayerTest {
  private IPlayer player;

  /**
   * Sets up all the variables needed before testing.
   */

  @Before
  public void setUp() {
    int [] positionOfRoom = new int[] {2, 3};
    IRoom room = new Room(positionOfRoom);
    IRoom otherRoom1 = new Room(new int[] {2, 4});
    IRoom otherRoom2 = new Room(new int[] {2, 2});
    IRoom otherRoom3 = new Room(new int[] {1, 3});
    IRoom otherRoom4 = new Room(new int[] {3, 3});

    room.connect(Direction.EAST, otherRoom1);
    room.connect(Direction.WEST, otherRoom2);
    room.connect(Direction.NORTH, otherRoom3);
    room.connect(Direction.SOUTH, otherRoom4);
    room.connect(Direction.EAST, otherRoom1);

    List<Treasure> treasureList = new ArrayList<>();
    treasureList.add(Treasure.SAPPHIRE);
    treasureList.add(Treasure.DIAMOND);
    treasureList.add(Treasure.SAPPHIRE);
    treasureList.add(Treasure.RUBY);
    treasureList.add(Treasure.DIAMOND);

    room.addTreasures(treasureList);
    player = new Player("Ben", room);
  }

  /**
   * Tests the getPosition method.
   */

  @Test
  public void testGetPosition() {
    List<Treasure> expectedResult = new ArrayList<>();
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.DIAMOND);
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.RUBY);
    expectedResult.add(Treasure.DIAMOND);

    int[] expectedPosition = new int[] {2, 3};
    assertTrue(Arrays.equals(expectedPosition, player.getPosition().getPosition()));

    String expectedDescription = "The room is on row 2 and column 3 in the dungeon."
            + " It has 4 entrances, and has 2 sapphires,"
            + " 2 diamonds, 1 rubies. The possible next locations are (<-^v->)";
    assertEquals(expectedDescription, player.getPosition().getDescription());

    int expectedEntrances = 4;
    assertEquals(expectedEntrances, player.getPosition().getNumberOfEntrances());
    assertEquals(expectedResult, player.getPosition().getTreasures());
  }

  /**
   * Tests the getName method.
   */

  @Test
  public void testGetName() {
    String expectedName = "Ben";
    assertEquals(expectedName, player.getName());
  }

  /**
   * Tests the pickUpTreasure method.
   */

  @Test
  public void testPickUpTreasure() {
    List<Treasure> expectedResult = new ArrayList<>();
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.DIAMOND);
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.RUBY);
    expectedResult.add(Treasure.DIAMOND);
    player.pickUpTreasure();
    assertEquals(expectedResult, player.getTreasures());
  }

  /**
   * Tests the getTreasures method.
   */

  @Test
  public void testGetTreasures() {
    List<Treasure> expectedResult = new ArrayList<>();
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.DIAMOND);
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.RUBY);
    expectedResult.add(Treasure.DIAMOND);
    player.pickUpTreasure();
    assertEquals(expectedResult, player.getTreasures());
  }

  /**
   * Tests the getDescription method.
   */

  @Test
  public void testGetDescription() {
    List<Treasure> expectedResult = new ArrayList<>();
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.DIAMOND);
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.RUBY);
    expectedResult.add(Treasure.DIAMOND);
    player.pickUpTreasure();
    String expectedDescription = "Ben is in room (<-^v->) which is at row 2, "
            + "column 3. Player has 2 sapphires, 2 diamonds, 1 rubies";
    assertEquals(expectedDescription, player.getDescription());
  }

  /**
   * Tests the move method for moving east.
   */

  @Test
  public void testMoveForMovingEast() {
    int[] expectedPosition = new int[] {2, 4};
    player.move(Direction.EAST);
    assertTrue(Arrays.equals(expectedPosition, player.getPosition().getPosition()));
  }

  /**
   * Tests the move method for moving west.
   */

  @Test
  public void testMoveForMovingWest() {
    int[] expectedPosition = new int[] {2, 2};
    player.move(Direction.WEST);
    assertTrue(Arrays.equals(expectedPosition, player.getPosition().getPosition()));
  }

  /**
   * Tests the move method for moving north.
   */

  @Test
  public void testMoveForMovingNorth() {
    int[] expectedPosition = new int[] {1, 3};
    player.move(Direction.NORTH);
    assertTrue(Arrays.equals(expectedPosition, player.getPosition().getPosition()));
  }

  /**
   * Tests the move method for moving south.
   */

  @Test
  public void testMoveForMovingSouth() {
    int[] expectedPosition = new int[] {3, 3};
    player.move(Direction.SOUTH);
    assertTrue(Arrays.equals(expectedPosition, player.getPosition().getPosition()));
  }


}
