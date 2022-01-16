package tictactoe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class BoardPanel extends JPanel {

  private final ReadonlyTttModel model;

  public BoardPanel(ReadonlyTttModel model) {
    this.model = model;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    // draw grid lines
    //g2d.drawLine(???);

    Player[][] board = model.getBoard();
    g2d.setFont(???);
    // iterate over board, draw X and O accordingly
    g2d.drawString("asdf", 5, 6);


  }
}
