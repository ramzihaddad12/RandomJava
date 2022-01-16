import static org.junit.Assert.assertEquals;

import controller.DungeonSwingController;
import controller.GuiController;
import org.junit.Before;
import org.junit.Test;
import randomize.MockRandomnessForUnwrappedWithMonsters;
import view.IView;
import view.MockView;

import java.awt.Button;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;



/**
 * Tests for the GuiController using a mock view.
 */
public class GuiControllerTest {

  private GuiController controller;
  private StringBuilder builder;

  /**
   * Sets up all the variables needed before testing.
   */

  @Before
  public void setUp() {
    builder = new StringBuilder();
    IView mockView = new MockView(builder);
    controller = new DungeonSwingController(mockView);
  }

  /**
   * Test for the handleCellClick method.
   */

  @Test
  public void testPlayGame() {
    controller.playGame();
    

    String expected = "adding keyboard listener\n"
            + "adding click listener\n"
            + "Controller added\n"
            + "initializing view\n"
            + "Making visible\n";
    assertEquals(expected, builder.toString());
  }

  /**
   * Test for the instantiateModel method.
   */

  @Test
  public void testInstantiateModel() {
    controller.instantiateModel(6, 8, 2, 20, 4, 1,
            0, new MockRandomnessForUnwrappedWithMonsters());
    
    String expected = "adding keyboard listener\n"
          + "adding click listener\n"
            + "Controller added\n"
          + "Setting dungeon panel\n"
          + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
          + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
          + " The player smells a PUNGENT"
          + ". The player is in danger of falling: false\n"
          + "Game is over: false\n"
          + "The room is on row 4 and column 5 in the dungeon. "
          + "It has 3 entrances, and has 0 sapphires,"
          + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (<-^v)\n"
          + "Refreshing\n";
    assertEquals(expected, builder.toString());
  }

  /**
   * Test for the handleCellClick method.
   */

  @Test
  public void testHandleCellClick() {
    controller.instantiateModel(6, 8, 2, 20, 4, 1,
            0, new MockRandomnessForUnwrappedWithMonsters());

    

    String expected = "adding keyboard listener\n"
          + "adding click listener\n"
          + "Controller added\n"
          + "Setting dungeon panel\n"
          + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
          + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
          + " The player smells a PUNGENT"
          + ". The player is in danger of falling: false\n"
          + "Game is over: false\n"
          + "The room is on row 4 and column 5 in the dungeon."
          + " It has 3 entrances, and has 0 sapphires,"
          + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (<-^v)\n"
          + "Refreshing\n";
    assertEquals(expected, builder.toString());

    controller.handleCellClick(352, 256);

    expected += "Setting dungeon panel\n"
            + "player is in room (<-^v) which is at row 3, column 5. The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a NO_SMELL"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 3 and column 5 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^v)\n"
            + "Refreshing\n";

    assertEquals(expected, builder.toString());
  }

  /**
   * Test for the handleKey method for moving.
   */

  @Test
  public void testHandleKeyForMove() {
    controller.instantiateModel(6, 8, 2, 20, 4, 1,
            0, new MockRandomnessForUnwrappedWithMonsters());

    

    String expected = "adding keyboard listener\n"
            + "adding click listener\n"
            + "Controller added\n"
            + "Setting dungeon panel\n"
            + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a PUNGENT"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (<-^v)\n"
            + "Refreshing\n";
    assertEquals(expected, builder.toString());

    KeyEvent e = new KeyEvent(new Button("mocking"), 0, 1, 1, KeyEvent.VK_UP, 'z');
    controller.handleKey(e);

    expected += "\nplayer is in room (<-^v) which is at row 3, column 5."
            + " The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a NO_SMELL"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 3 and column 5 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^v)\n"
            + "Setting dungeon panel\n"
            + "Refreshing\n";
    assertEquals(expected, builder.toString());
  }

  /**
   * Test for the handleKey method for picking up treasure.
   */

  @Test
  public void testHandleKeyForPickUpTreasure() {
    controller.instantiateModel(6, 8, 2, 20, 4, 1,
            0, new MockRandomnessForUnwrappedWithMonsters());

    

    String expected = "adding keyboard listener\n"
            + "adding click listener\n"
            + "Controller added\n"
            + "Setting dungeon panel\n"
            + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a PUNGENT"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (<-^v)\n"
            + "Refreshing\n";
    assertEquals(expected, builder.toString());

    KeyEvent e = new KeyEvent(new Button("mocking"), 0, 1, 1, KeyEvent.VK_T, 'z');
    controller.handleKey(e);

    expected += "\nPICKUP TREASURE UNSUCCESSFUL\n"
            + "PICKUP TREASURE UNSUCCESSFUL\n"
            + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a PUNGENT"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 4 and column 5 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^v)\n"
            + "Setting dungeon panel\n"
            + "Refreshing\n";
    assertEquals(expected, builder.toString());
  }

  /**
   * Test for the handleKey method for picking up arrows.
   */

  @Test
  public void testHandleKeyForPickUpArrows() {
    controller.instantiateModel(6, 8, 2, 20, 4, 1,
            0, new MockRandomnessForUnwrappedWithMonsters());

    

    String expected = "adding keyboard listener\n"
            + "adding click listener\n"
            + "Controller added\n"
            + "Setting dungeon panel\n"
            + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a PUNGENT"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (<-^v)\n"
            + "Refreshing\n";
    assertEquals(expected, builder.toString());

    KeyEvent e = new KeyEvent(new Button("mocking"), 0, 1, 1, KeyEvent.VK_A, 'z');
    controller.handleKey(e);

    expected += "\nPICKUP ARROWS UNSUCCESSFUL\n"
            + "PICKUP ARROWS UNSUCCESSFUL\n"
            + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a PUNGENT"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 4 and column 5 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^v)\n"
            + "Setting dungeon panel\n"
            + "Refreshing\n";
    assertEquals(expected, builder.toString());
  }

  /**
   * Test for the handleKey method for shooting.
   */

  @Test
  public void testHandleKeyForShooting() {
    controller.instantiateModel(6, 8, 2, 20, 4, 1,
            0, new MockRandomnessForUnwrappedWithMonsters());

    

    String expected = "adding keyboard listener\n"
            + "adding click listener\n"
            + "Controller added\n"
            + "Setting dungeon panel\n"
            + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a PUNGENT"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (<-^v)\n"
            + "Refreshing\n";
    assertEquals(expected, builder.toString());

    KeyEvent e = new KeyEvent(new Button("mocking"), 0, 1, 1, KeyEvent.VK_LEFT, 'z');
    e.setModifiers(InputEvent.CTRL_DOWN_MASK);
    controller.handleKey(e);


    expected += "\nSHOT UNSUCCESSFUL\n"
            + "SHOT UNSUCCESSFUL\n"
            + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 2 arrows."
            + " The player smells a PUNGENT"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 4 and column 5 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^v)\n"
            + "Setting dungeon panel\n"
            + "Refreshing\n";
    assertEquals(expected, builder.toString());
  }

  /**
   * Test for the restartingWithSameModel method for shooting.
  */

  @Test
  public void testRestartingWithSameModel() {
    controller.instantiateModel(6, 8, 2, 20, 4, 1,
            0, new MockRandomnessForUnwrappedWithMonsters());

    

    String expected = "adding keyboard listener\n"
            + "adding click listener\n"
            + "Controller added\n"
            + "Setting dungeon panel\n"
            + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
            + " The player smells a PUNGENT"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 4 and column 5 in the dungeon."
            + " It has 3 entrances, and has 0 sapphires,"
            + " 0 diamonds, 0 rubies, and 0 arrows. The possible next locations are (<-^v)\n"
            + "Refreshing\n";
    assertEquals(expected, builder.toString());

    KeyEvent e = new KeyEvent(new Button("mocking"), 0, 1, 1, KeyEvent.VK_LEFT, 'z');
    e.setModifiers(InputEvent.CTRL_DOWN_MASK);
    controller.handleKey(e);


    expected += "\nSHOT UNSUCCESSFUL\n"
            + "SHOT UNSUCCESSFUL\n"
            + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 2 arrows."
            + " The player smells a PUNGENT"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 4 and column 5 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^v)\n"
            + "Setting dungeon panel\n"
            + "Refreshing\n";
    assertEquals(expected, builder.toString());

    controller.handleKey(e);


    expected += "\nSHOT UNSUCCESSFUL\n"
            + "SHOT UNSUCCESSFUL\n"
            + "player is in room (<-^v) which is at row 4, column 5. The room is a tunnel : false. "
            + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 1 arrows."
            + " The player smells a PUNGENT"
            + ". The player is in danger of falling: false\n"
            + "Game is over: false\n"
            + "The room is on row 4 and column 5 in the dungeon. "
            + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
            + "The possible next locations are (<-^v)\n"
            + "Setting dungeon panel\n"
            + "Refreshing\n";
    assertEquals(expected, builder.toString());

    controller.restartingWithSameModel();

    expected += "Setting dungeon panel\n"
                + "player is in room (<-^v) which is at row 4, column 5."
                + " The room is a tunnel : false. "
                + "Player has 0 sapphires, 0 diamonds, 0 rubies, and 3 arrows."
                + " The player smells a PUNGENT"
                + ". The player is in danger of falling: false\n"
                + "Game is over: false\n"
                + "The room is on row 4 and column 5 in the dungeon. "
                + "It has 3 entrances, and has 0 sapphires, 0 diamonds, 0 rubies, and 0 arrows. "
                + "The possible next locations are (<-^v)\n"
                + "Refreshing\n";
    assertEquals(expected, builder.toString());
  }
}
