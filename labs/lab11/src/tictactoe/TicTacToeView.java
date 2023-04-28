package tictactoe;

/**
 * A view for TicTacToe: display the game board and provide visual interface
 * for users.
 */
public interface TicTacToeView {

  /**
   * Set up the controller to handle click events in this view.
   * 
   * @param listener the controller
   */
  void addClickListener(TicTacToeController listener);

  /**
   * Refresh the view to reflect any changes in the game state.
   */
  void refresh();

  /**
   * Make the view visible to start the game session.
   */
  void makeVisible();

  /**
   * Set the text area of the view to the given text.
   * @param text the given text to display in the text area of the view.
   */

  void setAreaText(String text);

  /**
   * Displays a given an error message to the view.
   * @param error the error message to be displayed in the view.
   */

  void showErrorMessage(String error);

  /**
   * Displays the winner of the game to the view.
   * @param winner the winner of the game to be displayed in the view.
   */

  void showWinner(String winner);
}
