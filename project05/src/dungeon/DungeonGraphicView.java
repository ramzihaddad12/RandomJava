package dungeon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This is an implementation of the IView interface
 * that uses Java Swing to draw the results of the
 * turtle. It shows any error messages using a
 * pop-up dialog box, and shows the turtle position
 * and heading
 */
public class DungeonGraphicView extends JFrame implements IView {
  private JButton commandButton,quitButton;
//  private JPanel buttonPanel;
  private DungeonPanel dungeonPanel;
//  private JTextField input;
//  private JLabel display;
  private JTextArea area;

  public DungeonGraphicView(IDungeon model) {
    super();
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
//    InputBox frame = new InputBox();
//    String m = JOptionPane.showInputDialog(frame, "Anyone there?", 42);


//    JPanel container = new JPanel();
//    container.setPreferredSize(new Dimension(400,300));
//    JScrollPane scrollPane = new JScrollPane(container);
//    add(scrollPane);

//    JFrame f = new JFrame("Menu demo");

    // create a menubar




    this.setTitle("Dungeon!");
//    this.setSize(100,100);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(new BorderLayout());
    dungeonPanel = new DungeonPanel(model);
//    dungeonPanel.setPreferredSize(new Dimension(500,500));
//    dungeonPanel.setPreferredSize(new Dimension(300,300));
////////////////////
//    dungeonPanel.setLayout(new BoxLayout(dungeonPanel, BoxLayout.Y_AXIS));
//
//    JScrollPane scroller = new JScrollPane();
//    scroller.setPreferredSize(new Dimension(200, 200));

//    for (Integer i = 0; i < 20; i++) {
//      FixtureComponent fixture = new FixtureComponent();
//      dungeonPanel.add(fixture);
//    }

    this.setLayout(new BorderLayout());
//    this.add(scroller);
//    this.setSize(300, 300);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//    this.setVisible(true);
//
//
//    JScrollBar hbar=new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 500);
//    JScrollBar vbar=new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
//    this.getContentPane().add(hbar, BorderLayout.SOUTH);
//    this.getContentPane().add(vbar, BorderLayout.EAST);
//    setPreferredSize(new Dimension(600, 600));
    setPreferredSize(new Dimension(500, 500));

    ///////////////////////
    System.out.println("WIDTH: " + dungeonPanel.getWidth());

    System.out.println("height: " + dungeonPanel.getHeight());
    JScrollPane scrollPane = new JScrollPane(dungeonPanel);
//    JScrollPane scrollFrame = new JScrollPane();
//    dungeonPanel.setAutoscrolls(true);
//    scrollPane.setPreferredSize(new Dimension( 500,500));
    scrollPane.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//    scrollPane.setViewportView (dungeonPanel);
//    this.add(dungeonPanel, BorderLayout.CENTER);
    this.add(scrollPane);


//    this.add(scrollPane, BorderLayout.CENTER);
//
    area = new JTextArea(model.getPlayerDescription());
    this.add(area, BorderLayout.SOUTH);
////    setSize(600, 600);
////    setLocation(200,200);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JMenuBar mb = new JMenuBar();
    JButton btnClose = new JButton("Quit");
    btnClose.addActionListener(e -> System.exit(0));
    // create a menu
    JMenu x = new JMenu("Menu");

    // create menuitems
    JMenuItem m1 = new JMenuItem("MenuItem1");
    JMenuItem m2 = new JMenuItem("MenuItem2");
    JMenuItem m3 = new JMenuItem("MenuItem3");

    // add menu items to menu
    x.add(m1);
    x.add(m2);
    x.add(m3);

    // add menu to menu bar
    mb.add(x);
    mb.add(btnClose);

    JMenu restarting = new JMenu("Restart");

    // create menuitems
    JButton restartWithNewGame = new JButton("Restart With New Game");
    JButton restartWithThisGame = new JButton("Restart With This Game");
    //TODO: add action to these buttons
    restarting.add(restartWithNewGame);
    restarting.add(restartWithThisGame);

    mb.add(restarting);
//
//    // add menubar to frame
////    f.setJMenuBar(mb);
//
//    // set the size of the frame
////    f.setSize(500, 500);
////    f.setVisible(true);
    this.add(mb, BorderLayout.PAGE_START);
    //quit button
//    quitButton = new JButton("Quit");
//    dungeonPanel.add(quitButton);
//    quitButton.addActionListener((ActionEvent e) -> System.exit(0));

//    requestFocus();
//      setFocusable(true);

//    this.setMinimumSize(new Dimension(200, 200));
//    this.setFocusable(true);
//    this.requestFocus();
//    this.pack();
//    requestFocusInWindow();
//
    this.setFocusable(true);
    this.requestFocus();
    this.pack();

  }



  @Override
  public void makeVisible() {
    this.setVisible(true);

  }

  @Override
  public void setCommandButtonListener(ActionListener actionEvent) {
    commandButton.addActionListener(actionEvent);
  }

  @Override
  public void setAreaText(String text) {
    this.area.setText(text);
  }

  @Override
  public void addKeyBoardListener(IDungeonController listener) {
    KeyAdapter keyListener = new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyChar());
        System.out.println("here");
//        super.keyPressed(e);
        System.out.println("HEHEUEHEHEUHE");
        System.out.println(e.getKeyChar());
//        e.getKeyCode() == KeyEvent.VK_DOWN
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP
                || e.getKeyCode() ==  KeyEvent.VK_LEFT || e.getKeyCode() ==  KeyEvent.VK_RIGHT) {
          System.out.println("CHARCTER PRESSED : " + e.getKeyChar());
          listener.handleKey(e.getKeyCode());
        }

//        else if ()
      }
    };
    System.out.println("ADDING KEY LISYENER");
    System.out.println(this.requestFocusInWindow());
    this.addKeyListener(keyListener);
    this.refresh();
  }
  @Override
  public void addClickListener(IDungeonController listener) {

    MouseAdapter clickHandler = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

//        double epsilon = 0.01;
        int x = e.getX();
        int y = e.getY();

        System.out.println("X = " + x);
        System.out.println("Y = " + y);
//        int row = -1;
//        int column = -1;
//
//        if (x <= 100) {
//          column = 0;
//        }
//
//        else if (x > 100 && x <= 200) {
//          column = 1;
//        }
//
//        else if (x > 200) { //TODO: && x <= 300
//          column = 2;
//        }
//
//        if (y <= 100) {
//          row = 0;
//        }
//
//        else if (y > 100 && y <= 200) {
//          row = 1;
//        }
//
//        else if (y > 200) { //TODO :  && y <= 300
//          row = 2;
//        }
//        System.out.println("ROW = " + row);
//        System.out.println("COLUMN = " + column);
        listener.handleCellClick(x, y);

        //arithmetic: convert MouseEvent coordinates into grid coordinates

      }
    };
    this.dungeonPanel.addMouseListener(clickHandler);
    this.refresh();
  }
//
//  @Override
//  public void setCommandButtonListener(ActionListener actionEvent) {
//
//  }
//
//  @Override
//  public String getTurtleCommand() {
//    return null;
//  }
//
//  @Override
//  public void setTurtleHeading(double headingDegrees) {
//
//  }
//
//  @Override
//  public void showErrorMessage(String error) {
//
//  }

  @Override
  public void refresh() {
    System.out.println("WIDTH: " + dungeonPanel.getWidth());

    System.out.println("height: " + dungeonPanel.getHeight());
    this.repaint();
  }

  @Override
  public void showErrorMessage(String error) {
    System.out.println("Error: " + error);
    JOptionPane.showMessageDialog(this,error,"Error",JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void showWinner(String winner) {
    JOptionPane.showMessageDialog(this , String.format("Player %s wins", winner),"Winner",
            JOptionPane.INFORMATION_MESSAGE);
  }
}
