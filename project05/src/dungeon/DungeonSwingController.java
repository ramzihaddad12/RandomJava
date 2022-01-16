package dungeon;

import java.awt.event.KeyEvent;

public class DungeonSwingController implements IDungeonController {
  private IDungeon model;
  private IView view;

  public DungeonSwingController(IDungeon model, IView view) {
    this.model = model;
    this.view = view;
    this.view.addKeyBoardListener(this);
    this.view.addClickListener(this);
  }

  @Override
  public void playGame() {
    this.go();
  }

  private void go() {
    this.view.makeVisible();
  }

  @Override
  public void handleCellClick(int x, int y) {

    try {
      int imgSize = 64;
      int x0 = imgSize * model.getPlayerLocation()[1]; //TODO: THIS IS wrong how to fix???
      int y0 = imgSize * model.getPlayerLocation()[0];

      System.out.println(x0);
      System.out.println(y0);
      x-=32;
      y-=32;
      System.out.println("X CLICKED: " + x);
      System.out.println("Y CLICKED: " + y);

      int diff = 20;

      Direction direction = null;
      if (Math.abs(x - x0) <= diff) {
        System.out.println("SAME X");
        if (y > y0) {
          direction = Direction.SOUTH;
        }

        else if (y < y0) {
          direction = Direction.NORTH;
        }
      }

      else if (Math.abs(y - y0) <= diff) {
        System.out.println("SAME Y");
        if (x > x0) {
          direction = Direction.EAST;
        }

        else if (x < x0) {
          direction = Direction.WEST;
        }
      }
      System.out.println("DIRECTION " + direction.toString());
      model.movePlayer(direction);
      System.out.println("hiiiii");
      view.setAreaText(model.getPlayerDescription());
      view.refresh();
    }

    catch (Exception ex) {
//      view.showErrorMessage(ex.getMessage());

//      if (model.getWinner() != null) {
//        String winner = String.format(". Player %s wins!", model.getWinner().toString());
//        view.showErrorMessage(ex.getMessage() + winner);
//      }

//      else{
        view.setAreaText("Game is over. No winner");
        view.showErrorMessage(ex.getMessage());

//      }
      return;
    }

//    if (model.getWinner() != null) {
//      view.setAreaText(String.format("Game is over! Player %s wins!", model.getWinner().toString()));
//      view.showWinner(model.getWinner());
//      return;
//    }

    if (model.isGameOver()) {
      view.setAreaText("Game is over. No winner");
      view.showErrorMessage("Game is over. No winner");
    }
  }

  @Override
  public void handleKey(int keyPressed) {
    System.out.println(keyPressed);
    try{
      Direction direction = null;
      if(keyPressed == KeyEvent.VK_DOWN || keyPressed == KeyEvent.VK_UP
              || keyPressed ==  KeyEvent.VK_LEFT || keyPressed ==  KeyEvent.VK_RIGHT) {
        System.out.println("CH : " + keyPressed);
        if (keyPressed == KeyEvent.VK_DOWN) {
          direction = Direction.SOUTH;
        }

        else if (keyPressed == KeyEvent.VK_UP) {
          direction = Direction.NORTH;
        }

        else if (keyPressed == KeyEvent.VK_LEFT) {
          direction = Direction.WEST;
        }

        else if (keyPressed == KeyEvent.VK_RIGHT) {
          direction = Direction.EAST;
        }

        System.out.println(direction.toString());
        model.movePlayer(direction);
        view.setAreaText(model.getPlayerDescription());
        view.refresh();
      }

    }

    catch (IllegalArgumentException ex) {
      view.showErrorMessage(ex.getMessage());
    }

  }
}
