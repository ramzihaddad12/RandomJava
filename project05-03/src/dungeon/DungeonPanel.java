package dungeon;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class DungeonPanel extends JPanel {
  boolean[][] visited;
  IRoom[][] board;
  int[] playerLocation;
  String playerDescription;

  DungeonPanel(int rows, int columns) {
    this.setLayout(new GridLayout(rows, columns));
    this.setPreferredSize(new Dimension( 600,600));
  }

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

  private BufferedImage overlay(BufferedImage starting, String fpath,
                                int offset) throws IOException {
    BufferedImage overlay = ImageIO.read(new File(fpath));
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

  void setNeededParameters(boolean[][] visited, IRoom[][] board, int[] playerLocation,
                                  String playerDescription) {
    this.visited = visited;
    this.board = board;
    this.playerLocation = playerLocation;
    this.playerDescription = playerDescription;
  }

  private void setDungeonDisplay(Graphics2D g2d) {
    int offset = 50;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        BufferedImage player = null;
        if (visited[i][j]) {
          BufferedImage starting = null;
          try {
            String path = "img/" + getDirections(board[i][j].getDescription()) + ".png";
            starting = ImageIO.read(new File(path));
            path = "img/player.png";
            if (Arrays.equals(playerLocation, new int[] {i, j})) {
              starting = overlay(starting, path, 2);

              if (playerDescription.contains("VERY_PUNGENT")) {
                starting = overlay(starting, "img/stench02.png", 2);
              }

              else if (playerDescription.contains("PUNGENT")) {
                starting = overlay(starting, "img/stench01.png", 2);
              }
            }

            if (board[i][j].hasAMonster()) {
              starting = overlay(starting, "img/otyugh.png", 2);
            }

            if (board[i][j].roomHasArrow()) {
              starting = overlay(starting, "img/arrow-white.png", 2);
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
