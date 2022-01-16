package tictactoe;

/**
 * A Swing controller implementation of the TicTacToeController.
 */
public class TicTacToeSwingController implements TicTacToeController {
  private TicTacToeModel model;
  private TicTacToeView view;

  /**
   * A constructor for the TicTacToeSwingController that takes in a
   * TicTacToeModel and TicTacToeView.
   *
   * @param model the model needed by the controller.
   * @param view  the view needed by the view.
   */

  public TicTacToeSwingController(TicTacToeModel model, TicTacToeView view) {
    this.model = model;
    this.view = view;
    this.view.addClickListener(this);
  }

  @Override
  public void playGame() {
    this.view.makeVisible();
  }

  @Override
  public void handleCellClick(int row, int col) {
    try {
      model.move(row, col);
      view.setAreaText(String.format("Its player %s's turn now!", model.getTurn().toString()));
      view.refresh();
    }

    catch (IllegalStateException ex) {
      if (model.getWinner() != null) {
        String winner = String.format(". Player %s wins!", model.getWinner().toString());
        view.showErrorMessage(ex.getMessage() + winner);
      }

      else {
        view.showErrorMessage(ex.getMessage());
      }

      return;
    }

    catch (IllegalArgumentException exception) {
      view.showErrorMessage(exception.getMessage());
    }

    if (model.getWinner() != null) {
      view.setAreaText(String.format("Game is over! Player %s wins!",
              model.getWinner().toString()));
      view.showWinner(model.getWinner().toString());
      return;
    }

    if (model.isGameOver()) {
      view.setAreaText("Game is over. No winner");
      view.showErrorMessage("Game is over. No winner");
    }
  }
}
