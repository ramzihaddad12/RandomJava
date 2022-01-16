package tictactoe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * A Swing view implementation of the view extending JFrame.
 */

public class TicTacToeSwingView extends JFrame implements TicTacToeView {
  private BoardPanel board;
  private JTextArea area;

  /**
   * A constructor foe the TicTacToeSwingView which takes in a ReadonlyTttModel model.
   * @param model the ReadonlyTttModel needed by the view.
   */
  public TicTacToeSwingView(ReadonlyTttModel model) {
    super("Tic-Tac-Toe");

    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }

    area = new JTextArea(String.format("Its player %s's turn now!", model.getTurn()));
    area.setEditable(false);
    Font valueFont = new Font("Digital-7", Font.BOLD, 20);
    area.setFont(valueFont);
    add(area, BorderLayout.SOUTH);
    setSize(600, 600);
    setLocation(200,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.board = new BoardPanel(model);
    add(board);

    setResizable(false);
    this.setMinimumSize(new Dimension(320, 360));
    this.pack();
  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    MouseAdapter clickHandler = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        int x = e.getX();
        int y = e.getY();

        Integer row = null;
        Integer column = null;

        if (x <= 100) {
          column = 0;
        }

        else if (x > 100 && x <= 200) {
          column = 1;
        }

        else if (x > 200) {
          column = 2;
        }

        if (y <= 100) {
          row = 0;
        }

        else if (y > 100 && y <= 200) {
          row = 1;
        }

        else if (y > 200) {
          row = 2;
        }

        listener.handleCellClick(row, column);
      }
    };

    this.board.addMouseListener(clickHandler);
    this.refresh();
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }

  @Override
  public void setAreaText(String text) {
    this.area.setText(text);
  }

  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this,error,"Error",JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void showWinner(String winner) {
    JOptionPane.showMessageDialog(this , String.format("Player %s wins", winner),"Winner",
            JOptionPane.INFORMATION_MESSAGE);
  }
}
