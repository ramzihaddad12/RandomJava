package dungeon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.*;
import javax.swing.text.BadLocationException;

/**
 * This is an implementation of the IView interface
 * that uses Java Swing to draw the results of the
 * turtle. It shows any error messages using a
 * pop-up dialog box, and shows the turtle position
 * and heading
 */

public class DungeonGraphicView extends JFrame implements IView {
  private JButton commandButton;
  private JButton quitButton;
  private DungeonPanel dungeonPanel;
//  private JTextArea playerDescription;
//  private JTextArea roomDescription;
  private JTextPane playerDescription;
  private JTextPane roomDescription;
  private GUIController controller;
  private JMenuItem m1;
  private JMenuItem m2;
  private JMenuItem m3;
  private JMenuItem m4;
  private JMenuItem m5;
  private JMenuItem m6;

  private JTextPane chest;
  private int rows;
  private int columns;

  public DungeonGraphicView() {
    super();
    this.setTitle("Dungeon!");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    dungeonPanel = new DungeonPanel(1, 1);

    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(500, 500));
    JScrollPane scrollPane = new JScrollPane(dungeonPanel);
    scrollPane.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    this.add(scrollPane);

    JPanel area = new JPanel();
    area.setPreferredSize(new Dimension(100, 100));
    Font valueFont = new Font("Digital-7", Font.BOLD, 15);
    area.setFont(valueFont);
//    playerDescription = new JTextArea();
    playerDescription = new JTextPane();
    playerDescription.setFont(valueFont);
//    this.add(playerDescription, BorderLayout.SOUTH);
    playerDescription.setEditable(false);
//    playerDescription.setSize();
//    roomDescription = new JTextArea();
    roomDescription = new JTextPane();
    roomDescription.setFont(valueFont);

//    this.add(roomDescription, BorderLayout.AFTER_LAST_LINE);
    roomDescription.setEditable(false);

    chest = new JTextPane();
//    chest.setText("");
    try {
      chest.getDocument().insertString(chest.getDocument().getLength(), "3", null);
      chest.getDocument().insertString(chest.getDocument().getLength(), "  ", null);
      this.chest.insertIcon(new ImageIcon("img/arrow-black.png"));

      chest.getDocument().insertString(chest.getDocument().getLength(), "0", null);
      this.chest.insertIcon(new ImageIcon( "img/ruby.png"));

      chest.getDocument().insertString(chest.getDocument().getLength(), "0", null);
      this.chest.insertIcon(new ImageIcon("img/diamond.png"));


      chest.getDocument().insertString(0, "0", null);
      this.chest.insertIcon(new ImageIcon("img/sapphire.png"));

    }
    catch (BadLocationException e) {
      e.printStackTrace();
    }
//    this.add(chest);
    chest.setEditable(false);
//    area.add(chest, BorderLayout.PAGE_START);
    area.add(playerDescription, BorderLayout.NORTH);
    area.add(roomDescription, BorderLayout.SOUTH);
    area.isVisible();
    this.add(area, BorderLayout.SOUTH);
    JButton btnClose = new JButton("Quit");
    btnClose.addActionListener(e -> System.exit(0));


    m1 = new JMenuItem("Number of rows: ");
    m2 = new JMenuItem("Number of columns: ");
    m3 = new JMenuItem("Interconnectivity: ");
    m4 = new JMenuItem("Wrapping: ");
    m5 = new JMenuItem("Percentage of caves with treasure: ");
    m6 = new JMenuItem("Number of monsters: ");
    JMenu x = new JMenu("Game settings");
    x.add(m1);
    x.add(m2);
    x.add(m3);
    x.add(m4);
    x.add(m5);
    x.add(m6);
    JMenuBar mb = new JMenuBar();
    mb.add(x);
    mb.add(btnClose);

//    JMenu restarting = new JMenu("New Game");

    JButton restartWithNewGame = new JButton("Restart With New Game");
    JButton restartWithThisGame = new JButton("Restart With This Game");
    restartWithNewGame.addActionListener(e -> {
      this.controller.playGame();
      this.requestFocus();
    });
    restartWithThisGame.addActionListener(e -> {
      this.controller.restartingWithSameModel();
      this.requestFocus();
    });
//
//    restarting.add(restartWithNewGame);
//    restarting.add(restartWithThisGame);

    mb.add(restartWithNewGame);
    mb.add(restartWithThisGame);
    mb.add(chest);
    mb.setSize(new Dimension(400, 100));
    this.add(mb, BorderLayout.PAGE_START);

    this.setFocusable(true);
    this.requestFocus();
    this.pack();
  }

  @Override
  public int getDistance() {
    InputBox frame = new InputBox();

    int distance = getInput(frame, "What is the distance of the shot desired?");
    return distance;
  }

  @Override
  public void initializeView() {
    InputBox frame = new InputBox();

    int rows = getInput(frame, "What is the number of rows desired for your dungeon? ");
    int columns = getInput(frame, "What is the number of columns desired for your dungeon? ");
    int interconnectivity = getInput(frame,
            "What is the interconnectivity desired for your dungeon? ");
    int percentage = getInput(frame,
            "What is the the percentage of caves with treasure desired for your dungeon? ");
    int numOfMonsters = getInput(frame,
            "What is the the number of monsters desired for your dungeon? ");
    int input = JOptionPane.showConfirmDialog(null,
            "Wrapping of the dungeon?", "Select an Option...",JOptionPane.YES_NO_OPTION);
    this.controller.instantiateModel(rows, columns, interconnectivity,
            percentage, numOfMonsters, input);
    m1.setText("Number of rows: " + rows);
    m2.setText("Number of columns: " + columns);
    m3.setText("Interconnectivity: " + interconnectivity);
    m4.setText("Wrapping: " + (input == 0));
    m5.setText("Percentage of caves with treasure: " + percentage);
    m6.setText("Number of monsters: " + numOfMonsters);

    this.rows = rows;
    this.columns = columns;
    this.dungeonPanel = new DungeonPanel(rows, columns);
  }

  @Override
  public void addController(GUIController controller) {
    this.controller = controller;
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void setPlayerDescriptionText(String text) {
    this.playerDescription.setText(text);
    try {
      chest.setText("");
      String s = text.substring(0, text.indexOf("sapphires"));
      chest.getDocument().insertString(0, String.valueOf(s.charAt(s.length() - 2)), null);
      this.chest.insertIcon(new ImageIcon("img/sapphire.png"));

      s = text.substring(text.indexOf("sapphires"), text.indexOf("diamonds"));
      chest.getDocument().insertString(chest.getDocument().getLength(), String.valueOf(s.charAt(s.length() - 2)), null);
      this.chest.insertIcon(new ImageIcon("img/diamond.png"));

      s = text.substring(text.indexOf("diamonds"), text.indexOf("rubies"));
      chest.getDocument().insertString(chest.getDocument().getLength(), String.valueOf(s.charAt(s.length() - 2)), null);
      this.chest.insertIcon(new ImageIcon("img/ruby.png"));

      s = text.substring(text.indexOf("rubies"), text.indexOf("arrows"));
      chest.getDocument().insertString(chest.getDocument().getLength(), String.valueOf(s.charAt(s.length() - 2)), null);
      chest.getDocument().insertString(chest.getDocument().getLength(), "  ", null);

      this.chest.insertIcon(new ImageIcon("img/arrow-black.png"));
      this.requestFocus();
    }
    catch (BadLocationException e) {
      e.printStackTrace();
    }

//    try {
//      playerDescription.selectAll();
//      playerDescription.replaceSelection("");
//      String s = text.substring(0, text.indexOf("sapphires"));
//      System.out.println(s);
//      playerDescription.getDocument().insertString(0, s, null);
////      this.playerDescription.insertIcon ( new ImageIcon ( "img/sapphire.png" ));
//
//      String s1 = text.substring(text.indexOf("sapphires"), text.indexOf("diamonds"));
//      playerDescription.getDocument().insertString(s.length(), s1, null);
////      this.playerDescription.insertIcon ( new ImageIcon ( "img/diamond.png" ));
//      System.out.println(s1);
//
//      String s2 = text.substring(text.indexOf("diamonds"), text.indexOf("rubies"));
//      playerDescription.getDocument().insertString(s.length() + s1.length(), s2, null);
//      System.out.println(s2);
////      this.playerDescription.insertIcon ( new ImageIcon ( "img/ruby.png" ));
//    }
//
//    catch (BadLocationException e) {
//      e.printStackTrace();
//    }

  }

  @Override
  public void setRoomDescriptionText(String text) {
    this.roomDescription.setText(text);
  }

  @Override
  public void addKeyBoardListener(GUIController listener) {
    KeyAdapter keyListener = new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
          listener.handleKey(e);
      }
    };
    this.requestFocusInWindow();
    this.addKeyListener(keyListener);
    this.refresh();
  }

  @Override
  public void addClickListener(GUIController listener) {
    MouseAdapter clickHandler = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        listener.handleCellClick(e.getX(), e.getY());
      }
    };
    this.dungeonPanel.addMouseListener(clickHandler);
    this.refresh();
  }

  @Override
  public void setDungeonPanel(boolean[][] visited, IRoom[][] board, int[] playerLocation,
                              String playerDescription) {
    this.dungeonPanel.setNeededParameters(visited, board, playerLocation, playerDescription);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this,error,"Error",JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void showInformationMessage(String error) {
    JOptionPane.showMessageDialog(this,error,"Information",JOptionPane.INFORMATION_MESSAGE);
  }

  private int getInput(InputBox frame, String displayMessage) {
    boolean gotValidRows = false;
    Integer rows = null;
    while (!gotValidRows) {
      String string = JOptionPane.showInputDialog(frame, displayMessage, 0);
      if (string == null) {
        System.exit(0);
      }
      try {
        rows = Integer.parseInt(string);
        gotValidRows = true;
      }
      catch (NumberFormatException e) {
        showErrorMessage("Please enter an integer");
        gotValidRows = false;
      }
    }
    return rows;
  }
}
