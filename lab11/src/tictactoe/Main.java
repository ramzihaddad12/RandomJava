package tictactoe;

/**
 * Run a TicTacToe game interactively.
 */
public class Main {
  /**
   * Run a TicTacToe game interactively.
   */
  public static void main(String[] args) {
    TicTacToeModel model = new TicTacToeModel();
    TicTacToeView view = new TicTacToeSwingView(model);
    TicTacToeController controller = new TicTacToeSwingController(model,view);
    controller.playGame();
  }
}
