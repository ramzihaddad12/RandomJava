package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;
/**
 * A TicTacToeModel model implements the actual functionalities
 * of TicTacToe.
 */

public class TicTacToeModel implements TicTacToe {
  private Player[][] board;
  private static boolean isXTurn;
  /**
   * A constructor for the TicTacToeModel.
   */

  public TicTacToeModel() {
    this.isXTurn = true;
    this.board = new Player[3][3];
  }

  /**
   * Execute a move in the position specified by the given row and column.
   *
   * @param r the row of the intended move
   * @param c the column of the intended move
   * @throws IllegalArgumentException if the space is occupied or the position is otherwise invalid
   * @throws IllegalStateException    if the game is over
   */
  @Override
  public void move(int r, int c) {
    if (r < 0 || c < 0 || r > 2 || c > 2) {
      throw new IllegalArgumentException("Row or column out of bounds!");
    }
    if (isGameOver()) {
      throw new IllegalStateException("Game is over");
    }

    if (getMarkAt(r, c) != null) {
      throw new IllegalArgumentException("Space is occupied!");
    }

    board[r][c] = getTurn();
    isXTurn = !isXTurn;
  }

  /**
   * Get the current turn, i.e., the player who will mark on the next call to move().
   *
   * @return the {@link Player} whose turn it is
   */
  @Override
  public Player getTurn() {
    return isXTurn ? Player.X : Player.O;
  }

  /**
   * Return whether the game is over. The game is over when either the board is full, or
   * one player has won.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    return isBoardFull() || getWinner() != null;
  }

  /**
   * Return the winner of the game, or {@code null} if there is no winner. If the game is not
   * over, returns {@code null}.
   *
   * @return the winner, or null if there is no winner
   */
  @Override
  public Player getWinner() {
    if (didPlayerWin(Player.X)) {
      return Player.X;
    }

    if (didPlayerWin(Player.O)) {
      return Player.O;
    }

    return null;
  }

  private boolean isBoardFull() {
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        if (board[r][c] == null) {
          return false;
        }
      }
    }
    return true;
  }


  private boolean didPlayerWin(Player player) {
    if ((board[0][0] == player && board[1][1] == player && board[2][2] == player)
            || (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
      return true;
    }

    for (int r = 0; r < board.length; r++) {
      if (board[r][0] == player && board[r][1] == player && board[r][2] == player) {
        return true;
      }
    }

    for (int c = 0; c < board[0].length; c++) {
      if (board[0][c] == player && board[1][c] == player && board[2][c] == player) {
        return true;
      }
    }


    return false;
  }

  /**
   * Return the current game state, as a 2D array of Player. A {@code null} value in the grid
   * indicates an empty position on the board.
   *
   * @return the current game board
   */
  @Override
  public Player[][] getBoard() {
    Player[][] copyOfBoard = new Player[3][3];
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        copyOfBoard[r][c] = board[r][c];
      }
    }
    return copyOfBoard;
  }

  /**
   * Return the current {@link Player} mark at a given row and column, or {@code null} if the
   * position is empty.
   *
   * @param r the row
   * @param c the column
   * @return the player at the given position, or null if it's empty
   */
  @Override
  public Player getMarkAt(int r, int c) {
    if (r < 0 || c < 0 || r > 2 || c > 2) {
      throw new IllegalArgumentException("Row or column out of bounds!");
    }
    Player mark = board[r][c];
    return mark;
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
      row -> " " + Arrays.stream(row).map(
          p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
            .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using the helpful
    // built-in String.join method.
    // List<String> rows = new ArrayList<>();
    // for(Player[] row : getBoard()) {
    //   List<String> rowStrings = new ArrayList<>();
    //   for(Player p : row) {
    //     if(p == null) {
    //       rowStrings.add(" ");
    //     } else {
    //       rowStrings.add(p.toString());
    //     }
    //   }
    //   rows.add(" " + String.join(" | ", rowStrings));
    // }
    // return String.join("\n-----------\n", rows);
  }
}
