package controller;

import model.Direction;
import model.Dungeon;
import model.IDungeon;
import randomize.Randomness;
import view.IView;

import java.awt.event.KeyEvent;
import java.util.Arrays;

/**
 * A swing controller that communicates with view and model
 * to display the dungeon.
 */
public class DungeonSwingController implements GuiController {
  private IDungeon model;
  private IView view;

  /**
   * A constructor for the DungeonSwingController which takes in a view.
   * @param view the view which the controller communicates with.
   */

  public DungeonSwingController(IView view) {
    if (view == null) {
      throw new IllegalArgumentException("view given is null");
    }
    this.model = null;
    this.view = view;
    this.view.addKeyBoardListener(this);
    this.view.addClickListener(this);
    this.view.addController(this);
  }

  @Override
  public void instantiateModel(int rows,int columns,int interconnectivity,
                               int percentage,int numOfMonsters,int wrapping,
                               int numOfPits, Randomness randomness) {
    try {
      this.model = new Dungeon(interconnectivity, "player",
              wrapping == 0, rows, columns, percentage, numOfMonsters, numOfPits, randomness);
      this.view.setDungeonPanel(model.getVisitedLocations(), model.getDungeon(),
              model.getPlayerLocation(), model.getPlayerDescription());
      this.view.setPlayerDescriptionText(model.getPlayerDescription(), false);
      this.view.setRoomDescriptionText(model.currentRoomDescription());
      this.view.refresh();
    }

    catch (IllegalArgumentException e) {
      this.view.showErrorMessage(e.getMessage());
      this.view.initializeView();
    }
  }

  @Override
  public void playGame() {
    this.view.initializeView();
    this.view.makeVisible();
  }

  @Override
  public void handleCellClick(int x, int y) {
    try {
      int imgSize = 64;
      int x0 = imgSize * model.getPlayerLocation()[1];
      int y0 = imgSize * model.getPlayerLocation()[0];
      x -= 32;
      y -= 32;

      int diff = 20;

      Direction direction = null;
      if (Math.abs(x - x0) <= diff) {
        if (y > y0) {
          direction = Direction.SOUTH;
        }

        else if (y < y0) {
          direction = Direction.NORTH;
        }
      }

      else if (Math.abs(y - y0) <= diff) {
        if (x > x0) {
          direction = Direction.EAST;
        }

        else if (x < x0) {
          direction = Direction.WEST;
        }
      }
      model.movePlayer(direction);
      this.view.setDungeonPanel(model.getVisitedLocations(), model.getDungeon(),
              model.getPlayerLocation(), model.getPlayerDescription());
      view.setPlayerDescriptionText(model.getPlayerDescription(), false);
      view.setRoomDescriptionText(model.currentRoomDescription());
      view.refresh();
      checkGameStatus();
    }

    catch (IllegalArgumentException ex) {
      view.showErrorMessage(ex.getMessage());
    }


  }

  /**
   * Checks the status of the game and displays information if the
   * game is over.
   */
  private void checkGameStatus() {

    if (model.didPlayerGetRobbed() && Arrays.equals(model.getPlayerLocation(), new int[] {1, 1})) {
      view.showInformationMessage("You just got robbed of all your treasure!");
      view.setStatusText("You just got robbed of all your treasure!");
    }

    if (model.isGameOver() && !model.isDidPlayerWin()) {
      if (model.didPlayerFallInPit()) {
        view.setPlayerDescriptionText("Game is over. Player fell in a pit", true);
        view.showInformationMessage("Game is over. Player fell in a pit");
      }

      else {
        view.setPlayerDescriptionText("Game is over. Player got eaten by a monster", true);
        view.showInformationMessage("Game is over. Player got eaten by a monster");
        view.setStatusText("Game over");
      }

    }

    else if (model.isGameOver() && model.isDidPlayerWin()) {
      view.setPlayerDescriptionText("Game is over. Player emerges victorious!", true);
      view.showInformationMessage("Game is over. Player emerges victorious!");
      view.setStatusText("Game over");
    }
  }

  @Override
  public void handleKey(KeyEvent e) {
    try {
      this.view.setStatusText("");
      if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP
              || e.getKeyCode() ==  KeyEvent.VK_LEFT || e.getKeyCode() ==  KeyEvent.VK_RIGHT)
              && !e.isControlDown()) {
        Direction direction = null;

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          direction = Direction.SOUTH;
        }

        else if (e.getKeyCode() == KeyEvent.VK_UP) {
          direction = Direction.NORTH;
        }

        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
          direction = Direction.WEST;
        }

        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
          direction = Direction.EAST;
        }

        try {
          model.movePlayer(direction);
          checkGameStatus();
        }

        catch (IllegalArgumentException exception) {
          this.view.showErrorMessage(exception.getMessage());
          return;
        }
      }

      else if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP
              || e.getKeyCode() ==  KeyEvent.VK_LEFT || e.getKeyCode() ==  KeyEvent.VK_RIGHT)
              && e.isControlDown()) {
        Direction direction = null;

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          direction = Direction.SOUTH;
        }

        else if (e.getKeyCode() == KeyEvent.VK_UP) {
          direction = Direction.NORTH;
        }

        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
          direction = Direction.WEST;
        }

        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
          direction = Direction.EAST;
        }

        int distance = this.view.getDistance();

        try {
          int result = model.shoot(distance, direction);
          if (result == 1) {
            this.view.showInformationMessage("SHOT IS A SUCCESS. MONSTER WAS KILLED");
            this.view.setStatusText("SHOT IS A SUCCESS. MONSTER WAS KILLED");
          }

          else if (result == 0) {
            this.view.showInformationMessage("SHOT IS A SUCCESS. MONSTER WAS HIT");
            this.view.setStatusText("SHOT IS A SUCCESS. MONSTER WAS HIT");

          }

          else {
            this.view.showInformationMessage("SHOT UNSUCCESSFUL");
            this.view.setStatusText("SHOT UNSUCCESSFUL");

          }
        }

        catch (IllegalStateException exception) {
          this.view.showErrorMessage(exception.getMessage());
          return;
        }

      }

      else if (e.getKeyCode() == KeyEvent.VK_A) {
        try {
          boolean success = model.pickUpArrows();
          if (success) {
            this.view.showInformationMessage("PICKUP ARROWS IS A SUCCESS");
            this.view.setStatusText("PICKUP ARROWS IS A SUCCESS");

          }

          else {
            this.view.showInformationMessage("PICKUP ARROWS UNSUCCESSFUL");
            this.view.setStatusText("PICKUP ARROWS UNSUCCESSFUL");
          }
        }

        catch (IllegalArgumentException exception) {
          this.view.showErrorMessage(exception.getMessage());
          return;
        }
      }

      else if (e.getKeyCode() == KeyEvent.VK_T) {
        try {
          boolean success = model.pickUpTreasure();
          if (success) {
            this.view.showInformationMessage("PICKUP TREASURE IS A SUCCESS");
            this.view.setStatusText("PICKUP TREASURE IS A SUCCESS");
          }

          else {
            this.view.showInformationMessage("PICKUP TREASURE UNSUCCESSFUL");
            this.view.setStatusText("PICKUP TREASURE UNSUCCESSFUL");
          }
        }

        catch (IllegalArgumentException exception) {
          this.view.showErrorMessage(exception.getMessage());
          return;
        }
      }

      if (!model.isGameOver()) {
        view.setPlayerDescriptionText(model.getPlayerDescription(), false);
        view.setRoomDescriptionText(model.currentRoomDescription());
      }

      this.view.setDungeonPanel(model.getVisitedLocations(), model.getDungeon(),
              model.getPlayerLocation(), model.getPlayerDescription());
      view.refresh();

    }

    catch (IllegalArgumentException exception) {
      view.showErrorMessage(exception.getMessage());
    }

  }

  @Override
  public void restartingWithSameModel() {
    this.model.clearDungeon();
    this.view.setDungeonPanel(model.getVisitedLocations(), model.getDungeon(),
            model.getPlayerLocation(), model.getPlayerDescription());
    this.view.setPlayerDescriptionText(model.getPlayerDescription(), false);
    this.view.setRoomDescriptionText(model.currentRoomDescription());
    this.view.refresh();
  }
}
