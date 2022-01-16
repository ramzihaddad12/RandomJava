package tictactoe;

import java.awt.*;

import javax.swing.*;

class BoardPanel extends JPanel {

  private final ReadonlyTttModel model;

  BoardPanel(ReadonlyTttModel model) {
    this.model = model;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    //draw the lines
    //g2d.drawLine(???);

    Player[][] board = model.getBoard();
    //iterate over board, draw X and O accordingly
//    g2d.drawString();
  }
}
