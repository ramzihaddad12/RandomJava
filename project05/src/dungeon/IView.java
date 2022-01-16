package dungeon;

import java.awt.event.ActionListener;
import java.util.List;

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
  void addClickListener(IDungeonController listener);

  /**
   * Refresh the view to reflect any changes in the game state.
   */
  void refresh();

  /**
   * Make the view visible to start the game session.
   */
  void makeVisible();

  public void setCommandButtonListener(ActionListener actionEvent);

  public void setAreaText(String text);
  public void showErrorMessage(String error);
  public void showWinner(String winner);
  public void addKeyBoardListener(IDungeonController listener);
}

