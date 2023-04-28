import static org.junit.Assert.assertEquals;

import org.junit.Test;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeConsoleController;
import tictactoe.TicTacToeController;
import tictactoe.TicTacToeModel;

import java.io.StringReader;

/**
 * Test cases for the tic tac toe controller, using mocks for readable and
 * appendable.
 */
public class TicTacToeControllerTest {

  /**
   * Test for an invalid null model passed to the controller.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidModel() {
    StringReader input = new StringReader("1 1");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(null);
  }

  /**
   * Test for invalid input (not an integer) for row.
   */

  @Test
  public void testInvalidNumberForRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 one 1 2 three 3 3 2 1 two 2 2");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            + "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            +  " X |   |  \n"
            +   "-----------\n"
            +    "   |   |  \n"
            +    "-----------\n"
            +    "   |   |  \n"
            +      "Enter a move for O:\n"
            + "Not a valid number: one\n"
            +  " X | O |  \n"
            +  "-----------\n"
            +   "   |   |  \n"
            +    "-----------\n"
            +    "   |   |  \n"
            +   "Enter a move for X:\n"
            + "Not a valid number: three\n"
            +  " X | O |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +    "-----------\n"
            +  "   |   | X\n"
            +  "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            +   " O |   |  \n"
            + "-----------\n"
            +  "   |   | X\n"
            + "Enter a move for X:\n"
            + "Not a valid number: two\n"
            +  " X | O |  \n"
            +  "-----------\n"
            +  " O | X |  \n"
            + "-----------\n"
            + "   |   | X\n"
            + "Game is over! X wins.\n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test for invalid input (not an integer) for column.
   */

  @Test
  public void testInvalidNumberForColumn() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 two three 2 3 three 3 2 1 2 two 2");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            + "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            +  " X |   |  \n"
            +   "-----------\n"
            +    "   |   |  \n"
            +    "-----------\n"
            +    "   |   |  \n"
            +      "Enter a move for O:\n"
            + "Not a valid number: two\n"
            + "Not a valid number: three\n"
            +  " X | O |  \n"
            +  "-----------\n"
            +   "   |   |  \n"
            +    "-----------\n"
            +    "   |   |  \n"
            +   "Enter a move for X:\n"
            + "Not a valid number: three\n"
            +  " X | O |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +    "-----------\n"
            +  "   |   | X\n"
            +  "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            +   " O |   |  \n"
            + "-----------\n"
            +  "   |   | X\n"
            + "Enter a move for X:\n"
            + "Not a valid number: two\n"
            +  " X | O |  \n"
            +  "-----------\n"
            +  " O | X |  \n"
            + "-----------\n"
            + "   |   | X\n"
            + "Game is over! X wins.\n";
    assertEquals(expectedString, gameLog.toString());
  }


  /**
   * Test for invalid move when row out of bounds.
   */

  @Test
  public void testInvalidMoveRowOutOfBounds() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 2 4 3 2 2 0 2 -1 0 1 3 3 3");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + " X |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + "Not a valid move: 4, 3\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   | X |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for O:\n"
            + "Not a valid move: 0, 2\n"
            + "Not a valid move: -1, 0\n"
            + " X | O | O\n"
            + "-----------\n"
            + "   | X |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + " X | O | O\n"
            + "-----------\n"
            + "   | X |  \n"
            + "-----------\n"
            +   "   |   | X\n"
            +  "Game is over! X wins.\n";
    assertEquals(expectedString, gameLog.toString());
  }


  /**
   * Test for invalid move when column out of bounds.
   */

  @Test
  public void testInvalidMoveColumnOutOfBounds() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 2 3 4 3 5 2 2 1 0 0 -1 1 3 3 3");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + " X |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + "Not a valid move: 3, 4\n"
            + "Not a valid move: 3, 5\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   | X |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for O:\n"
            + "Not a valid move: 1, 0\n"
            + "Not a valid move: 0, -1\n"
            + " X | O | O\n"
            + "-----------\n"
            + "   | X |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + " X | O | O\n"
            + "-----------\n"
            + "   | X |  \n"
            + "-----------\n"
            +   "   |   | X\n"
            +  "Game is over! X wins.\n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test for quitting game 'q' key is given for row.
   */

  @Test
  public void testQuittingGameWhenqIsGivenForRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 2 q 1");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "Enter a move for X:\n"
            +  " X |   |  \n"
            + "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +   "Enter a move for O:\n"
            +  " X | O |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            + "Enter a move for X:\n"
            +  "Game quit! Ending game state:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test for quitting game 'q' key is given for column.
   */

  @Test
  public void testQuittingGameWhenqIsGivenForColumn() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 2 1 q");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "Enter a move for X:\n"
            +  " X |   |  \n"
            + "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +   "Enter a move for O:\n"
            +  " X | O |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            + "Enter a move for X:\n"
            +  "Game quit! Ending game state:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test for quitting game 'Q' key is given for row.
   */

  @Test
  public void testQuittingGameWhenQIsGivenForRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 2 Q 1");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "Enter a move for X:\n"
            +  " X |   |  \n"
            + "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +   "Enter a move for O:\n"
            +  " X | O |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            + "Enter a move for X:\n"
            +  "Game quit! Ending game state:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test for quitting game 'Q' key is given for column.
   */

  @Test
  public void testQuittingGameWhenQIsGivenForColumn() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 2 1 Q");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "Enter a move for X:\n"
            +  " X |   |  \n"
            + "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +   "Enter a move for O:\n"
            +  " X | O |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            +  "-----------\n"
            +  "   |   |  \n"
            + "Enter a move for X:\n"
            +  "Game quit! Ending game state:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test that valid moves work correctly.
   */

  @Test
  public void testValidMoves() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 2 3 3 2 1 2 2");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + " X |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   | X\n"
            + "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            + " O |   |  \n"
            +  "-----------\n"
            +    "   |   | X\n"
            +    "Enter a move for X:\n"
            +   " X | O |  \n"
            +     "-----------\n"
            +    " O | X |  \n"
            +     "-----------\n"
            +    "   |   | X\n"
            +   "Game is over! X wins.\n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test for invalid move when position already occupied.
   */

  @Test
  public void testInvalidMoveAlreadyTakenSpace() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 1 2 2 3 3 1 2 3 3 2 2 3 1 2 1 2 3 1 3 3 2");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            +  "Enter a move for X:\n"
            +   " X |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for O:\n"
            + "Not a valid move: 1, 1\n"
            + " X |   |  \n"
            +  "-----------\n"
            + "   | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + " X |   |  \n"
            + "-----------\n"
            + "   | O |  \n"
            + "-----------\n"
            + "   |   | X\n"
            + "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   | O |  \n"
            + "-----------\n"
            +  "   |   | X\n"
            + "Enter a move for X:\n"
            + "Not a valid move: 3, 3\n"
            + "Not a valid move: 2, 2\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   | O |  \n"
            + "-----------\n"
            + " X |   | X\n"
            + "Enter a move for O:\n"
            +  " X | O |  \n"
            + "-----------\n"
            + " O | O |  \n"
            + "-----------\n"
            + " X |   | X\n"
            + "Enter a move for X:\n"
            + " X | O |  \n"
            + "-----------\n"
            + " O | O | X\n"
            + "-----------\n"
            + " X |   | X\n"
            + "Enter a move for O:\n"
            + " X | O | O\n"
            + "-----------\n"
            + " O | O | X\n"
            + "-----------\n"
            + " X |   | X\n"
            + "Enter a move for X:\n"
            + " X | O | O\n"
            + "-----------\n"
            + " O | O | X\n"
            + "-----------\n"
            + " X | X | X\n"
            + "Game is over! X wins.\n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test that an invalid move does not stop the program.
   */

  @Test
  public void testInvalidMoveDoesNotStopProgram() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 1 two 2 2 3 three 3 1 2 3 "
            + "3 2 2 3 1 2 1 2 3 1 3 3 2");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            +  "Enter a move for X:\n"
            +   " X |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for O:\n"
            + "Not a valid move: 1, 1\n"
            + "Not a valid number: two\n"
            + " X |   |  \n"
            +  "-----------\n"
            + "   | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + "Not a valid number: three\n"
            + " X |   |  \n"
            + "-----------\n"
            + "   | O |  \n"
            + "-----------\n"
            + "   |   | X\n"
            + "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   | O |  \n"
            + "-----------\n"
            +  "   |   | X\n"
            + "Enter a move for X:\n"
            + "Not a valid move: 3, 3\n"
            + "Not a valid move: 2, 2\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   | O |  \n"
            + "-----------\n"
            + " X |   | X\n"
            + "Enter a move for O:\n"
            +  " X | O |  \n"
            + "-----------\n"
            + " O | O |  \n"
            + "-----------\n"
            + " X |   | X\n"
            + "Enter a move for X:\n"
            + " X | O |  \n"
            + "-----------\n"
            + " O | O | X\n"
            + "-----------\n"
            + " X |   | X\n"
            + "Enter a move for O:\n"
            + " X | O | O\n"
            + "-----------\n"
            + " O | O | X\n"
            + "-----------\n"
            + " X |   | X\n"
            + "Enter a move for X:\n"
            + " X | O | O\n"
            + "-----------\n"
            + " O | O | X\n"
            + "-----------\n"
            + " X | X | X\n"
            + "Game is over! X wins.\n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test when X wins.
   */

  @Test
  public void testXWinsGame() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 2 3 3 2 1 2 2");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + " X |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   | X\n"
            + "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            + " O |   |  \n"
            +  "-----------\n"
            +    "   |   | X\n"
            +    "Enter a move for X:\n"
            +   " X | O |  \n"
            +     "-----------\n"
            +    " O | X |  \n"
            +     "-----------\n"
            +    "   |   | X\n"
            +   "Game is over! X wins.\n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test when O wins.
   */

  @Test
  public void testOWinsGame() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 2 1 1 2 1 3 3 3 1 2 2");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + "   | X |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for O:\n"
            + " O | X |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + " O | X |  \n"
            + "-----------\n"
            + " X |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for O:\n"
            + " O | X |  \n"
            + "-----------\n"
            + " X |   |  \n"
            + "-----------\n"
            + "   |   | O\n"
            + "Enter a move for X:\n"
            + " O | X |  \n"
            + "-----------\n"
            + " X |   |  \n"
            + "-----------\n"
            + " X |   | O\n"
            + "Enter a move for O:\n"
            + " O | X |  \n"
            + "-----------\n"
            + " X | O |  \n"
            + "-----------\n"
            + " X |   | O\n"
            +   "Game is over! O wins.\n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test when no one wins.
   */

  @Test
  public void testTieGame() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 2 2 3 3 1 2 3 2 3 1 1 3 2 3 2 1");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);

    String expectedString = "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "Enter a move for X:\n"
            + " X |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            + "-----------\n"
            + "   |   |  \n"
            +  "Enter a move for O:\n"
            + " X |   |  \n"
            +  "-----------\n"
            +  "   | O |  \n"
            + "-----------\n"
            + "   |   |  \n"
            +  "Enter a move for X:\n"
            + " X |   |  \n"
            +  "-----------\n"
            +  "   | O |  \n"
            + "-----------\n"
            + "   |   | X\n"
            + "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   | O |  \n"
            + "-----------\n"
            + "   |   | X\n"
            + "Enter a move for X:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   | O |  \n"
            + "-----------\n"
            + "   | X | X\n"
            + "Enter a move for O:\n"
            + " X | O |  \n"
            + "-----------\n"
            + "   | O |  \n"
            +  "-----------\n"
            +  " O | X | X\n"
            +  "Enter a move for X:\n"
            +  " X | O | X\n"
            + "-----------\n"
            + "   | O |  \n"
            + "-----------\n"
            + " O | X | X\n"
            +  "Enter a move for O:\n"
            +  " X | O | X\n"
            +  "-----------\n"
            +   "   | O | O\n"
            +  "-----------\n"
            +   " O | X | X\n"
            +   "Enter a move for X:\n"
            +   " X | O | X\n"
            +  "-----------\n"
            +   " X | O | O\n"
            +  "-----------\n"
            +  " O | X | X\n"
            + "Game is over! Tie game.\n";
    assertEquals(expectedString, gameLog.toString());
  }

  /**
   * Test for a failing appendable.
   */

  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    // Testing when something goes wrong with the Appendable
    // Here we are passing it a mock of an Appendable that always fails
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
  }
}
