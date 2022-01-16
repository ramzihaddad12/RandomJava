package tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class TicTacToeSwingView extends JFrame implements TicTacToeView {
  private BoardPanel board;
  public TicTacToeSwingView(ReadonlyTttModel model) {

    //check model for null
    super("Tic-Tac-Toe");

    setSize(500, 300);
    setLocation(200,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //create the panel giving it a model
    board = new BoardPanel(model);
    //add panel to this JFrame
    add(board);
  }
  @Override
  public void addClickListener(TicTacToeController listener) {
    //create mouseadapter--use anonymous class
    MouseAdapter clickHandler = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        //arithmetic: convert MouseEvenet coordinates into grid coordinates

      }
    };

    board.addMouseListerner(clickHandler);
  }

  @Override
  public void refresh() {
    repaint();
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }
}
