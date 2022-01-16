import static org.junit.Assert.assertEquals;

import org.junit.Test;
import tictactoe.Player;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeModel;

/**
 * A test class that tests the functionalities of TicTacToe.
 */
public class TicTacToeTest {
  /**
   * A method that tests the getMarkAt method.
   */

  @Test
  public void testGetMarkAt() {
    TicTacToe game = new TicTacToeModel();
    int row = 0;
    int column = 0;
    game.move(row, column);
    Player expectedMark = Player.X;
    assertEquals(expectedMark, game.getMarkAt(row, column));

    expectedMark = null;
    assertEquals(expectedMark, game.getMarkAt(row + 1, column + 1));
  }

  /**
   * A method that tests the getMarkAt method when index out of bounds.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testGetMarkAtWhenIndexOutOfBounds() {
    TicTacToe game = new TicTacToeModel();
    game.getMarkAt(4, 0);
  }

  /**
   * A method that tests the move method.
   */

  @Test
  public void testMove() {
    TicTacToe game = new TicTacToeModel();
    int row = 0;
    int column = 0;
    game.move(row, column);
    Player expectedMark = Player.X;
    assertEquals(expectedMark, game.getMarkAt(row, column));
  }

  /**
   * A method that tests the move method when index out of bounds.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMoveWhenIndexOutOfBounds() {
    TicTacToe game = new TicTacToeModel();
    game.move(4, 0);
  }

  /**
   * A method that tests the move method when position already filled.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testMoveWhenMarkPositionAlreadyFilled() {
    TicTacToe game = new TicTacToeModel();
    int row = 0;
    int column = 0;
    game.move(row, column);
    game.move(row, column);
  }

  /**
   * A method that tests the move method when game is over.
   */

  @Test(expected = IllegalStateException.class)
  public void testMoveWhenGameIsOver() {
    TicTacToe game = new TicTacToeModel();

    game.move(0, 0); // X moves
    game.move(0, 2); // O moves
    game.move(1, 1); // X moves
    game.move(1, 2); // O moves
    game.move(2, 2); //X makes winning move

    game.move(2, 0);
  }

  /**
   * A method that tests the getTurn method.
   */

  @Test
  public void testGetTurn() {
    TicTacToe game = new TicTacToeModel();

    //assuming game starts with player X always
    Player expectedMark = Player.X;
    assertEquals(expectedMark, game.getTurn());

    //X makes turn
    int row = 0;
    int column = 0;
    game.move(row, column);

    expectedMark = Player.O;
    assertEquals(expectedMark, game.getTurn());
  }

  /**
   * A method that tests the getWinner method when no winner.
   */

  @Test
  public void testGetWinnerWhenNoWinner() {
    TicTacToe game = new TicTacToeModel();

    game.move(0, 0); // X moves
    game.move(0, 2); // O moves
    game.move(1, 1); // X moves
    game.move(1, 2); // O moves

    Player expectedWinner = null;
    assertEquals(expectedWinner, game.getWinner());
  }

  /**
   * A method that tests the getWinner method when X is the winner.
   */

  @Test
  public void testGetWinnerWhenXisWinner() {
    TicTacToe game = new TicTacToeModel();

    game.move(0, 0); // X moves
    game.move(0, 2); // O moves
    game.move(1, 1); // X moves
    game.move(1, 2); // O moves

    Player expectedWinner = null;
    assertEquals(expectedWinner, game.getWinner());

    game.move(2, 2); //X makes winning move
    expectedWinner = Player.X;
    assertEquals(expectedWinner, game.getWinner());
  }

  /**
   * A method that tests the getWinner method when O is the winner.
   */

  @Test
  public void testGetWinnerWhenOisWinner() {
    TicTacToe game = new TicTacToeModel();

    game.move(0, 0); // X moves
    game.move(0, 2); // O moves
    game.move(1, 1); // X moves
    game.move(1, 2); // O moves
    game.move(2, 0); // X moves
    Player expectedWinner = null;
    assertEquals(expectedWinner, game.getWinner());

    game.move(2, 2); //O makes winning move
    expectedWinner = Player.O;
    assertEquals(expectedWinner, game.getWinner());
  }

  /**
   * A method that tests the isGameOver method when game is ongoing.
   */

  @Test
  public void testIsGameOverWhenGameIsOngoing() {
    TicTacToe game = new TicTacToeModel();

    game.move(1, 0); // X moves
    game.move(0, 2); // O moves
    game.move(1, 1); // X moves
    game.move(1, 2); // O moves
    game.move(2, 0); // X moves

    Player expectedWinner = null;
    assertEquals(expectedWinner, game.getWinner());
    boolean expectedAnswer = false;
    assertEquals(expectedAnswer, game.isGameOver());
  }

  /**
   * A method that tests the isGameOver method when board is full and no winner.
   */

  @Test
  public void testIsGameOverWhenBoardIsFullAndNoWinner() {
    TicTacToe game = new TicTacToeModel();

    game.move(1, 0); // X moves
    game.move(0, 2); // O moves
    game.move(1, 1); // X moves
    game.move(1, 2); // O moves
    game.move(2, 0); // X moves
    game.move(0, 0); // O moves
    game.move(0, 1); // X moves
    game.move(2, 1); // O moves
    game.move(2, 2); // X moves
    Player expectedWinner = null;
    assertEquals(expectedWinner, game.getWinner());
    boolean expectedAnswer = true;
    assertEquals(expectedAnswer, game.isGameOver());
  }

  /**
   * A method that tests the isGameOver method when there is a winner by diagonal.
   */

  @Test
  public void testIsGameOverWhenAWinnerEmergesByDiagonal() {
    TicTacToe game = new TicTacToeModel();

    game.move(0, 0); // X moves
    game.move(0, 2); // O moves
    game.move(1, 1); // X moves
    game.move(1, 2); // O moves
    game.move(2, 2); //X makes winning move

    Player expectedWinner = Player.X;
    assertEquals(expectedWinner, game.getWinner());

    boolean expectedAnswer = true;
    assertEquals(expectedAnswer, game.isGameOver());
  }

  /**
   * A method that tests the isGameOver method when there is a winner by anti diagonal.
   */

  @Test
  public void testIsGameOverWhenAWinnerEmergesByAntiDiagonal() {
    TicTacToe game = new TicTacToeModel();

    game.move(0, 2); // X moves
    game.move(0, 0); // O moves
    game.move(1, 1); // X moves
    game.move(1, 2); // O moves
    game.move(2, 0); //X makes winning move

    Player expectedWinner = Player.X;
    assertEquals(expectedWinner, game.getWinner());

    boolean expectedAnswer = true;
    assertEquals(expectedAnswer, game.isGameOver());
  }

  /**
   * A method that tests the isGameOver method when there is a winner by row.
   */

  @Test
  public void testIsGameOverWhenAWinnerEmergesByRow() {
    TicTacToe game = new TicTacToeModel();

    game.move(0, 0); // X moves
    game.move(1, 0); // O moves
    game.move(0, 1); // X moves
    game.move(1, 2); // O moves
    game.move(0, 2); //X makes winning move

    Player expectedWinner = Player.X;
    assertEquals(expectedWinner, game.getWinner());

    boolean expectedAnswer = true;
    assertEquals(expectedAnswer, game.isGameOver());
  }

  /**
   * A method that tests the isGameOver method when there is a winner by column.
   */

  @Test
  public void testIsGameOverWhenAWinnerEmergesByColumn() {
    TicTacToe game = new TicTacToeModel();

    game.move(0, 0); // X moves
    game.move(0, 1); // O moves
    game.move(1, 0); // X moves
    game.move(1, 2); // O moves
    game.move(2, 0); //X makes winning move

    Player expectedWinner = Player.X;
    assertEquals(expectedWinner, game.getWinner());

    boolean expectedAnswer = true;
    assertEquals(expectedAnswer, game.isGameOver());
  }

  /**
   * A method that tests the getBoard method.
   */

  @Test
  public void testGetBoard() {
    TicTacToe game = new TicTacToeModel();

    //assuming game starts with player X always\
    //X makes turn
    int row = 0;
    int column = 0;
    game.move(row, column);
    Player expectedMark = Player.X;
    assertEquals(expectedMark, game.getBoard()[row][column]);

    game.move(row + 1, column);
    expectedMark = Player.O;
    assertEquals(expectedMark, game.getBoard()[row + 1][column]);

    expectedMark = null;
    assertEquals(expectedMark, game.getBoard()[row + 1][column + 1]);
  }
}
