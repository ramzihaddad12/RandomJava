package view;

import controller.GuiController;
import model.IRoom;
import randomize.Randomness;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.text.BadLocationException;

/**
 * This is an implementation of the IView interface
 * that uses Java Swing to display the dungeon and information surrounding
 * the game.
 */

public class DungeonGraphicView extends JFrame implements IView {
  private DungeonPanel dungeonPanel;
  private JTextPane playerDescription;
  private JTextPane roomDescription;
  private JTextPane status;
  private GuiController controller;
  private JMenuItem item1;
  private JMenuItem item2;
  private JMenuItem item3;
  private JMenuItem item4;
  private JMenuItem item5;
  private JMenuItem item6;
  private JMenuItem item7;
  private JTextPane chest;
  private InputBox frame;

  /**
   * A constructor for the DungeonGraphicView that sets up the dungeon
   * display.
   */

  public DungeonGraphicView() {
    super();
    this.setTitle("Dungeon!");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    dungeonPanel = new DungeonPanel();

    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(700, 500));
    JScrollPane scrollPane = new JScrollPane(dungeonPanel);
    this.add(scrollPane);

    JPanel area = new JPanel();
    area.setLayout(new GridLayout(3, 1));
    Font valueFont = new Font("Digital-7", Font.BOLD, 15);
    area.setFont(valueFont);
    area.setSize(new Dimension(100,100));
    playerDescription = new JTextPane();
    playerDescription.setFont(valueFont);
    playerDescription.setEditable(false);
    roomDescription = new JTextPane();
    roomDescription.setFont(valueFont);
    status = new JTextPane();
    status.setFont(valueFont);
    status.setEditable(false);
    roomDescription.setEditable(false);

    chest = new JTextPane();
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
    chest.setEditable(false);
    area.add(playerDescription);

    area.add(roomDescription);
    area.add(status);
    area.isVisible();
    this.add(area, BorderLayout.SOUTH);
    JButton quitButton = new JButton("Quit");
    quitButton.addActionListener(e -> System.exit(0));


    item1 = new JMenuItem("Number of rows: ");
    item2 = new JMenuItem("Number of columns: ");
    item3 = new JMenuItem("Interconnectivity: ");
    item4 = new JMenuItem("Wrapping: ");
    item5 = new JMenuItem("Percentage of caves with treasure: ");
    item6 = new JMenuItem("Number of monsters: ");
    item7 = new JMenuItem("Number of pits: ");
    JMenu menu = new JMenu("Game settings");
    menu.add(item1);
    menu.add(item2);
    menu.add(item3);
    menu.add(item4);
    menu.add(item5);
    menu.add(item6);
    menu.add(item7);

    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
    menuBar.add(quitButton);

    JButton restartWithNewGame = new JButton("New Game");
    JButton restartWithThisGame = new JButton("Restart This Game");
    restartWithNewGame.addActionListener(e -> {
      this.controller.playGame();
      this.requestFocus();
    });
    restartWithThisGame.addActionListener(e -> {
      this.controller.restartingWithSameModel();
      this.requestFocus();
    });

    menuBar.add(restartWithNewGame);
    menuBar.add(restartWithThisGame);
    menuBar.add(chest);
    menuBar.setSize(new Dimension(400, 100));
    this.add(menuBar, BorderLayout.PAGE_START);
    this.setFocusable(true);
    this.requestFocus();
    this.pack();
  }

  @Override
  public int getDistance() {
    frame = new InputBox();
    int distance = getInput(frame, "What is the distance of the shot desired?");
    return distance;
  }

  @Override
  public void initializeView() {
    frame = new InputBox();

    int rows = getInput(frame, "What is the number of rows desired for your dungeon? ");
    int columns = getInput(frame, "What is the number of columns desired for your dungeon? ");
    int interconnectivity = getInput(frame,
            "What is the interconnectivity desired for your dungeon? ");
    int percentage = getInput(frame,
            "What is the the percentage of caves with treasure desired for your dungeon? ");
    int numOfMonsters = getInput(frame,
            "What is the the number of monsters desired for your dungeon? ");
    int numOfPits = getInput(frame,
            "What is the the number of pits desired for your dungeon? ");
    int wrapping = JOptionPane.showConfirmDialog(null,
            "Wrapping of the dungeon?", "Select an Option...",JOptionPane.YES_NO_OPTION);
    this.controller.instantiateModel(rows, columns, interconnectivity,
            percentage, numOfMonsters, wrapping, numOfPits, new Randomness());
    item1.setText("Number of rows: " + rows);
    item2.setText("Number of columns: " + columns);
    item3.setText("Interconnectivity: " + interconnectivity);
    item4.setText("Wrapping: " + (wrapping == 0));
    item5.setText("Percentage of caves with treasure: " + percentage);
    item6.setText("Number of monsters: " + numOfMonsters);
    item7.setText("Number of pits: " + numOfPits);
  }

  @Override
  public void addController(GuiController controller) {
    if (controller == null) {
      throw new IllegalArgumentException("Controller can't be null");
    }
    this.controller = controller;
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void setPlayerDescriptionText(String text, boolean isGameOver) {
    this.playerDescription.setText(text);
    try {

      if (!isGameOver) {
        chest.setText("");
        String s = text.substring(0, text.indexOf("sapphires"));
        chest.getDocument().insertString(0, String.valueOf(s.charAt(s.length() - 2)), null);
        this.chest.insertIcon(new ImageIcon(ClassLoader.getSystemResource("img/sapphire.png")));
        s = text.substring(text.indexOf("sapphires"), text.indexOf("diamonds"));
        chest.getDocument().insertString(chest.getDocument().getLength(),
                String.valueOf(s.charAt(s.length() - 2)), null);
        this.chest.insertIcon(new ImageIcon(ClassLoader.getSystemResource("img/diamond.png")));

        s = text.substring(text.indexOf("diamonds"),
                text.indexOf("rubies"));
        chest.getDocument().insertString(chest.getDocument().getLength(),
                String.valueOf(s.charAt(s.length() - 2)), null);
        this.chest.insertIcon(new ImageIcon(ClassLoader.getSystemResource("img/ruby.png")));

        s = text.substring(text.indexOf("rubies"), text.indexOf("arrows"));
        chest.getDocument().insertString(chest.getDocument().getLength(),
                String.valueOf(s.charAt(s.length() - 2)), null);
        chest.getDocument().insertString(chest.getDocument().getLength(), "  ", null);

        this.chest.insertIcon(new ImageIcon(ClassLoader.getSystemResource("img/arrow-black.png")));
        this.requestFocus();
      }

    }
    catch (BadLocationException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void setRoomDescriptionText(String text) {
    this.roomDescription.setText(text);
  }

  @Override
  public void setStatusText(String text) {
    this.status.setText(text);
  }

  @Override
  public void addKeyBoardListener(GuiController listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Listener cannot be null");
    }
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
  public void addClickListener(GuiController listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Listener cannot be null");
    }
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
  public void showInformationMessage(String information) {
    JOptionPane.showMessageDialog(this,information,"Information",JOptionPane.INFORMATION_MESSAGE);
  }

  private int getInput(InputBox frame, String displayMessage) {
    if (frame == null) {
      throw new IllegalArgumentException("Frame cannot be null");
    }
    boolean gotValidNumber = false;
    Integer number = null;
    while (!gotValidNumber) {
      String string = JOptionPane.showInputDialog(frame, displayMessage, 0);
      if (string == null) {
        System.exit(0);
      }
      try {
        number = Integer.parseInt(string);
        gotValidNumber = true;
      }
      catch (NumberFormatException e) {
        showErrorMessage("Please enter an integer");
        gotValidNumber = false;
      }
    }
    return number;
  }
}
