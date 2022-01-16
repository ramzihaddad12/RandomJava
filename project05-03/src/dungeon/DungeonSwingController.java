package dungeon;

import randomize.Randomness;

import java.awt.event.KeyEvent;

public class DungeonSwingController implements GUIController {
  private IDungeon model;
  private IView view;

  public DungeonSwingController(IView view) {
    this.model = null;
    this.view = view;
    this.view.addKeyBoardListener(this);
    this.view.addClickListener(this);
    this.view.addController(this);
  }

  @Override
  public void instantiateModel(int rows,int columns,int inteconnectivity,
                               int percentage,int numOfMonsters,int input) {
    try {
      this.model = new Dungeon(inteconnectivity, "player",
              input == 0, rows, columns, percentage, numOfMonsters, new Randomness());
      this.view.setDungeonPanel(model.getVisitedLocations(), model.getDungeon(),
              model.getPlayerLocation(), model.getPlayerDescription());
      this.view.setPlayerDescriptionText(model.getPlayerDescription());
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
    this.go();
  }

  private void go() {
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
      view.setPlayerDescriptionText(model.getPlayerDescription());
      view.setRoomDescriptionText(model.currentRoomDescription());
      view.refresh();
    }

    catch (IllegalArgumentException ex) {
      view.showErrorMessage(ex.getMessage());
    }

    checkGameStatus();
  }

  private void checkGameStatus() {
    if (model.isGameOver() && !model.isDidPlayerWin()) {
      view.setPlayerDescriptionText("Game is over. Player got eaten by a monster");
      view.showInformationMessage("Game is over. Player got eaten by a monster");
    }

    else if (model.isGameOver() && model.isDidPlayerWin()) {
      view.setPlayerDescriptionText("Game is over. Player emerges victorious!");
      view.showInformationMessage("Game is over. Player emerges victorious!");
    }
  }

  @Override
  public void handleKey(KeyEvent e) {
    try {
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
        }

        catch (IllegalArgumentException exception) {
          this.view.showErrorMessage(exception.getMessage());
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
            this.view.showInformationMessage("SHOT IS A SUCCESS. MONSTER WAS KILLED"); //TODO: FIX
          }

          else if (result == 0) {
            this.view.showInformationMessage("SHOT IS A SUCCESS. MONSTER WAS HIT");
          }

          else {
            this.view.showInformationMessage("SHOT UNSUCCESSFUL"); //TODO: FIX
          }
        }

        catch (IllegalStateException exception) {
          this.view.showErrorMessage(exception.getMessage());
        }

      }

      else if (e.getKeyCode() == KeyEvent.VK_A) {
        try {
          boolean success = model.pickUpArrows();
          if (success) {
            this.view.showInformationMessage("PICKUP ARROWS IS A SUCCESS"); //TODO: FIX
          }

          else {
            this.view.showInformationMessage("PICKUP ARROWS UNSUCCESSFUL"); //TODO: FIX
          }
        }

        catch (IllegalArgumentException exception) {
          this.view.showErrorMessage(exception.getMessage());
        }
      }

      else if (e.getKeyCode() == KeyEvent.VK_T) {
        try {
          boolean success = model.pickUpTreasure();
          if (success) {
            this.view.showInformationMessage("PICKUP TREASURE IS A SUCCESS"); //TODO: FIX
          }

          else {
            this.view.showInformationMessage("PICKUP TREASURE UNSUCCESSFUL"); //TODO: FIX
          }
        }

        catch (IllegalArgumentException exception) {
          this.view.showErrorMessage(exception.getMessage());
        }
      }

      this.view.setDungeonPanel(model.getVisitedLocations(), model.getDungeon(),
              model.getPlayerLocation(), model.getPlayerDescription());
      view.setPlayerDescriptionText(model.getPlayerDescription());
      view.setRoomDescriptionText(model.currentRoomDescription());
      view.refresh();
      checkGameStatus();
    }

    catch (IllegalArgumentException exception) {
      view.showErrorMessage(exception.getMessage());
    }

  }

  @Override
  public void restartingWithSameModel() {
    this.model.clearVisited();
    this.view.setDungeonPanel(model.getVisitedLocations(), model.getDungeon(),
            model.getPlayerLocation(), model.getPlayerDescription());
    this.view.setPlayerDescriptionText(model.getPlayerDescription());
    this.view.setRoomDescriptionText(model.currentRoomDescription());
    this.view.refresh();
  }
}
