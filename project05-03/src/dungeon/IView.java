package dungeon;

/**
 * The view interface. To motivate the methods here
 * think about all the operations that the controller
 * would need to invoke on the view
 *
 */
public interface IView {
  /**
   * Set up the controller to handle click events in this view.
   *
   * @param listener the controller
   */
  void addClickListener(GUIController listener);

  /**
   * Refresh the view to reflect any changes in the game state.
   */
  void refresh();

  /**
   * Make the view visible to start the game session.
   */
  void makeVisible();

  public void setRoomDescriptionText(String text);

  public void setPlayerDescriptionText(String text);

  public void showErrorMessage(String error);

  public void showInformationMessage(String error);

  public void addKeyBoardListener(GUIController listener);

  public void setDungeonPanel(boolean[][] visited, IRoom[][] board,
                              int[] playerLocation, String playerDescription);

  public void addController(GUIController controller);

  public void initializeView();

  public int getDistance();
}

