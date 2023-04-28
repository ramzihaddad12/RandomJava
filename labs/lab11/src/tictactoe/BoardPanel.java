package tictactoe;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class BoardPanel extends JPanel {

  private final ReadonlyTttModel model;

  BoardPanel(ReadonlyTttModel model) {
    this.model = model;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(10));

    g2d.drawLine(0, 100, 300, 100);
    g2d.drawLine(0, 200, 300, 200);

    g2d.drawLine(100, 0, 100, 300);
    g2d.drawLine(200, 0, 200, 300);

    Player[][] board = model.getBoard();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {

        int xPosition = i;
        int yPosition = j;

        if (i == 0) {
          yPosition = 50;
        }

        else if (i == 1) {
          yPosition = 150;
        }

        else if (i == 2) {
          yPosition = 250;
        }

        if (j == 0) {
          xPosition = 50;
        }

        else if (j == 1) {
          xPosition = 150;
        }

        else if (j == 2) {
          xPosition = 250;
        }

        if (model.getMarkAt(i, j) != null) {
          Font valueFont = new Font("Digital-7", Font.BOLD, 40);
          g2d.setFont(valueFont);
          g2d.drawString(board[i][j].toString(), xPosition - 15, yPosition + 15);
        }
      }
    }
  }
}
