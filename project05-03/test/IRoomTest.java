import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import dungeon.Direction;
import dungeon.Health;
import dungeon.IRoom;
import dungeon.Room;
import org.junit.Before;
import org.junit.Test;
import treasure.Treasure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * A test that tests all the different methods
 * of the IRoom interface.
 */

public class IRoomTest {
  private IRoom room;

  /**
   * Sets up all the variables needed before testing.
   */

  @Before
  public void setUp() {
    int[] positionOfRoom = new int[] {2, 3};
    room = new Room(positionOfRoom);
  }

  /**
   * Tests the constructor when array for position has length 1.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testRoomConstructorWhenArrayForPositionHasLengthOf1() {
    IRoom invalidRoom = new Room(new int[] {2});
  }

  /**
   * Tests the constructor when array for position has one negative value.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testRoomConstructorWhenArrayForPositionHasOneNegativeValue() {
    IRoom invalidRoom = new Room(new int[] {2, -1});
  }

  /**
   * Tests the constructor when array for position has two negative value.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testRoomConstructorWhenArrayForPositionHasTwoNegativeValue() {
    IRoom invalidRoom = new Room(new int[] {-2, -1});
  }

  /**
   * Tests the copy constructor for room.
   */

  @Test
  public void testRoomCopyConstructor() {
    IRoom roomCopy = new Room(room);
    assertEquals(room.getNumberOfEntrances(), roomCopy.getNumberOfEntrances());
    assertEquals(room.isTunnel(), roomCopy.isTunnel());
    assertTrue(Arrays.equals(room.getPosition(), roomCopy.getPosition()));
    assertEquals(room.getDescription(), roomCopy.getDescription());
    assertEquals(room.getNextRooms(), roomCopy.getNextRooms());
    assertTrue(room.getTreasures().equals(roomCopy.getTreasures()));

  }

  /**
   * Tests the getPosition method.
   */

  @Test
  public void testRoomGetPosition() {
    int[] expectedPosition = new int[] {2, 3};
    assertTrue(Arrays.equals(expectedPosition, room.getPosition()));
  }

  /**
   * Tests the connect method.
   */

  @Test
  public void testConnectBetweenTwoRooms() {
    IRoom otherRoom1 = new Room(new int[] {2, 4});
    IRoom otherRoom2 = new Room(new int[] {2, 2});
    IRoom otherRoom3 = new Room(new int[] {1, 3});
    IRoom otherRoom4 = new Room(new int[] {3, 3});

    room.connect(Direction.EAST, otherRoom1);
    room.connect(Direction.WEST, otherRoom2);
    room.connect(Direction.NORTH, otherRoom3);
    room.connect(Direction.SOUTH, otherRoom4);

    int expectedEntrancesForRoom = 4;
    assertEquals(expectedEntrancesForRoom, room.getNumberOfEntrances());
  }

  /**
   * Tests the connect method when the room is already connected from that direction.
   */

  @Test
  public void testConnectBetweenTwoRoomsWhenAlreadyConnected() {
    IRoom otherRoom1 = new Room(new int[] {2, 4});
    IRoom otherRoom2 = new Room(new int[] {2, 2});
    IRoom otherRoom3 = new Room(new int[] {1, 3});
    IRoom otherRoom4 = new Room(new int[] {3, 3});

    room.connect(Direction.EAST, otherRoom1);
    room.connect(Direction.WEST, otherRoom2);
    room.connect(Direction.NORTH, otherRoom3);
    room.connect(Direction.SOUTH, otherRoom4);

    int expectedEntrancesForRoom = 4;
    assertEquals(expectedEntrancesForRoom, room.getNumberOfEntrances());

    room.connect(Direction.EAST, otherRoom1);
    assertEquals(expectedEntrancesForRoom, room.getNumberOfEntrances());

  }

  /**
   * Tests the isTunnel method.
   */

  @Test
  public void testTheIsTunnelMethod() {

    IRoom otherRoom1 = new Room(new int[] {2, 4});
    room.connect(Direction.EAST, otherRoom1);
    assertFalse(room.isTunnel());

    IRoom otherRoom2 = new Room(new int[] {2, 2});
    room.connect(Direction.WEST, otherRoom2);
    assertTrue(room.isTunnel());

    IRoom otherRoom3 = new Room(new int[] {1, 3});
    room.connect(Direction.NORTH, otherRoom3);
    assertFalse(room.isTunnel());

    IRoom otherRoom4 = new Room(new int[] {3, 3});
    room.connect(Direction.SOUTH, otherRoom4);
    assertFalse(room.isTunnel());
  }

  /**
   * Tests the getNumberOfEntrances method.
   */

  @Test
  public void testTheGetNumberOfEntrancesMethod() {


    int expectedEntrancesForRoom = 1;

    IRoom otherRoom1 = new Room(new int[] {2, 4});
    room.connect(Direction.EAST, otherRoom1);
    assertEquals(expectedEntrancesForRoom, room.getNumberOfEntrances());

    IRoom otherRoom2 = new Room(new int[] {2, 2});
    room.connect(Direction.WEST, otherRoom2);
    assertEquals(expectedEntrancesForRoom + 1, room.getNumberOfEntrances());

    IRoom otherRoom3 = new Room(new int[] {1, 3});
    room.connect(Direction.NORTH, otherRoom3);
    assertEquals(expectedEntrancesForRoom + 2, room.getNumberOfEntrances());

    IRoom otherRoom4 = new Room(new int[] {3, 3});
    room.connect(Direction.SOUTH, otherRoom4);
    assertEquals(expectedEntrancesForRoom + 3, room.getNumberOfEntrances());

    room.connect(Direction.EAST, otherRoom1);
    assertEquals(expectedEntrancesForRoom + 3, room.getNumberOfEntrances());
  }

  /**
   * Tests the getTreasures method.
   */

  @Test
  public void testTheGetTreasuresMethod() {

    List<Treasure> treasureList = new ArrayList<>();
    treasureList.add(Treasure.SAPPHIRE);
    treasureList.add(Treasure.DIAMOND);
    treasureList.add(Treasure.SAPPHIRE);
    treasureList.add(Treasure.RUBY);
    treasureList.add(Treasure.DIAMOND);

    room.addTreasures(treasureList);

    List<Treasure> expectedResult = new ArrayList<>();
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.DIAMOND);
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.RUBY);
    expectedResult.add(Treasure.DIAMOND);

    assertEquals(expectedResult, room.getTreasures());

  }

  /**
   * Tests the addTreasures method.
   */

  @Test
  public void testTheAddTreasuresMethod() {

    List<Treasure> treasureList = new ArrayList<>();
    treasureList.add(Treasure.SAPPHIRE);
    treasureList.add(Treasure.DIAMOND);
    treasureList.add(Treasure.SAPPHIRE);
    treasureList.add(Treasure.RUBY);
    treasureList.add(Treasure.DIAMOND);

    room.addTreasures(treasureList);

    List<Treasure> expectedResult = new ArrayList<>();
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.DIAMOND);
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.RUBY);
    expectedResult.add(Treasure.DIAMOND);

    assertEquals(expectedResult, room.getTreasures());

  }

  /**
   * Tests the removeAllTreasures method.
   */

  @Test
  public void testTheRemoveAllTreasuresMethod() {

    List<Treasure> treasureList = new ArrayList<>();
    treasureList.add(Treasure.SAPPHIRE);
    treasureList.add(Treasure.DIAMOND);
    treasureList.add(Treasure.SAPPHIRE);
    treasureList.add(Treasure.RUBY);
    treasureList.add(Treasure.DIAMOND);

    room.addTreasures(treasureList);

    List<Treasure> expectedResult = new ArrayList<>();
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.DIAMOND);
    expectedResult.add(Treasure.SAPPHIRE);
    expectedResult.add(Treasure.RUBY);
    expectedResult.add(Treasure.DIAMOND);
    assertEquals(expectedResult, room.getTreasures());

    room.removeAllTreasures();

    assertTrue(room.getTreasures().isEmpty());
  }

  /**
   * Tests the getNextRooms method.
   */

  @Test
  public void testTheGetNextRoomsMethod() {

    IRoom otherRoom1 = new Room(new int[] {2, 4});
    IRoom otherRoom2 = new Room(new int[] {2, 2});
    IRoom otherRoom3 = new Room(new int[] {1, 3});
    IRoom otherRoom4 = new Room(new int[] {3, 3});

    room.connect(Direction.EAST, otherRoom1);
    room.connect(Direction.WEST, otherRoom2);
    room.connect(Direction.NORTH, otherRoom3);
    room.connect(Direction.SOUTH, otherRoom4);
    room.connect(Direction.EAST, otherRoom1);

    Map<Direction, IRoom> expectedMap = new HashMap<>();
    expectedMap.put(Direction.EAST, otherRoom1);
    expectedMap.put(Direction.WEST, otherRoom2);
    expectedMap.put(Direction.NORTH, otherRoom3);
    expectedMap.put(Direction.SOUTH, otherRoom4);

    assertEquals(expectedMap, room.getNextRooms());
  }

  /**
   * Tests the getDescription method.
   */

  @Test
  public void testTheGetDescriptionMethod() {

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

    String expectedDescription = "The room is on row 2 and column 3 in the dungeon."
            + " It has 4 entrances, and has 2 sapphires,"
            + " 2 diamonds, 1 rubies, and 0 arrows. The possible next locations are (<-^v->)";

    assertEquals(expectedDescription, room.getDescription());
  }

  /**
   * Tests the getNumberOfArrows method.
   */

  @Test
  public void testTheGetNumberOfArrowsMethod() {
    room.addArrows(3);
    assertEquals(3, room.getNumberOfArrows());
    room.removeAllArrows();
    assertEquals(0, room.getNumberOfArrows());
  }

  /**
   * Tests the removeAllArrows method.
   */

  @Test
  public void testTheRemoveAllArrowsMethod() {
    room.addArrows(3);
    assertEquals(3, room.getNumberOfArrows());
    room.removeAllArrows();
    assertEquals(0, room.getNumberOfArrows());
  }

  /**
   * Tests the addArrows method.
   */

  @Test
  public void testTheAddArrowsMethod() {
    room.addArrows(3);
    assertEquals(3, room.getNumberOfArrows());
  }

  /**
   * Tests the addArrows method when negative number inputted.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testTheAddArrowsMethodWhenNegativeNumberInputted() {
    room.addArrows(-3);
  }

  /**
   * Tests the removeMonster method.
   */

  @Test
  public void testTheRemoveMonsterMethod() {
    assertFalse(room.hasAMonster());
    room.addMonster();
    assertTrue(room.hasAMonster());
    room.removeMonster();
    assertFalse(room.hasAMonster());
  }

  /**
   * Tests the hasAMonster method.
   */

  @Test
  public void testTheHasMonsterMethod() {
    assertFalse(room.hasAMonster());
    room.addMonster();
    assertTrue(room.hasAMonster());
    room.removeMonster();
    assertFalse(room.hasAMonster());
  }

  /**
   * Tests the addMonster method.
   */

  @Test
  public void testTheAddMonsterMethod() {
    assertFalse(room.hasAMonster());
    room.addMonster();
    assertTrue(room.hasAMonster());
    room.removeMonster();
    assertFalse(room.hasAMonster());
  }

  /**
   * Tests the addMonster method when monster already exists.
   */

  @Test(expected = IllegalStateException.class)
  public void testTheAddMonsterMethodWhenMonsterAlreadyExists() {
    assertFalse(room.hasAMonster());
    room.addMonster();
    assertTrue(room.hasAMonster());
    room.addMonster();
  }

  /**
   * Tests the hitMonster method.
   */

  @Test
  public void testTheHitMonsterMethod() {
    assertFalse(room.hasAMonster());
    room.addMonster();
    assertTrue(room.hasAMonster());
    Health expectedHealth = Health.FULL_HEALTH;
    assertEquals(expectedHealth, room.getMonsterHealth());
    room.hitMonster();
    expectedHealth = Health.HALF_HEALTH;
    assertEquals(expectedHealth, room.getMonsterHealth());
    room.hitMonster();
    assertFalse(room.hasAMonster());
  }

  /**
   * Tests the getMonsterHealth method.
   */

  @Test
  public void testTheGetMonsterHealthMethod() {
    assertFalse(room.hasAMonster());
    room.addMonster();
    assertTrue(room.hasAMonster());
    Health expectedHealth = Health.FULL_HEALTH;
    assertEquals(expectedHealth, room.getMonsterHealth());
    room.hitMonster();
    expectedHealth = Health.HALF_HEALTH;
    assertEquals(expectedHealth, room.getMonsterHealth());
    room.hitMonster();
    assertFalse(room.hasAMonster());
  }

  /**
   * Tests the getMonsterHealth method when no monster exists.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testTheGetMonsterHealthMethodWhenNoMonsterExists() {
    assertFalse(room.hasAMonster());
    room.getMonsterHealth();
  }

  /**
   * Tests the getMonster method when no monster exists.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testTheGetMonsterMethodWhenNoMonsterExists() {
    assertFalse(room.hasAMonster());
    room.getMonster();
  }
}
