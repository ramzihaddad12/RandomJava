import dungeon.Dungeon;
import randomize.Randomness;

public class Main3 {
  public static void main(String[] args) {
    Dungeon dungeon = new Dungeon(2, "player",
            true, 6, 8, 20, 2, new Randomness());
  }
}
