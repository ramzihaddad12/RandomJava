package tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * This starter files is for students to implement a console controller for the
 * TicTacToe MVC assignment.
 */

public class TicTacToeConsoleController implements TicTacToeController {

  private final Appendable out;
  private final Scanner scan;

  /**
   * Constructor for the controller.
   *
   * @param in  the source to read from
   * @param out the target to print to
   */

  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = out;
    scan = new Scanner(in);
  }

  @Override
  public void playGame(TicTacToe m) {
    if (m == null) {
      throw new IllegalArgumentException();
    }

    boolean isGameNotOver = true;
    try {
      this.out.append(m.toString() + "\n");
    }

    catch (IOException e) {
      throw new IllegalStateException();
    }

    while (isGameNotOver) {

      try {
        this.out.append(String.format("Enter a move for %s:\n", m.getTurn()));
        boolean haveFirst = false;
        boolean haveSecond = false;
        int row = -1;
        int column = -1;

        while (!haveFirst && !haveSecond) {
          while (!haveFirst) {
            String num1 = scan.next();
            if (num1.equals("q") || num1.equals("Q")) {
              out.append("Game quit! Ending game state:\n");
              out.append(m.toString());
              out.append("\n");
              return;
            }
            try {
              row = Integer.parseInt(num1);
              haveFirst = true;
            } catch (NumberFormatException e) {
              out.append(String.format("Not a valid number: %s\n", num1));
              continue;
            }
          }

          while (!haveSecond) {
            String num1 = scan.next();
            if (num1.equals("q") || num1.equals("Q")) {
              out.append("Game quit! Ending game state:\n");
              out.append(m.toString());
              out.append("\n");
              return;
            }
            try {
              column = Integer.parseInt(num1);
              haveSecond = true;
            } catch (NumberFormatException e) {
              out.append(String.format("Not a valid number: %s\n", num1));
              continue;
            }
          }

          try {
            if (isGameNotOver) {
              m.move(row - 1, column - 1);
              isGameNotOver = !m.isGameOver();
              this.out.append(m.toString() + "\n");
            }

          } catch (IllegalArgumentException e) {
            out.append(String.format("Not a valid move: %d, %d\n", row, column));
            haveFirst = false;
            haveSecond = false;
          }
        }

      } catch (IOException e) {
        throw new IllegalStateException();
      }
    }

    try {
      this.out.append("Game is over! ");
      if (m.getWinner() == null) {
        this.out.append("Tie game.\n");
      } else {
        this.out.append(String.format("%s wins.\n", m.getWinner()));
      }
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }

}
