import dungeon.DungeonGraphicView;
import dungeon.DungeonSwingController;
import dungeon.GUIController;
import dungeon.IDungeonController;
import dungeon.IView;

public class Main2 {
  /**
   * The method that displays a run of the game.
   * @param args the possible arguments needed.
   */

  public static void main(String[] args) {
    try {
      IView view = new DungeonGraphicView();
      GUIController controller = new DungeonSwingController(view);
      controller.playGame();
    }

    catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }
}
