package view;

import controller.GuiController;
import model.IRoom;

import java.io.IOException;

/**
 * A mock view that is used for testing purposes.
 *
 */

public class MockView implements IView {
  private Appendable log;

  /**
   * A constructor for the MockView.
   */

  public MockView(Appendable log) {
    this.log = log;
  }


  @Override
  public void addClickListener(GuiController listener) {
    try {
      log.append("adding click listener" + "\n");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void refresh() {
    try {
      log.append("Refreshing"  + "\n");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void makeVisible() {
    try {
      log.append("Making visible" + "\n");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void setRoomDescriptionText(String text) {
    try {
      log.append(text + "\n");
    }
    catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void setPlayerDescriptionText(String text, boolean isGameOver) {
    try {
      log.append(text + "\n");
      log.append("Game is over: " + isGameOver + "\n");
    }

    catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void showErrorMessage(String error) {
    try {
      log.append(error + "\n");
    }

    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void showInformationMessage(String information) {

    try {
      log.append(information + "\n");

    }

    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void addKeyBoardListener(GuiController listener) {

    try {
      log.append("adding keyboard listener" + "\n");

    }

    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void setDungeonPanel(boolean[][] visited, IRoom[][] board,
                              int[] playerLocation, String playerDescription) {

    try {
      log.append("Setting dungeon panel\n");
    }

    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void addController(GuiController controller) {

    try {
      log.append("Controller added\n");
    }

    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void initializeView() {
    try {
      log.append("initializing view\n");
    }

    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int getDistance() {
    return 1;
  }

  @Override
  public void setStatusText(String text) {
    try {
      log.append(text + "\n");
    }

    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
