package view;

import controller.GuiController;
import model.IRoom;

/**
 * The view interface. To motivate the methods here
 * think about all the operations that the controller
 * would need to invoke on the view.
 *
 */
public interface IView {
  /**
   * Set up the controller to handle click events in this view.
   *
   * @param listener the GUIController.
   */
  void addClickListener(GuiController listener);

  /**
   * Refresh the view to reflect any changes in the dungeon state.
   */
  void refresh();

  /**
   * Make the view visible to start the game session.
   */

  void makeVisible();

  /**
   * Sets the text needed for displaying the room description.
   * @param text the text to be displayed.
   */

  void setRoomDescriptionText(String text);

  /**
   * Sets the text needed for displaying the player description.
   * @param text the text to be displayed.
   * @param isGameOver whether the game is over.
   */

  void setPlayerDescriptionText(String text, boolean isGameOver);

  /**
   * Displays an error message to the user.
   * @param error the error message to be displayed.
   */

  void showErrorMessage(String error);

  /**
   * Displays an information message to the user.
   * @param information the information message to be displayed.
   */

  void showInformationMessage(String information);

  /**
   * Set up the controller to handle keyboard events in this view.
   *
   * @param listener the GUIController.
   */
  void addKeyBoardListener(GuiController listener);

  /**
   * Sets the DungeonPanel needed to display the dungeon.
   * @param visited the visited locations by the player.?
   * @param board the dungeon.
   * @param playerLocation the location of the player.
   * @param playerDescription the description of the player
   */
  void setDungeonPanel(boolean[][] visited, IRoom[][] board,
                              int[] playerLocation, String playerDescription);

  /**
   * Set up the controller to communicate with the view.
   *
   * @param controller the GUIController
   */

  void addController(GuiController controller);

  /**
   * Initializes the view in a setUp manner, getting the inputs to
   * start the game.
   */
  void initializeView();

  /**
   * Gets the distance needed for the user to shoot.
   * @return the distance needed to shoot.
   */
  int getDistance();

  /**
   * Sets the text needed for displaying the result of
   * the player's last move.
   * @param text the text to be displayed.
   */

  void setStatusText(String text);
}

