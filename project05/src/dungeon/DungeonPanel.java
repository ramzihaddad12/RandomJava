package dungeon;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import dungeon.Direction;
import dungeon.IDungeon;

class DungeonPanel extends JPanel {

  private final IDungeon model; //TODO: ReadonlyTttModel
  private final boolean[][] visited;

  DungeonPanel(IDungeon model) {
    this.model = model;
    this.visited = new boolean[model.getRows()][model.getColumns()];
    this.setPreferredSize(new Dimension( 600,600));

//    this.setSize(new Dimension(300, 300));

//    JScrollPane scrollFrame = new JScrollPane();
//    scrollFrame.setViewportView (this);
//    scrollFrame.setPreferredSize(new Dimension( 100,100));
//    this.add(scrollFrame);

//    this.setLayout(new GridLayout(10, 4, 10, 10));
//    JScrollPane scrollPane = new JScrollPane(this);
//    scrollPane.setViewportView (this);


    //    setFocusable(true);
//    requestFocusInWindow();
//    this.setFocusable(true);
//    this.requestFocus();
//    setFocusable(true);
//    requestFocus();

  }
  /*
   * A class that extends JPanel and overrides paintComponent
   * that draws the game board and game status.
   *  Status includes indicating whose turn it is,
   *  and if the game is over, who won (or if it was a tie).*/

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
  private BufferedImage overlay(BufferedImage starting, String fpath, int offset) throws IOException {
    BufferedImage overlay = ImageIO.read(new File(fpath));
    int w = Math.max(starting.getWidth(), overlay.getWidth());
    int h = Math.max(starting.getHeight(), overlay.getHeight());

    BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics g = combined.getGraphics();
    g.drawImage(starting, 0, 0, null);
    g.drawImage(overlay, offset, offset, null);

//    g.drawImage(overlay, 0, 0, null);
    return combined;

  }
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(10));

    //draw the lines

//    g2d.translate(0, );
//    System.out.println(this.getPreferredSize().getHeight());
//    g2d.drawLine(0, 100, 300, 100);
//    g2d.drawLine(0, 200, 300, 200);
//
//    g2d.drawLine(100, 0, 100, 300);
//    g2d.drawLine(200, 0, 200, 300);


    //iterate over board, draw X and O accordingly

    boolean[][] visited = model.getVisitedLocations();
    int offset = 50;


    for (int i = 0; i < model.getRows(); i++) {
      for (int j = 0; j < model.getColumns(); j++) {
        BufferedImage player = null;
        try {
          player = ImageIO.read(new File("img/player.png"));
//          System.out.println("PLA)YER" + player.getWidth());
//          System.out.println("PLA)YER" + player.getHeight());

//          g2d.drawImage(player,  model.getPlayerLocation()[1] * (player.getWidth() - 8) - 5,model.getPlayerLocation()[0] * (player.getHeight() - 8) - 5, null);
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (visited[i][j]) {
          BufferedImage starting = null;
          try {
            String string = getDirections(model.getRoomDescription(i, j));
            String path = "img/" + string + ".png";
            starting = ImageIO.read(new File(path));
//            g2d.drawImage(starting,  j * starting.getWidth(),i * starting.getHeight(), null);

            path = "img/player.png";
            if (Arrays.equals(model.getPlayerLocation(), new int[] {i, j})) {
              starting = overlay(starting, path, 2);
//              g2d.drawImage(starting,  j * starting.getWidth(),i * starting.getHeight(), null);

              if (model.getPlayerDescription().contains("VERY_PUNGENT")) {
                System.out.println("Getting very PUNGENTTTTTTTTTTTTTTTTT");
                starting = overlay(starting, "img/stench02.png", 2);
//                g2d.drawImage(starting,  j * starting.getWidth(),i * starting.getHeight(), null);
//
//                BufferedImage smell = ImageIO.read(new File("img/stench02.png"));
//                g2d.drawImage(smell,  j * starting.getWidth(),i * starting.getHeight(), null);
              }

              else if (model.getPlayerDescription().contains("PUNGENT")) {
                starting = overlay(starting, "img/stench01.png", 2);
//                g2d.drawImage(starting,  j * starting.getWidth(),i * starting.getHeight(), null);
//
//                BufferedImage smell = ImageIO.read(new File("img/stench02.png"));
//                g2d.drawImage(smell,  j * starting.getWidth(),i * starting.getHeight(), null);
              }
            }
            //            System.out.println(path);
//            starting = ImageIO.read(new File(path));
//            System.out.println("WIDTH: " + starting.getWidth());
//            System.out.println("HEIGHT: " + starting.getHeight());
//            System.out.println(Arrays.toString(model.getStart()));
//            g2d.drawImage(starting,  j * starting.getWidth(),i * starting.getHeight(), null);
//            BufferedImage monster = ImageIO.read(new File("img/otyugh.png"));

            if (model.roomHasMonster(i, j)) {
              starting = overlay(starting, "img/otyugh.png", 2);
//              g2d.drawImage(starting,  j * starting.getWidth(),i * starting.getHeight(), null);
//              g2d.drawImage(monster,  j * starting.getWidth(),i * starting.getHeight(), null);
            }

            if (model.roomHasArrow(i, j)) {
              starting = overlay(starting, "img/arrow-black.png", 2);
//              g2d.drawImage(starting,  j * starting.getWidth(),i * starting.getHeight(), null);

//              BufferedImage arrow = ImageIO.read(new File("img/arrow-black.png"));
//              System.out.println("ARROW: " + arrow.getWidth());
//              System.out.println("ARROW: " + arrow.getHeight());
//              g2d.drawImage(arrow,  j * starting.getWidth(),i * starting.getHeight() + 32, null);
            }

            if (model.roomHasTreasure(i, j)) {
              String description = model.getRoomDescription(i, j);
              if (description.contains("1 diamonds")) {
                starting = overlay(starting, "img/diamond.png", 2);
//                g2d.drawImage(starting,  j * starting.getWidth(),i * starting.getHeight(), null);

//                BufferedImage diamond = ImageIO.read(new File("img/diamond.png"));
//                g2d.drawImage(diamond,  j * starting.getWidth(),i * starting.getHeight(), null);
              }

              else if (description.contains("1 sapphires")) {
                starting = overlay(starting, "img/sapphire.png", 2);
//                g2d.drawImage(starting,  j * starting.getWidth(),i * starting.getHeight(), null);
//                BufferedImage sapphire = ImageIO.read(new File("img/sapphire.png"));
//                g2d.drawImage(sapphire,  j * starting.getWidth(),i * starting.getHeight(), null);
              }

              else if (description.contains("1 rubies")) {
                starting = overlay(starting, "img/ruby.png", 2);
//                g2d.drawImage(starting,  j * starting.getWidth(),i * starting.getHeight(), null);

//                BufferedImage ruby = ImageIO.read(new File("img/ruby.png"));
//                g2d.drawImage(ruby,  j * starting.getWidth(),i * starting.getHeight(), null);
              }




            }
//            g2d.drawImage(starting,  j * starting.getWidth(),i * starting.getHeight(), null);
            g2d.drawImage(starting,  j * 64,i * 64, null);

            System.out.println(starting);
          } catch (IOException e) {
            e.printStackTrace();
          }
          //SMell



//          try {
//            starting = overlay(starting, "/img/" + getDirections(model.getRoomsDescription()),offset);
//          } catch (IOException e) {
//            e.printStackTrace();
//          }
        }
      }
    }

  }
}
