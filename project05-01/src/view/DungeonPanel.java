package view;

import model.IRoom;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * The dungeon panel that displays the visited rooms, extending JPanel.
 */

class DungeonPanel extends JPanel {
  boolean[][] visited;
  IRoom[][] board;
  int[] playerLocation;
  String playerDescription;

  /**
   * A constructor for the DungeonPanel.
   */

  DungeonPanel() {
    this.setPreferredSize(new Dimension( 600,600));
  }

  /**
   * Gets the directions present in a room in a string format.
   * @param roomDescription the description of the room.
   * @return a string representing the directions present in the room.
   */
  private String getDirections(String roomDescription) {
    StringBuilder builder = new StringBuilder();
    if (roomDescription.contains("^")) {
      builder.append("N");
    }

    if (roomDescription.contains("v")) {
      builder.append("S");
    }

    if (roomDescription.contains("->")) {
      builder.append("E");
    }

    if (roomDescription.contains("<-")) {
      builder.append("W");
    }

    return builder.toString();

  }

  /**
   * Overlays two images together.
   * @param starting the starting image.
   * @param fpath the path of the second image.
   * @param offset the offset between the two images.
   * @return A combines image of the two
   * @throws IOException if second image was not found.
   */
  private BufferedImage overlay(BufferedImage starting, String fpath,
                                int offset) throws IOException {
    BufferedImage overlay = ImageIO.read(ClassLoader.getSystemResource(fpath));
    int w = Math.max(starting.getWidth(), overlay.getWidth());
    int h = Math.max(starting.getHeight(), overlay.getHeight());

    BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics g = combined.getGraphics();
    g.drawImage(starting, 0, 0, null);
    g.drawImage(overlay, offset, offset, null);

    return combined;

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(10));
    setDungeonDisplay(g2d);
  }

  /**
   * Sets the needed parameters to draw the dungeon.
   * @param visited the visited locations by the player.
   * @param board the dungeon.
   * @param playerLocation the location of the player.
   * @param playerDescription the description of the player.
   */
  void setNeededParameters(boolean[][] visited, IRoom[][] board, int[] playerLocation,
                                  String playerDescription) {
    this.visited = visited;
    this.board = board;
    this.playerLocation = playerLocation;
    this.playerDescription = playerDescription;
  }

  /**
   * Draws the dungeon rooms to the panel.
   * @param g2d the Graphics2d object that is drawn on.
   */

  private void setDungeonDisplay(Graphics2D g2d) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (visited[i][j]) {
          BufferedImage starting = null;
          try {

            if (board[i][j].hasPit()) {
              starting = ImageIO.read(ClassLoader.getSystemResource("img/"
                      + "pit.png"));
            }

            else {
              starting = ImageIO.read(ClassLoader.getSystemResource("img/"
                      + getDirections(board[i][j].getDescription()) + ".png"));
            }

            String path = "img/player.png";
            if (Arrays.equals(playerLocation, new int[] {i, j})) {
              starting = overlay(starting, path, 2);

              if (playerDescription.contains("VERY_PUNGENT")) {
                starting = overlay(starting, "img/stench02.png", 2);
              }

              else if (playerDescription.contains("PUNGENT")) {
                starting = overlay(starting, "img/stench01.png", 2);
              }

              if (playerDescription.contains("falling: true")) {
                starting = overlay(starting, "img/danger.png", 40);
              }
            }

            if (board[i][j].hasThief()) {
              starting = overlay(starting, "img/thief.png", 18);

            }

            if (board[i][j].hasAMonster()) {
              starting = overlay(starting, "img/otyugh.png", 2);
            }

            if (board[i][j].roomHasArrow()) {
              starting = overlay(starting, "img/arrow-white.png", 15);
            }

            if (board[i][j].roomHasTreasure()) {
              String description = board[i][j].getDescription();
              if (description.contains("1 diamonds")) {
                starting = overlay(starting, "img/diamond.png", 2);
              }

              else if (description.contains("1 sapphires")) {
                starting = overlay(starting, "img/sapphire.png", 2);
              }

              else if (description.contains("1 rubies")) {
                starting = overlay(starting, "img/ruby.png", 2);
              }
            }

            g2d.drawImage(starting,  j * 64,i * 64, null);
          }

          catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
